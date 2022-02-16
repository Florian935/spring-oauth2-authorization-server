package com.florian935.oauth2server.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class AuthenticatedClient implements ClientDetails {

    OAuthClientDetails oAuthClientDetails;

    @Override
    public Integer getAccessTokenValiditySeconds() {

        return this.oAuthClientDetails.getAccessTokenValidity();
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {

        return null;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> grantedAuthority = new ArrayList<>();
        grantedAuthority.add(new SimpleGrantedAuthority("ROLE_CLIENT"));

        return grantedAuthority;
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {

        final String[] authorizedGrantTypes = this.oAuthClientDetails.getAuthorizedGrantTypes().split(",");

        return Arrays.stream(authorizedGrantTypes).collect(Collectors.toSet());
    }

    @Override
    public String getClientId() {

        return this.oAuthClientDetails.getClientId();
    }

    @Override
    public String getClientSecret() {

        return this.oAuthClientDetails.getClientSecret();
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {

        return this.oAuthClientDetails.getRefreshTokenValidity();
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {

        String[] registeredRedirectUris = this.oAuthClientDetails.getWebServerRedirectUri().split(",");

        return Arrays.stream(registeredRedirectUris).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getResourceIds() {

        String[] resourceIds = this.oAuthClientDetails.getResourceIds().split(",");

        return Arrays.stream(resourceIds).collect(Collectors.toSet());
    }

    @Override
    public Set<String> getScope() {

        String[] scopes = this.oAuthClientDetails.getScope().split(",");

        return Arrays.stream(scopes).collect(Collectors.toSet());

    }

    @Override
    public boolean isAutoApprove(String arg0) {

        return false;
    }

    @Override
    public boolean isScoped() {

        return true;
    }

    @Override
    public boolean isSecretRequired() {

        return true;
    }
}
