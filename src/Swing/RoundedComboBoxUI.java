
package Swing;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;

public class RoundedComboBoxUI extends BasicComboBoxUI {
    private final Color borderColor;

    public RoundedComboBoxUI(Color borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    protected JButton createArrowButton() {
        JButton arrow = new JButton("▼");
        arrow.setBorder(BorderFactory.createEmptyBorder());
        arrow.setContentAreaFilled(false);
        arrow.setForeground(Color.GRAY);
        arrow.setFont(new Font("SansSerif", Font.PLAIN, 12));
        return arrow;
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        comboBox.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(borderColor, 1, true),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        comboBox.setOpaque(true);
    }
}

