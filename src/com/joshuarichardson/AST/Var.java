package com.joshuarichardson.AST;

import com.joshuarichardson.Token;

/**
 * Created by Joshua on 23/09/2016.
 */
public class Var extends AST{

    private Token token;
    private String value;

    public Var(Token token) {
        this.token = token;
        this.value = token.getValue();
    }

    @Override
    public String toString() {
        return "Var: {" + token.getType().getName() + ", " + value + "} ";
    }

    public String getValue() {
        return value;
    }

    public Token getToken() {
        return token;
    }
}
