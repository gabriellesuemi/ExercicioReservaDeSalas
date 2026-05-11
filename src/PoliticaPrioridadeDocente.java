import java.util.List;

public class PoliticaPrioridadeDocente implements PoliticaDeReserva {

    @Override
    public boolean podeReservar(Reserva novaReserva, List<Reserva> reservasExistentes) {

        for (Reserva reserva : reservasExistentes) {

            if (reserva.isConfirmada()
                    && reserva.getSala().getCodigo().equals(novaReserva.getSala().getCodigo())
                    && horariosColidem(novaReserva, reserva)) {

                if (novaReserva.getUsuario() instanceof Professor
                        && reserva.getUsuario() instanceof Estudante) {

                    reserva.cancelar();
                    reserva.getUsuario().atualizar(
                            "Sua reserva foi cancelada por prioridade docente."
                    );

                    return true;
                }

                return false;
            }
        }

        return true;
    }

    private boolean horariosColidem(Reserva r1, Reserva r2) {
        return r1.getInicio().isBefore(r2.getFim())
                && r1.getFim().isAfter(r2.getInicio());
    }
}