import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;

public class Main {

    private static final String FILE_PATH = "resources/ClassAnalyse.java";

    public static void main(String[] args) throws Exception {

        CompilationUnit cu = StaticJavaParser.parse(new FileInputStream(FILE_PATH));

        WMC1 wmc1 = new WMC1(cu);
        System.out.println("Methods amount: " + wmc1.getMethodsAmount());

//        WMC2 wmc2 = new WMC2(cu);
//        System.out.println(wmc2.getCount());

//          RFC rfc = new RFC(cu);
//          rfc.methodCalls();

    }
}