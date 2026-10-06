package act2_13;

import java.io.File;

public class Lanzador2 {
    public void lanzarSumador(Integer n1, Integer n2, String fichResultado){
        String clase="programacionmultiproceso.Sumador";
        File directorio=new File("./repo/PSP/Javas/Ejercicios");

        ProcessBuilder pb;

        try {
            pb=new ProcessBuilder("java",clase,n1.toString(),n2.toString());
            pb.directory(directorio);

            pb.redirectError(new File("errores.txt"));
            pb.redirectOutput(new File(fichResultado));
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Lanzador2 l=new Lanzador2();

        l.lanzarSumador(1,5,"result1.txt");
        l.lanzarSumador(6,10,"result.txt");
        System.out.println("Ok");
    }
}
