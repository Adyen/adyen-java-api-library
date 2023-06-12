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
  newVersion = data.replace(/(LIB_VERSION = )"(\d{1,2}\.\d\.\d)"/, "$1" + '"' + version +'"');
  fs.writeFileSync('src/main/java/com/adyen/Client.java', newVersion, 'utf-8');

  data = fs.readFileSync('pom.xml', 'utf-8');
  newVersion = data.replace(/(<version>)(\d{1,2}.\d.\d)(<\/version>\n.*<name>Adyen Java API Library<\/name>)/, "$1" + version + "$3");
  fs.writeFileSync('pom.xml', newVersion, 'utf-8');
}