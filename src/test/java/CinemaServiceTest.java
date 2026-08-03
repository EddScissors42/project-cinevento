import cinevento.irl.*;
import cinevento.repository.*;
import cinevento.service.*;
import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CinemaServiceTest {

    private CinemaService cinemaService;

    @BeforeEach
    void setUp() {
        cinemaService = new CinemaService();
    }

    @Test
    void cadastrarEPesquisarFilme() {
        Filme filme = new Filme(1, "Duna", "Sci-Fi", 9000, "12");
        cinemaService.cadastrarFilme(filme);

        Filme resultado = cinemaService.pesquisarFilme(1);

        assertEquals(filme, resultado);
    }

    @Test
    void removerFilme() {
        Filme filme = new Filme(1, "Duna", "Sci-Fi", 9000, "12");
        cinemaService.cadastrarFilme(filme);

        cinemaService.removerFilme(1);

        assertNull(cinemaService.pesquisarFilme(1));
    }

    @Test
    void removerSessaoInexistente() {
        assertThrows(SessaoInexistenteException.class, () -> {
            cinemaService.removerSessao(999);
        });
    }

    @Test
    void gerenciarFluxoDeCliente() {
        Cliente cliente = new Cliente("Edd", "C001");

        cinemaService.cadastrarCliente(cliente);

        Cliente resultadoPesquisa = cinemaService.pesquisarCliente("C001");
        assertNotNull(resultadoPesquisa);
        assertEquals("Edd", resultadoPesquisa.getNome());

        cinemaService.removerCliente("C001");
        assertNull(cinemaService.pesquisarCliente("C001"));
    }

    @Test
    void comprarIngressoComSucesso() { //vamo fazer uma loucura aqui
        Cliente cliente = new Cliente("Edd", "C001"); // cadastro de cliente
        Filme filme = new Filme(10, "Suzume", "Drama", 7200, "12"); // cadastro do filme

        Map<String, Cadeira> cadeiras = new HashMap<>();
        cadeiras.put("A1", new Cadeira("A1", false)); //Essa cadeira existe! (talvez)

        Sessao sessao = new Sessao(100, TipoSala.IMAX, cadeiras, filme);

        cinemaService.cadastrarCliente(cliente);
        cinemaService.cadastrarFilme(filme);
        cinemaService.cadastrarSessao(sessao);

        Ingresso ingresso = cinemaService.comprarIngresso(cliente, sessao);

        assertNotNull(ingresso, "O ingresso não deveria ser nulo após a compra.");
        assertNotNull(ingresso.getCodigoReserva(), "O código de reserva (UUID) deveria ter sido gerado.");
        assertEquals(sessao, ingresso.getSessao(), "A sessão do ingresso deve ser a mesma que passámos na compra.");
    }




}