package com.joshuarichardson.AST;

import com.joshuarichardson.Token;

/**
 * Created by Joshua on 23/09/2016.
 */
public class Type extends AST {


    private final Token token;
    private final String value;
    public Type(Token token) {
        this.value = token.getValue();
        this.token = token;
    }

    @Override
    public String toString() {
        return null;
    }

    public Token getToken() {
        return token;
    }

    public String getValue() {
        return value;
    }
}
