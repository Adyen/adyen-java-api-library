
[![Build Status](https://travis-ci.org/Adyen/adyen-java-api-library.svg?branch=master)](https://travis-ci.org/Adyen/adyen-java-api-library)
[![Coverage Status](https://coveralls.io/repos/github/Adyen/adyen-java-api-library/badge.svg?branch=master)](https://coveralls.io/github/Adyen/adyen-java-api-library?branch=master)


# Adyen Java API Library

The Adyen API Library for Java enables you to work with Adyen APIs and Hosted Payment Pages.

## Requirements

* Java 7 or higher

## Installation
  
You can use Maven or simply download the release.
  
### Maven

Add this dependency to your project's POM:

```
<dependency>
  <groupId>com.adyen</groupId>
  <artifactId>adyen-java-api-library</artifactId>
  <version>1.8.0</version>
</dependency>
```

## Documentation

Follow the rest of our guides from the [documentation](http://adyen.github.io/adyen-java-api-library/index.html) on how to use this library.

## Usage

The code examples on using this library are located in the library section of the java-sample-code repository: https://github.com/adyen/adyen-java-sample-code

## Proxy configuration

You can configure a proxy connection by injecting your own HttpURLConnectionClient on your client instance.

Example:
```
...
HttpURLConnectionClient httpURLConnectionClientWithProxy = new HttpURLConnectionClient();

Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("PROXY_HOST", PROXY_PORT));
httpURLConnectionClientWithProxy.setProxy(proxy);

client.setHttpClient(httpURLConnectionClientWithProxy);
```

## Support

If you have any problems, questions or suggestions, create an issue here or send your inquiry to support@adyen.com.
  
## Licence

MIT license. For more information, see the LICENSE file.
