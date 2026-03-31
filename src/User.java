//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class User
{
    private String name;
    private int age;
    private String address;
    private String phone;

    private User()
    {

    }

    public static class Builder
    {
        private User  obj = new User();

        public Builder(String name)
        {
            obj.name = name;
        }

        public Builder age(int age)
        {
            obj.age = age;
            return this;
        }

        public Builder address(String address)
        {
            obj.address = address;
            return this;
        }

        public Builder phone(String phone)
        {
            obj.phone = phone;
            return this;//we sare building for the same user right
            // so we return the same object which enables chaining to build object step by step
        }

        public User build()
        {
            return obj;
        }
    }
    // MAIN METHOD (Entry point)
    public static void main(String[] args) {

        User user = new User.Builder("Lokesh")
                .age(23)
                .address("Hyderabad")
                .phone("9999999999")
                .build();

        user.display();
    }

    private void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phone);
    }

}




