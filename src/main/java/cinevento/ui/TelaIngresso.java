package cinevento.ui;

import cinevento.irl.Cliente;
import cinevento.irl.Ingresso;
import cinevento.irl.Sessao;
import cinevento.service.CinemaService;

import javax.swing.*;
import java.awt.*;

public class TelaIngressos extends JFrame {

    private JTextField txtCodigoCliente;
    private JTextField txtNumeroSessao;
    private JTextField txtCodigoReserva;

    private JButton btnComprar;
    private JButton btnCancelar;
    private JButton btnLimpar;

    private JTextArea areaResultado;

    private CinemaService cinemaService;

    public TelaIngressos(CinemaService cinemaService){

        this.cinemaService = cinemaService;

        setTitle("Ingressos");

        setSize(600,500);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel painelCampos = new JPanel(new GridLayout(3,2,5,5));

        painelCampos.setBorder(
                BorderFactory.createTitledBorder("Dados do Ingresso")
        );

        painelCampos.add(new JLabel("Código do Cliente"));
        txtCodigoCliente = new JTextField();
        painelCampos.add(txtCodigoCliente);

        painelCampos.add(new JLabel("Número da Sessão"));
        txtNumeroSessao = new JTextField();
        painelCampos.add(txtNumeroSessao);

        painelCampos.add(new JLabel("Código da Reserva"));
        txtCodigoReserva = new JTextField();
        painelCampos.add(txtCodigoReserva);

        add(painelCampos, BorderLayout.NORTH);

        JPanel painelBotoes = new JPanel(new GridLayout(1,3,10,10));

        btnComprar = new JButton("Comprar");
        btnCancelar = new JButton("Cancelar");
        btnLimpar = new JButton("Limpar");

        painelBotoes.add(btnComprar);
        painelBotoes.add(btnCancelar);
        painelBotoes.add(btnLimpar);

        add(painelBotoes, BorderLayout.CENTER);

        areaResultado = new JTextArea();

        areaResultado.setEditable(false);

        JScrollPane scroll = new JScrollPane(areaResultado);

        scroll.setBorder(
                BorderFactory.createTitledBorder("Resultado")
        );

        add(scroll, BorderLayout.SOUTH);

        //==========================================
        // COMPRAR INGRESSO
        //==========================================

        btnComprar.addActionListener(e -> {

            try{

                Cliente cliente =
                        cinemaService.pesquisarCliente(
                                txtCodigoCliente.getText());

                Sessao sessao =
                        cinemaService.pesquisarSessao(
                                Integer.parseInt(txtNumeroSessao.getText()));

                Ingresso ingresso =
                        cinemaService.comprarIngresso(cliente, sessao);

                txtCodigoReserva.setText(
                        ingresso.getCodigoReserva());

                areaResultado.setText(
                        ingresso.toString());

                JOptionPane.showMessageDialog(
                        null,
                        "Ingresso comprado com sucesso!"
                );

            }catch(Exception ex){

                JOptionPane.showMessageDialog(
                        null,
                        "Erro ao comprar ingresso."
                );

            }

        });

        //==========================================
        // CANCELAR
        //==========================================

        btnCancelar.addActionListener(e -> {

            try{

                cinemaService.cancelarIngresso(
                        txtCodigoReserva.getText());

                JOptionPane.showMessageDialog(
                        null,
                        "Ingresso cancelado."
                );

                areaResultado.setText("");

            }catch(Exception ex){

                JOptionPane.showMessageDialog(
                        null,
                        "Ingresso não encontrado."
                );

            }

        });

        //==========================================
        // LIMPAR
        //==========================================

        btnLimpar.addActionListener(e -> {

            txtCodigoCliente.setText("");
            txtNumeroSessao.setText("");
            txtCodigoReserva.setText("");
            areaResultado.setText("");

        });

    }

}
