package com.florian935.oauth2server.service;

import com.florian935.oauth2server.domain.AuthenticatedClient;
import com.florian935.oauth2server.domain.OAuthClientDetails;
import com.florian935.oauth2server.repository.OAuthClientDetailsRepository;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class ClientDetailsServiceImpl implements ClientDetailsService {

    OAuthClientDetailsRepository oAuthClientDetailsRepository;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        final OAuthClientDetails oAuthClientDetails = oAuthClientDetailsRepository.findByClientId(clientId);

        return new AuthenticatedClient(oAuthClientDetails);
    }
}
