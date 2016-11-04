package com.joshuarichardson.Symbols;

import java.util.HashMap;

/**
 * Created by Joshua on 25/09/2016.
 */
public class SymbolTable {
    private HashMap<String, Symbol> symbols = new HashMap<>();

    public SymbolTable() {
        define(new BuiltinTypeSymbol("INTEGER"));
        define(new BuiltinTypeSymbol("REAL"));

    }


    public void define(Symbol s) {
        System.out.println("Define: " + s);
        symbols.put(s.getName(), s);
    }

    public Symbol lookup(String s) {
        System.out.println("Lookup: " + s);
        return symbols.get(s);
    }



}
