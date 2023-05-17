package com.mf.visitor.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;

import com.mf.visitor.AreaVisitor;
import com.mf.visitor.Circle;
import com.mf.visitor.PerimeterVisitor;
import com.mf.visitor.Shape;
import com.mf.visitor.ShapeVisitor;
import com.mf.visitor.Square;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "visitor-design-pattern-shape.feature")
public class VisitorDesignPatternShapeSteps {
	private List<Shape> shapeCollection;
	private ShapeVisitor areaVisitor;
	private ShapeVisitor perimeterVisitor;

	@Given("^a shape collection with a circle of radius (\\d+) and a square with side length (\\d+)$")
	public void aShapeCollectionWithACircleAndASquare(double circleRadius, double squareSideLength) {
		shapeCollection = new ArrayList<>();
		
		shapeCollection.add(new Circle(circleRadius));
		shapeCollection.add(new Square(squareSideLength));
		
		areaVisitor = new AreaVisitor();
		perimeterVisitor = new PerimeterVisitor();
	}

	@When("^I calculate the total area and perimeter$")
	public void iCalculateTheTotalAreaAndPerimeter() {
		for (Shape shape : shapeCollection) {
			shape.accept(areaVisitor);
			shape.accept(perimeterVisitor);
		}
	}

	@Then("^the total area should be (\\d+.\\d+) and the total perimeter should be (\\d+)$")
	public void theTotalAreaAndPerimeterShouldBe(double expectedArea, double expectedPerimeter) {
		assertEquals(expectedArea, ((AreaVisitor)areaVisitor).getTotalArea(), 0.01);
		assertEquals(expectedPerimeter,((PerimeterVisitor)perimeterVisitor).getTotalPerimeter(), 0.01);
	}
}
