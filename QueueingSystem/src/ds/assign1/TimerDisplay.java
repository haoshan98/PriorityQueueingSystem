package ds.assign1;

import static ds.assign1.DS_Main.systemStartTime;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import javax.swing.JLabel;
import javax.swing.Timer;


public class TimerDisplay extends JLabel {
    private long nowTime = 0;
    private DateFormat format;

    public TimerDisplay() {
        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }

        });
        timer.start();
    }

    public String getRemainingTime() {
        nowTime = (System.currentTimeMillis() - systemStartTime)/1000;
        int hours = (int) ((this.nowTime / 3600000) % 60);
        int minutes = (int) ((this.nowTime / 60000) % 60);
        int seconds = (int) (((this.nowTime) / 1000) % 60);

        return (format.format(hours) + ":" + format.format(minutes) + ":" + format.format(seconds));
    }

    @Override
    public String getText() {
        if (format != null) {
            return getRemainingTime();
        } else {
            return "";
        }
    }
}
