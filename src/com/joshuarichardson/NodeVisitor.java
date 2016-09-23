package com.joshuarichardson;

import com.joshuarichardson.AST.AST;
import com.joshuarichardson.AST.BinOp;
import com.joshuarichardson.AST.UnaryOp;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Joshua on 21/09/2016.
 */
public class NodeVisitor {

    final Parser parser;

    public NodeVisitor(Parser parser) {
        this.parser = parser;
    }

    public String visit(AST node) {
        try {
            if (node instanceof BinOp || node instanceof Number || node instanceof UnaryOp) {
                String methodName = "visit_" + node.getClass().getSimpleName();
                Method m = getClass().getMethod(methodName, Class.forName(node.getClass().getName()));
                m.setAccessible(true);
                return String.valueOf(m.invoke(this, node));
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Failed visit");
        return "0";
    }


}
