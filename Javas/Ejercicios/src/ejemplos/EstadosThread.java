package ejemplos;

public class EstadosThread {
    static class Hilo implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        Thread t=new Thread(new Hilo(), "Hilo-1");

        System.out.println("Estado inicial: "+t.getState());

        t.start();
        System.out.println("Tras start(): "+t.getState());

        Thread.sleep(50);
        System.out.println("Durante sleep(): "+t.getState());

        t.join();
        System.out.println("Durante join():WAITING");
        System.out.println("Tras join(): "+t.getState());
    }
}
