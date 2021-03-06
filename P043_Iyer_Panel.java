import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 P043_Iyer_Panel is panel of Supriya Iyer
 The first row prints first name
 The second row prints last name
 the third row is a counter that is either incrementing from 0 or decrementing from 9.
 The mode of the counter and the background color are determined by the value passed to the constructor
 @author Supriya Iyer
 */

public class P043_Iyer_Panel extends JPanel {
    private int timer;
    private int type;
    private Font font_new = new Font("Papyrus", Font.BOLD, 16);

    /**
     * Class constructor.
     * @param  type Describes the background and counter mode of the panel. Even numbers result in a white background with incrementing counter, odd gives light blue background with decrementing counter.
     *This function is used to design the layout for the panel by setting its dimensions.
     *Jlabel name is used to set the name of the author.
     *Jlabel counter is used to set the timer.
     *It executes the thread for the counter.
     *Exception handling is included to check for errors encountered by threads.*/

    public  P043_Iyer_Panel(int type) {
        this.type = type;
        if (type % 2 == 0)
        {
            timer = 0;
        }
        else
        {
            timer = 9;
        }

        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(2,1));
        jp.setPreferredSize(new Dimension(100,100));
        if (type % 2 == 0)
            jp.setBackground(new Color(255, 255, 255));
        else
            jp.setBackground(new Color(90, 150, 255));
        JLabel name = new JLabel("<html>Supriya<br>Iyer</html>", JLabel.CENTER);
        JLabel counter = new JLabel("",JLabel.CENTER);

        final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                counter.setText(String.valueOf(timer));
                if (type % 2 == 0)
                {
                    timer++;
                    if (timer > 9)
                    {
                        timer = 0;
                    }
                }
                else
                {
                    timer--;
                    if (timer < 0)
                        timer = 9;

                }
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }, 0, 1, TimeUnit.SECONDS);

        jp.add(name);
        jp.add(counter);
        add(jp);

    }
    /** The main was included in the file for testing purpose.*/

    /*
    public static void main(String args[])
    {
        JFrame jf= new JFrame();
        jf.getContentPane().add(new P043_Iyer_Panel(3));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        jf.setSize(400,400);
    }*/
}






