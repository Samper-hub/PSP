package ficheros.factory;
import ficheros.dao.*;

public class FileFactory {

    public enum DaoType {
        BASIC, ADVANCE, BIN, BIN_ADV
    }

    public IFileDao getDao(DaoType tipo) {
        if (tipo == null)
            tipo=DaoType.BASIC;
        return switch (tipo) {
            case BIN ->new FileDaoBinary();
            case BIN_ADV ->new FileDaoBinaryAdvance();
            case ADVANCE -> new FileDaoAdvance();
            case BASIC -> new FileDaoBasic();
            default -> new FileDaoBasic();
        };
    }
}
