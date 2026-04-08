interface item
{
    int accept(Visitor visitor);
}

class Books implements item
{
    int price;
    String name;

    public Books(int price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}


class Fruit implements item
{
    int price;
    String name;

    public Fruit(int price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public int accept(Visitor visitor) {
        return visitor.visit(this);
    }
}


interface Visitor
{
    int visit(Books book);
    int visit(Fruit fruit);
}

class PriceVisitor implements Visitor
{
    @Override
    public int visit(Books book) {
        System.out.println("Book: " + book.name + " Price = " + book.price);
        return book.price;
    }

    @Override
    public int visit(Fruit fruit) {
        System.out.println("Book: " + fruit.name + " Price = " + fruit.price);
        return fruit.price;
    }
}

public class VisitorPattern
{
    public static void main(String [] args)
    {
        item [] items =
        {
                new Books(100,"Java"),
                new Fruit(50,"Apple"),
                new Books( 200,"DSA"),
                new Fruit(80,"Mango")
        };

        Visitor visitor = new PriceVisitor();

        int total = 0;
        for(int i = 0;i < items.length;i++)
        {
            total += items[i].accept(visitor);
        }

        System.out.println("Total items amount is: " + total);
    }
}