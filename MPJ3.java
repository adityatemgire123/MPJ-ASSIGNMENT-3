public class MPJ3 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("=== SHAPES: Constructor + Method Overloading & Polymorphism (User Input) ===\n");

        // User input for circle
        System.out.print("Enter radius for circle: ");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);

        // User input for rectangle
        System.out.print("Enter length for rectangle: ");
        double length = scanner.nextDouble();
        System.out.print("Enter width for rectangle: ");
        double width = scanner.nextDouble();
        Rectangle rect = new Rectangle(length, width);

        // User input for triangle
        System.out.print("Enter base for triangle: ");
        double base = scanner.nextDouble();
        System.out.print("Enter height for triangle: ");
        double height = scanner.nextDouble();
        Triangle tri = new Triangle(base, height);

        // Method overloading examples in helper
        AreaCalculator calc = new AreaCalculator();
        System.out.println("Circle area (via overloaded method): " + calc.area(radius));
        System.out.println("Rectangle area (via overloaded method): " + calc.area(length, width));
        System.out.println("Triangle area (via overloaded method): " + calc.area(base, height, true));

        // Polymorphism via Shape reference (use user-provided shapes)
        Shape[] shapes = { circle, rect, tri };
        for (Shape s : shapes) {
            System.out.println("Shape: " + s.getClass().getSimpleName() + " | Area = " + s.area());
        }

        // Hillstation section

        System.out.println("\n=== HILLSTATIONS: Method Overriding (Runtime Polymorphism) ===\n");
        Hillstations h;

        h = new Shimla();
        System.out.println("Current hill station: " + h.getName());
        h.famousfood();
        h.famousfor();

        h = new Manali();
        System.out.println("\nCurrent hill station: " + h.getName());
        h.famousfood();
        h.famousfor();

        h = new Darjeeling();
        System.out.println("\nCurrent hill station: " + h.getName());
        h.famousfood();
        h.famousfor();
    }
}

// Shape polymorphism and overloading classes
abstract class Shape {
    public abstract double area();
}

class Circle extends Shape {
    private double radius;

    public Circle() {
        this(1.0); // default radius
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle() {
        this(1.0, 1.0); // default rectangle
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}

class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle() {
        this(1.0, 1.0); // default triangle
    }

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

class AreaCalculator {
    // method overloading for area calculation
    public double area(double radius) {
        return Math.PI * radius * radius;
    }

    public double area(double length, double width) {
        return length * width;
    }

    public double area(double base, double height, boolean isTriangle) {
        if (isTriangle) {
            return 0.5 * base * height;
        }
        return 0.0;
    }
}

// Hillstations superclass and subclasses demonstrating runtime overriding
class Hillstations {
    public String getName() {
        return "Generic Hillstation";
    }

    public void famousfood() {
        System.out.println("Famous Food: Local special");
    }

    public void famousfor() {
        System.out.println("Famous For: Scenic beauty");
    }
}

class Shimla extends Hillstations {
    @Override
    public String getName() {
        return "Shimla";
    }

    @Override
    public void famousfood() {
        System.out.println("Famous Food: Sidu, Channa Madra");
    }

    @Override
    public void famousfor() {
        System.out.println("Famous For: Ridge, Mall Road, Toy Train");
    }
}

class Manali extends Hillstations {
    @Override
    public String getName() {
        return "Manali";
    }

    @Override
    public void famousfood() {
        System.out.println("Famous Food: Trout Fish, Tibetan Bread");
    }

    @Override
    public void famousfor() {
        System.out.println("Famous For: Solang Valley, Rohtang Pass");
    }
}

class Darjeeling extends Hillstations {
    @Override
    public String getName() {
        return "Darjeeling";
    }

    @Override
    public void famousfood() {
        System.out.println("Famous Food: Momos, Thukpa");
    }

    @Override
    public void famousfor() {
        System.out.println("Famous For: Tea Gardens, Toy Train, Kanchenjunga views");
    }
}