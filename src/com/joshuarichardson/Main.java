package com.joshuarichardson;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        Lexer lexer = new Lexer(input);
        Parser parser = new Parser(lexer);
        System.out.println(parser.parse().toString());
//
//        Interpreter interpreter = new Interpreter(parser);
//        System.out.println(interpreter.interpret());


//        Token mulToken = new Token(TokenType.MULTIPLY, "*");
//        Token plusToken = new Token(TokenType.PLUS, "+");
//        BinOp mulNode = new BinOp(new Number(new Token(TokenType.INTEGER, "2")), mulToken, new Number(new Token(TokenType.INTEGER, "7")));
//        BinOp add_node = new BinOp(mulNode, plusToken, new Number(new Token(TokenType.INTEGER, "3")));
//        System.out.println(new NodeVisitor(new Interpreter()).visit(add_node));

    }
}

//class helper {
//
//    public helper(String keksimus) {
//
//        System.out.println(keksimus);
//    }
//
//}