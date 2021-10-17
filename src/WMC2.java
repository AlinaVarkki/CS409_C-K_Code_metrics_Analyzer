import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.stmt.*;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WMC2 extends VoidVisitorAdapter<List<String>> {

    CompilationUnit compilationUnit;
    List<String> complexityUnitsMethods = new ArrayList<>();
    List<String> complexityUnits = new ArrayList<>();

    List<String> constructorUnits = new ArrayList<>();
    List<String> decisionUnits = new ArrayList<>();

    public WMC2(CompilationUnit compilationUnit) {
        this.compilationUnit = compilationUnit;
        compilationUnit.accept(this, complexityUnits);
        //compare2();
    }

    public int getCount() { return complexityUnits.size(); }

    public void getDecisions() {
        for (String complexityUnit : complexityUnits) {
            System.out.println("complexityUnits " + complexityUnit);
        }
//        for (String complexityUnit : decisionUnits) {
//            System.out.println("decisionUnit " + complexityUnit);
//        }
//        for (String complexityUnit : constructorUnits) {
//            System.out.println("constructorUnits " + complexityUnit);
//        }
//        System.out.println(constructorUnits.size());
    }

//    public void getMethods() {
//        for (int i =0; i < decisionUnits.size(); i++) {
//            System.out.println("Methods Counted " + decisionUnits.get(i));
//        }
//    }

    //Considers Inner Class's Methods
    @Override
    public void visit(ClassOrInterfaceDeclaration md, List<String> counter) {
        super.visit(md, counter);
    }

    //Collects All Methods
    @Override
    public void visit(MethodDeclaration md, List<String> counter) {
        super.visit(md, counter);
        complexityUnits.add(md.getNameAsString());
    }

//    //Collects Body of Constructor
//    @Override
//    public void visit(ConstructorDeclaration md, List<String> counter) {
//        super.visit(md, counter);
//        constructorUnits.add(md.getBody().toString());
//    }

//    private void compare2() {
//        for (String constructorUnit : constructorUnits) {
//            for (String decisionUnit : decisionUnits) {
//                if (constructorUnit.contains(decisionUnit)) {
//                    System.out.println("MATCHES ----------------------");
//                }
//                else System.out.println("NOPE --------------------------");
//            }
//        }
//    }


//    //Compare DecisionUnits to ConstructorUnits and Remove Duplicates
//    private void compare() {
//        for (String decisionUnit : decisionUnits) {
//
//            char[] decisionUnitArray = convert(decisionUnit);
//            //Pattern dUnit = Pattern.compile(String.valueOf(decisionUnitArray));
//            System.out.println("decisionUnitArray " + String.valueOf(decisionUnitArray));
//
//            for (String constructorUnit : constructorUnits) {
//                char[] constructorUnitArray = convert(constructorUnit);
//                System.out.println("constructorUnitArray " + String.valueOf(constructorUnitArray));
//
////                if (String.valueOf(constructorUnitArray).contains(String.valueOf(decisionUnitArray))) {
////                    System.out.println("MATCH ------------------------------------------");
////                    decisionUnits.remove(decisionUnit);
////                } else {
////                    System.out.println("NO MATCH --------------------------------------");
////                }
//
//                //Matcher check = dUnit.matcher(String.valueOf(constructorUnitArray));
//
//                //boolean matches = check.matches();
//                //System.out.println(matches);
////                if (matches) {
////                    decisionUnits.remove(decisionUnit);
////                }
//            }
//
//        }
//
//    }

//    //Converts Stored Strings to Char Arrays, Removing '{ }' for '/' which can be compared
//    private char[] convert(String toConvert) {
//        char[] ch = toConvert.toCharArray();
//        for (int i = 0; i < ch.length; i++) {
//            if (ch[i] == '{') {
//                ch[i] = '/';
//            } else if (ch[i] == '}') {
//                ch[i] = '/';
//            }
//        }
//        return ch;
//    }

    @Override
    public void visit(IfStmt md, List<String> counter) {
        super.visit(md, counter);
        complexityUnits.add(md.toString());
    }


    @Override
    public void visit(WhileStmt md, List<String> counter) {
        super.visit(md, counter);
        complexityUnits.add(md.toString());
    }

    @Override
    public void visit(BinaryExpr md, List<String> counter) {
            super.visit(md, counter);
            String currOperator = md.getOperator().toString();

            if (currOperator.equals("AND") || currOperator.equals("OR")) complexityUnits.add(md.toString());
    }

    @Override
    public void visit(ForEachStmt md, List<String> counter) {
        super.visit(md, counter);
        complexityUnits.add(md.toString());
    }

    @Override
    public void visit(ForStmt md, List<String> counter) {
        super.visit(md, counter);
        complexityUnits.add(md.toString());
    }

    @Override
    public void visit(TryStmt md, List<String> counter) {
        super.visit(md, counter);
        complexityUnits.add(md.toString());
    }

    @Override
    public void visit(SwitchStmt md, List<String> counter) {
        super.visit(md, counter);
        complexityUnits.add(md.toString());
    }


}