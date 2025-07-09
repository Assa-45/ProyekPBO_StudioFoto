
package Component;

import Swing.RoundedComboBoxUI;
import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.util.Calendar;


public class TimePicker extends JPanel {

    public JComboBox<String> hourCombo;
    public JComboBox<String> minuteCombo;

    public TimePicker() {
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        setOpaque(false);

        // Styling global
        Font font = new Font("SansSerif", Font.PLAIN, 16);
        Dimension comboSize = new Dimension(70, 36);
        Color background = Color.WHITE;
        Color border = new Color(206, 212, 218); // Bootstrap border color
        Color foreground = new Color(33, 37, 41); // Bootstrap text color

        // ComboBox Jam
        hourCombo = createComboBox(24, font, comboSize, background, border, foreground);

        // ComboBox Menit
        minuteCombo = createComboBox(60, font, comboSize, background, border, foreground);

        JLabel colon = new JLabel(":");
        colon.setFont(new Font("SansSerif", Font.BOLD, 18));
        colon.setForeground(foreground);
        colon.setPreferredSize(new Dimension(10, 36));

        add(hourCombo);
        add(colon);
        add(minuteCombo);
    }

    private JComboBox<String> createComboBox(int limit, Font font, Dimension size,
                                             Color bg, Color border, Color fg) {
        JComboBox<String> combo = new JComboBox<>();
        for (int i = 0; i < limit; i++) {
            combo.addItem(String.format("%02d", i));
        }
        combo.setFont(font);
        combo.setPreferredSize(size);
        combo.setForeground(fg);
        combo.setBackground(bg);
        combo.setUI(new RoundedComboBoxUI(border));
        return combo;
    }

    public Time getTime() {
        int hour = Integer.parseInt((String) hourCombo.getSelectedItem());
        int minute = Integer.parseInt((String) minuteCombo.getSelectedItem());

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return new Time(cal.getTimeInMillis());
    }

    public void setTime(Time time) {
        String timeStr = time.toString();  // format: HH:mm:ss
        String[] parts = timeStr.split(":");

        System.out.println("[TimePicker] Time to set: " + timeStr);

        if (parts.length >= 2) {
            String hour = parts[0];
            String minute = parts[1];

            System.out.println("[TimePicker] Setting hour: " + hour);
            System.out.println("[TimePicker] Setting minute: " + minute);

            // Log apakah nilai yang akan diset memang ada di combo box
            boolean hourFound = false;
            boolean minuteFound = false;
            for (int i = 0; i < hourCombo.getItemCount(); i++) {
                if (hourCombo.getItemAt(i).equals(hour)) {
                    hourFound = true;
                }
            }
            for (int i = 0; i < minuteCombo.getItemCount(); i++) {
                if (minuteCombo.getItemAt(i).equals(minute)) {
                    minuteFound = true;
                }
            }

            if (!hourFound) System.err.println("[ERROR] Hour not found in combo: " + hour);
            if (!minuteFound) System.err.println("[ERROR] Minute not found in combo: " + minute);

            hourCombo.setSelectedItem(hour);
            minuteCombo.setSelectedItem(minute);
        } else {
            System.err.println("[TimePicker] Format Time tidak valid: " + timeStr);
        }
    }

}

