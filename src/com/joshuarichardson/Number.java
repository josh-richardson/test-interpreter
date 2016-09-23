package com.joshuarichardson;

import com.joshuarichardson.AST.AST;

/**
 * Created by Joshua on 21/09/2016.
 */
public class Number extends AST {
    private Token token;
    private String tokenValue;
    public Number(Token token) {
        this.tokenValue = token.getValue();
        this.token = token;
    }






    public Token getToken() {
        return token;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    @Override
    public String toString() {
        return "Number: {" + tokenValue + "} ";
    }
}
