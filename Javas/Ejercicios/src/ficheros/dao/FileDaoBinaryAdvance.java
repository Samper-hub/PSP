package ficheros.dao;
// FileDaoBinaryAdvance.java

import java.io.*;

public class FileDaoBinaryAdvance implements IFileDao {

    /**
     * Lectura en bloque de 8KB, mejor porque tiene menos accesos al disco.
     * @param filename
     */
    public void leer(String filename) {
        int BLOCK = 8192; // tamaño de bloque de lectura 8*1024bytes= 8KB
        try (BufferedInputStream in =
                     new BufferedInputStream(new FileInputStream(filename))) {
            int i = 0;
            byte[] buffer_read = new byte[BLOCK]; //leo de 8KB en 8KB no de 1B a 1B MEJOR!!
            int bytes_in = in.read(buffer_read); // incluye los bytes en buffer_read y
                                                 // devuelve el número de bytes leidos
            while (bytes_in != -1) {
                for (int k=0;k<bytes_in;k++) {
                    //escribir byte a byte es lento....(mejorable con StringBuffer)
                    System.out.printf("%02X ", buffer_read[k]);
                    i++;
                    // salto de línea cada 16 bytes
                    if (i % 16 == 0) System.out.println();
                }
                bytes_in = in.read(buffer_read);
            }
        } catch (IOException e) {
            System.err.println("Error al acceder a la imagen: " + e.getMessage());
        }
    }

    /**
     * Escritura mejorada... lee en bloque y escribe en bloque..
     * @param filename
     * @param output
     */
    @Override
    public void escribir(String filename, String output) {
        final int BLOCK = 8192; // 8 KB

        try (BufferedInputStream  in  = new BufferedInputStream(new FileInputStream(filename));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(output))) {

            byte[] buffer = new byte[BLOCK];
            int n;
            int bytes_in = in.read(buffer);
            while (bytes_in != -1) {
                // Escritura en bloques (¡no byte a byte!)
                out.write(buffer, 0, bytes_in);
                bytes_in = in.read(buffer);
            }
            out.flush(); // por si acaso...
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
