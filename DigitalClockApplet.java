package new_lab;

import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClockApplet extends JFrame 
{
    private JLabel timeLabel;
    private Timer timer;

    public DigitalClockApplet() 
    {
        setTitle("Digital Clock by TARACHAND");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        
        setSize(800, 100);
        
        timeLabel = new JLabel();

        timeLabel.setFont(new Font("verdana",Font.PLAIN,30));
        add(timeLabel);

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimeTask(), 0, 1000);
        this.setVisible(true);
    }

	class TimeTask extends TimerTask 
    {
        public void run() 
        {
            Date currentDate = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy ");
            
            Date currentTime = new Date();
            SimpleDateFormat formatter1 = new SimpleDateFormat(" HH:mm:ss");
            
            String formattedDate = "Date :- " + formatter.format(currentDate) + "     Time :- " + formatter1.format(currentTime);
            timeLabel.setText(formattedDate);  
            
        }
    }

    public static void main(String[] args) 
    {
        new DigitalClockApplet();
    }
}