import java.io.FileNotFoundException;

public class Main {

    //Sub in folder name to run each folder's test files (foxes-and-rabbits-graph , weblog-analyzer , taxi-company-later-stage)

    private static final String FOLDER_PATH = "resources/taxi-company-later-stage/";

    public static void main(String[] args) throws FileNotFoundException {
        CKFolderPrinter ckFolderPrinter = new CKFolderPrinter(FOLDER_PATH);
        ckFolderPrinter.getCKMeasurementsFolder();
    }
}