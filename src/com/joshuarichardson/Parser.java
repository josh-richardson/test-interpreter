package com.joshuarichardson;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Created by Joshua on 20/09/2016.
 */
public class Parser {
    private final Lexer lexer;
    private Token currentToken = null;


    public Parser(Lexer lexer) {
        this.lexer = lexer;
        currentToken= lexer.getNextToken();

    }
    private void eat(TokenType tokenType) {
        if (tokenType == currentToken.getType()) {
            currentToken = lexer.getNextToken();
        } else {
            throw new NotImplementedException();
        }
    }

    private AST factor() {

        if (currentToken.getType() == TokenType.INTEGER) {
            eat(TokenType.INTEGER);
            return new Number(currentToken);
        }

        if (currentToken.getType() == TokenType.LPAREN) {
            eat(TokenType.LPAREN);
            AST result = evaluate();
            eat(TokenType.RPAREN);
            return result;
        }
        throw new NotImplementedException();

    }


    private AST term() {
        AST node = factor();
        while (currentToken.getType() == TokenType.MULTIPLY || currentToken.getType() == TokenType.DIVIDE) {
            if (currentToken.getType() == TokenType.MULTIPLY) {
                eat(TokenType.MULTIPLY);
            } else if (currentToken.getType() == TokenType.DIVIDE) {
                eat(TokenType.DIVIDE);
            }
            System.out.println(currentToken.getType());

            node = new BinOp(node, currentToken, factor());
        }
        return node;
    }


    public AST evaluate() {
        AST node = term();
        while (currentToken.getType() == TokenType.PLUS || currentToken.getType() == TokenType.MINUS) {
            if (currentToken.getType() == TokenType.PLUS) {
                eat(TokenType.PLUS);
            } else if (currentToken.getType() == TokenType.MINUS) {
                eat(TokenType.MINUS);
            }
            node = new BinOp(node, currentToken, term());
        }

        return node;
    }

    public AST parse() {
        return evaluate();
    }

}
