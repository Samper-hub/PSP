package act2_12;

import java.io.File;

public class Lanzador {
    public void lanzarSumador(Integer n1,Integer n2){
        String clase="programacionmultiproceso.Sumador";
        File directorio = new File("/repo/PSP/Javas/Ejercicios");
        ProcessBuilder pb=new ProcessBuilder("java",
                clase,n1.toString(),n2.toString());
        pb.inheritIO();
        pb.directory(directorio);
        try {
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Lanzador l=new Lanzador();
        l.lanzarSumador(1, 50);
        l.lanzarSumador(51, 100);
        System.out.println("Ok");
    }
}
