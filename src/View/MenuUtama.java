/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author lenovo
 */
public class MenuUtama implements ActionListener {

    JFrame frame = new JFrame();

    public MenuUtama() {
        frame.setTitle("Menu Utama");
        frame.setSize(400, 400);
        frame.setLayout(null);
        JButton buttonLogin = new JButton("Login");
        buttonLogin.setBounds(50, 100, 300, 30);
        buttonLogin.addActionListener(this);
        JButton buttonRegistrasi = new JButton("Registrasi Pengguna Baru");
        buttonRegistrasi.setBounds(50, 150, 300, 30);
        buttonRegistrasi.addActionListener(this);
        JButton buttonLihatDataKategori = new JButton("Lihat Data Pengguna Berdasarkan Kategori");
        buttonLihatDataKategori.setBounds(50, 200, 300, 30);
        buttonLihatDataKategori.addActionListener(this);
        frame.add(buttonLogin);
        frame.add(buttonRegistrasi);
        frame.add(buttonLihatDataKategori);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "Login":
                frame.dispose();
                new MenuLogin();
                break;
            case "Registrasi Pengguna Baru":
                frame.dispose();
                new MenuRegistrasi();
                break;
            case "Lihat Data Pengguna Berdasarkan Kategori":
                frame.dispose();
                new MenuLihatPenggunaBerdasarkanKategori();
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        new MenuUtama();
    }
}
