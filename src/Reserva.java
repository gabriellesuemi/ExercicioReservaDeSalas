import java.time.LocalDateTime;

public class Reserva {
    private Usuario usuario;
    private Sala sala;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private boolean confirmada;

    public Reserva(Usuario usuario, Sala sala, LocalDateTime inicio, LocalDateTime fim) {
        this.usuario = usuario;
        this.sala = sala;
        this.inicio = inicio;
        this.fim = fim;
        this.confirmada = true;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Sala getSala() {
        return sala;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public LocalDateTime getFim() {
        return fim;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public void cancelar() {
        this.confirmada = false;
    }

    public void alterarHorario(LocalDateTime novoInicio, LocalDateTime novoFim) {
        this.inicio = novoInicio;
        this.fim = novoFim;
    }

    @Override
    public String toString() {
        return "Reserva de " + usuario.getNome() +
                " na sala " + sala.getCodigo() +
                " de " + inicio +
                " até " + fim;
    }
}
