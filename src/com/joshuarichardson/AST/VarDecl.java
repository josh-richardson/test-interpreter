package com.joshuarichardson.AST;

/**
 * Created by Joshua on 23/09/2016.
 */
public class VarDecl extends AST{


    private final Var varNode;
    private final Symbol typeNode;

    public VarDecl(Var varNode, Symbol typeNode) {

        this.varNode = varNode;
        this.typeNode = typeNode;
    }


    @Override
    public String toString() {
        return null;
    }

    public Var getVarNode() {
        return varNode;
    }

    public Symbol getTypeNode() {
        return typeNode;
    }
}
