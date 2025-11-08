package patterns.task11;

public class Main {
    public static void main(String[] args) {
        DoorLock lock = new DoorLock();
        DoorOpen open = new DoorOpen();
        DoorClose close = new DoorClose();
        DoorFacade facade = new DoorFacade(close, open, lock);
        facade.useDoor();
    }
}
