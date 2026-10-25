package rcronometro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Cronometro extends JFrame implements Runnable {
    private JPanel panel1;
    private JButton actionButton;
    private JLabel jlTimer;
    private Thread h1;
    private boolean running=true;
    private long timeInMillis;

    public Cronometro(){
        setContentPane(panel1);
        setTitle("Cronómetro");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        running=false;
        timeInMillis=0;
        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                running=!running;
                String buttonText=running?"Stop":"Run";
                actionButton.setText(buttonText);
                if (running){
                    h1=new Thread(Cronometro.this);
                    h1.start();
                }
            }
        });
    }
    @Override
    public void run() {
        Thread ct=Thread.currentThread();
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss.SSS");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        long start=System.currentTimeMillis()-timeInMillis;

        while (ct==h1&&running){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                ct.interrupt();
                running=false;
            }
            timeInMillis=System.currentTimeMillis() - start;
            jlTimer.setText(sdf.format(timeInMillis));
        }
    }
    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Cronometro().setVisible(true);
            }
        });
    }
}
