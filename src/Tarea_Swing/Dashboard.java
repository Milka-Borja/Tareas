package Tarea_Swing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {


    private JPanel Dashboard;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton Sumabtn;
    private JButton Restabtn;
    private JButton Multbtn;
    private JButton Divbtn;

    public Dashboard() {
        setTitle("Pantalla Principal");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setContentPane(Dashboard);
        setLocationRelativeTo(null);

        Sumabtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double val1= Double.parseDouble(textField1.getText());
                double val2= Double.parseDouble(textField2.getText());
                double suma = val1 + val2;
                textField3.setText(String.valueOf(suma));
            }
        });

        Restabtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double val1= Double.parseDouble(textField1.getText());
                double val2= Double.parseDouble(textField2.getText());
                double resta = val1 - val2;
                textField3.setText(String.valueOf(resta));
            }
        });

        Multbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double val1= Double.parseDouble(textField1.getText());
                double val2= Double.parseDouble(textField2.getText());
                double mult=val1*val2;
                textField3.setText(String.valueOf(mult));
            }
        });

        Divbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double val1= Double.parseDouble(textField1.getText());
                double val2= Double.parseDouble(textField2.getText());
                double div=val1/val2;
                textField3.setText(String.valueOf(div));
            }
        });
    }

}