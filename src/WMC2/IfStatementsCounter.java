package WMC2;

import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

public class IfStatementsCounter extends VoidVisitorAdapter<List<String>> {

    @Override
    public void visit(IfStmt md, List<String> counter) {
        super.visit(md, counter);
        counter.add(md.toString());
    }
}
