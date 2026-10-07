package ficheros;

import ficheros.dao.*;
import ficheros.factory.*;

import java.io.File;

public abstract class TestFileFactory  {
    public static FileFactory fileFactory = new FileFactory();

    public static void main(String[] args) {
        String directorioPrueba="archivos_prueba";
        File dir=new File(directorioPrueba);
        if (!dir.exists()){
            dir.mkdir();
            System.out.println("Directorio creado "+dir.getPath());
        }

        System.out.println("\nPRUEBA DE DAO\n");

        System.out.println("Prueba de FileDaoBasic...");
        IFileDao daoBasic= fileFactory.getDao(FileFactory.DaoType.BASIC);
        String rutaBasic=directorioPrueba+ "/test_basic.txt";

        System.out.println("\n2. Prueba de FileDaoAdvance...");
        IFileDao daoAdvance= fileFactory.getDao(FileFactory.DaoType.ADVANCE);
        String rutaAdvance=directorioPrueba+"/test_advance.txt";

        System.out.println("3. Prueba FileDaoBinary...");
        IFileDao daoBinary= fileFactory.getDao(FileFactory.DaoType.BIN);
        String rutaBinaria=directorioPrueba+"/test_binary.";

        System.out.println("\n4. Prueba FileDaoBinaryAdvance...");
        IFileDao daoBinariadv= fileFactory.getDao(FileFactory.DaoType.BIN_ADV);
        String rutaBinaryAdv=directorioPrueba+"/test_binaryadv.";

        System.out.println("\nPrueba Finalizadas.");


    }
}
