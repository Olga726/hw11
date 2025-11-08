package patterns.task12;

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Conditioner conditioner = new Conditioner();
        Alarm alarm = new Alarm();
        CleverHouseFacade facade = new CleverHouseFacade(light, conditioner, alarm);
        facade.enterHouse();
        facade.leaveHouse();

    }
}
