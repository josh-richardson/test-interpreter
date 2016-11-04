package com.joshuarichardson.Symbols;

/**
 * Created by Joshua on 25/09/2016.
 */
public class BuiltinTypeSymbol extends Symbol{
    public BuiltinTypeSymbol(String name) {
        super(name, null);
    }

    @Override
    public String toString() {
        return name;
    }
}
