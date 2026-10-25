package ficheros.dao;

// FileDaoBasic.java

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDaoBasic implements IFileDao {

    @Override
    public void leer(String filename) {

        try (FileReader in = new FileReader(filename)) {
            int byte_in = in.read();
            while ( byte_in != -1) {
                char letter = (char) byte_in;
                System.out.print(letter);
                byte_in = in.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    @Override
    public void escribir(String filename, String text) {
        try (FileWriter out = new FileWriter(filename)) {
            for (int i = 0; i < text.length(); i++) {
                out.write(text.charAt(i));
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
