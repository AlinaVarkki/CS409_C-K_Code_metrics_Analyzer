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
        countIfStatements();
        countWhileStatements();
        countOrAndOperators();
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

}
