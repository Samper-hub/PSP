package ejemplos;

public class HilosEjemploInterrumpt extends Thread{
    public void run(){
        try {
            while (!isInterrupted()){
                System.out.println("En el Hilo");
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido una excepción");
        }
        System.out.println("Fin del Hilo");
    }
    public static void main(String[] args){
        HilosEjemploInterrumpt h=new HilosEjemploInterrumpt();
        h.start();
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        h.interrupt();
    }
}
