package Taller_Operaciones_Matematicas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JPanel Login_pa;
    private JTextField textField1;
    private JTextField textField2;
    private JButton ACCESOButton;

    public Login() {
        setTitle("Pantalla Principal");
        setSize(400, 280);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(Login_pa);
        setLocationRelativeTo(null);
        ACCESOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user="Milka";
                String pass="1234";
                String usuario = textField1.getText();
                String password = textField2.getText();
                if(usuario.equals(user) && password.equals(pass)){
                    JOptionPane.showMessageDialog(null, "Usuario ingresado correctamente");
                    dispose();
                    new Dashboard();

                }else{
                    JOptionPane.showMessageDialog(null, "Usuario ingresado incorrecto");
                    textField1.setText("");
                    textField2.setText("");
                };
            }
        });
    }
}
