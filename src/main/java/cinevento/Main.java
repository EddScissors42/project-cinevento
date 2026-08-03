package cinevento;

import cinevento.service.CinemaService;
import cinevento.ui.TelaInicial;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        CinemaService cinemaService = new CinemaService();

        SwingUtilities.invokeLater(() -> {
            new TelaInicial(cinemaService).setVisible(true);
        });

    }

}