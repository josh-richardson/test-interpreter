package com.joshuarichardson;

/**
 * Created by Joshua on 20/09/2016.
 */
public class Token {


    private final TokenType type;
    private final String  value;

    public Token(TokenType type, String  value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("Token({%s}{%s})", type.getName(), value);
    }

    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

}
