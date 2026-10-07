package ficheros.dao;

// FileDaoAdvance.java

import java.io.*;
import java.util.HexFormat;
import java.util.function.LongToIntFunction;

public class FileDaoBinary implements IFileDao {

    /**
     * Lectura básica.. byte a byte y saca en pantalla cada byte
     * @param filename
     */

    public void leer(String filename) {
        try (FileInputStream in = new FileInputStream(filename)) {
            int byte_in = in.read();
            int i=0;
            while(byte_in != -1) {
                System.out.printf("%02X ", byte_in); //lo muestro en pantalla en HEX
                i++;
                byte_in = in.read();
                // salto de línea cada 16 bytes y espacio cada 2
                //if (i % 2 == 0)
                if (i % 16 == 0) System.out.println();
            }

        } catch (Exception e) {
            System.err.println("Error al acceder a la imagen: " + e.getMessage());
        }
    }


    /**
     * Escritura básica: lee byte => escribe byte=>lee otro byte=>etc...
     * @param filename
     * @param output
     */

    @Override
    public void escribir(String filename, String output) {
        try (FileInputStream in = new FileInputStream(filename);
            FileOutputStream out = new FileOutputStream(output)) {
            int byte_in = in.read();
            while(byte_in != -1) {
                out.write(byte_in);
                byte_in = in.read();
            }
            //out.flush(); // no hace falta: try-with-resources cierra y vacía el buffer
            //out.close(); //idem
            //in.close(); //idem
        } catch (Exception e) {
            System.err.println("Error al acceder a la imagen: " + e.getMessage());
        }
    }
}
