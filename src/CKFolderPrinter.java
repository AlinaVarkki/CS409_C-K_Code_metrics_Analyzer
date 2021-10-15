import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CKFolderPrinter {

    private String FOLDER_PATH;

    public CKFolderPrinter(String FOLDER_PATH) {
        this.FOLDER_PATH = FOLDER_PATH;
    }

    public void getCKMeasurementsFolder() {
        try (Stream<Path> paths = Files.walk(Paths.get(FOLDER_PATH))) {
            paths.filter(Files::isRegularFile)
                    .forEach(file -> {
                        if (file.toString().endsWith(".java")) {
                            try {
                                getCKMeasurementsFile(file.toString());
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getCKMeasurementsFile(String filePath) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        CompilationUnit cu = StaticJavaParser.parse(new FileInputStream(filePath));

        result.append(filePath + " CALCULATIONS: " + "\n");

        WMC1 wmc1 = new WMC1(cu);
        result.append("WMC1: " + wmc1.getMethodsAmount() + "\n");

        WMC2 wmc2 = new WMC2(cu);
        result.append("WMC2: " + wmc2.getCount() + "\n");

        RFC rfc = new RFC(cu);
        result.append("RFC: " + rfc.getMethodOutputs() + "\n");

        CBO cbo = new CBO(cu);
        result.append("CBO: " + cbo.getMethodOutputs() + "\n");

        LCOM lcom = new LCOM(cu);
        result.append("LCOM: " + lcom.getCommonAccessMethodsAmount() + "\n");

        System.out.println(result);
    }

}
