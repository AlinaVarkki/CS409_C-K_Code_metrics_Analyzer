import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.ObjectCreationExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.*;

public class CBO extends VoidVisitorAdapter {

    Map<String, String> nameToObjType = new HashMap<>();
    CompilationUnit compilationUnit;
    String className;
    Set<String> dependedClasses = new HashSet<>();

    public CBO(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        compilationUnit.accept(this, null);

//        for(String s: dependedClasses) System.out.println(s + " " + getClassName());
    }

    public String getClassName() {
        return className;
    }

    public Set<String> getDependedClasses() {
        return dependedClasses;
    }

    @Override
    public void visit(ClassOrInterfaceDeclaration n, Object arg) {
        className = n.getNameAsString();
        super.visit(n, arg);
    }

    //object can be created or passed in
    //save type of created object and a var name
    @Override
    public void visit(ObjectCreationExpr n, Object arg) {
//        System.out.println(n.getParentNode());

        Optional<Node> node = n.getParentNode();
        String objName = node.toString().split(" ")[0].substring(9);
        nameToObjType.put(objName, n.getType().toString());
        super.visit(n, arg);
    }

    //object can be created or passed in
    @Override
    public void visit(Parameter n, Object arg) {
        nameToObjType.put(n.getNameAsString(), n.getType().toString());
        super.visit(n, arg);
    }

    //check what obj is method called on
    @Override
    public void visit(MethodCallExpr n, Object arg) {

        String[] args = n.toString().split("[\\s().]+");
        if (args.length > 1) {
            String var = args[0];

            if (nameToObjType.containsKey(var)) dependedClasses.add(nameToObjType.get(var));
        }
        super.visit(n, arg);
    }

}
