import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.List;

    public class WMC1 extends VoidVisitorAdapter<List<String>> {

    CompilationUnit compilationUnit;
    List<String> complexityUnits = new ArrayList();

    public WMC1(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        compilationUnit.accept(this, this.complexityUnits);
    }

    public int getMethodsAmount() { return complexityUnits.size(); }

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

}
