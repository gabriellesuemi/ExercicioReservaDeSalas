import java.time.LocalDateTime;

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

    public void criarReserva(Usuario usuario, Sala sala, LocalDateTime inicio, LocalDateTime fim) {

        Reserva novaReserva = new Reserva(usuario, sala, inicio, fim);

        if (politica.podeReservar(novaReserva, repositorio.getReservas())) {
            repositorio.getReservas().add(novaReserva);
            usuario.atualizar("Reserva criada com sucesso.");
        } else {
            usuario.atualizar("Não foi possível criar a reserva. Existe conflito de horário.");
        }
    }
}