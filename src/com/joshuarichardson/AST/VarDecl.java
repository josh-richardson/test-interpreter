package com.joshuarichardson.AST;

/**
 * Created by Joshua on 23/09/2016.
 */
public class VarDecl extends AST{


    private final AST varNode;
    private final AST typeNode;

    public VarDecl(AST varNode, AST typeNode) {

        this.varNode = varNode;
        this.typeNode = typeNode;
    }


    @Override
    public String toString() {
        return null;
    }

    public AST getVarNode() {
        return varNode;
    }

    public AST getTypeNode() {
        return typeNode;
    }
}
