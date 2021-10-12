import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.List;

public class RFC extends VoidVisitorAdapter<List<String>> {

    CompilationUnit compilationUnit;
    List<String> complexityUnits = new ArrayList<>();
    List<String> refinedComplexityUnits = new ArrayList<>();

    public RFC(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        compilationUnit.accept(this, complexityUnits);
        updateMethodOutput();
    }

    @Override
    public void visit(MethodCallExpr md, List<String> counter) {
        super.visit(md, counter);
        counter.add(md.getNameAsString());
    }

    @Override
    public void visit(MethodDeclaration md, List<String> counter) {
        super.visit(md, counter);
        counter.add(md.getNameAsString());
    }

    private void updateMethodOutput() {
        for (String complexityUnit : complexityUnits) {
            if (!refinedComplexityUnits.contains(complexityUnit)) {
                refinedComplexityUnits.add(complexityUnit);
            }
        }
    }

    public void printMethodOutputs() {
        System.out.println("Methods + MethodCalls :");
        for (String refinedComplexityUnit : refinedComplexityUnits) {
            System.out.println(refinedComplexityUnit);
        }
        System.out.println(" ");
        System.out.println("Total : " + refinedComplexityUnits.size());
    }
}
