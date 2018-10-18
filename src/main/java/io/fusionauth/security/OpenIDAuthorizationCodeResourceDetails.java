package io.fusionauth.security;

import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

/**
 * Add some OpenID stuff.
 *
 * @author Tyler Scott
 */
public class OpenIDAuthorizationCodeResourceDetails extends AuthorizationCodeResourceDetails {
    private String userInfoUri;

    public String getUserInfoUri() {
        return userInfoUri;
    }

    public void settUserInfoUri(String userInfoUri) {
        this.userInfoUri = userInfoUri;
    }

}
