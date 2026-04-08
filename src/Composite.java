interface smartdevice
{
    void turnOn();
}
class Light implements smartdevice
{
    String name;

    public Light(String name) {
        this.name = name;
    }

    @Override
    public void turnOn() {
        System.out.println(name + " Light ON");
    }
}

class AC implements smartdevice
{
    String name;

    public AC(String name) {
        this.name = name;
    }

    @Override
    public void turnOn() {
        System.out.println(name + " AC ON");
    }
}
class TV implements smartdevice
{
    String name;

    public TV(String name) {
        this.name = name;
    }

    @Override
    public void turnOn() {
        System.out.println(name + " TV ON");
    }
}

class Room implements  smartdevice
{
    smartdevice devices[] = new smartdevice[10];
    int count  = 0;

    public void addDevice(smartdevice device)
    {
        devices[count] = device;
        count++;
    }

    @Override
    public void turnOn() {
        for(int i = 0;i < count;i++)
        {
            devices[i].turnOn();
        }
    }
}
public class Composite {
    public static void main(String[] args)
    {
        // individual devices
        Light livingLight = new Light("Living Room");
        TV livingTV = new TV("Living Room");

        Light bedroomLight = new Light("Bedroom");
        AC bedroomAC = new AC("Bedroom");

        // group devices into rooms
        Room livingRoom = new Room();
        livingRoom.addDevice(livingLight);
        livingRoom.addDevice(livingTV);

        Room bedRoom = new Room();
        bedRoom.addDevice(bedroomLight);
        bedRoom.addDevice(bedroomAC);

        // whole home
        Room home = new Room();
        home.addDevice(livingRoom);
        home.addDevice(bedRoom);

        // single call controls everything
        home.turnOn();
    }
}
