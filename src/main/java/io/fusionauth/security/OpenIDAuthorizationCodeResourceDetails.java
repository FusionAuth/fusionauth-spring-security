package io.fusionauth.security;

import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;

/**
 * Extend the {@link AuthorizationCodeResourceDetails} to add the OpenID Connect UserInfo endpoint as described
 * in section <code>5.3</code> of OpenID Connect Core 1.0.
 *
 * @author Tyler Scott
 * @see <a href="https://openid.net/specs/openid-connect-core-1_0.html#UserInfo">https://openid.net/specs/openid-connect-core-1_0.html#UserInfo</a>
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
