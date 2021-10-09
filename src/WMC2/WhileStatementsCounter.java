package WMC2;

import com.github.javaparser.ast.stmt.WhileStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

public class WhileStatementsCounter extends VoidVisitorAdapter<List<String>> {

    @Override
    public void visit(WhileStmt md, List<String> counter) {
        super.visit(md, counter);
        counter.add(md.toString());
    }
}
