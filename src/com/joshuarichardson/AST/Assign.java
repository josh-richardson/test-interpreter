package com.joshuarichardson.AST;

import com.joshuarichardson.Token;

/**
 * Created by Joshua on 23/09/2016.
 */
public class Assign extends AST {


    private AST left;
    private final Token op;
    private final AST right;

    public Assign(AST left, Token op, AST right) {

        this.left = left;
        this.op = op;
        this.right = right;
    }



    @Override
    public String toString() {
        return "Assign: {" + left.toString() + ", " + op.getType().getName() + ", " + right.toString() + "} ";
    }

    public AST getLeft() {
        return left;
    }

    public Token getOp() {
        return op;
    }

    public AST getRight() {
        return right;
    }
}
