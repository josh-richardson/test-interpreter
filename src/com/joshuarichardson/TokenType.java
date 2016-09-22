package com.joshuarichardson;

/**
 * Created by Joshua on 20/09/2016.
 */
public enum TokenType {
    INTEGER("INTEGER"),
    PLUS("PLUS"),
    MINUS("MINUS"),
    MULTIPLY("MULTIPLY"),
    DIVIDE("DIVIDE"),
    LPAREN("("),
    RPAREN(")"),
    EOF("EOF");


    private String name;

    TokenType(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
