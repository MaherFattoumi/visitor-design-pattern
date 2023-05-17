Feature: Shape Processing Application

  Scenario: Calculate the total area and perimeter of shapes
    Given a shape collection with a circle of radius 5 and a square with side length 10
    When I calculate the total area and perimeter
    Then the total area should be 78.54 and the total perimeter should be 50
