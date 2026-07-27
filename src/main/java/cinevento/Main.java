package cinevento;

import cinevento.irl.*;
import cinevento.repository.TipoSala;
import cinevento.service.CinemaService;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        CinemaService cinemaService = new CinemaService();

        // Filme, selecionei interestellar pq sim, melhor filme do seculo
        Filme filme = new Filme(
                1,
                "Interestelar",
                "Sci-Fi",
                10140, //2h49m | 2 x 3600 = 7200 | 49 x 60 = 2940 = 7200 + 2940 = 10140
                "10"
        );

        cinemaService.cadastrarFilme(filme);

        System.out.println("=== Filmes cadastrados ===");
        System.out.println(cinemaService.listarFilmes());

        // cadastro de cliente :D
        Cliente cliente = new Cliente("Maria Eduarda", "C001");
        cinemaService.cadastrarCliente(cliente);

        System.out.println("\n=== Clientes cadastrados ===");
        System.out.println(cinemaService.listarClientes());

        //registro de cadeiras e sessão
        Map<String, Cadeira> cadeiras = new HashMap<>();
        cadeiras.put("A1", new Cadeira("A1", false)); // livre
        cadeiras.put("A2", new Cadeira("A2", true));  // ocupada

        Sessao sessao = new Sessao(1, TipoSala.IMAX, cadeiras);
        cinemaService.cadastrarSessao(sessao);

        System.out.println("\n=== Sessões cadastradas ===");
        System.out.println(cinemaService.listarSessoes());

        //sistema da compra de ingresso
        Ingresso ingresso = cinemaService.comprarIngresso(cliente, sessao);

        System.out.println("\n=== Ingresso(s) comprado(s) ===");
        System.out.println(ingresso);

        //cancelamento
        cinemaService.cancelarIngresso(ingresso.getCodigoReserva());
        System.out.println("\nIngresso " + ingresso.getCodigoReserva() + " cancelado com sucesso.");

        // testando exceção, tente isso e pegue isso!
        try {
            cinemaService.cancelarIngresso("finjo-que-sou-umcodigo-gg");
        } catch (IllegalArgumentException e) {
            System.out.println("\nErro ao cancelar ingresso inexistente(an?): " + e.getMessage());
        }

    }

}
