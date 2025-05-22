import java.awt.*;
import java.util.*;
import java.util.List;

public class MainApp
{
    private static Scanner keyboard = new Scanner(System.in);
    private static World world;
    private static Turtle turtle;
    private static final List<Shape> shapes = new ArrayList<>();

    public static void main(String[] args)
    {
        // Prompt user for canvas size
        System.out.println("Welcome to Turtle Graphics!");
        int width = promptForInt("Enter canvas width: ");
        int height = promptForInt("Enter canvas height: ");
        // The world is your canvas
        world = new World(width, height);
        turtle = new Turtle(world);

        while (true) {
            showMenu();
            int choice = promptForInt("Choose and option: ");

            switch (choice) {
                case 1 -> addShape();
                case 2 -> {
                    System.out.println("Enter filename to save (include .png or .jpg)");
                    String filename = keyboard.nextLine();
                    world.saveAs(filename);
                    System.out.println("Image saved!");
                }
                case 0 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice was made, try again!");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nHome Screen:");
        System.out.println("--------------------");
        System.out.println("1) Add Shape");
        System.out.println("2) Save Image");
        System.out.println("0) Exit");
    }

    private static void addShape() {
        int shapeChoice = promptForShape();
        int borderWidth = promptForInt("Enter border width: ");
        Color color = promptForColor();
        int x = promptForInt("Enter x location: ");
        int y = promptForInt("Enter y location: ");

        Shape shape = null;

        switch (shapeChoice) {
            case 1 -> {
                int side = promptForInt("Enter side length: ");
                shape = new Square(turtle, new Point(x, y), color, borderWidth, side);
            }
            case 2 -> {
                int radius = promptForInt("Enter radius: ");
                shape = new Circle(turtle, new Point(x, y), color, borderWidth, radius);
            }
            case 3 -> {
            int side = promptForInt("Enter side length: ");
            shape = new Triangle(turtle, new Point(x, y), color, borderWidth, side);
            }
            default -> System.out.println("Invalid shape type choice, try again!");
        }

        if (shape != null) {
            shape.paint();
            shapes.add(shape);
            System.out.println("Image painted!");
        }
    }

    private static int promptForShape() {
        while (true) {
            try {
                System.out.println("Which shape? (1. Square, 2. Circle, 3. Triangle: ");
                int input = Integer.parseInt(keyboard.nextLine());
                if (input >= 1 && input <= 3) return input;
                else System.out.println("Please enter 1, 2, or 3: ");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
            }
        }
    }

    private static int promptForInt(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                return Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
                keyboard.next();
            }
        }
    }

    private static Color promptForColor() {
        Map<String, Color> colors = Map.of(
                "red", Color.RED,
                "blue", Color.BLUE,
                "green", Color.GREEN);

        while (true) {
            System.out.println("Enter border color (red, green, blue): ");
            String colorName = keyboard.nextLine().trim().toLowerCase();
            if (colors.containsKey(colorName)) {
                return colors.get(colorName);
            } else {
                System.out.println("Invalid color. Please try again.");
            }
    }
    }
}
