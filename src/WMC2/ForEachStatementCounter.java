package WMC2;

import com.github.javaparser.ast.stmt.ForEachStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

public class ForEachStatementCounter extends VoidVisitorAdapter<List<String>> {

    @Override
    public void visit(ForEachStmt md, List<String> counter) {
        super.visit(md, counter);
        counter.add(md.toString());
    }

}
