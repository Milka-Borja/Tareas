package Tarea_Banco_BDD.forms;

import Tarea_Banco_BDD.db.ConexionDB;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.sql.SQLException;

public class bancoForm extends JFrame {
    private JLabel lblSaldo;
    private JLabel lblNombreCliente; // Asegúrate de que este componente exista en tu .form
    private JPanel mainPanel;
    private JButton btnDeposito;
    private JButton SALIRButton;
    private JButton btnRetiro;
    private JButton btnTransferencia;
    private JTextArea txtHistorial;
    private JLabel gatos;
    private JLabel gatos2;


    private String usuarioActual;
    private String nombreCliente;
    private double saldo;
    private ArrayList<String> listaTransacciones = new ArrayList<>();


    // 🛑 NUEVO CONSTRUCTOR
    public bancoForm(String usuario, String nombre) {
        this.usuarioActual = usuario;
        this.nombreCliente = nombre;

        setTitle("Banco de " + nombre);
        setSize(1000, 800);
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        try {
            ImageIcon gati = new ImageIcon(getClass().getResource("/Tarea_Banco_BDD/img/gatis.jpg"));
            gatos.setIcon(gati);
            ImageIcon gati2 = new ImageIcon(getClass().getResource("/Tarea_Banco_BDD/img/gatis2.jpg"));
            gatos2.setIcon(gati2);
        } catch (Exception e) {
            System.err.println("Error al cargar imágenes. Revisar la ruta en el classpath.");
            // Esto evita que la aplicación se caiga si la ruta sigue siendo incorrecta
        }

        // Cargar el saldo inicial y el nombre desde la DB
        cargarDatosIniciales();

        // Los ActionListeners se mantienen y se conectan a los nuevos métodos

        btnDeposito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deposito = JOptionPane.showInputDialog("Ingrese el monto a depositar:");
                if (deposito != null && !deposito.isEmpty()) {
                    try {
                        double monto = Double.parseDouble(deposito);
                        if (monto > 0) {
                            saldo += monto;
                            actualizarSaldoDB();
                            registrarTransaccion("Depósito: $" + String.format("%.2f", monto));
                            JOptionPane.showMessageDialog(null, "Depósito exitoso.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Monto inválido.");
                    }
                }
            }
        });

        SALIRButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnTransferencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String destinatario = JOptionPane.showInputDialog("Ingrese el nombre del destinatario:");
                if (destinatario == null || destinatario.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un nombre");
                    return;
                }

                String valor = JOptionPane.showInputDialog("Ingrese el monto a transferir:");
                if (valor == null || valor.isEmpty()) {
                    return;
                }

                try {
                    double monto = Double.parseDouble(valor);

                    if (monto <= 0) {
                        JOptionPane.showMessageDialog(null, "El monto debe ser mayor a 0.");
                        return;
                    }

                    if (monto > saldo) {
                        JOptionPane.showMessageDialog(null, "Fondos insuficientes.");
                        return;
                    }

                    saldo -= monto;
                    actualizarSaldoDB();
                    registrarTransaccion("Transferencia a " + destinatario + ": $" + String.format("%.2f", monto));
                    JOptionPane.showMessageDialog(null, "Transferencia exitosa a " + destinatario + " por $" + String.format("%.2f", monto));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Monto inválido.");
                }
            }
        });

        btnRetiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String retiro = JOptionPane.showInputDialog("Ingrese el monto a retirar:");
                if(retiro == null || retiro.isEmpty()){
                    return;
                }

                try {
                    double monto = Double.parseDouble(retiro);

                    if(monto <= 0){
                        JOptionPane.showMessageDialog(null, "El monto no puede ser negativo.");
                        return;
                    }

                    if(monto > saldo){
                        JOptionPane.showMessageDialog(null, "Saldo insuficiente.");
                        return;
                    }

                    saldo -= monto;
                    actualizarSaldoDB();
                    registrarTransaccion("Retiro: $" + String.format("%.2f", monto));
                    JOptionPane.showMessageDialog(null, "Retiro exitoso.");

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Monto inválido.");
                }
            }
        });
    }

    // ----------------------------------------------------------------------
    // Lógica de Base de Datos y Actualización de UI
    // ----------------------------------------------------------------------

    private void cargarDatosIniciales() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT saldo, nombre_cliente FROM usuarios WHERE usuario = ?";

        try {
            conn = ConexionDB.getConnection();
            if (conn == null) return;

            ps = conn.prepareStatement(sql);
            ps.setString(1, this.usuarioActual);
            rs = ps.executeQuery();

            if (rs.next()) {
                this.saldo = rs.getDouble("saldo");
                this.nombreCliente = rs.getString("nombre_cliente");

                // Actualiza la interfaz con los datos cargados
                lblSaldo.setText("Saldo: $" + String.format("%.2f", this.saldo));
                // Si tienes lblNombreCliente, descomenta la siguiente línea:
                // lblNombreCliente.setText("Bienvenido, " + this.nombreCliente);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos del usuario desde la DB.", "Error SQL", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
            } catch (SQLException e) {}
            ConexionDB.closeConnection(conn);
        }
    }

    // Método para actualizar el saldo en la base de datos
    private void actualizarSaldoDB() {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "UPDATE usuarios SET saldo = ? WHERE usuario = ?";

        try {
            conn = ConexionDB.getConnection();
            if (conn == null) return;

            ps = conn.prepareStatement(sql);
            ps.setDouble(1, this.saldo);
            ps.setString(2, this.usuarioActual);
            ps.executeUpdate();

            // Actualizar el saldo en la UI
            lblSaldo.setText("Saldo: $" + String.format("%.2f", this.saldo));

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el saldo en la DB.", "Error SQL", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (SQLException e) {}
            ConexionDB.closeConnection(conn);
        }
    }

    // Método para registrar y mostrar las transacciones
    private void registrarTransaccion(String mensaje) {
        listaTransacciones.add(mensaje + " | Saldo: $" + String.format("%.2f", this.saldo));
        txtHistorial.setText("");
        for (String transaccion : listaTransacciones){
            txtHistorial.append(transaccion + "\n");
        }
    }
}
