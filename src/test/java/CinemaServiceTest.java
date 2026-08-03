import cinevento.irl.*;
import cinevento.service.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CinemaServiceTest {

    private CinemaService cinemaService;

    @BeforeEach
        //testes quentinhos a toda hora
    void setUp() {
        cinemaService = new CinemaService();
    }

    @Test
    void CadastrarEPesquisarFilme() {
        Filme filme = new Filme(1, "Duna", "Sci-Fi", 9000, "12");
        cinemaService.cadastrarFilme(filme);

        Filme resultado = cinemaService.pesquisarFilme(1);

        assertEquals(filme, resultado);
    }

    @Test
    void RemoverFilme() {
        Filme filme = new Filme(1, "Duna", "Sci-Fi", 9000, "12");
        cinemaService.cadastrarFilme(filme);

        cinemaService.removerFilme(1);

        assertNull(cinemaService.pesquisarFilme(1));
    }

    @Test
    void RemoverSessaoInexistente() {
        assertThrows(SessaoInexistenteException.class, () -> {
            cinemaService.removerSessao(999);
        });
    }




}