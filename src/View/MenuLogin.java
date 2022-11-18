/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.Controller;
import Model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author lenovo
 */
public class MenuLogin implements ActionListener {

    JFrame frame = new JFrame();
    JTextField inputUsername;
    JPasswordField inputPassword;

    public MenuLogin() {
        frame.setTitle("Menu Utama");
        frame.setSize(400, 400);
        frame.setLayout(null);
        ImageIcon img = new ImageIcon("");
        //set image icon
        JLabel namaAplikasi = new JLabel("Instogram");
        namaAplikasi.setBounds(10, 40, 100, 30);
        frame.add(namaAplikasi);

        JLabel username = new JLabel("Username");
        username.setBounds(10, 80, 100, 30);
        inputUsername = new JTextField();
        inputUsername.setBounds(120, 80, 200, 30);
        frame.add(username);
        frame.add(inputUsername);

        JLabel password = new JLabel("Password");
        password.setBounds(10, 140, 100, 30);
        inputPassword = new JPasswordField();
        inputPassword.setBounds(120, 140, 200, 30);
        frame.add(password);
        frame.add(inputPassword);

        JButton buttonLogin = new JButton("Login");
        buttonLogin.setBounds(10, 200, 100, 30);
        buttonLogin.addActionListener(this);
        frame.add(buttonLogin);

        JButton buttonBack = new JButton("Back");
        buttonBack.setBounds(120, 200, 100, 30);
        buttonBack.addActionListener(this);
        frame.add(buttonBack);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Login":
                Controller control = new Controller();
                boolean checkLogin = control.checkLogin(inputUsername.getText(), inputPassword.getPassword());
                if (checkLogin) {
                    JOptionPane.showMessageDialog(null, "User ada di database");
                } else {
                    JOptionPane.showMessageDialog(null, "User tidak ada di database");
                }
                break;
            case "Back":
                frame.dispose();
                new MenuUtama();
                break;
            default:
                break;
        }
    }
}
