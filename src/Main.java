import java.io.FileNotFoundException;

public class Main {

    /**
     * RFC/CBO/LCOM - Animal,Counter,Field,FieldStats,Fox,GraphView,GridView,Location,Rabbit,Randomizer,Simulator,SimulatorView
     * WMC Complex - GraphView,GridView,Simulator
     * <p>
     * RFC/CBO/LCOM - Actor,City,CityGUI,DrawableItem,Item,Location,MissingPassengerException,Passenger,PassengerSource,
     * Shuttle,Simulation,Taxi,TaxiCompany,Vehicle
     * <p>
     * WMC Complex - City,CityGUI,Location,Passenger,PassengerSource,Vehicle
     * <p>
     * RFC/CBO/LCOM - LogAnalyzer,LogEntry,LogfileCreator,LogfileReader,LoglineTokenizer
     * WMC Complex - LogfileReader,
     */

    private static final String FOLDER_PATH = "resources/Bank Example";

    public static void main(String[] args) throws FileNotFoundException {
        CKFolderPrinter ckFolderPrinter = new CKFolderPrinter(FOLDER_PATH);
        ckFolderPrinter.getCKMeasurementsFolder();
    }
}