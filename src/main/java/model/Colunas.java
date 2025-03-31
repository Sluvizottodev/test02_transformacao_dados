package model;
import java.util.Arrays;

public enum Colunas {
    OD("Odontológico"),
    AMB("Ambulatorial");

    private String descricao;

    Colunas(String descricao) {
        this.descricao = descricao;
    }

    public static String getDescricao(String abrev) {
    return Arrays.stream(values())
        .filter(col -> col.name().equalsIgnoreCase(abrev))
        .findFirst()
        .map(col -> col.descricao)
        .orElse(abrev);
    }
}