package Tarea_Swing;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PRACTICA1 {
    private JTextField textField1; // Número 1
    private JTextField textField2; // Número 2
    private JTextField textField3; // Resultado
    private JButton dividirButton;
    private JButton multiplicarButton;
    private JButton restarButton;
    private JButton sumaButton;
    private JPanel mainPanel;

    public PRACTICA1() {
        sumaButton.addActionListener(e -> calcularResultado('+'));
        restarButton.addActionListener(e -> calcularResultado('-'));
        multiplicarButton.addActionListener(e -> calcularResultado('*'));
        dividirButton.addActionListener(e -> calcularResultado('/'));
        textField3.setEditable(false);
    }
    private void calcularResultado(char operacion) {
        Double valor1 = obtenerNumero(textField1, "Número 1");
        if (valor1 == null) return;
        Double valor2 = obtenerNumero(textField2, "Número 2");
        if (valor2 == null) return;
        double resultado = 0;
        boolean operacionExitosa = true;

        switch (operacion) {
            case '+':
                resultado = valor1 + valor2;
                break;
            case '-':
                resultado = valor1 - valor2;
                break;
            case '*':
                resultado = valor1 * valor2;
                break;
            case '/':
                if (valor2 == 0) {
                    JOptionPane.showMessageDialog(mainPanel,
                            "Error: No se puede dividir por cero.",
                            "Error Matemático",
                            JOptionPane.ERROR_MESSAGE);
                    operacionExitosa = false;
                } else {
                    resultado = valor1 / valor2;
                }
                break;
        }

        if (operacionExitosa) {

            textField3.setText(String.format("%.2f", resultado));
        } else {
            textField3.setText("");
        }
    }

    private Double obtenerNumero(JTextField campo, String nombreCampo) {
        String texto = campo.getText().trim();

        if (texto.isEmpty()) {
            JOptionPane.showMessageDialog(mainPanel,
                    "Error: El campo '" + nombreCampo + "' no puede estar vacío.",
                    "Error de Entrada",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }

        try {
            String textoLimpio = texto.replace(',', '.');
            return Double.parseDouble(textoLimpio);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainPanel,
                    "Error: Ingrese un valor numérico válido en el campo '" + nombreCampo + "'.",
                    "Error de Entrada",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("FORMULARIO 1 - Operaciones Matemáticas");

        PRACTICA1 practica1 = new PRACTICA1();

        frame.setContentPane(practica1.mainPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}