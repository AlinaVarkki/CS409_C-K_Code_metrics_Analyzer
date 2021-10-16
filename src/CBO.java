import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CBO extends VoidVisitorAdapter {

    CompilationUnit compilationUnit;
    List<String> complexityUnits = new ArrayList<>();
    String className;

    public CBO(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        compilationUnit.accept(this, complexityUnits);
    }

    public String getClassName() {
        return className;
    }

    public HashSet<String> getDependedClasses() {
        return new HashSet<>();
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, Object arg){
        className = n.getNameAsString();
        super.visit(n, arg);
    }

}
