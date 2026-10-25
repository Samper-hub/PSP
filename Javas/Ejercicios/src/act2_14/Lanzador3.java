package act2_14;

import java.io.*;

public class Lanzador3 {
    public static void main(String[] args)throws IOException, InterruptedException{
        int n1=Integer.parseInt(args[0]);
        int n2=Integer.parseInt(args[1]);
        int salto=(n2/4)-1;
        for (int i=1; i<=4;i++){
            System.out.println("n1: "+n1);
            int resultadoSumaConSalto=n1+salto;
            if (n1+salto>n2){
                resultadoSumaConSalto=n2;
            }
            System.out.println(n2+resultadoSumaConSalto);
            lanzarSumador3(n1, resultadoSumaConSalto, "fich"+String.valueOf(i));
            n1=n1+salto+1;
            System.out.println("Suma lanzada...");
        }
        int sumaTotla=getSumaTotal(4);
        System.out.println("La suma total es "+sumaTotla);
    }
    public static void lanzarSumador3(int n1, int n2, String fichResultados){
        String clase="programacionmultiproceso.Sumador";
        File directorioSumador=new File("build/classes");
        File fichResultado=new File(fichResultados);
        ProcessBuilder pb;

        try {
            pb=new ProcessBuilder("java",clase,String.valueOf(n1),String.valueOf(n2));
            pb.directory(directorioSumador);
            pb.redirectOutput(fichResultado);
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getResultadoFichero(String nombreFichero){
        int suma=0;
        try {
            FileInputStream fichero=new FileInputStream(nombreFichero);
            InputStreamReader fis=new InputStreamReader(fichero);
            BufferedReader br=new BufferedReader(fis);
            String linea=br.readLine();
            suma=Integer.parseInt(linea);

        } catch (FileNotFoundException e) {
            System.out.println("No se puede abrir "+nombreFichero);
        } catch (IOException e) {
            System.out.println("No hay nada en "+nombreFichero);
        }
        return suma;
    }
    public static int getSumaTotal(int numFicheros){
        int sumaTotal=0;
        for (int i=1; i<=4;i++){
            sumaTotal+=getResultadoFichero("fich"+String.valueOf(i));
        }
        return sumaTotal;
    }
}
