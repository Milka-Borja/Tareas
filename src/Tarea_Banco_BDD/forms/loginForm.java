package Tarea_Banco_BDD.forms;

import Tarea_Banco_BDD.db.ConexionDB; // Importar la clase de conexión
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

    // Variables adicionales para manejo de intentos (Requisito extra)
    private static final int MAX_INTENTOS = 3;
    private int intentosFallidos = 0;

    public loginForm(){
        setTitle("loginForm");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(loginPanel);
        setLocationRelativeTo(null);
        setVisible(true); // Se hace visible antes de establecer las propiedades si no se usa Main

        textField1.setBorder(BorderFactory.createEmptyBorder());
        passwordField1.setBorder(BorderFactory.createEmptyBorder());
        button1.setBorder(BorderFactory.createEmptyBorder());

        // 🛑 Corregir Rutas de Imagen (Asumiendo que /img/ es la ruta correcta)
        try {
            ImageIcon icono = new ImageIcon(getClass().getResource("/Tarea_Banco_BDD/img/gato.jpg"));
            ImageIcon logotipo = new ImageIcon(getClass().getResource("/Tarea_Banco_BDD/img/pata.png"));
            logo.setIcon(logotipo);
            icon.setIcon(icono);
        } catch (Exception e) {
            System.err.println("Error al cargar imágenes. Revisar la ruta en el classpath.");
            // Esto evita que la aplicación se caiga si la ruta sigue siendo incorrecta
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

                // Llamar a la validación de la DB
                String nombreCliente = validarCredenciales(usuarioIngresado, claveIngresada);

                if (nombreCliente != null) {
                    // Éxito: Resetear intentos y hacer la transición
                    intentosFallidos = 0;
                    JOptionPane.showMessageDialog(null, "Bienvenido, " + nombreCliente + "!");

                    dispose(); // Cerrar la ventana de login actual

                    // 🚨 TRANSICIÓN: Crear y mostrar el BancoForm, pasando el usuario y nombre
                    bancoForm ventanaBanco = new bancoForm(usuarioIngresado, nombreCliente);
                    ventanaBanco.setVisible(true);

                } else {
                    // Falla: Incrementar intentos y mostrar error
                    intentosFallidos++;
                    JOptionPane.showMessageDialog(null, "Clave o Usuario incorrecto. Intento " + intentosFallidos + " de " + MAX_INTENTOS, "Error de Login", JOptionPane.ERROR_MESSAGE);

                    if (intentosFallidos >= MAX_INTENTOS) {
                        JOptionPane.showMessageDialog(null, "Acceso Bloqueado. Demasiados intentos fallidos.", "BLOQUEO", JOptionPane.ERROR_MESSAGE);
                        button1.setEnabled(false); // Deshabilita el botón
                        // System.exit(0); // O cerrar la aplicación si el requisito lo pide
                    }
                }

                // Limpiar campos después del intento (sea exitoso o fallido)
                passwordField1.setText("");
            }
        });

    }

    /**
     * Consulta la base de datos para verificar las credenciales.
     * @param usuario El nombre de usuario ingresado.
     * @param clave La contraseña ingresada.
     * @return El nombre completo del cliente si las credenciales son válidas, o null si son incorrectas.
     */
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
                // Credenciales correctas. Obtener el nombre.
                nombreCliente = rs.getString("nombre_cliente");
            }

        } catch (SQLException e) {
            System.err.println("Error al consultar credenciales: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Asegurar que todos los recursos se cierren
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
