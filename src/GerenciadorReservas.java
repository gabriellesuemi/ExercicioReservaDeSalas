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
            usuario.atualizar("Reserva criada com sucesso." + novaReserva);
        } else {
            usuario.atualizar("Não foi possível criar a reserva. Existe conflito de horário.");
        }
    }

    public void listarSalasDisponiveis(LocalDateTime inicio, LocalDateTime fim) {

        System.out.println("Salas disponíveis:");

        for (Sala sala : repositorio.getSalas()) {

            Reserva reservaTeste = new Reserva(
                    new Estudante("Teste"),
                    sala,
                    inicio,
                    fim
            );

            if (politica.podeReservar(reservaTeste, repositorio.getReservas())) {
                System.out.println(sala);
            }
        }
    }

    public void cancelarReserva(Reserva reserva) {
        reserva.cancelar();
        reserva.getUsuario().atualizar("Reserva cancelada.");
    }

    public void alterarReserva(Reserva reserva, LocalDateTime novoInicio, LocalDateTime novoFim) {
        reserva.alterarHorario(novoInicio, novoFim);
        reserva.getUsuario().atualizar("Reserva alterada."  + reserva);
    }
}