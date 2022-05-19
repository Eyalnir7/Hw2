public class Clock {
    protected int hours;
    protected int minutes;

    public Clock(int hours, int minutes){
        this.hours = hours;
        this.minutes = minutes;
    }
    @Override
    public boolean equals(Object other) {
        if(!(other instanceof Clock otherClock))
            return false;
        return other.toString().equals(this.toString());
    }

    @Override
    public int hashCode(){
        return 60 * hours + minutes;
    }

    @Override
    public String toString(){
        return Integer.toString(hours / 10) + Integer.toString(hours % 10) + ":"
                + Integer.toString(minutes / 10) + Integer.toString(minutes % 10);
    }
}
