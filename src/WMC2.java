import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.stmt.ForEachStmt;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.stmt.WhileStmt;
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

    public int getCount() {
        return complexityUnits.size();
    }

    @Override
    public void visit(MethodDeclaration md, List<String> counter) {
        super.visit(md, counter);
        counter.add(md.getNameAsString());
    }

    @Override
    public void visit(IfStmt md, List<String> counter) {
        super.visit(md, counter);
        counter.add(md.toString());
    }

    @Override
    public void visit(WhileStmt md, List<String> counter) {
        super.visit(md, counter);
        counter.add(md.toString());
    }

    @Override
    public void visit(BinaryExpr md, List<String> counter) {
        super.visit(md, counter);
        String currOperator = md.getOperator().toString();

        if (currOperator.equals("AND") || currOperator.equals("OR")) counter.add(md.toString());
    }

    @Override
    public void visit(ForEachStmt md, List<String> counter) {
        super.visit(md, counter);
        counter.add(md.toString());
    }

    @Override
    public void visit(ForStmt md, List<String> counter) {
        super.visit(md, counter);
        counter.add(md.toString());
    }

}