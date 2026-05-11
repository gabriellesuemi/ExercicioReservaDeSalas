public class SalaGrupo extends Sala {
    public SalaGrupo(String codigo, int capacidade) {
        super(codigo, capacidade);
    }

    @Override
    public String getTipo() {
        return "Sala de Grupo";
    }
}
