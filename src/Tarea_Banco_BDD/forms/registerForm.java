package Tarea_Banco_BDD.forms;

import Tarea_Banco_BDD.db.ConexionDB;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registerForm extends JFrame {
    private JPanel registerPanel;
    private JTextField txtUsuario;
    private JPasswordField txtClave;
    private JTextField txtNombre;
    private JTextField txtSaldoInicial;
    private JButton btnRegistrar;
    private JLabel imagen;

    public registerForm() {
        setTitle("Registro de Nuevo Cliente");
        setSize(700, 400);
        setContentPane(registerPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        try {
            ImageIcon cat = new ImageIcon(getClass().getResource("/Tarea_Banco_BDD/img/gatito.png"));
            imagen.setIcon(cat);

        } catch (Exception e) {
            System.err.println("Error al cargar imágenes. Revisar la ruta en el classpath.");
            // Esto evita que la aplicación se caiga si la ruta sigue siendo incorrecta
        }
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });
    }

    private void registrarUsuario() {
        String usuario = txtUsuario.getText();
        String clave = new String(txtClave.getPassword());
        String nombre = txtNombre.getText();
        String saldoStr = txtSaldoInicial.getText();
        double saldoInicial;

        // 1. Validaciones
        if (usuario.isEmpty() || clave.isEmpty() || nombre.isEmpty() || saldoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            saldoInicial = Double.parseDouble(saldoStr);
            if (saldoInicial < 0) {
                JOptionPane.showMessageDialog(this, "El saldo inicial no puede ser negativo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El saldo debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 2. Ejecutar INSERT en la DB
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO usuarios (usuario, clave, nombre_cliente, saldo) VALUES (?, ?, ?, ?)";

        try {
            conn = ConexionDB.getConnection();
            if (conn == null) return;

            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ps.setString(3, nombre);
            ps.setDouble(4, saldoInicial);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "Registro exitoso para " + nombre + "! Ya puedes ingresar.");
                dispose(); // Cerrar la ventana de registro
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar el usuario.", "Error SQL", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            // Error 1062 es el código de MySQL para entrada duplicada (UNIQUE key, en este caso, el usuario)
            if (e.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(this, "El nombre de usuario '" + usuario + "' ya existe. Por favor, elige otro.", "Error de Duplicado", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error de base de datos: " + e.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
            }
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {}
            ConexionDB.closeConnection(conn);
        }
    }
}