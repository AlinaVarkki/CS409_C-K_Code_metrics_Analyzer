import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;

public class Main {


    /**
     * RFC/CBO/LCOM - Animal,Counter,Field,FieldStats,Fox,GraphView,GridView,Location,Rabbit,Randomizer,Simulator,SimulatorView
     * WMC/WMC Complex - GraphView,GridView,Simulator
     *
     * RFC/CBO/LCOM - Actor,City,CityGUI,DrawableItem,Item,Location,MissingPassengerException,Passenger,PassengerSource,
     *                Shuttle,Simulation,Taxi,TaxiCompany,Vehicle
     *
     * WMC/WMC Complex - City,CityGUI,Location,Passenger,PassengerSource,Vehicle
     *
     * RFC/CBO/LCOM - LogAnalyzer,LogEntry,LogfileCreator,LogfileReader,LoglineTokenizer
     * WMC/WMC Complex - LogfileReader,
     */

 //   private static final String FILE_PATH = "resources/Bank Example/MerchantBank.java";
//    private static final String FILE_PATH = "resources/foxes-and-rabbits-graph/SimulatorView.java";
 //     private static final String FILE_PATH = "resources/taxi-company-later-stage/Vehicle.java";
    private static final String FILE_PATH = "resources/weblog-analyzer/LoglineTokenizer.java";



    public static void main(String[] args) throws Exception {

        CompilationUnit cu = StaticJavaParser.parse(new FileInputStream(FILE_PATH));
//
//        WMC1 wmc1 = new WMC1(cu);
//        System.out.println("Methods amount: " + wmc1.getMethodsAmount());
//
//        WMC2 wmc2 = new WMC2(cu);
//        System.out.println(wmc2.getCount());
//
//          RFC rfc = new RFC(cu);
//          rfc.printMethodOutputs();

//          CBO cbo = new CBO(cu);
//          cbo.printMethodOutputs();

        LCOM lcom = new LCOM(cu);

    }
}