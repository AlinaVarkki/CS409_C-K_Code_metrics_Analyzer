import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.AnnotationDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.stmt.LocalClassDeclarationStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.List;

    public class WMC1 extends VoidVisitorAdapter<List<String>> {

    CompilationUnit compilationUnit;
    List<String> complexityUnits = new ArrayList();
    int methodsAm;

    public WMC1(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        compilationUnit.accept(this, this.complexityUnits);
    }

    public int getMethodsAmount() {
        methodsAm = complexityUnits.size();
        return methodsAm;
    }

    public void classList() {
        for (int i =0; i< complexityUnits.size(); i++) {
            System.out.println(complexityUnits.get(i));
        }
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration md, List<String> counter) {
            super.visit(md, counter);
    }

    @Override
    public void visit(MethodDeclaration md, List<String> counter) {
        super.visit(md, counter);
        counter.add(md.getNameAsString());
    }

}
