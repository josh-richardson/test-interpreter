package com.joshuarichardson.AST;

import java.util.ArrayList;

/**
 * Created by Joshua on 23/09/2016.
 */
public class Block extends AST{


    private final ArrayList<AST> declarations;
    private final AST compound_statement;

    public Block(ArrayList<AST> declarations, AST compoundStatement) {

        this.declarations = declarations;
        this.compound_statement = compoundStatement;
    }



    @Override
    public String toString() {
        return null;
    }

    public ArrayList<AST> getDeclarations() {
        return declarations;
    }

    public AST getCompound_statement() {
        return compound_statement;
    }
}
