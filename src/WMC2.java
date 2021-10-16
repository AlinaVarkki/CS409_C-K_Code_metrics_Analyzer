import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.List;

public class WMC2 extends VoidVisitorAdapter<List<String>> {

    CompilationUnit compilationUnit;
    List<String> complexityUnitsMethods = new ArrayList<>();
    List<String> complexityUnits = new ArrayList<>();

    List<String> constructorUnits = new ArrayList<>();
    List<String> decisionUnits = new ArrayList<>();

    public WMC2(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        compilationUnit.accept(this, complexityUnits);
    }

    public int getCount() { return complexityUnits.size(); }

    public void getDecisions() {
//        for (String complexityUnit : complexityUnits) {
//            System.out.println("complexityUnits " + complexityUnit);
//        }
//        for (String complexityUnit : decisionUnits) {
//            System.out.println("decisionUnit " + complexityUnit);
//        }
        for (String complexityUnit : constructorUnits) {
            System.out.println("constructorUnits " + complexityUnit);
        }
    }

//    public void getMethods() {
//        for (int i =0; i < decisionUnits.size(); i++) {
//            System.out.println("Methods Counted " + decisionUnits.get(i));
//        }
//    }

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

    @Override
    public void visit(ConstructorDeclaration md, List<String> counter) {
        super.visit(md, counter);
        constructorUnits.add(md.getNameAsString());
    }

    @Override
    public void visit(IfStmt md, List<String> counter) {
        super.visit(md, counter);
        decisionUnits.add(md.toString());
    }


    @Override
    public void visit(WhileStmt md, List<String> counter) {
        super.visit(md, counter);
        decisionUnits.add(md.toString());
    }

    @Override
    public void visit(BinaryExpr md, List<String> counter) {
            super.visit(md, counter);
            String currOperator = md.getOperator().toString();

            if (currOperator.equals("AND") || currOperator.equals("OR")) decisionUnits.add(md.toString());
    }

    @Override
    public void visit(ForEachStmt md, List<String> counter) {
        super.visit(md, counter);
        decisionUnits.add(md.toString());
    }

    @Override
    public void visit(ForStmt md, List<String> counter) {
        super.visit(md, counter);
        decisionUnits.add(md.toString());
    }

    @Override
    public void visit(TryStmt md, List<String> counter) {
        super.visit(md, counter);
        decisionUnits.add(md.toString());
    }


}