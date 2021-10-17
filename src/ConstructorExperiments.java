import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.IfStmt;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.List;

public class ConstructorExperiments extends VoidVisitorAdapter<List<String>> {

    CompilationUnit compilationUnit;
    List<String> complexityUnits = new ArrayList<>();
    List<String> constructorUnits = new ArrayList<>();

    public ConstructorExperiments(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        compilationUnit.accept(this, complexityUnits);
    }

    @Override
    public void visit(ConstructorDeclaration md, List<String> counter) {
        super.visit(md, counter);
        //counter.add(md.getBody().toString());
        constructorUnits.add(md.getNameAsString());
        //compair();
    }

//    @Override
//    public void visit(BlockStmt md, List<String> counter) {
//        if (md.getStatements().get)
//        super.visit(md, counter);
//        complexityUnits.add(md.getStatements().toString());
//        //compair();
//    }

    public void getDecisions() {
        for (int i = 0; i < constructorUnits.size(); i++) {
            System.out.println(i + " constructorUnits " + constructorUnits);
        }
//        for (String complexityUnit : complexityUnits) {
//            System.out.println("complexityUnits " + complexityUnit);
 //   }
        System.out.println(constructorUnits.size());
    }

    @Override
    public void visit(IfStmt md, List<String> counter) {
            super.visit(md, counter);
            counter.add(md.toString());
    }

//    public void compair() {
//        for (String complexityUnit : constructorUnits) {
//            if (complexityUnit.contains("if")) {
//                constructorUnits.remove(complexityUnit);
//            }
//        }
//    }

}
