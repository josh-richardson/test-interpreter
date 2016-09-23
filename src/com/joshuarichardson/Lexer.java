package com.joshuarichardson;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;

/**
 * Created by Joshua on 21/09/2016.
 */
@SuppressWarnings("Duplicates")
public class Lexer {

    HashMap<String, Token> reservedKeywords = new HashMap<String, Token>() {{
        put("PROGRAM", new Token(TokenType.PROGRAM, "PROGRAM"));
        put("VAR", new Token(TokenType.VAR, "VAR"));
        put("DIV", new Token(TokenType.INTEGER_DIVIDE, "DIV"));
        put("INTEGER", new Token(TokenType.INTEGER, "INTEGER"));
        put("REAL", new Token(TokenType.REAL, "REAL"));
        put("BEGIN", new Token(TokenType.BEGIN, "BEGIN"));
        put("END", new Token(TokenType.END, "END"));
    }};


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

    private String peek() {
        int peek_position = position + 1;
        if (peek_position > text.length() -1) {
            return null;
        } else {
            return String.valueOf(text.charAt(peek_position));
        }
    }

    private void skipWhitespace() {
        while (!currentChar.equals("") && Utils.isSpace(currentChar)) {
            advance();
        }
    }


    private void skip_comment() {
        while (!currentChar.equals("}")) {
            advance();
        }
        advance();
    }

    private Token number() {
        Token token;
        String result = "";
        while (currentChar != null && Utils.isNumeric(currentChar)) {
            result += currentChar;
            advance();
        }
        if (currentChar != null && currentChar.equals(".")) {
            result += currentChar;
            advance();
            while (currentChar != null && Utils.isNumeric(currentChar)) {
                result += currentChar;
                advance();
            }

            token = new Token(TokenType.REAL_CONST, result);

        } else {
            token = new Token(TokenType.INTEGER_CONST, result);
        }
        return token;
    }

    private Token _id() {
        String result = "";
        while (currentChar != null && Utils.isAlphaNumeric(currentChar)) {
            result += currentChar;
            advance();
        }
        if (reservedKeywords.containsKey(result)) {
            return reservedKeywords.get(result);
        } else {
            return new Token(TokenType.ID, result);
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
                skipWhitespace();
                continue;
            }

            if (currentChar.equals("{")) {
                advance();
                skip_comment();
                continue;
            }

            if(Utils.isAlpha(currentChar)) {
                return _id();
            }

            if (Utils.isNumeric(currentChar)) {
                return number();
            }

            if (currentChar.equals(":") && peek() != null && peek().equals("=")) {
                advance();
                advance();
                return new Token(TokenType.ASSIGN, ":=");
            }

            switch (currentChar) {
                case ";":
                    advance();
                    return new Token(TokenType.SEMI, ";");
                case ":":
                    advance();
                    return new Token(TokenType.COLON, ";");
                case ",":
                    advance();
                    return new Token(TokenType.COMMA, ",");
                case ".":
                    advance();
                    return new Token(TokenType.DOT, ".");
                case "+":
                    advance();
                    return new Token(TokenType.PLUS, "+");
                case "-":
                    advance();
                    return new Token(TokenType.MINUS, "-");
                case "*":
                    advance();
                    return new Token(TokenType.MULTIPLY, "*");
                case "/":
                    advance();
                    return new Token(TokenType.FLOAT_DIVIDE, "/");
                case "(":
                    advance();
                    return new Token(TokenType.LPAREN, "(");
                case ")":
                    advance();
                    return new Token(TokenType.RPAREN, ")");
            }
            throw new NotImplementedException();
        }
        return new Token(TokenType.EOF, null);
    }


}
