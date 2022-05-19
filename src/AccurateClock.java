public class AccurateClock extends Clock{
    private int seconds;

    public AccurateClock(int hours, int minutes, int seconds){
        super(hours, minutes);
        this.seconds = seconds;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof AccurateClock otherClock)) {
            return false;
        }
        return hours == otherClock.hours && minutes == otherClock.minutes && seconds == otherClock.seconds;
    }

    @Override
    public int hashCode() {
        return 3600 * hours + 60 * minutes + seconds;
    }

    @Override
    public String toString(){
        return super.toString() + ":" + Integer.toString(seconds/10) + Integer.toString(seconds%10);
    }
}
