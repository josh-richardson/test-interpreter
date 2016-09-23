package com.joshuarichardson;

import com.joshuarichardson.AST.AST;
import com.joshuarichardson.AST.BinOp;
import com.joshuarichardson.AST.Compound;
import com.joshuarichardson.AST.UnaryOp;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Joshua on 21/09/2016.
 */
public class Interpreter extends NodeVisitor{

    public Interpreter(Parser parser) {
        super(parser);
    }

    public int visit_BinOp(BinOp node){
        switch (node.getOp().getType()) {
            case PLUS:
                return Integer.valueOf(visit(node.getLeft())) + Integer.valueOf(visit(node.getRight()));
            case MINUS:
                return Integer.valueOf(visit(node.getLeft())) - Integer.valueOf(visit(node.getRight()));
            case MULTIPLY:
                return Integer.valueOf(visit(node.getLeft())) * Integer.valueOf(visit(node.getRight()));
            case DIVIDE:
                return Integer.valueOf(visit(node.getLeft())) / Integer.valueOf(visit(node.getRight()));

        }
        throw new NotImplementedException();
    }

    public void visit_Compound(Compound node) {
        node.getChildren().forEach(this::visit);
    }

    public int visit_UnaryOp(UnaryOp node) {
        TokenType op = node.getOp().getType();
        if (op == TokenType.PLUS) {
            return +Integer.valueOf(visit(node.getExpr()));
        } else if (op == TokenType.MINUS) {
            return -Integer.valueOf(visit(node.getExpr()));
        }
        return 0;
    }

    public int visit_Number(Number node) {
        return Integer.valueOf(node.getTokenValue());
    }

    public int interpret() {
        AST tree = parser.parse();
        System.out.println(tree.toString());
        return Integer.valueOf(visit(tree));
    }

}
