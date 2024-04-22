package interviewscheduler;

import java.time.LocalDateTime;

public class TimeSlot implements Comparable {
    private final LocalDateTime startTime;
    private final boolean selected;

    public static TimeSlot of(int year, int month, int day, int hour, int minute) {
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute);
        return new TimeSlot(dateTime);
    }

    public TimeSlot(final LocalDateTime startTime) {
        this.startTime = startTime;
        this.selected = false;
    }

    public TimeSlot(final LocalDateTime startTime, final boolean selected) {
        this.startTime = startTime;
        this.selected = selected;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public int compareTo(final Object o) {
        return startTime.compareTo(((TimeSlot) o).startTime);
    }

}
