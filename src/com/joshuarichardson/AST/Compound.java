package com.joshuarichardson.AST;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by Joshua on 23/09/2016.
 */
public class Compound extends AST{
    private ArrayList<AST> children;

    public Compound(ArrayList<AST> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Compound: {" + children.stream().map(AST::toString).collect(Collectors.joining(", ")) + "} ";
    }

    public ArrayList<AST> getChildren() {
        return children;
    }
}
