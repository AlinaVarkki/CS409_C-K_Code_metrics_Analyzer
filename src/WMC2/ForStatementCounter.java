package WMC2;

import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

public class ForStatementCounter extends VoidVisitorAdapter<List<String>> {

    @Override
    public void visit(ForStmt md, List<String> counter) {
        super.visit(md, counter);
        counter.add(md.toString());
    }

}
