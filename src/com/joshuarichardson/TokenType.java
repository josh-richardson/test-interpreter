package com.joshuarichardson;

/**
 * Created by Joshua on 20/09/2016.
 */
public enum TokenType {
    INTEGER("INTEGER"),
    REAL("REAL"),
    INTEGER_CONST("INTEGER_CONST"),
    REAL_CONST("REAL_CONST"),
    PLUS("PLUS"),
    MINUS("MINUS"),
    MULTIPLY("MULTIPLY"),
    INTEGER_DIVIDE("INTEGER_DIVIDE"),
    FLOAT_DIVIDE("FLOAT_DIVIDE"),
    LPAREN("("),
    RPAREN(")"),
    ID("ID"),
    ASSIGN(":="),
    BEGIN("BEGIN"),
    END("END"),
    SEMI("SEMI"),
    DOT("DOT"),
    PROGRAM("PROGRAM"),
    VAR("VAR"),
    COLON("COLON"),
    COMMA("COMMA"),
    EOF("EOF");


    private String name;

    TokenType(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
