FusionAuth Spring Security
====

This library provides an OpenID Connect implementation for FusionAuth and Spring Security.

## Maven 
```xml
<dependency>
  <groupId>io.fusionauth</groupId>
  <artifactId>fusionauth-spring-security</artifactId>
  <version>1.0.5</version>
</dependency>
```

Use our Example to get going and read through this tutorial to understand more about using Spring Security with FusionAuth. 
* https://github.com/FusionAuth/fusionauth-spring-security-example
* https://fusionauth.io/blog/2018/10/24/easy-integration-of-fusionauth-and-spring

If you encounter an issue with this library please open an Issue on this project, or if you get stuck integrating FusionAuth in your application open an issue here https://github.com/FusionAuth/fusionauth-issues/issues.

## Configuration

Example configuration where the base URL of FusionAuth is `login.piedpiper.com` and the Spring application is running on port `8081`.
```properties
# Copy this file to application.properties and fill in the clientId and clientSecret
server.port=8081
fusionAuth.clientId=<your client_id>
fusionAuth.clientSecret=<your client_secret>
fusionAuth.accessTokenUri=https://login.piedpiper.com/oauth2/token
fusionAuth.userAuthorizationUri=https://login.piedpiper.com/oauth2/authorize
fusionAuth.userInfoUri=https://login.piedpiper.com/oauth2/userinfo
fusionAuth.redirectUri=http://localhost:8081/login
```

License
----
Some portions of this code were forked/based on the code available here: https://github.com/eugenp/tutorials
which are licensed under MIT. The full license is available under [LICENSE](LICENSE).
