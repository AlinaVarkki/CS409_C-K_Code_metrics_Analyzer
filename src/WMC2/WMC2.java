package WMC2;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.visitor.VoidVisitor;

import java.util.ArrayList;
import java.util.List;

public class WMC2 {

    CompilationUnit compilationUnit;
    VoidVisitor<List<String>> methodComplexityCounter;
    List<String> complexityUnits = new ArrayList<>();

    public WMC2(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
    }

    public void getMethodsComplexity() {
        complexityUnits.add("Default Decision");
        countIfStatements();
        countWhileStatements();
        countOrAndOperators();
        countForStatements();
        countForEachStatements();

        //TODO remove forloop once confirmed correct output
        for (int i = 0; i < complexityUnits.size(); i++) {
            System.out.println("For statements and ForEach operators: " + complexityUnits.get(i));
        }
        System.out.println("if statements and AndOr operators: " + complexityUnits.size());
    }

    public void countIfStatements() {
        methodComplexityCounter = new IfStatementsCounter();
        methodComplexityCounter.visit(compilationUnit, complexityUnits);
    }

    public void countWhileStatements() {
        methodComplexityCounter = new WhileStatementsCounter();
        methodComplexityCounter.visit(compilationUnit, complexityUnits);
    }

    public void countOrAndOperators() {
        methodComplexityCounter = new AndOrCounter();
        methodComplexityCounter.visit(compilationUnit, complexityUnits);
    }

    public void countForStatements() {
        methodComplexityCounter = new ForStatementCounter();
        methodComplexityCounter.visit(compilationUnit, complexityUnits);
    }

    public void countForEachStatements() {
        methodComplexityCounter = new ForEachStatementCounter();
        methodComplexityCounter.visit(compilationUnit, complexityUnits);
    }

}
