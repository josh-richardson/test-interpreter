package com.joshuarichardson.AST;

/**
 * Created by Joshua on 23/09/2016.
 */
public class Program extends AST{


    private final String name;
    private final AST block;

    public Program(String name, AST block) {

        this.name = name;
        this.block = block;
    }



    @Override
    public String toString() {
        return null;
    }

    public String getName() {
        return name;
    }

    public AST getBlock() {
        return block;
    }
}
