package com.joshuarichardson.Symbols;

/**
 * Created by Joshua on 25/09/2016.
 */
public class VarSymbol extends com.joshuarichardson.Symbols.Symbol {

    public VarSymbol(String name, Symbol type) {
        super(name, type);
    }

    @Override
    public String getName() {
        return String.format("<%s:%s>", name, type);
    }
}
