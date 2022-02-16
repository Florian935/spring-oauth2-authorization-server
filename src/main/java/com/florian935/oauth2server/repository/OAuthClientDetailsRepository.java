package com.florian935.oauth2server.repository;

import com.florian935.oauth2server.domain.OAuthClientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OAuthClientDetailsRepository extends JpaRepository<OAuthClientDetails, Integer> {

    OAuthClientDetails findByClientId(String clientId);
}
