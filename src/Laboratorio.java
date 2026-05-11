public class Laboratorio extends Sala {
    public Laboratorio(String codigo, int capacidade) {
        super(codigo, capacidade);
    }

    @Override
    public String getTipo() {
        return "Laboratório";
    }
}