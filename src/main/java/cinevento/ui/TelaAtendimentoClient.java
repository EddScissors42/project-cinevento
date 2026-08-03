package cinevento.ui;

import cinevento.irl.Cliente;
import cinevento.irl.Filme;
import cinevento.irl.Ingresso;
import cinevento.irl.Sessao;
import cinevento.service.CinemaService;

import javax.swing.*;
import java.awt.*;
import java.util.UUID;

public class TelaAtendimentoClient extends JFrame {

    private JTextField txtNome;
    private JComboBox<Filme> cbFilme;
    private JComboBox<Sessao> cbSessao;
    private JButton btnComprar;
    private JButton btnLimpar;
    private JTextArea areaResultado;
    private CinemaService cinemaService;

    public TelaAtendimentoClient(CinemaService cinemaService) {

        this.cinemaService = cinemaService;

        setTitle("CineVento - Comprar Ingresso");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel painelCampos = new JPanel(new GridLayout(3, 2, 5, 5));
        painelCampos.setBorder(BorderFactory.createTitledBorder("Comprar Ingresso"));

        painelCampos.add(new JLabel("Seu nome"));
        txtNome = new JTextField();
        painelCampos.add(txtNome);

        painelCampos.add(new JLabel("Filme"));
        cbFilme = new JComboBox<>();
        atualizarComboFilmes();
        painelCampos.add(cbFilme);

        painelCampos.add(new JLabel("Sessão"));
        cbSessao = new JComboBox<>();
        painelCampos.add(cbSessao);

        add(painelCampos, BorderLayout.NORTH);

        //toda vez que a gente mudar o filme escolhido, a lista de sessoes vai mudar
        cbFilme.addActionListener(e -> atualizarComboSessoes());
        atualizarComboSessoes(); //popula o combo de sessoes já na abertura da tela, baseado no primeiro filme da lista

        JPanel painelBotoes = new JPanel(new GridLayout(1, 2, 5, 5));

        btnComprar = new JButton("Comprar Ingresso");
        btnLimpar = new JButton("Limpar");

        painelBotoes.add(btnComprar);
        painelBotoes.add(btnLimpar);

        add(painelBotoes, BorderLayout.CENTER);

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);

        JScrollPane scroll = new JScrollPane(areaResultado);
        scroll.setBorder(BorderFactory.createTitledBorder("Resultado"));

        add(scroll, BorderLayout.SOUTH);

        //ta na hora de passar um pix (COMPRAR)
        btnComprar.addActionListener(e -> {

            try {

                String nome = txtNome.getText();

                if (nome == null || nome.isBlank()) {
                    JOptionPane.showMessageDialog(null, "Digite teu nome antes de continuar.");
                    return;
                }

                Sessao sessaoSelecionada = (Sessao) cbSessao.getSelectedItem();

                if (sessaoSelecionada == null) {
                    JOptionPane.showMessageDialog(null, "Escolha uma sessão antes de continuar.");
                    return;
                }

                String codigoCliente = UUID.randomUUID().toString();
                Cliente cliente = new Cliente(nome, codigoCliente);
                cinemaService.cadastrarCliente(cliente);

                Ingresso ingresso = cinemaService.comprarIngresso(cliente, sessaoSelecionada);

                areaResultado.setText(ingresso.toString());

                JOptionPane.showMessageDialog(null, "Ingresso comprado com sucesso!");

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(null, "Erro ao comprar ingresso. :(");

            }

        });

        //limpando a bagunça
        btnLimpar.addActionListener(e -> {

            txtNome.setText("");
            atualizarComboFilmes();
            atualizarComboSessoes();
            areaResultado.setText("");

        });

    }

    // recarrega os filmes
    private void atualizarComboFilmes() {
        cbFilme.removeAllItems();
        for (Filme filme : cinemaService.listarFilmes()) {
            cbFilme.addItem(filme);
        }
    }

    // recarrega o combo de sessões tambm
    private void atualizarComboSessoes() {
        cbSessao.removeAllItems();

        Filme filmeSelecionado = (Filme) cbFilme.getSelectedItem();

        if (filmeSelecionado == null) {
            return;
        }

        for (Sessao sessao : cinemaService.listarSessoes()) {
            if (filmeSelecionado.equals(sessao.getFilme())) {
                cbSessao.addItem(sessao);
            }
        }
    }

}