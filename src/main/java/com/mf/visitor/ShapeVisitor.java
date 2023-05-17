package com.mf.visitor;

public interface ShapeVisitor {
    void visit(Circle circle);
    void visit(Square square);
}



