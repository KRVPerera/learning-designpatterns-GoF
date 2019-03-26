package creational.factory;

interface Shape {
    void draw();
}


class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}


class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}


class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}


class Default implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Default::draw() method.");
    }
}


// TODO: Singleton ?
class ShapeFactory {

    private Shape aDefault;
    /**
     * Ctor will change behaviour of the factory to return different types of default object
     * @param shape shape to be returned as default shape
     */
    public ShapeFactory(Shape shape) {
        aDefault = shape;
    }

    public ShapeFactory() {
        aDefault = new Default();
    }

    Shape getShape(Types shapeType) {
        if (shapeType == Types.CIRCLE) {
            return new Circle();
        } else if (shapeType == Types.RECTANGLE) {
            return new Rectangle();

        } else if ((shapeType == Types.SQUARE)) {
            return new Square();
        } else {
            return aDefault;
        }
    }

    enum Types {
        UNKNOWN, CIRCLE, RECTANGLE, SQUARE
    }
}


class FactoryPatternDemo {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory(new Circle());

        Shape circle = shapeFactory.getShape(ShapeFactory.Types.CIRCLE);
        circle.draw();

        Shape rectangle = shapeFactory.getShape(ShapeFactory.Types.RECTANGLE);
        rectangle.draw();

        Shape square = shapeFactory.getShape(ShapeFactory.Types.SQUARE);
        square.draw();

        Shape unknown = shapeFactory.getShape(ShapeFactory.Types.UNKNOWN);
        unknown.draw();

        ShapeFactory shapeFactoryDefault = new ShapeFactory();
        Shape defaultShape = shapeFactoryDefault.getShape(ShapeFactory.Types.UNKNOWN);
        defaultShape.draw();
    }
}