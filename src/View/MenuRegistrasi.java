/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.Controller;
import Model.CategoryUser;
import Model.User;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author lenovo
 */
public class MenuRegistrasi implements ActionListener {

    JFrame frame = new JFrame();
    JTextField inputEmail;
    JTextField inputUsername;
    JRadioButton Pria;
    JRadioButton Wanita;
    JComboBox inputkategori;
    JPasswordField inputPassword;

    public MenuRegistrasi() {
        frame.setTitle("Menu Registrasi");
        frame.setSize(400, 400);
        frame.setLayout(null);
        JLabel email = new JLabel("Email");
        email.setBounds(10, 40, 100, 30);
        inputEmail = new JTextField();
        inputEmail.setBounds(120, 40, 200, 30);
        frame.add(email);
        frame.add(inputEmail);
        JLabel username = new JLabel("Username");
        username.setBounds(10, 80, 100, 30);
        inputUsername = new JTextField();
        inputUsername.setBounds(120, 80, 200, 30);
        frame.add(username);
        frame.add(inputUsername);

        JLabel kelamin = new JLabel("Jenis Kelamin");
        kelamin.setBounds(10, 120, 100, 30);
        Pria = new JRadioButton("Pria");
        Pria.setBounds(120, 120, 100, 30);
        Wanita = new JRadioButton("Wanita");
        Wanita.setBounds(230, 120, 100, 30);
        ButtonGroup groupKelamin = new ButtonGroup();
        groupKelamin.add(Pria);
        groupKelamin.add(Wanita);
        frame.add(kelamin);
        frame.add(Pria);
        frame.add(Wanita);

        Controller control = new Controller();
        JLabel kategori = new JLabel("Kategori");
        kategori.setBounds(10, 160, 100, 30);
        ArrayList<CategoryUser> listCategory = control.getAllCategory();
        inputkategori = new JComboBox();
        inputkategori.setBounds(120, 160, 100, 30);
        inputkategori.addItem("-");
        for (int i = 0; i < listCategory.size(); i++) {
            inputkategori.addItem(listCategory.get(i).getCategoryName());
        }
        frame.add(kategori);
        frame.add(inputkategori);
        JLabel password = new JLabel("Password");
        password.setBounds(10, 200, 100, 30);
        inputPassword = new JPasswordField();
        inputPassword.setBounds(120, 200, 200, 30);
        frame.add(password);
        frame.add(inputPassword);

        JButton buttonLogin = new JButton("Registrasi");
        buttonLogin.setBounds(10, 240, 100, 30);
        buttonLogin.addActionListener(this);
        frame.add(buttonLogin);

        JButton buttonBack = new JButton("Back");
        buttonBack.setBounds(120, 240, 100, 30);
        buttonBack.addActionListener(this);
        frame.add(buttonBack);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Registrasi":
                if(inputEmail.getText()=="" && inputUsername.getText()=="" && !(Pria.isSelected() || Wanita.isSelected()) && inputkategori.getSelectedItem() =="-" && inputPassword.getPassword().toString()==""){
                }else{
                    Controller controller = new Controller();
                    
                    
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
