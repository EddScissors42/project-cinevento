package cinevento;
import cinevento.irl.*;
import cinevento.service.CinemaService;

public class Main {

    public static void main(String[] args) {

        CinemaService cinemaService = new CinemaService();

        Filme filme = new Filme(
                1,
                "Interestelar",
                "Sci-Fi",
                10140, //2h49m | 2 x 3600 = 7200 | 49 x 60 = 2940 = 7200 + 2940 = 10140
                "L"
        );

        cinemaService.cadastrarFilme(filme);

        System.out.println(
                cinemaService.listarFilmes()
        );

    }

}
