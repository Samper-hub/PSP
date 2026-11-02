package ejemplos;

public class EjemploJoin {
    static class HiloJoin extends Thread{
        private int n;
        public HiloJoin(String nombre, int n){
            super(nombre);
            this.n=n;
        }
        public void run(){
            for (int i=0;i<=n;i++){
                System.out.println(this.getName()+": "+i);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {}
            }
            System.out.println("Fin Bucle "+getName());
        }
    }
    public static void main(String[] args){
        HiloJoin h1=new HiloJoin("Hilo1",2);
        HiloJoin h2=new HiloJoin("Hilo2",5);
        HiloJoin h3=new HiloJoin("Hilo3",7);
        h1.start();
        h2.start();
        h3.start();
        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException e) {}
        System.out.println("FINAL DE PROGRAMA");
    }
}
