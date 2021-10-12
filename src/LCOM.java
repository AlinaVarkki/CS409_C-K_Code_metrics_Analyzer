import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.*;

public class LCOM extends VoidVisitorAdapter {

    CompilationUnit compilationUnit;
    Map<String, Set<String>> methodAndInstances = new HashMap<>();
    List<Node> allVariables = new ArrayList<>();

    public LCOM(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        compilationUnit.accept(this, null);
        System.out.println(allVariables);
    }

    public void visit(FieldDeclaration vd, Object arg) {
        NodeList<VariableDeclarator> currVars = vd.getVariables();
        for(VariableDeclarator var: currVars) allVariables.add(var);
    }

//    public void visit(MethodDeclaration method, Object arg) {
//
//    }

}
