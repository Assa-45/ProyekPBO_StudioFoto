
package Component;

import Swing.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.*;
import net.miginfocom.swing.MigLayout;

public class PanelLoginDanReg extends javax.swing.JLayeredPane {
    private MyTextField loginEmail;
    private MyPasswordField loginPassword;
    private Button loginButton;
    
    private MyTextField registerUsername;
    private MyTextField registerName;
    private MyTextField registerEmail;
    private MyPasswordField registerPassword;
    private Button registerButton;
    
    public PanelLoginDanReg() {
        initComponents();
        initRegister();
        initLogin();
        login.setVisible(false);
        register.setVisible(true);
    }
    
    public void initRegister(){
        register.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]10[]25[]push"));
        JLabel label = new JLabel("Create Account");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(240,106,91));
        register.add(label);
        
        registerUsername = new MyTextField();
        registerUsername.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/user.png")));
        registerUsername.setHint("Username");
        register.add(registerUsername, "w 60%");
        
        registerName = new MyTextField();
        registerName.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/fullname.png")));
        registerName.setHint("Full Name");
        register.add(registerName, "w 60%");
        
        registerEmail = new MyTextField();
        registerEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/mail.png")));
        registerEmail.setHint("Email");
        register.add(registerEmail, "w 60%");
        
        registerPassword = new MyPasswordField();
        registerPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        registerPassword.setHint("Password");
        register.add(registerPassword, "w 60%");
        
        registerButton = new Button();
        registerButton.setBackground(new Color(240,106,91));
        registerButton.setForeground(new Color(250, 250, 250));
        registerButton.setText("SIGN UP");
        register.add(registerButton, "w 40%, h 40");
    }
    
    public void initLogin(){
        login.setLayout(new MigLayout("wrap", "push[center]push", "push[]25[]10[]10[]25[]push"));
        JLabel label = new JLabel("Sign In");
        label.setFont(new Font("sansserif", 1, 30));
        label.setForeground(new Color(240,106,91));
        login.add(label);
        
        loginEmail = new MyTextField();
        loginEmail.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/mail.png")));
        loginEmail.setHint("Email");
        login.add(loginEmail, "w 60%");
        
        loginPassword = new MyPasswordField();
        loginPassword.setPrefixIcon(new ImageIcon(getClass().getResource("/icon/pass.png")));
        loginPassword.setHint("Password");
        login.add(loginPassword, "w 60%");
        
        loginButton = new Button();
        loginButton.setBackground(new Color(240,106,91));
        loginButton.setForeground(new Color(250, 250, 250));
        loginButton.setText("SIGN IN");
        login.add(loginButton, "w 40%, h 40");
    }
    
    
    public void showReg(boolean show){
        if(show){
            register.setVisible(true);
            login.setVisible(false);
        }else{
            register.setVisible(false);
            login.setVisible(true);
        }
    }
    
    public void resetFieldsReg(){
        registerUsername.setText(" ");
        registerName.setText(" ");
        registerEmail.setText(" ");
        registerPassword.setText(" ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JPanel();
        register = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        login.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout loginLayout = new javax.swing.GroupLayout(login);
        login.setLayout(loginLayout);
        loginLayout.setHorizontalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        loginLayout.setVerticalGroup(
            loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(login, "card3");

        register.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(register, "card2");
    }// </editor-fold>//GEN-END:initComponents
    
    public MyTextField getLoginEmailField() {
        return loginEmail;
    }

    public MyPasswordField getLoginPasswordField() {
        return loginPassword;
    }

    public Button getLoginButton() {
        return loginButton;
    }
    
    public MyTextField getRegisterUsernameField() {
        return registerUsername;
    }

    public MyTextField getRegisterNameField() {
        return registerName;
    }

    public MyTextField getRegisterEmailField() {
        return registerEmail;
    }

    public MyPasswordField getRegisterPasswordField() {
        return registerPassword;
    }

    public Button getRegisterButton() {
        return registerButton;
    }
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel login;
    private javax.swing.JPanel register;
    // End of variables declaration//GEN-END:variables

   
}
