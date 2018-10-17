package io.fusionauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

import static java.util.Arrays.asList;

/**
 * @author Tyler Scott
 */
@Configuration
@EnableOAuth2Client
public class FusionAuthOpenIdConnectConfig {
    @Value("${fusionAuth.clientId}")
    private String clientId;

    @Value("${fusionAuth.clientSecret}")
    private String clientSecret;

    @Value("${fusionAuth.accessTokenUri}")
    private String accessTokenUri;

    @Value("${fusionAuth.userAuthorizationUri}")
    private String userAuthorizationUri;

    @Value("${fusionAuth.redirectUri}")
    private String redirectUri;

    @Bean
    public OAuth2ProtectedResourceDetails fusionAuthOpenId() {
        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(accessTokenUri);
        details.setUserAuthorizationUri(userAuthorizationUri);
        details.setScope(asList("openid", "email"));
        details.setPreEstablishedRedirectUri(redirectUri);
        details.setUseCurrentUri(false);
        details.setClientAuthenticationScheme(AuthenticationScheme.form);
        return details;
    }

    @Bean
    public OAuth2RestTemplate fusionAuthOpenIdTemplate(final OAuth2ClientContext clientContext) {
        return new OAuth2RestTemplate(fusionAuthOpenId(), clientContext);
    }
}
