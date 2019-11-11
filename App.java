package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimerTask;


public class App extends JFrame {
    /**
     * button create to add to Timer option
     */

    private JButton start = new JButton("START");
    private JButton stop = new JButton("Stop");

    JPanel panel = new JPanel( );

    JButton time;
    JButton timer;
    JButton button3;

    JLabel label = new JLabel( );


    public App() {

        /**
         * declaration of size & title & defaultClose
         * declaration basic button
         */
        super("First frame");
        this.setBounds(500, 500, 300, 300);
        this.setDefaultCloseOperation(3);
        time = new JButton("Time");
        timer = new JButton("Timer");
        button3 = new JButton("Alarm");


        time.addActionListener(new ActionFild("time"));
        timer.addActionListener(new ActionFild("timer"));
        // button3.addActionListener(new ActionFild(Color.white));


        Panel panelCentre = new Panel( );
        this.getContentPane( ).add(panelCentre, BorderLayout.CENTER);

        panelCentre.add(time);
        panelCentre.add(timer);
        panelCentre.add(button3);


        this.getContentPane( ).add(panel, BorderLayout.SOUTH);


        panel.add(label);


        this.setVisible(true);
        pack( );
    }


    private class Watch implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText(getTime( ));
        }
    }

    /**
     * getTime get hour, min & sec from gregorian calendar method
     * end return it
     * also if time number is single add 0 in front of him
     *
     * @return
     */


    public String getTime() {
        GregorianCalendar calendar = new GregorianCalendar( );
        String hour = "" + calendar.get(Calendar.HOUR_OF_DAY);
        String minute = "" + calendar.get(Calendar.MINUTE);
        String second = "" + calendar.get(Calendar.SECOND);


        if (Integer.parseInt(hour) < 10)
            hour = "0" + hour;

        if (Integer.parseInt(minute) < 10)
            minute = "0" + minute;

        if (Integer.parseInt(second) < 10)
            second = "0" + second;


        return hour + " : " +
                minute + " : " +
                second;
    }


    private class ActionFild implements ActionListener {

        private String action;

        public String getAction() {
            return action;
        }
        public ActionFild(String actrion) {
            this.action = actrion;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Watch time = new Watch( );
            Timer clock = new Timer(1000, time);

            java.util.Timer stoper = new java.util.Timer( );

            if (action.equals("time")) {
                clock.start( );
            }
            if (action.equals("timer")) {
                System.out.println("you can take a time");

                stoper.schedule(timerTask, 1, 1);
                //System.out.println(getTimer(6500000) );
            }
        }
    }


    int cunter = 0;
    TimerTask timerTask = new TimerTask( ) {
        @Override
        public void run() {
            label.setText(getTimer(cunter));
            cunter++;
        }
    };

    /**
     * getTimer take millisecond from Timer method
     * converted int to **hh : mm: ss : mmm** form
     *
     * @param millisecond
     * @return
     */

    public String getTimer(int millisecond) {
        this.millisecond = millisecond;

// 100 = 1s
        //sekundy

        if (millisecond > 100 && millisecond < 6000) {
            second = millisecond / 100;
            this.millisecond -= (second * 100);
        }
        //minuty
        // 60s = 1m
        if (millisecond > 6000 && millisecond < 360000) {
            minutes = millisecond / 6000;
            second = (millisecond / 100) - (minutes * 60);
            this.millisecond -= second * 6000;
        }
        //godziny
        if (millisecond > 360000 && millisecond < 21600000) {
            hour = millisecond / 360000;
            minutes = (millisecond / 6000) - (hour * 60);
            second = (millisecond / 100) - (minutes * 60);
            this.millisecond -= second * 6000;
        }
        return String.format("%02d:%02d:%02d:%02d", hour, minutes, second, this.millisecond);
    }


    /**
     * We have hear all variables we need to create timer
     * while counter is true loop is working and timer count the time
     * hour, minutes, second, millisecond is counting during loop is working
     */


    public int hour = 0;
    public int minutes = 0;
    public int second = 0;
    public int millisecond = 0;


    public static void main(String[] args) {
        new App( );


    }


}
