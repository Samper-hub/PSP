package ficheros.dao;

// FileDaoAdvance.java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileDaoAdvance implements IFileDao {


    @Override
    public void leer(String filename) {

        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            do{
                line= br.readLine();
                if(line!=null){
                   System.out.println(line);
                }
            }while (line !=null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    @Override
    public void escribir(String filename, String text) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
