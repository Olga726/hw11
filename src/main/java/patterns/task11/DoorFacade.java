package patterns.task11;

public class DoorFacade {
    private DoorClose doorClose;
    private DoorOpen doorOpen;
    private DoorLock doorLock;

    public DoorFacade(DoorClose doorClose, DoorOpen doorOpen, DoorLock doorLock) {
        this.doorClose = doorClose;
        this.doorOpen = doorOpen;
        this.doorLock = doorLock;
    }

    public void useDoor() {
        doorOpen.openDoor();
        doorClose.closeDoor();
        doorLock.lockDoor();
    }
}
