import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.List;

public class RFC extends VoidVisitorAdapter<List<String>> {

    CompilationUnit compilationUnit;
    List<String> complexityUnitsMethods = new ArrayList<>();
    List<String> complexityUnitsMethodCalls = new ArrayList<>();

    public RFC(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        compilationUnit.accept(this, complexityUnitsMethods);
        updateMethodOutput();
    }

    //Considers Inner Class's Methods
    @Override
    public void visit(ClassOrInterfaceDeclaration md, List<String> counter) {
        super.visit(md, counter);
    }

    //Collects All Methods
    @Override
    public void visit(MethodDeclaration md, List<String> counter) {
        super.visit(md, counter);
        counter.add(md.getNameAsString());
    }

    //Collects All Method Call's
    @Override
    public void visit(MethodCallExpr md, List<String> counter) {
        super.visit(md, counter);
        complexityUnitsMethodCalls.add(md.getNameAsString());
    }

    //Collects All Constructors
    @Override
    public void visit(ConstructorDeclaration md, List<String> counter) {
        super.visit(md, counter);
        counter.add(md.getNameAsString());
    }

    //Checks Class Methods Don't Include Calls To Themselves (Removes Duplicate Method Calls)
    private void updateMethodOutput() {
        for (String complexityUnit : complexityUnitsMethodCalls) {
            if (!complexityUnitsMethods.contains(complexityUnit)) {
                complexityUnitsMethods.add(complexityUnit);
            }
        }
    }

    public int getMethodOutputs() { return complexityUnitsMethods.size();}
}
