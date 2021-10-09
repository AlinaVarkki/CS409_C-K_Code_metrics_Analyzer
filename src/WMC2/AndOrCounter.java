package WMC2;

import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

public class AndOrCounter extends VoidVisitorAdapter<List<String>> {

    @Override
    public void visit(BinaryExpr md, List<String> counter) {
        super.visit(md, counter);
        String currOperator = md.getOperator().toString();

        if (currOperator.equals("AND") || currOperator.equals("OR")) counter.add(md.toString());
    }

}
