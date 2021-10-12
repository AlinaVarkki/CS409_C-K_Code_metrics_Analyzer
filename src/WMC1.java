import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.List;

public class WMC1 extends VoidVisitorAdapter<List<String>> {

    CompilationUnit compilationUnit;
    List<String> complexityUnits = new ArrayList<>();

    public WMC1(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        compilationUnit.accept(this, complexityUnits);
    }

    public int getMethodsAmount() {
        return complexityUnits.size();
    }

    @Override
    public void visit(MethodDeclaration md, List<String> counter) {
        super.visit(md, counter);
        counter.add(md.getNameAsString());
    }

}
