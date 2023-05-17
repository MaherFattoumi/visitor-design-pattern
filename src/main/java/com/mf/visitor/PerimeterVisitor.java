package com.mf.visitor;

public class PerimeterVisitor implements ShapeVisitor {
    private double totalPerimeter = 0;

    @Override
    public void visit(Circle circle) {
        double perimeter = 2 * Math.PI * circle.getRadius();
        totalPerimeter += perimeter;
    }

    @Override
    public void visit(Square square) {
        double perimeter = 4 * square.getSideLength();
        totalPerimeter += perimeter;
    }

    public double getTotalPerimeter() {
        return totalPerimeter;
    }
}