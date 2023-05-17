package com.mf.visitor;

public interface Shape {
    void accept(ShapeVisitor visitor);
}

