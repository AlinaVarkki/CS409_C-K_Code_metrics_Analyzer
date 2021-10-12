package RFC;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitor;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.List;

public class RFC extends VoidVisitorAdapter<List<String>> {

    CompilationUnit compilationUnit;
    VoidVisitor<List<String>> methodComplexityCounter;
    List<String> complexityUnits = new ArrayList<>();
    List<String> refinedComplexityUnits = new ArrayList<>();

    public RFC(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
    }

    public void methodCalls() {
        visit(compilationUnit, complexityUnits);
        countMethodCalls();

        for (int i =0; i< complexityUnits.size(); i++) {
            if (!refinedComplexityUnits.contains(complexityUnits.get(i))) {
                refinedComplexityUnits.add(complexityUnits.get(i));
            }
        }
        //TODO remove forloop once confirmed correct output
        for (int j = 0; j < refinedComplexityUnits.size(); j ++) {
            System.out.println("Methods + MethodCalls :" + refinedComplexityUnits.get(j));
        }
        System.out.println("Methods + MethodCalls " + refinedComplexityUnits.size());

//        List<String> methods = new ArrayList<>();
//        VoidVisitor<List<String>> methodsCounter = new MethodCollector();
//        methodsCounter.visit(compilationUnit, methods);
//        return methods;
    }


    public void countMethodCalls() {
        methodComplexityCounter = new MethodCaller();
        methodComplexityCounter.visit(compilationUnit, complexityUnits);
    }

    @Override
    public void visit(MethodDeclaration md, List<String> counter) {
        super.visit(md, counter);
        counter.add(md.getNameAsString());
    }
}
