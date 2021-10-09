package WMC1;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.visitor.VoidVisitor;

import java.util.ArrayList;
import java.util.List;

public class WMC1 {

    CompilationUnit compilationUnit;

    public WMC1(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
    }

    public int getMethodsAmount() {
        List<String> methods = new ArrayList<>();
        VoidVisitor<List<String>> methodsCounter = new MethodCollector();

        methodsCounter.visit(compilationUnit, methods);
        return methods.size();
    }

}
