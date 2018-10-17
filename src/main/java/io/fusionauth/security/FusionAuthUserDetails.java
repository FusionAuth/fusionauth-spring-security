package io.fusionauth.security;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Tyler Scott
 */
public class FusionAuthUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;

    public OAuth2AccessToken token;

    public String userId;

    public String username;

    private List<String> roles;

    public FusionAuthUserDetails(JsonNode claims, OAuth2AccessToken token) {
        userId = claims.get("sub").asText();
        username = claims.get("email").asText();
        roles = claims.findValuesAsText("roles");
        this.token = token;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
