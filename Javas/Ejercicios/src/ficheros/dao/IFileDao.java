package ficheros.dao;

// IFileDao.java
public interface IFileDao {
    void leer(String nombreArchivo);
    void escribir(String nombreArchivo, String text );
}

