package framework;

import framework.Clock;
import framework.EventList;
import model.ServicePoint;

public abstract class Engine {

    private static final String RED = "\033[0;31m"; // https://gist.github.com/fnky/458719343aabd01cfb17a3a4f7296797
    private static final String WHITE = "\033[0;37m"; // ANSI escape code for white color
    public abstract ServicePoint[] getServicePoint();
    private double simulationTime = 0;
    protected EventList eventList;

    public Engine() {
        eventList = new EventList();
        // Service Points are created in the subclass
    }

    public void setSimulationTime(double simulationTime) {
        this.simulationTime = simulationTime;
    }

    public void run() {
        initialize();
        while (simulate()) {

            System.out.printf("\n%sA-phase:%s time is %.2f\n", RED, WHITE, currentTime());
            Clock.getInstance().setClock(currentTime());

            System.out.printf("%sB-phase:%s ", RED, WHITE);
            runBEvents();

            System.out.printf("\n%sC-phase:%s", RED, WHITE);
            tryCEvents();
        }

        results();
    }

    protected boolean simulate() {
        return Clock.getInstance().getClock() < simulationTime;
    }

    protected double currentTime() {
        return eventList.getNextEventTime();
    }

    protected void runBEvents() {
        while (eventList.getNextEventTime() == Clock.getInstance().getClock()) {
            runEvent(eventList.removeFromEventList());
        }
    }

    protected abstract void initialize();
    protected abstract void runEvent(Event e);
    protected abstract void tryCEvents();
    protected abstract void results();
}