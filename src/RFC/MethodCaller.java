package RFC;

import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.List;

public class MethodCaller extends VoidVisitorAdapter<List<String>> {

        @Override
        public void visit(MethodCallExpr md, List<String> counter) {
            super.visit(md, counter);
            counter.add(md.getNameAsString());
        }
    }
