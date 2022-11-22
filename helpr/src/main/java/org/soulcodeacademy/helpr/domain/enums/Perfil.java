package org.soulcodeacademy.helpr.domain.enums;

// ROLE = papel do usuário
// Enum delimita um conjunto de valores constantes
public enum Perfil {
    ADMIN("ROLE_ADMIN"), // 0
    FUNCIONARIO("ROLE_FUNCIONARIO"), // 1
    CLIENTE("ROLE_CLIENTE"); // 2

    private String descricao;

    Perfil(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

}
