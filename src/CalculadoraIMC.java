import javax.swing.*;
import java.awt.*;

public class CalculadoraIMC extends JFrame {
    private JTextField txtPeso, txtAltura;
    private JButton btnCalcular;
    private JLabel lblResultado;

    public CalculadoraIMC() {
        setTitle("Calculadora de IMC");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        txtPeso = new JTextField(10);
        txtAltura = new JTextField(10);
        btnCalcular = new JButton("Calcular IMC");
        lblResultado = new JLabel("IMC: - Categoria: -");

        add(new JLabel("Peso:"));
        add(txtPeso);
        add(new JLabel("Altura:"));
        add(txtAltura);
        add(btnCalcular);
        add(lblResultado);

        btnCalcular.addActionListener(e -> {
            try {
                double peso = Double.parseDouble(txtPeso.getText());
                double altura = Double.parseDouble(txtAltura.getText());
                double imc = peso / (altura * altura);
                String categoria = imc < 18.5 ? "Baixo Peso" : imc < 24.9 ? "Normal" : imc < 29.9 ? "Sobrepeso" : "Obesidade";
                lblResultado.setText(String.format("IMC: %.2f Categoria: %s", imc, categoria));
            } catch (Exception ex) {
                lblResultado.setText("Entrada inválida");
            }
        });
    }

    public static void main(String[] args) {
        new CalculadoraIMC().setVisible(true);
    }
}
