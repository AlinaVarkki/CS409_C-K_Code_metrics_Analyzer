package RFC;

import WMC1.MethodCollector;
import WMC2.ForEachStatementCounter;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.visitor.VoidVisitor;

import java.util.ArrayList;
import java.util.List;

public class RFC {

    CompilationUnit compilationUnit;
    VoidVisitor<List<String>> methodComplexityCounter;
    List<String> complexityUnits = new ArrayList<>();
    List<String> refinedComplexityUnits = new ArrayList<>();

    public RFC(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
    }

    public void methodCalls() {
        countStartingMethodStatements();
        countMethodCalls();

        for (int i =0; i< complexityUnits.size(); i++) {
            if (!refinedComplexityUnits.contains(complexityUnits.get(i))) {
                refinedComplexityUnits.add(complexityUnits.get(i));
            }
        }
        //TODO remove forloop once confirmed correct output
        for (int j = 0; j < refinedComplexityUnits.size(); j ++) {
            System.out.println("Methods + MethodCalls :" + refinedComplexityUnits.get(j));
        }
        System.out.println("Methods + MethodCalls " + refinedComplexityUnits.size());

//        List<String> methods = new ArrayList<>();
//        VoidVisitor<List<String>> methodsCounter = new MethodCollector();
//        methodsCounter.visit(compilationUnit, methods);
//        return methods;
    }

    public void countStartingMethodStatements() {
        methodComplexityCounter = new MethodCollector();
        methodComplexityCounter.visit(compilationUnit, complexityUnits);
    }

    public void countMethodCalls() {
        methodComplexityCounter = new MethodCaller();
        methodComplexityCounter.visit(compilationUnit, complexityUnits);
    }
}
