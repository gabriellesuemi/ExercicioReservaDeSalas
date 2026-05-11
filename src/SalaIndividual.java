public class SalaIndividual extends Sala {
    public SalaIndividual(String codigo, int capacidade) {
        super(codigo, capacidade);
    }

    @Override
    public String getTipo() {
        return "Sala Individual";
    }
}