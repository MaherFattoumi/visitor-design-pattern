package com.mf.visitor.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.mf.visitor.AreaVisitor;
import com.mf.visitor.Circle;
import com.mf.visitor.PerimeterVisitor;
import com.mf.visitor.ShapeVisitor;
import com.mf.visitor.Square;

class VisitorDesignPatternShapeTest {

    @Test
    void testCircleAccept() {
        ShapeVisitor areaVisitor = new AreaVisitor();
        ShapeVisitor perimeterVisitor = new PerimeterVisitor();
        Circle circle = new Circle(5);

        circle.accept(areaVisitor);
        circle.accept(perimeterVisitor);

        Assert.assertEquals(78.54, ((AreaVisitor) areaVisitor).getTotalArea(), 0.01);
        Assert.assertEquals(31.42, ((PerimeterVisitor) perimeterVisitor).getTotalPerimeter(), 0.01);
    }

    @Test
    void testSquareAccept() {
        ShapeVisitor areaVisitor = new AreaVisitor();
        ShapeVisitor perimeterVisitor = new PerimeterVisitor();
        Square square = new Square(10);

        square.accept(areaVisitor);
        square.accept(perimeterVisitor);

        Assert.assertEquals(100.0, ((AreaVisitor) areaVisitor).getTotalArea(), 0.01);
        Assert.assertEquals(40.0, ((PerimeterVisitor) perimeterVisitor).getTotalPerimeter(), 0.01);
    }
}

