import java.awt.*;

public class Triangle extends Shape{
    private int side;

    public Triangle(Turtle turtle, Point location, Color color, int border, int side) {
        super(turtle, location, color, border);
        this.side = side;
    }

    @Override
    public void paint() {
        turtle.penUp();
        turtle.goTo(location.x, location.y);
        turtle.setColor(color);
        turtle.setPenWidth(border);
        turtle.setHeading(0);
        turtle.penDown();

        for (int i = 0; i < 3; i++) {
            turtle.forward(side);
            turtle.turnRight(120);
        }

        turtle.penUp();
    }
}
