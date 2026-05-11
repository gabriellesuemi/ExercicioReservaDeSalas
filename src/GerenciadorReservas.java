public class GerenciadorReservas {

    private Repositorio repositorio;
    private PoliticaDeReserva politica;

    public GerenciadorReservas() {
        repositorio = Repositorio.getInstancia();
        politica = new PoliticaPrimeiroReserva();
    }

    public void trocarPolitica(PoliticaDeReserva novaPolitica) {
        this.politica = novaPolitica;
    }

    public void adicionarSala(Sala sala) {
        repositorio.getSalas().add(sala);
    }
}
