package Controller;

import Component.PanelLoginDanReg;
import Model.Operator.*;
import View.*;
import javax.swing.*;
import java.awt.*;

public class ControllerOperator {
    private ViewLogin viewLogin;
    private PanelLoginDanReg cover;

    public ControllerOperator(ViewLogin viewLogin, PanelLoginDanReg cover) {
        this.viewLogin = viewLogin;
        this.cover = cover;
    }

    public void insertData(String username, String namaLengkap, String email, String password) {
        ModelOperator operator = new ModelOperator();
        operator.setUsername(username);
        operator.setNama_lengkap(namaLengkap);
        operator.setEmail(email);
        operator.setPassword(password);

        DAOOperator dao = new DAOOperator();
        boolean inputBerhasil = dao.insert(operator);
        
        if(inputBerhasil){
            JOptionPane.showMessageDialog(null, createStyledPanel("Berhasil Sign Up! Silahkan Lanjutkan Login."), "Sukses", JOptionPane.INFORMATION_MESSAGE);
            new ViewLogin();
            viewLogin.dispose();
        } else {
            JOptionPane.showMessageDialog(null, createStyledPanel("Terjadi Kesalahan saat Sign Up"), "Sign Up Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void validasiLogin(String email, String password) {
        DAOOperator dao = new DAOOperator();
        boolean isValid = dao.validasiLogin(email, password);

        if (isValid) {
            JOptionPane.showMessageDialog(null, createStyledPanel("Login Berhasil!"), "Sukses", JOptionPane.INFORMATION_MESSAGE);
            new ViewReservasi(); 
            viewLogin.dispose(); 
        } else {
            JOptionPane.showMessageDialog(null, createStyledPanel("Email atau Password salah!"), "Login Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JPanel createStyledPanel(String message) {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(new Color(220, 53, 69), 2));
        JLabel label = new JLabel("<html><div style='padding:8px;font-size:12px;color:#dc3545;'>" + message + "</div></html>");
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(label);
        return panel;
    }
    
    
}
