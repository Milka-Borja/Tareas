package Tarea_Banco_BDD.forms;

import Tarea_Banco_BDD.db.ConexionDB;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginForm extends JFrame {
    private JPanel loginPanel;
    private JLabel icon;
    private JLabel logo;
    private JTextField textField1; // Campo de Usuario
    private JPasswordField passwordField1; // Campo de Contraseña
    private JButton button1; // Botón Ingresar
    private JButton btnRegistro;


    private static final int MAX_INTENTOS = 3;
    private int intentosFallidos = 0;

    public loginForm(){
        setTitle("loginForm");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(loginPanel);
        setLocationRelativeTo(null);
        setVisible(true);

        textField1.setBorder(BorderFactory.createEmptyBorder());
        passwordField1.setBorder(BorderFactory.createEmptyBorder());
        button1.setBorder(BorderFactory.createEmptyBorder());


        try {
            ImageIcon icono = new ImageIcon(getClass().getResource("/Tarea_Banco_BDD/img/gato.jpg"));
            ImageIcon logotipo = new ImageIcon(getClass().getResource("/Tarea_Banco_BDD/img/pata.png"));
            logo.setIcon(logotipo);
            icon.setIcon(icono);
        } catch (Exception e) {
            System.err.println("Error al cargar imágenes. Revisar la ruta en el classpath.");

        }
        btnRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerForm registro = new registerForm();
                registro.setVisible(true);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuarioIngresado = textField1.getText();
                String claveIngresada = new String(passwordField1.getPassword());

                String nombreCliente = validarCredenciales(usuarioIngresado, claveIngresada);

                if (nombreCliente != null) {

                    intentosFallidos = 0;
                    JOptionPane.showMessageDialog(null, "Bienvenido, " + nombreCliente + "!");

                    dispose();

                    bancoForm ventanaBanco = new bancoForm(usuarioIngresado, nombreCliente);
                    ventanaBanco.setVisible(true);

                } else {

                    intentosFallidos++;
                    JOptionPane.showMessageDialog(null, "Clave o Usuario incorrecto. Intento " + intentosFallidos + " de " + MAX_INTENTOS, "Error de Login", JOptionPane.ERROR_MESSAGE);

                    if (intentosFallidos >= MAX_INTENTOS) {
                        JOptionPane.showMessageDialog(null, "Acceso Bloqueado. Demasiados intentos fallidos.", "BLOQUEO", JOptionPane.ERROR_MESSAGE);
                        button1.setEnabled(false); // Deshabilita el botón

                    }
                }


                passwordField1.setText("");
            }
        });

    }


    private String validarCredenciales(String usuario, String clave) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String nombreCliente = null;

        // Consulta SQL parametrizada
        String sql = "SELECT nombre_cliente FROM usuarios WHERE usuario = ? AND clave = ?";

        try {
            conn = ConexionDB.getConnection();
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "No se pudo conectar a la base de datos.", "Error de Conexión", JOptionPane.ERROR_MESSAGE);
                return null;
            }

            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            rs = ps.executeQuery();

            if (rs.next()) {

                nombreCliente = rs.getString("nombre_cliente");
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar credenciales: " + e.getMessage());
            e.printStackTrace();
        } finally {

            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
            ConexionDB.closeConnection(conn);
        }
        return nombreCliente;
    }
}
