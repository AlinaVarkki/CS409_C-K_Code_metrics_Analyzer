import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class CBOCounter {

    Map<String, Set<String>> classDependedClasses = new HashMap<>();
    List<String> classes;
    Map<String, Integer> classCBO = new HashMap<>();
    Map<String, String> fileClass = new HashMap<>();

    public CBOCounter(List<String> classes) throws FileNotFoundException {
        this.classes = classes;
        calculateCBO();
    }

    public void calculateCBO() throws FileNotFoundException {
        for (String className : classes) addDependedClasses(className);

        for (String className : classDependedClasses.keySet()) {
            classCBO.put(className, classCBO.getOrDefault(className, 0) + classDependedClasses.get(className).size());
            for (String depClass : classDependedClasses.get(className)) {
                if(classDependedClasses.containsKey(depClass) && !classDependedClasses.get(depClass).contains(className)) {
                    classCBO.put(depClass, classCBO.getOrDefault(depClass, 0) + 1);
                }
            }
        }

    }

    public void addDependedClasses(String filePath) throws FileNotFoundException {
        CompilationUnit cu = StaticJavaParser.parse(new FileInputStream(filePath));
        CBO cbo = new CBO(cu);
        classDependedClasses.put(cbo.getClassName(), cbo.getDependedClasses());
        fileClass.put(filePath, cbo.getClassName());
    }

    public Map<String, Integer> getCBOMap() {
        return classCBO;
    }

    public Map<String, String> getFileClassMap() {
        return fileClass;
    }
}
