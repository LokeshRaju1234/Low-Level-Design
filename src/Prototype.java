interface Proto
{
    Proto clone();
    void show();
}

class Book implements Proto
{
    private String id;
    private String title;

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public Book clone()
    {
        return new Book(id,title);
    }

    public void show()
    {
        System.out.println("Book with id " + id + " Title " + title);
    }
}
public class Prototype {

    public static void main(String[] args)
    {
        Book b1 = new Book("2","Alexu");

        //cloning object
        //instead of recreating the object again and again create
        Book b2 =  b1.clone();
        b1.show();
        b2.show();
    }
}
