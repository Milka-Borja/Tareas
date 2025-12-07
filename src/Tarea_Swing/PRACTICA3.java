package Tarea_Swing;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PRACTICA3 {
    private JPanel panel1; // Asumiendo que el panel principal se llama panel1 o JPanel
    private JButton procesarSelecciónButton; // Tu botón "Procesar Selección"

    private JCheckBox programaciónCheckBox;
    private JCheckBox redesCheckBox;
    private JCheckBox baseDeDatosCheckBox;
    private JCheckBox diseñoDeInterfacesCheckBox; // Diseño de Interfaces
    private JCheckBox gestionDeProyectosCheckBox; // Gestión de Proyectos
    private JCheckBox analisisDeDatosCheckBox;   // Análisis de Datos

    private JLabel labelIntereses;

    public PRACTICA3() {
        if (procesarSelecciónButton != null) {
            procesarSelecciónButton.addActionListener(e -> procesarSeleccion());
        }
    }

    private void procesarSeleccion() {

        List<String> seleccionados = new ArrayList<>();

        verificarYAgregar(programaciónCheckBox, seleccionados);
        verificarYAgregar(redesCheckBox, seleccionados);
        verificarYAgregar(baseDeDatosCheckBox, seleccionados);
        verificarYAgregar(diseñoDeInterfacesCheckBox, seleccionados);
        verificarYAgregar(gestionDeProyectosCheckBox, seleccionados);
        verificarYAgregar(analisisDeDatosCheckBox, seleccionados);

        // 2. Construir el mensaje de resumen
        String resumen;

        if (seleccionados.isEmpty()) {
            resumen = "No ha seleccionado ningún interés o preferencia.";
        } else {
            // Unir todos los intereses seleccionados con saltos de línea (\n)
            resumen = " Intereses seleccionados: \n- " + String.join("\n- ", seleccionados);
        }
        JOptionPane.showMessageDialog(
                panel1,
                resumen,
                "Selección Procesada",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
    private void verificarYAgregar(JCheckBox cb, List<String> lista) {
        if (cb != null && cb.isSelected()) {
            lista.add(cb.getText());
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("FORMULARIO 3 - CheckBox (Selección Múltiple)");
        PRACTICA3 practica3 = new PRACTICA3();

        if (practica3.panel1 != null) {
            frame.setContentPane(practica3.panel1);
        } else {
            System.err.println("FATAL: El panel principal es NULL. Revisa el diseñador de GUI.");
            return;
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}