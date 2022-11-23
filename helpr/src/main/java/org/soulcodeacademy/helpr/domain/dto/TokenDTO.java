package org.soulcodeacademy.helpr.domain.dto;

public class TokenDTO {

    private String accessToken;
    private String tokenType = "Bearer";

    public TokenDTO(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAcessToken() {
        return accessToken;
    }

    public void setAcessToken(String acessToken) {
        this.accessToken = acessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
