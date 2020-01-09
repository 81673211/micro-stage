package com.fred.microstage.service.user.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class TokenService {

    @Value("${oauth.token.url.get}")
    private String tokenGetUrl;

    @Autowired
    private OAuthTokenHelper oAuthTokenHelper;

    public OAuthToken getToken(String authorizationCode) {
        RequestEntity<MultiValueMap<String, String>> requestEntity = new RequestEntity<>(
                oAuthTokenHelper.getBody(authorizationCode),
                oAuthTokenHelper.getHeader(),
                HttpMethod.POST,
                URI.create(tokenGetUrl));
        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<OAuthToken> responseEntity = restTemplate.exchange(requestEntity, OAuthToken.class);
        return responseEntity.getBody();
    }
}
