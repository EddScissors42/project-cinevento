package cinevento.ui;

import cinevento.service.CinemaService;

import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JFrame {

    private JLabel linha1;
    private JMenuBar barraDeMenu = new JMenuBar();

    private CinemaService cinemaService;

    public TelaInicial(CinemaService cinemaService) {

        this.cinemaService = cinemaService;

        setTitle("Cinevento");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(2, 1));

        linha1 = new JLabel("Bem-vindo ao Cinevento!\n Use o menu acima para navegar.", SwingConstants.CENTER);

        //adicionando botão para comprar ingresso no meio da tela
        JButton btnComprarIngresso = new JButton("Comprar Ingresso");

        btnComprarIngresso.addActionListener(e -> {
            new TelaAtendimentoClient(cinemaService).setVisible(true);
        });

        add(linha1);
        add(btnComprarIngresso);

        //menu filmes
        JMenu menuFilmes = new JMenu("Filmes");
        JMenuItem itemAbrirFilmes = new JMenuItem("Gerenciar Filmes");

        itemAbrirFilmes.addActionListener(e -> {
            new TelaFilmes(cinemaService).setVisible(true);
        });

        menuFilmes.add(itemAbrirFilmes);

        // menu dos cliente
        JMenu menuClientes = new JMenu("Clientes");
        JMenuItem itemAbrirClientes = new JMenuItem("Gerenciar Clientes");

        itemAbrirClientes.addActionListener(e -> {
            new TelaClientes(cinemaService).setVisible(true);
        });

        menuClientes.add(itemAbrirClientes);

        // eu escolho vc menu de sessões
        JMenu menuSessoes = new JMenu("Sessões");
        JMenuItem itemAbrirSessoes = new JMenuItem("Gerenciar Sessões");

        itemAbrirSessoes.addActionListener(e -> {
            new TelaSessoes(cinemaService).setVisible(true);
        });

        menuSessoes.add(itemAbrirSessoes);

       // o menu de ingresso
        JMenu menuIngressos = new JMenu("Ingressos");
        JMenuItem itemAbrirIngressos = new JMenuItem("Gerenciar Ingressos");

        itemAbrirIngressos.addActionListener(e -> {
            new TelaIngressos(cinemaService).setVisible(true);
        });

        menuIngressos.add(itemAbrirIngressos);


        //salva'r / Recuperar
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem itemSalvar = new JMenuItem("Salvar");
        JMenuItem itemRecuperar = new JMenuItem("Recuperar");

        itemSalvar.addActionListener(e -> {
            cinemaService.salvarDados("filmes.dat");
            JOptionPane.showMessageDialog(null, "Dados salvos!");
        });

        itemRecuperar.addActionListener(e -> {
            cinemaService.recuperarDados("filmes.dat");
            JOptionPane.showMessageDialog(null, "Dados recuperados!");
        });

        menuArquivo.add(itemSalvar);
        menuArquivo.add(itemRecuperar);

        // a barra de menu 😴
        barraDeMenu.add(menuFilmes);
        barraDeMenu.add(menuClientes);
        barraDeMenu.add(menuSessoes);
        barraDeMenu.add(menuIngressos);
        barraDeMenu.add(menuArquivo);

        setJMenuBar(barraDeMenu);
    }
}