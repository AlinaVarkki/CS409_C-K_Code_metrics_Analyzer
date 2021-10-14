import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.List;

//public class RFC extends VoidVisitorAdapter<List<String>> {
public class RFC extends VoidVisitorAdapter {

    CompilationUnit compilationUnit;
    List<String> complexityUnitsMethods = new ArrayList<>();
    List<String> complexityUnitsMethodCalls = new ArrayList<>();
    List<String> refinedComplexityUnits = new ArrayList<>();
    int methodsAm;

    public RFC(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        compilationUnit.accept(this, (Object)null);
        //compilationUnit.accept(this, complexityUnits);
        updateMethodOutput();
    }

    @Override
    public void visit(MethodCallExpr md, Object arg) {
        super.visit(md, arg);
       if (!complexityUnitsMethodCalls.contains(md.getNameAsString())) {
           complexityUnitsMethodCalls.add(md.getNameAsString());
       }
    }

//    @Override
//    public void visit(MethodDeclaration md, List<String> counter) {
//        super.visit(md, counter);
//        counter.add(md.getNameAsString());
//    }

//    @Override
//    public void visit(MethodCallExpr md, List<String> counter) {
//        super.visit(md, counter);
//        if (!counter.contains(md.getNameAsString())) {
//            if (!counter.contains(md.getName())) {
//                counter.add(md.getNameAsString());
//            }
//        }
//    }

//    public void printMethodOutputs() {
//        System.out.println("Methods + MethodCalls :");
//        for (String refinedComplexityUnit : complexityUnits) {
//            System.out.println(refinedComplexityUnit);
//        }
//        System.out.println(" ");
//        System.out.println("Total : " + complexityUnits.size());
//    }

    private void updateMethodOutput() {
        for (String complexityUnit : complexityUnitsMethods) {
            if (!refinedComplexityUnits.contains(complexityUnit)) {
                refinedComplexityUnits.add(complexityUnit);
            }
        }
        for (String complexityUnit : complexityUnitsMethodCalls) {
            if (!refinedComplexityUnits.contains(complexityUnit)) {
                refinedComplexityUnits.add(complexityUnit);
            }
        }
    }

    public void printMethodOutputs() {
        System.out.println("Methods :");
        for (String refinedComplexityUnit : complexityUnitsMethods) {
            System.out.println(refinedComplexityUnit);
        }
        System.out.println("MethodCalls :");
        for (String complexityUnit : complexityUnitsMethodCalls) {
            System.out.println(complexityUnit);
        }
        System.out.println("Refined Collective :");
        for (String refinedComplexityUnit : refinedComplexityUnits) {
            System.out.println(refinedComplexityUnit);
        }
        System.out.println(" ");
        System.out.println("Total : " + refinedComplexityUnits.size());
    }
}
