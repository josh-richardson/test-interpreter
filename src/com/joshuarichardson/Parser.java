package com.joshuarichardson;

import com.joshuarichardson.AST.*;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

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

    private AST program() {
        eat(TokenType.PROGRAM);
        Program varNode = (Program) variable();
        String programName = varNode.getName();
        eat(TokenType.SEMI);
        AST blockNode = block();
        AST programNode = new Program(programName, blockNode);
        eat(TokenType.DOT);
        return programNode;
    }

    private AST block() {
        ArrayList<AST> declarationNodes = declarations();
        AST compoundStatement = compoundStatement();
        return new Block(declarationNodes, compoundStatement);
    }

    private ArrayList<AST> declarations() {
        ArrayList<AST> declarations = new ArrayList<>();

        if (currentToken.getType() == TokenType.VAR) {
            eat(TokenType.VAR);
            while(currentToken.getType() == TokenType.ID) {
                ArrayList<VarDecl> varDecl = variableDeclaration();
                declarations.addAll(varDecl);
                eat(TokenType.SEMI);
            }
        }
        return declarations;
    }


    private ArrayList<VarDecl> variableDeclaration() {
        ArrayList<Var> varNodes = new ArrayList<>();
        varNodes.add(new Var(currentToken));
        eat(TokenType.ID);
        while (currentToken.getType() == TokenType.COMMA) {
            eat(TokenType.COMMA);
            varNodes.add(new Var(currentToken));
        }
        eat(TokenType.COLON);
        Type typeNode = (Type) typeSpec();
        ArrayList<VarDecl> varDeclarations = new ArrayList<>();
        varNodes.stream().map(x -> new VarDecl(x, typeNode)).forEach(varDeclarations::add);
        return varDeclarations;
//        Fairly sure they're functionally identical, but want to be on the safe side.
//        return varNodes.stream().map(x -> new VarDecl(x, typeNode)).collect(Collectors.toCollection(ArrayList::new));
    }


    private AST typeSpec() {
        Token token = currentToken;
        if (currentToken.getType() == TokenType.INTEGER) {
            eat(TokenType.INTEGER);
        } else {
            eat(TokenType.REAL);
        }
        return new Type(token);
    }

    private AST compoundStatement() {
        eat(TokenType.BEGIN);
        ArrayList<AST> nodes = statementList();
        eat(TokenType.END);
        return new Compound(nodes);
    }


    private ArrayList<AST> statementList() {
        ArrayList<AST> results = new ArrayList<>();
        AST node = statement();
        results.add(node);

        while (currentToken.getType() == TokenType.SEMI) {
            eat(TokenType.SEMI);
            results.add(statement());
        }

        if (currentToken.getType() == TokenType.ID) {
            throw new NotImplementedException();
        }

        return results;
    }

    private AST statement() {
        AST node;
        switch (currentToken.getType()) {
            case BEGIN:
                node = compoundStatement();
                break;
            case ID:
                node = assignmentStatement();
                break;
            default:
                node = empty();
        }
        return node;
    }


    private AST assignmentStatement() {
        AST left = variable();
        Token token = currentToken;
        eat(TokenType.ASSIGN);
        AST right = evaluate();
        return new Assign(left, token, right);
    }



    private AST variable() {
        Var node = new Var(currentToken);
        eat(TokenType.ID);
        return node;
    }


    private AST empty() {
        return new NoOp();
    }


    public AST evaluate() {
        AST node = term();

        while (currentToken.getType() == TokenType.PLUS || currentToken.getType() == TokenType.MINUS) {
            Token tempToken = currentToken;
            if (currentToken.getType() == TokenType.PLUS) {
                eat(TokenType.PLUS);
            } else if (currentToken.getType() == TokenType.MINUS) {
                eat(TokenType.MINUS);
            }
            node = new BinOp(node, tempToken, term());
        }

        return node;
    }

    private AST term() {
        AST node = factor();
        while (currentToken.getType() == TokenType.MULTIPLY || currentToken.getType() == TokenType.INTEGER_DIVIDE || currentToken.getType() == TokenType.FLOAT_DIVIDE) {
            Token tempToken = currentToken;
            if (currentToken.getType() == TokenType.MULTIPLY) {
                eat(TokenType.MULTIPLY);
            } else if (currentToken.getType() == TokenType.FLOAT_DIVIDE) {
                eat(TokenType.FLOAT_DIVIDE);
            } else if (currentToken.getType() == TokenType.INTEGER_DIVIDE) {
                eat(TokenType.INTEGER_DIVIDE);
            }
            node = new BinOp(node, tempToken, factor());
        }
        return node;
    }



    private AST factor() {
        Token tempToken = currentToken;

        if (currentToken.getType() == TokenType.PLUS) {
            eat(TokenType.PLUS);
            return new UnaryOp(tempToken, factor());
        } else if (currentToken.getType() == TokenType.MINUS) {
            eat(TokenType.MINUS);
            return new UnaryOp(tempToken, factor());
        } else if (currentToken.getType() == TokenType.INTEGER_CONST) {
            eat(TokenType.INTEGER_CONST);
            return new Number(tempToken);
        } else if (currentToken.getType() == TokenType.REAL_CONST) {
            eat(TokenType.REAL_CONST);
            return new Number(tempToken);
        } else if (currentToken.getType() == TokenType.LPAREN) {
            eat(TokenType.LPAREN);
            AST result = evaluate();
            eat(TokenType.RPAREN);
            return result;
        } else {
            return variable();
        }
    }






    public AST parse() {
        AST node = program();
        if (currentToken.getType() != TokenType.EOF) {
            throw new NotImplementedException();
        }
        return node;
    }

}
