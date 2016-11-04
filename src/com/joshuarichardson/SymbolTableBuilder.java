package com.joshuarichardson;

import com.joshuarichardson.AST.*;
import com.joshuarichardson.Symbols.Symbol;
import com.joshuarichardson.Symbols.SymbolTable;
import com.joshuarichardson.Symbols.VarSymbol;

/**
 * Created by Joshua on 25/09/2016.
 */
public class SymbolTableBuilder extends NodeVisitor{
    SymbolTable symTab = new SymbolTable();

    public SymbolTableBuilder(Parser parser) {
        super(parser);
    }

    public void visit_Block(Block node) {
        node.getDeclarations().forEach(this::visit);
        visit(node.getCompound_statement());
    }


    public void visit_Program(Program node) {
        visit(node.getBlock());
    }

    public void visit_BinOp(BinOp node) {
        visit(node.getLeft());
        visit(node.getRight());
    }

    public void visit_Num(Num node) {
    }

    public void visit_UnaryOp(UnaryOp node) {
        visit(node.getExpr());
    }

    public void visit_Compound(Compound node) {
        node.getChildren().forEach(this::visit);
    }

    public void visit_NoOp(NoOp node){}

    public void visit_VarDecl(VarDecl node) {
        String typeName = node.getTypeNode().getValue();
        Symbol typeSymbol = symTab.lookup(typeName);
        String varName = node.getVarNode().getValue();
        VarSymbol varSymbol = new VarSymbol(varName, typeSymbol);
        symTab.define(varSymbol);
    }

    public void visit_Assign(Assign node) {
        String varName = node.getLeft().getValue();
    }

}
