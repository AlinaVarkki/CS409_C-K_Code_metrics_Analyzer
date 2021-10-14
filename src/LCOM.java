import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.*;

public class LCOM extends VoidVisitorAdapter {

    CompilationUnit compilationUnit;
    List<VariableDeclarator> allVariables = new ArrayList<>();
    List<Set<String>> methodBodies = new ArrayList<>();

    public LCOM(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        compilationUnit.accept(this, null);
        System.out.println("LCOM IS " + getCommonAccessMethodsAmount());
    }

    public int getCommonAccessMethodsAmount() {

        int allPairs = methodBodies.size() * methodBodies.size();
        int sameVarAccessPairs = 0;

        for (int i = 0; i < methodBodies.size(); i++) {
            for (int j = i + 1; j < methodBodies.size(); j++) {
                for (VariableDeclarator var : allVariables) {
                    if (methodBodies.get(i).contains(var.getNameAsString()) && methodBodies.get(j).contains(var.getNameAsString())) {
//                        System.out.println("matching!!! " + var.getNameAsString() + " " + i + " " + j);
                        sameVarAccessPairs++;
                    }
                }
            }
        }

        int lcom = allPairs - sameVarAccessPairs;

        return lcom;
    }

    public void visit(FieldDeclaration vd, Object arg) {

        NodeList<VariableDeclarator> currVars = vd.getVariables();
        for (VariableDeclarator var : currVars) allVariables.add(var);

        super.visit(vd, arg);
    }

    public void visit(MethodDeclaration md, Object arg) {
        Set<String> currWords = new HashSet<>();

        Optional<BlockStmt> bs = md.getBody();

        bs.ifPresent(blockStmt -> {
            BlockStmt bStmt = md.getBody().get();
            for (Statement stmt : bStmt.getStatements()) {
                //break down every statement and make it a set of words
                //words should be without special characters
                String[] terms = stmt.toString().split("[\\s;,()]+");
                for (String s : terms) currWords.add(s);
            }
        });

        methodBodies.add(currWords);

        super.visit(md, arg);
    }

}
