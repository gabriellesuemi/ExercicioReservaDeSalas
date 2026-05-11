import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private static volatile Repositorio instancia;

    private List<Sala> salas;
    private List<Reserva> reservas;

    private Repositorio() {
        salas = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public static Repositorio getInstancia() {
        if (instancia == null) {
            synchronized (Repositorio.class) {
                if (instancia == null) {
                    instancia = new Repositorio();
                }
            }
        }
        return instancia;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}