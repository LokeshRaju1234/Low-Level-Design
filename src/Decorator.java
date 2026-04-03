//each coffee has its cost so it will be common to all the items
interface Coffee
{
    int cost();
}

class simpleCoffee implements Coffee
{
    @Override
    public int cost()
    {
        return 100;
    }
}

//which acts a base
abstract class CoffeeDecorator implements Coffee
{
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee)
    {
        this.coffee = coffee;
    }
}

class MilkDecorator extends CoffeeDecorator
{

    public MilkDecorator(Coffee coffee)
    {
        super(coffee);
    }

    public int cost()
    {
        return coffee.cost() + 20;
    }
}

class SugarDecorator extends CoffeeDecorator
{

    public SugarDecorator(Coffee coffee)
    {
        //object is instantiated in the parent class
        super(coffee);
    }

    public int cost()
    {
        //that particular object method will be called and it taking the value
        //that is instantiated from
        return coffee.cost() + 10;
    }
}

public class Decorator
{
    public static void main(String[] args)
    {
        //wraps the objects and each object will calls its own cost method
        Coffee coffee = new MilkDecorator(new SugarDecorator(new simpleCoffee()));
        System.out.println(coffee.cost());
    }
}
