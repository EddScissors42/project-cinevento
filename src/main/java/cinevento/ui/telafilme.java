package cinevento.ui;

import cinevento.service.CinemaService;
import cinevento.irl.Filme;

import javax.swing.*;
import java.awt.*;

public class TelaFilmes extends JFrame {

    private JTextField txtId;
    private JTextField txtTitulo;
    private JTextField txtGenero;
    private JTextField txtDuracao;

    private JComboBox<String> cbClassificacao;

    private JButton btnCadastrar;
    private JButton btnBuscar;
    private JButton btnRemover;
    private JButton btnListar;
    private JButton btnLimpar;

    private JTextArea areaResultado;

    private CinemaService cinemaService;

    public TelaFilmes(CinemaService cinemaService){

        this.cinemaService = cinemaService;

        setTitle("Filmes");
        setSize(600,550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel painelCampos = new JPanel(new GridLayout(5,2,5,5));

        painelCampos.setBorder(BorderFactory.createTitledBorder("Dados do Filme"));

        painelCampos.add(new JLabel("ID"));
        txtId = new JTextField();
        painelCampos.add(txtId);

        painelCampos.add(new JLabel("Título"));
        txtTitulo = new JTextField();
        painelCampos.add(txtTitulo);

        painelCampos.add(new JLabel("Gênero"));
        txtGenero = new JTextField();
        painelCampos.add(txtGenero);

        painelCampos.add(new JLabel("Duração (segundos)"));
        txtDuracao = new JTextField();
        painelCampos.add(txtDuracao);

        painelCampos.add(new JLabel("Classificação"));

        cbClassificacao = new JComboBox<>();

        cbClassificacao.addItem("Livre");
        cbClassificacao.addItem("10");
        cbClassificacao.addItem("12");
        cbClassificacao.addItem("14");
        cbClassificacao.addItem("16");
        cbClassificacao.addItem("18");

        painelCampos.add(cbClassificacao);

        add(painelCampos,BorderLayout.NORTH);

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

        add(painelBotoes,BorderLayout.CENTER);

        areaResultado = new JTextArea();

        areaResultado.setEditable(false);

        JScrollPane scroll = new JScrollPane(areaResultado);

        scroll.setBorder(BorderFactory.createTitledBorder("Resultado"));

        add(scroll,BorderLayout.SOUTH);

        //==========================
        // BOTÃO CADASTRAR
        //==========================

        btnCadastrar.addActionListener(e->{

            try{

                Filme filme = new Filme(

                        Integer.parseInt(txtId.getText()),
                        txtTitulo.getText(),
                        txtGenero.getText(),
                        Integer.parseInt(txtDuracao.getText()),
                        cbClassificacao.getSelectedItem().toString()

                );

                cinemaService.cadastrarFilme(filme);

                JOptionPane.showMessageDialog(null,
                        "Filme cadastrado com sucesso!");

            }catch(Exception ex){

                JOptionPane.showMessageDialog(null,
                        "Erro ao cadastrar filme.");

            }

        });

        //==========================
        // BUSCAR
        //==========================

        btnBuscar.addActionListener(e->{

            try{

                Filme filme =
                        cinemaService.pesquisarFilme(
                                Integer.parseInt(txtId.getText()));

                if(filme==null){

                    areaResultado.setText("Filme não encontrado.");

                }else{

                    areaResultado.setText(filme.toString());

                }

            }catch(Exception ex){

                areaResultado.setText("Erro na pesquisa.");

            }

        });

        //==========================
        // REMOVER
        //==========================

        btnRemover.addActionListener(e->{

            try{

                cinemaService.removerFilme(
                        Integer.parseInt(txtId.getText()));

                JOptionPane.showMessageDialog(null,
                        "Filme removido.");

            }catch(Exception ex){

                JOptionPane.showMessageDialog(null,
                        "Erro ao remover.");

            }

        });

        //==========================
        // LISTAR
        //==========================

        btnListar.addActionListener(e->{

            areaResultado.setText("");

            for(Filme filme : cinemaService.listarFilmes()){

                areaResultado.append(filme+"\n");

            }

        });

        //==========================
        // LIMPAR
        //==========================

        btnLimpar.addActionListener(e->{

            txtId.setText("");
            txtTitulo.setText("");
            txtGenero.setText("");
            txtDuracao.setText("");
            cbClassificacao.setSelectedIndex(0);
            areaResultado.setText("");

        });

    }

}
