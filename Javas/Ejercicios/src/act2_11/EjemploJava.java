package act2_11;

import act2_10.EjemploComando;

import java.io.File;
import java.io.IOException;

public class EjemploJava {
    public static void main(String[] args) throws IOException {
        File directorio= new File("./repo/PSP/Javas/Ejercicios");

        ProcessBuilder pb=new ProcessBuilder("java", "EjemploComando");

        pb.inheritIO();

        pb.directory(directorio);
        System.out.printf("Directorio de trabajo %S%n",pb.directory());

        Process p=pb.start();
    }
}
