package com.joshuarichardson.AST;

import com.joshuarichardson.Token;

/**
 * Created by Joshua on 22/09/2016.
 */
public class UnaryOp extends AST{

    private AST expr;
    private Token op;

    public UnaryOp(Token op, AST expr) {
        this.expr = expr;
        this.op = op;

    }

    public AST getExpr() {
        return expr;
    }

    public Token getOp() {
        return op;
    }

    @Override
    public String toString() {
        return  "UnaryOP: {" + op.getType().getName() + ", " + expr.toString() + "} ";
    }
}
