package com.mf.visitor;

public class AreaVisitor implements ShapeVisitor {
    private double totalArea = 0;

    @Override
    public void visit(Circle circle) {
        double area = Math.PI * Math.pow(circle.getRadius(), 2);
        totalArea += area;
    }

    @Override
    public void visit(Square square) {
        double area = Math.pow(square.getSideLength(), 2);
        totalArea += area;
    }

    public double getTotalArea() {
        return totalArea;
    }
}