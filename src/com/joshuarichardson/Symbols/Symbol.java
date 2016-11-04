package com.joshuarichardson.Symbols;

/**
 * Created by Joshua on 25/09/2016.
 */
public class Symbol {

    protected final String name;
    protected final com.joshuarichardson.Symbols.Symbol type;

    public Symbol(String name, com.joshuarichardson.Symbols.Symbol type) {

        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public com.joshuarichardson.Symbols.Symbol getType() {
        return type;
    }
}
