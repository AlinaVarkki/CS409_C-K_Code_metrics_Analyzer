import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.List;

public class WMC2 extends VoidVisitorAdapter<List<String>> {

    CompilationUnit compilationUnit;
    List<String> complexityUnits = new ArrayList<>();

    public WMC2(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        compilationUnit.accept(this, complexityUnits);
    }

    public int getCount() { return complexityUnits.size(); }


    //Considers Inner Class's Methods
    @Override
    public void visit(ClassOrInterfaceDeclaration md, List<String> counter) {
        super.visit(md, counter);
    }

    //Collects All Methods
    @Override
    public void visit(MethodDeclaration md, List<String> counter) {
        super.visit(md, counter);
        complexityUnits.add(md.getNameAsString());
    }

    //Counts 'if' Statements
    @Override
    public void visit(IfStmt md, List<String> counter) {
        super.visit(md, counter);
        complexityUnits.add(md.toString());
    }

    //Counts 'while' Statements
    @Override
    public void visit(WhileStmt md, List<String> counter) {
        super.visit(md, counter);
        complexityUnits.add(md.toString());
    }

    //Counts '&&' and '||' Statements
    @Override
    public void visit(BinaryExpr md, List<String> counter) {
            super.visit(md, counter);
            String currOperator = md.getOperator().toString();

            if (currOperator.equals("AND") || currOperator.equals("OR")) complexityUnits.add(md.toString());
    }

    //Counts 'foreach' Statements
    @Override
    public void visit(ForEachStmt md, List<String> counter) {
        super.visit(md, counter);
        complexityUnits.add(md.toString());
    }

    //Counts 'for' Statements
    @Override
    public void visit(ForStmt md, List<String> counter) {
        super.visit(md, counter);
        complexityUnits.add(md.toString());
    }

    //Counts 'try' Statements
    @Override
    public void visit(TryStmt md, List<String> counter) {
        super.visit(md, counter);
        complexityUnits.add(md.toString());
    }

    //Counts 'switch' Statements
    @Override
    public void visit(SwitchStmt md, List<String> counter) {
        super.visit(md, counter);
        complexityUnits.add(md.toString());
    }


}