import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        GerenciadorReservas gerenciador = new GerenciadorReservas();

        Sala sala1 = SalaFactory.criarSala("individual", "S101", 1);
        Sala sala2 = SalaFactory.criarSala("grupo", "G202", 6);
        Sala sala3 = SalaFactory.criarSala("laboratorio", "L303", 20);

        gerenciador.adicionarSala(sala1);
        gerenciador.adicionarSala(sala2);
        gerenciador.adicionarSala(sala3);

        Usuario estudante = new Estudante("Ana");
        Usuario professor = new Professor("Carlos");

        LocalDateTime inicio = LocalDateTime.of(2026, 5, 10, 14, 0);
        LocalDateTime fim = LocalDateTime.of(2026, 5, 10, 16, 0);

        System.out.println("Criando primeira reserva:");
        gerenciador.criarReserva(estudante, sala1, inicio, fim);

        System.out.println("\nTentando criar reserva no mesmo horário:");
        gerenciador.criarReserva(professor, sala1, inicio, fim);

        System.out.println("\nTrocando política para prioridade docente:");
        gerenciador.trocarPolitica(new PoliticaPrioridadeDocente());

        System.out.println("\nTentando reservar novamente com professor:");
        gerenciador.criarReserva(professor, sala1, inicio, fim);

        System.out.println("\nListando salas disponíveis:");
        gerenciador.listarSalasDisponiveis(inicio, fim);

        System.out.println("\nRelatório diário:");
        gerenciador.gerarRelatorioDiario(2026, 5, 10);
    }
}