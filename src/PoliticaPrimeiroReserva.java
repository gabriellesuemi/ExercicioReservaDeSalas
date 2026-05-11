import java.util.List;

public class PoliticaPrimeiroReserva implements PoliticaDeReserva {
    @Override
    public boolean podeReservar(Reserva novaReserva, List<Reserva> reservasExistentes) {
        for (Reserva reserva : reservasExistentes) {
            if (reserva.isConfirmada()
                    && reserva.getSala().getCodigo().equals(novaReserva.getSala().getCodigo())
                    && horariosColidem(novaReserva, reserva)) {
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