public abstract class Sala {
    protected String codigo;
    protected int capacidade;

    public Sala(String codigo, int capacidade) {
        this.codigo = codigo;
        this.capacidade = capacidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return getTipo() + " - " + codigo + " | Capacidade: " + capacidade;
    }
}