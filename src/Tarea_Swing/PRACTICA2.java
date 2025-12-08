package Tarea_Swing;

import javax.swing.*;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PRACTICA2 {

    private JPanel panel1;
    private JButton enviarRespuestasButton;

    private JRadioButton SIRadioButton;
    private JRadioButton NORadioButton;
    private JRadioButton quieroTenerRadioButton;

    private JRadioButton muyFrecuentementeRadioButton;
    private JRadioButton aVecesRadioButton;
    private JRadioButton nuncaRadioButton;

    private JRadioButton caféRadioButton;
    private JRadioButton téRadioButton;
    private JRadioButton lecheRadioButton;

    private ButtonGroup bgMascotas;
    private ButtonGroup bgEjercicio;
    private ButtonGroup bgBebida;

    public PRACTICA2() {

        bgMascotas = new ButtonGroup();
        bgEjercicio = new ButtonGroup();
        bgBebida = new ButtonGroup();

        bgMascotas.add(SIRadioButton);
        bgMascotas.add(NORadioButton);
        bgMascotas.add(quieroTenerRadioButton);

        bgEjercicio.add(muyFrecuentementeRadioButton);
        bgEjercicio.add(aVecesRadioButton);
        bgEjercicio.add(nuncaRadioButton);

        // Grupo 3: Bebida
        bgBebida.add(caféRadioButton);
        bgBebida.add(téRadioButton);
        bgBebida.add(lecheRadioButton);

        if (enviarRespuestasButton != null) {
            enviarRespuestasButton.addActionListener(e -> enviarEncuesta());
        }
    }


    private void enviarEncuesta() {
        String resMascota = obtenerRespuesta(bgMascotas);
        String resEjercicio = obtenerRespuesta(bgEjercicio);
        String resBebida = obtenerRespuesta(bgBebida);
        if (resMascota.equals("No respondida") ||
                resEjercicio.equals("No respondida") ||
                resBebida.equals("No respondida")) {

            JOptionPane.showMessageDialog(panel1,
                    "⚠️ Por favor, selecciona una opción para cada pregunta.",
                    "Faltan Respuestas",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        String resumen = "--- Resumen de la Encuesta --- \n"
                + "1. ¿Tienes mascotas?: " + resMascota + "\n"
                + "2. ¿Con qué frecuencia haces ejercicio?: " + resEjercicio + "\n"
                + "3. ¿Cuál es tu bebida caliente favorita?: " + resBebida;
        JOptionPane.showMessageDialog(panel1, resumen, "Resultados Enviados", JOptionPane.INFORMATION_MESSAGE);
    }

    private String obtenerRespuesta(ButtonGroup grupo) {

        Enumeration<AbstractButton> buttons = grupo.getElements();
        while (buttons.hasMoreElements()) {
            AbstractButton boton = buttons.nextElement();
            if (boton.isSelected()) {
                return boton.getText();
            }
        }
        return "No respondida";
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("FORMULARIO 2 - Encuesta Rápida");
        PRACTICA2 practica2 = new PRACTICA2();

        if (practica2.panel1 != null) {
            frame.setContentPane(practica2.panel1);
        } else {
            System.err.println("FATAL: El panel principal 'panel1' es NULL. Revisa el diseñador de GUI (binding).");
            return;
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}