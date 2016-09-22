package com.joshuarichardson;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Joshua on 21/09/2016.
 */
@SuppressWarnings("Duplicates")
public class Lexer {


    private final String text;
    private int position;
    private String currentChar;

    public Lexer(String text) {
        position = 0;
        this.text = text;
        currentChar = String.valueOf(text.charAt(position));
    }

    private void advance() {
        position++;
        if (position > text.length() - 1) {
            currentChar = "";
        } else {
            currentChar = String.valueOf(text.charAt(position));
        }
    }

    private void handleWhitespace() {
        while (!currentChar.equals("") && Utils.isSpace(currentChar)) {
            advance();
        }
    }

    private String getInteger() {
        String value = "";
        while(Utils.isNumeric(currentChar)) {
            value += currentChar;
            advance();
        }
        return value;
    }

    Token getNextToken() {
        while (!currentChar.equals("")) {
            if (Utils.isSpace(currentChar)) {
                handleWhitespace();
                continue;
            }

            if (Utils.isNumeric(currentChar)) {
                return new Token(TokenType.INTEGER, getInteger());
            }

            if (currentChar.equals("+")) {
                advance();
                return new Token(TokenType.PLUS, "+");

            }
            if (currentChar.equals("-")) {
                advance();
                return new Token(TokenType.MINUS, "-");
            }

            if (currentChar.equals("*")) {
                advance();
                return new Token(TokenType.MULTIPLY, "*");
            }

            if (currentChar.equals("/")) {
                advance();
                return new Token(TokenType.DIVIDE, "/");
            }

            if (currentChar.equals("(")) {
                advance();
                return new Token(TokenType.LPAREN, "(");
            }

            if (currentChar.equals(")")) {
                advance();
                return new Token(TokenType.RPAREN, ")");
            }


            throw new NotImplementedException();


        }
        return new Token(TokenType.EOF, null);
    }


}
