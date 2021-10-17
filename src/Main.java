import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;
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

    private static final String FOLDER_PATH = "resources/Bank Example/";
//    private static final String FILE_PATH = "resources/weblog-analyzer/LogfileReader.java";


    public static void main(String[] args) {
//        public static void main(String[] args) throws FileNotFoundException {
        CKFolderPrinter ckFolderPrinter = new CKFolderPrinter(FOLDER_PATH);
        ckFolderPrinter.getCKMeasurementsFolder();

//        CompilationUnit cu = StaticJavaParser.parse(new FileInputStream(FILE_PATH));
//        WMC2 wmc2 = new WMC2(cu);
//        wmc2.getDecisions();


    }
}