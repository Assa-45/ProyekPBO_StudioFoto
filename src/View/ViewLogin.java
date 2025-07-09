
package View;

import Component.*;
import Controller.ControllerOperator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;


public class ViewLogin extends javax.swing.JFrame {
    private MigLayout layout;
    private PanelCover cover;
    private PanelLoginDanReg loginNReg;
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;
    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));

    
    public ViewLogin() {
        initComponents();
        ControllerOperator opera = new ControllerOperator(this, loginNReg);
        loginNReg = new PanelLoginDanReg();
        init();
        setVisible(true);
        // Untuk login:
        loginNReg.getLoginButton().addActionListener(e -> {
            String email = loginNReg.getLoginEmailField().getText();
            String pass = new String(loginNReg.getLoginPasswordField().getPassword());
            opera.validasiLogin(email, pass);
            this.dispose();
        });

        // Untuk sign up:
        loginNReg.getRegisterButton().addActionListener(e -> {
            String username = loginNReg.getRegisterUsernameField().getText();
            String name = loginNReg.getRegisterNameField().getText();
            String email = loginNReg.getRegisterEmailField().getText();
            String pass = new String(loginNReg.getRegisterPasswordField().getPassword());
            opera.insertData(username, name, email, pass);
        });
    }
    
    private void init(){
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction){
                double fractionCover;
                double fractionLogin;
                double size = coverSize;
                
                if(fraction <= 0.5f){
                    size += fraction * size;
                }else{
                    size += addSize - fraction * addSize;
                }
                
                if(isLogin){
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if(fraction >= 0.5f){
                        cover.registerRight(fractionCover * 100);
                    }else{
                        cover.loginRight(fractionLogin * 100);
                    }
                }else{
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if(fraction <= 0.5f){
                        cover.registerLeft(fraction * 100);
                    }else{
                        cover.loginLeft((1f - fraction) * 100);
                    }
                }
                
                if(fraction >= 0.5f){
                    loginNReg.showReg(isLogin);
                }
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionLogin = Double.valueOf(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width " + size + "%, pos " + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(loginNReg, "width " + loginSize + "%, pos " + fractionLogin + "al 0 n 100%");
                background.revalidate();
            }
            
            @Override
            public void end(){
                isLogin = !isLogin;
            }
        };
        Animator animator = new Animator(800, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0); // biar animasi makin smooth
        background.setLayout(layout);
        background.add(cover, "width " + coverSize + "%, pos " + (isLogin ? "1al" : "0al") + " 0 n 100%");
        background.add(loginNReg, "width " + loginSize + "%, pos " + (isLogin ? "0al" : "1al") + " 0 n 100%");
        loginNReg.showReg(!isLogin);
        cover.login(isLogin);
        cover.addEvent(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                if(!animator.isRunning()){
                    animator.start();
                }
            }
        });
    }


    public PanelCover getCover(){
        return cover;
    }
    
    public PanelLoginDanReg getLogiNReg(){
        return loginNReg;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setOpaque(true);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 764, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 447, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane background;
    // End of variables declaration//GEN-END:variables
}
