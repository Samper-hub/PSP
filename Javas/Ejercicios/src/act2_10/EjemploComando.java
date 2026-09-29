package act2_10;

import java.io.IOException;
import java.io.InputStream;

public class EjemploComando {
    public static void main(String[] args) throws IOException {
        Process p=new ProcessBuilder("/usr/bin/ls", "-la").start();

        try {
            InputStream is=p.getInputStream();

            int c;
            while ((c=is.read()) != -1){
                System.out.print((char) c);
            }
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int exitVal;
        try {
            exitVal=p.waitFor();
            System.out.println("El proceso termino con "+exitVal);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
