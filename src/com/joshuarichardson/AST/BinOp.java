package com.joshuarichardson.AST;

import com.joshuarichardson.Token;

/**
 * Created by Joshua on 21/09/2016.
 */
public class BinOp extends AST {

    private AST left;
    private AST right;
    private Token op;

    public BinOp(AST left,Token op,  AST right) {

        this.left = left;
        this.right = right;
        this.op = op;
    }




    public AST getLeft() {
        return left;
    }

    public AST getRight() {
        return right;
    }

    public Token getOp() {
        return op;
    }

    @Override
    public String toString() {
        return  "BinOp: {" + left.toString() + ", "+  op.getType().getName() + ", " + right.toString() + "} ";
    }
}
