interface Shape
{
    void draw();
}

class Circle implements Shape{
    public void draw()
    {
        System.out.println("I am circle");
    }
}

class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("I am Square");
    }
}

class Rectangle implements Shape
{
    @Override
    public void draw() {
        System.out.println("I am Rectangle");
    }
}

class ShapeFactory
{
    public Shape getShape(String type)
    {
        if(type.equals("square"))
        {
            return new Square();
        }
        else if(type.equals("circle"))
        {
            return new Circle();
        }
        else if(type.equals("rectangle"))
        {
            return new Rectangle();
        }

        return null;
    }
}

class Main
{
    public static  void main(String [] args)
    {
        ShapeFactory factory = new ShapeFactory();//need object
        //we are asking factory to create the object of the mentioned shape
        Shape obj = factory.getShape("rectangle");
        //So internally: --> shape1 → Circle object  --->This is called polymorphism.
        obj.draw();//that particular object will be called
        Shape obj1 = factory.getShape("circle");
        obj1.draw();

        //let the client decide which class to be instantiated

    }
}
