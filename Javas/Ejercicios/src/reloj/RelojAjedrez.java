package reloj;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RelojAjedrez extends JFrame {

    private final long TIEMPO_INICIAL = 3 * 60 * 1000; // 3 minutos
    private long tiempoJugador1 = TIEMPO_INICIAL;
    private long tiempoJugador2 = TIEMPO_INICIAL;

    private JPanel mainPanel;
    private JLabel lblTiempo1;
    private JLabel lblTiempo2;
    private JButton btnJugador1;
    private JButton btnJugador2;

    private Timer timer;
    private int turnoActivo = 0;

    public RelojAjedrez() {
        setContentPane(mainPanel);
        setTitle("Reloj de Ajedrez");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 250);
        setLocationRelativeTo(null);

        lblTiempo1.setText(formatearTiempo(tiempoJugador1));
        lblTiempo2.setText(formatearTiempo(tiempoJugador2));

        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (turnoActivo == 1) {
                    tiempoJugador1 -= 10;
                    lblTiempo1.setText(formatearTiempo(tiempoJugador1));
                    if (tiempoJugador1 <= 0) finalizarPartida("Jugador 2");
                } else if (turnoActivo == 2) {
                    tiempoJugador2 -= 10;
                    lblTiempo2.setText(formatearTiempo(tiempoJugador2));
                    if (tiempoJugador2 <= 0) finalizarPartida("Jugador 1");
                }
            }
        });

        btnJugador1.addActionListener(e -> {
            turnoActivo = 2;
            btnJugador1.setEnabled(false);
            btnJugador2.setEnabled(true);
            timer.start();
        });

        btnJugador2.addActionListener(e -> {
            turnoActivo = 1;
            btnJugador2.setEnabled(false);
            btnJugador1.setEnabled(true);
            timer.start();
        });
    }

    private String formatearTiempo(long tiempoMs) {
        if (tiempoMs < 0) tiempoMs = 0;
        long minutos = (tiempoMs / 1000) / 60;
        long segundos = (tiempoMs / 1000) % 60;
        long milis = tiempoMs % 1000;
        return String.format("%02d:%02d:%03d", minutos, segundos, milis);
    }

    private void finalizarPartida(String ganador) {
        timer.stop();
        turnoActivo = 0;
        btnJugador1.setEnabled(false);
        btnJugador2.setEnabled(false);
        lblTiempo1.setText(formatearTiempo(tiempoJugador1));
        lblTiempo2.setText(formatearTiempo(tiempoJugador2));

        JOptionPane.showMessageDialog(this,
                "¡El tiempo se ha agotado!\nHa ganado el " + ganador,
                "Fin de la partida",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {

        try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
        catch (Exception e) { e.printStackTrace(); }

        SwingUtilities.invokeLater(() -> {
            new RelojAjedrez().setVisible(true);
        });
    }
}
