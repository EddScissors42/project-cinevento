package cinevento.ui;

import cinevento.irl.Cadeira;
import cinevento.irl.Sessao;
import cinevento.repository.TipoSala;
import cinevento.service.CinemaService;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class TelaSessoes extends JFrame {

    private JTextField txtNumero;

    private JComboBox<TipoSala> cbTipoSala;

    private JButton btnCadastrar;
    private JButton btnBuscar;
    private JButton btnRemover;
    private JButton btnListar;
    private JButton btnLimpar;

    private JTextArea areaResultado;

    private CinemaService cinemaService;

    public TelaSessoes(CinemaService cinemaService){

        this.cinemaService = cinemaService;

        setTitle("Sessões");

        setSize(600,500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel painelCampos = new JPanel(new GridLayout(2,2,5,5));

        painelCampos.setBorder(
                BorderFactory.createTitledBorder("Dados da Sessão"));

        painelCampos.add(new JLabel("Número"));

        txtNumero = new JTextField();

        painelCampos.add(txtNumero);

        painelCampos.add(new JLabel("Tipo da Sala"));

        cbTipoSala = new JComboBox<>(TipoSala.values());

        painelCampos.add(cbTipoSala);

        add(painelCampos, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel(new GridLayout(1,5,5,5));

        btnCadastrar = new JButton("Cadastrar");
        btnBuscar = new JButton("Buscar");
        btnRemover = new JButton("Remover");
        btnListar = new JButton("Listar");
        btnLimpar = new JButton("Limpar");

        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnBuscar);
        painelBotoes.add(btnRemover);
        painelBotoes.add(btnListar);
        painelBotoes.add(btnLimpar);

        add(painelBotoes, BorderLayout.CENTER);

        areaResultado = new JTextArea();

        areaResultado.setEditable(false);

        JScrollPane scroll = new JScrollPane(areaResultado);

        scroll.setBorder(
                BorderFactory.createTitledBorder("Resultado"));

        add(scroll, BorderLayout.SOUTH);

        //=========================
        // CADASTRAR
        //=========================

        btnCadastrar.addActionListener(e -> {

            try{

                Map<String,Cadeira> cadeiras = new HashMap<>();

                cadeiras.put("A1", new Cadeira("A1",false));
                cadeiras.put("A2", new Cadeira("A2",false));
                cadeiras.put("A3", new Cadeira("A3",false));

                Sessao sessao = new Sessao(

                        Integer.parseInt(txtNumero.getText()),
                        (TipoSala) cbTipoSala.getSelectedItem(),
                        cadeiras

                );

                cinemaService.cadastrarSessao(sessao);

                JOptionPane.showMessageDialog(
                        null,
                        "Sessão cadastrada com sucesso!"
                );

            }catch(Exception ex){

                JOptionPane.showMessageDialog(
                        null,
                        "Erro ao cadastrar sessão."
                );

            }

        });

        //=========================
        // BUSCAR
        //=========================

        btnBuscar.addActionListener(e -> {

            Sessao sessao =
                    cinemaService.pesquisarSessao(
                            Integer.parseInt(txtNumero.getText()));

            if(sessao == null){

                areaResultado.setText("Sessão não encontrada.");

            }else{

                areaResultado.setText(sessao.toString());

            }

        });

        //=========================
        // REMOVER
        //=========================

        btnRemover.addActionListener(e -> {

            try{

                cinemaService.removerSessao(
                        Integer.parseInt(txtNumero.getText()));

                JOptionPane.showMessageDialog(
                        null,
                        "Sessão removida.");

            }catch(Exception ex){

                JOptionPane.showMessageDialog(
                        null,
                        ex.getMessage());

            }

        });

        //=========================
        // LISTAR
        //=========================

        btnListar.addActionListener(e -> {

            areaResultado.setText("");

            for(Sessao s : cinemaService.listarSessoes()){

                areaResultado.append(s + "\n");

            }

        });

        //=========================
        // LIMPAR
        //=========================

        btnLimpar.addActionListener(e -> {

            txtNumero.setText("");

            cbTipoSala.setSelectedIndex(0);

            areaResultado.setText("");

        });

    }

}
