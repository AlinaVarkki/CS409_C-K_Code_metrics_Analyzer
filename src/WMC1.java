import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class WMC1 extends VoidVisitorAdapter {

    CompilationUnit compilationUnit;
    int methodsAm;

    public WMC1(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        compilationUnit.accept(this, null);
    }

    public int getMethodsAmount() {
        return methodsAm;
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration md, Object arg) {
        super.visit(md, arg);
        methodsAm = md.getMethods().size();
    }

}
