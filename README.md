

[![Build Status](https://travis-ci.org/Adyen/adyen-java-api-library.svg?branch=master)](https://travis-ci.org/Adyen/adyen-java-api-library)
[![Coverage Status](https://coveralls.io/repos/github/Adyen/adyen-java-api-library/badge.svg?branch=master)](https://coveralls.io/github/Adyen/adyen-java-api-library?branch=master)


# Adyen Java API Library

The Adyen API Library for Java enables you to work with Adyen APIs and Hosted Payment Pages.

## Integration
The Library supports all APIs under the following services:

* checkout
* checkout utility
* payments
* modifications
* payouts
* recurring
* marketpay
* notifications
* BIN lookup
* terminal API

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
  <version>5.0.0</version>
</dependency>
```

## Documentation
* https://docs.adyen.com/developers/development-resources/libraries
* https://docs.adyen.com/developers/checkout/api-integration


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

## Contributing
We strongly encourage you to join us in contributing to this repository so everyone can benefit from:
* New features and functionality
* Resolved bug fixes and issues
* Any general improvements

Read our [**contribution guidelines**](CONTRIBUTING.md) to find out how.

## Licence

MIT license. For more information, see the LICENSE file.
