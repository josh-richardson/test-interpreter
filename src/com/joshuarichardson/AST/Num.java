package com.joshuarichardson.AST;

import com.joshuarichardson.Token;

/**
 * Created by Joshua on 23/09/2016.
 */
public class Num extends AST{

    private final Token token;
    private final String value;

    public Num(Token token) {
        this.value = token.getValue();
        this.token = token;
    }


    @Override
    public String toString() {
        return "Num: ";
    }

    public Token getToken() {
        return token;
    }

    public String getValue() {
        return value;
    }
}
