package JDBC_1_Pratica.Exercicio_7_Sistema_de_Contas_de_Usuario_Streaming.Enums;

public enum TipoPlano {
    PADRAO,
    PREMIUM;

    public static TipoPlano fromTexto(String texto) {
        if (texto == null)
            throw new IllegalArgumentException("Plano não pode ser vazio.");

        String normalizado = texto.trim()
                .toUpperCase()
                .replace("Ã", "A")
                .replace("Á", "A")
                .replace("À", "A");

        if (normalizado.startsWith("PAD")) return TipoPlano.PADRAO;
        else if (normalizado.startsWith("PREM")) return TipoPlano.PREMIUM;

        throw new IllegalArgumentException("Plano inválido: '" + texto + "'. Use 'Padrao' ou 'Premium'.");
    }
}