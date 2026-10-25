package reloj;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class JFrameReloj extends JFrame implements Runnable {
    // IntelliJ conecta estas variables automáticamente con el .form
    private JPanel panel1;
    private JLabel labelTime;

    private Thread h1;

    public JFrameReloj() {
        // En lugar de inicializar panel1 y labelTime a mano,
        // IntelliJ lo hace por detrás. Solo le decimos que use el panel1.
        setContentPane(panel1);
        setTitle("Reloj Digital");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Iniciamos el hilo del reloj
        h1 = new Thread(this);
        h1.start();
    }

    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        while (currentThread == h1) {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            String horaActual = sdf.format(calendar.getTime());

            // Actualizamos la etiqueta que creaste visualmente
            labelTime.setText(horaActual);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JFrameReloj().setVisible(true);
            }
        });
    }

}
