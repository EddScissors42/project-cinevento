package cinevento.ui;

import cinevento.irl.Cliente;
import cinevento.service.CinemaService;

import javax.swing.*;
import java.awt.*;

public class TelaClientes extends JFrame {

    private JTextField txtNome;
    private JTextField txtCodigo;

    private JButton btnCadastrar;
    private JButton btnBuscar;
    private JButton btnRemover;
    private JButton btnListar;
    private JButton btnLimpar;

    private JTextArea areaResultado;

    private CinemaService cinemaService;

    public TelaClientes(CinemaService cinemaService){

        this.cinemaService = cinemaService;

        setTitle("Clientes");
        setSize(550,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel painelCampos = new JPanel(new GridLayout(2,2,5,5));

        painelCampos.setBorder(
                BorderFactory.createTitledBorder("Dados do Cliente"));

        painelCampos.add(new JLabel("Nome"));
        txtNome = new JTextField();
        painelCampos.add(txtNome);

        painelCampos.add(new JLabel("Código"));
        txtCodigo = new JTextField();
        painelCampos.add(txtCodigo);

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

        scroll.setBorder(
                BorderFactory.createTitledBorder("Resultado"));

        add(scroll,BorderLayout.SOUTH);

        //=========================
        // CADASTRAR
        //=========================

        btnCadastrar.addActionListener(e->{

            try{

                Cliente cliente = new Cliente(

                        txtNome.getText(),
                        txtCodigo.getText()

                );

                cinemaService.cadastrarCliente(cliente);

                JOptionPane.showMessageDialog(
                        null,
                        "Cliente cadastrado com sucesso!"
                );

            }catch(Exception ex){

                JOptionPane.showMessageDialog(
                        null,
                        "Erro ao cadastrar cliente."
                );

            }

        });

        //=========================
        // BUSCAR
        //=========================

        btnBuscar.addActionListener(e->{

            Cliente cliente =
                    cinemaService.pesquisarCliente(
                            txtCodigo.getText());

            if(cliente==null){

                areaResultado.setText("Cliente não encontrado.");

            }else{

                areaResultado.setText(cliente.toString());

            }

        });

        //=========================
        // REMOVER
        //=========================

        btnRemover.addActionListener(e->{

            try{

                cinemaService.removerCliente(
                        txtCodigo.getText());

                JOptionPane.showMessageDialog(
                        null,
                        "Cliente removido."
                );

            }catch(Exception ex){

                JOptionPane.showMessageDialog(
                        null,
                        "Erro ao remover cliente."
                );

            }

        });

        //=========================
        // LISTAR
        //=========================

        btnListar.addActionListener(e->{

            areaResultado.setText("");

            for(Cliente cliente :
                    cinemaService.listarClientes()){

                areaResultado.append(cliente+"\n");

            }

        });

        //=========================
        // LIMPAR
        //=========================

        btnLimpar.addActionListener(e->{

            txtNome.setText("");
            txtCodigo.setText("");
            areaResultado.setText("");

        });

    }

}
