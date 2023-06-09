// Get the current version of a Node.js package
exports.packageVersion = () => {
  return require('../../package.json').version;
};

// List of merged pull requests in Markdown
exports.changelog = (changeset) => {
  let entries = [];
  for (const { node: { associatedPullRequests: prs } } of changeset.repository.ref.compare.commits.edges) {
    for (const { node: { number: number } } of prs.edges) {
      entries.push(`- #${number}`);
    }
  }
  return entries;
};

// Get the current version of a Python package from setup.py
exports.setupPythonVersion = () => {
  const fs = require('fs');
  const re = /version='(\d{1,2}.\d.\d)\'/;
  data = fs.readFileSync("setup.py", 'utf-8');
  version = data.match(re)[1];
  return version;
};

// Update the version in settings.py and setup.py
exports.updatePythonVersion = async (version) => {
  const fs = require('fs');
  data = fs.readFileSync('Adyen/settings.py', 'utf-8');
  newVersion = data.replace(/\d{1,2}\.\d\.\d/, version);
  fs.writeFileSync('Adyen/settings.py', newVersion, 'utf-8');

  data = fs.readFileSync('setup.py', 'utf-8');
  newVersion = data.replace(/\d{1,2}\.\d\.\d/, version);
  fs.writeFileSync('setup.py', newVersion, 'utf-8');
}

// Get the current version in pom.xml file

exports.pomJavaVersion = () => {
    const fs = require('fs');
    const re = /<version>(\d{1,2}.\d.\d)<\/version>\n.*<name>Adyen Java API Library<\/name>/;
    data = fs.readFileSync("pom.xml", 'utf-8');
    version = data.match(re)[1];
    return version;
}

// Update version in pom.xml and settings
exports.updateJavaVersion = async (version) => {
  const fs = require('fs');
  data = fs.readFileSync('src/main/java/com/adyen/Client.java', 'utf-8');
  newVersion = data.replace(/LIB_VERSION = "(\d{1,2}\.\d\.\d)"/, version);
  fs.writeFileSync('src/main/java/com/adyen/Client.java', newVersion, 'utf-8');

  data = fs.readFileSync('pom.xml', 'utf-8');
  newVersion = data.replace(/<version>(\d{1,2}.\d.\d)<\/version>\n.*<name>Adyen Java API Library<\/name>/, version);
  fs.writeFileSync('pom.xml', newVersion, 'utf-8');
}

// Next semantic version number
exports.nextVersion = (current, increment) => {
  let [major, minor, patch] = current.split('.');
  switch (increment) {
    case 'patch':
      patch++;
      break;
    case 'minor':
      minor++;
      patch = 0;
      break;
    case 'major':
      major++;
      minor = 0;
      patch = 0;
      break;
  }
  return [major, minor, patch].join('.');
};

// Compare two branches on Github
exports.compareBranches = async (github, { owner, repo, base, head }) => {
  return await github.graphql(`
    query($owner: String!, $repo: String!, $base: String!, $head: String!) {
        repository(owner: $owner, name: $repo) {
          name
          ref(qualifiedName: $base) {
            compare(headRef: $head) {
              aheadBy
              commits(first: 100) {
                edges {
                  node {
                    message
                    associatedPullRequests(first: 5) {
                      edges {
                        node {
                          number
                          labels(first: 5) {
                            nodes {
                              name
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
    }
    `, { owner, repo, base, head });
}

// Scan the changelog to decide what kind of release we need
exports.detectChanges = (changeset) => {
  if (!changeset || changeset.repository.ref.compare.aheadBy < 1) {
    // Nothing to release
    return '';
  }

  let increment = 'patch';

  // increment based on the merged PR labels
  for (const { node: { associatedPullRequests: prs } } of changeset.repository.ref.compare.commits.edges) {
    for (const { node: { labels: { nodes: labels } } } of prs.edges) {
      for (const { name: label } of labels) {
        const normalizedLabel = label.toLowerCase().replace(' ', '-');
        switch (normalizedLabel) {
          case 'feature':
            increment = 'minor';
            break;
          case 'breaking-change':
            increment = 'major';
            break;
        }
      }
    }
  }

  return increment;
};

// Define next release
exports.bump = async ({ github, context, core, getCurrentVersion }) => {
  const changeset = await this.compareBranches(github, {
    owner: context.repo.owner,
    repo: context.repo.repo,
    base: 'main',
    head: 'develop',
  });
  const changelog = this.changelog(changeset);
  const increment = this.detectChanges(changeset);
  const nextVersion = this.nextVersion(getCurrentVersion(), increment);

  core.setOutput('increment', increment);
  core.setOutput('nextVersion', nextVersion);
  core.setOutput('changelog', changelog.join("\n"));
};