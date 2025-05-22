import java.awt.*;

public class Circle extends Shape{
    private int radius;

    public Circle(Turtle turtle, Point location, Color color, int border, int radius) {
        super(turtle, location, color, border);
        this.radius = radius;
    }

    @Override
    public void paint() {
        turtle.penUp();
        turtle.goTo(location.x + radius, location.y); // start at rightmost point
        turtle.setColor(color);
        turtle.setPenWidth(border);
        turtle.setHeading(90);
        turtle.penDown();

        int steps = 120;
        double stepLength = 2 * Math.PI * radius / steps;
        double turnAngle = 360.0 / steps;

        for (int i = 0; i < steps; i++) {
            turtle.forward(stepLength);
            turtle.turnRight(turnAngle);
        }

        turtle.penUp();
    }
}
