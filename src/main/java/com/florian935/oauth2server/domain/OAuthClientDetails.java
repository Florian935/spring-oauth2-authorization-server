package com.florian935.oauth2server.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "oauth_client_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class OAuthClientDetails {

    @Id
    @GeneratedValue(strategy= AUTO)
    @Column(name="oauth_client_details_id")
    private Integer oauthClientDetailsId;

    @Column(name="client_id")
    private String clientId;

    @Column(name="client_secret")
    private String clientSecret;

    @Column(name="access_token_validity")
    private int accessTokenValidity;

    @Column(name="scope")
    private String scope;

    @Column(name="authorities")
    private String authorities;

    @Column(name="authorized_grant_types")
    private String authorizedGrantTypes;

    @Column(name="refresh_token_validity")
    private int refreshTokenValidity;

    @Column(name="resource_ids")
    private String resourceIds;

    @Column(name="web_server_redirect_uri")
    private String webServerRedirectUri;

    @Column(name="auto_approve")
    private String autoApprove;

    @Column(name="additional_information")
    private String additionalInformation;
}
