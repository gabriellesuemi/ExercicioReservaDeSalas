public class SalaFactory {
    public static Sala criarSala(String tipo, String codigo, int capacidade) {
        if (tipo.equalsIgnoreCase("individual")) {
            return new SalaIndividual(codigo, capacidade);
        } else if (tipo.equalsIgnoreCase("grupo")) {
            return new SalaGrupo(codigo, capacidade);
        } else if (tipo.equalsIgnoreCase("laboratorio")) {
            return new Laboratorio(codigo, capacidade);
        }

        throw new IllegalArgumentException("Tipo de sala inválido.");
    }
}