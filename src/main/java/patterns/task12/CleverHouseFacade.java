package patterns.task12;

public class CleverHouseFacade {
    private Light light;
    private Conditioner conditioner;
    private Alarm alarm;

    public CleverHouseFacade(Light light, Conditioner conditioner, Alarm alarm) {
        this.light = light;
        this.conditioner = conditioner;
        this.alarm = alarm;
    }

    public void enterHouse() {
        alarm.alarmOff();
        light.lightOn();
        conditioner.conditionerOn();
    }

    public void leaveHouse() {
        light.lightOff();
        conditioner.conditionerOff();
        alarm.alarmOff();
    }
}
