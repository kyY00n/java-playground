package interviewscheduler;

import java.time.LocalDateTime;
import java.util.Objects;

public class TimeSlot implements Comparable {
    private final LocalDateTime startTime;
    private final int duration;
    private final boolean selected;

    public static TimeSlot of(int year, int month, int day, int hour, int minute, int duration) {
        LocalDateTime dateTime = LocalDateTime.of(year, month, day, hour, minute);
        return new TimeSlot(dateTime, duration);
    }

    public TimeSlot(final LocalDateTime startTime, final int duration) {
        this.startTime = startTime;
        this.duration = duration;
        this.selected = false;
    }

    public TimeSlot(final LocalDateTime startTime, final int duration, final boolean selected) {
        this.startTime = startTime;
        this.duration = duration;
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public int compareTo(final Object o) {
        return startTime.compareTo(((TimeSlot) o).startTime);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final TimeSlot timeSlot = (TimeSlot) o;
        return duration == timeSlot.duration && Objects.equals(startTime, timeSlot.startTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, duration);
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "TimeSlot{" +
                "startTime=" + startTime +
                ", duration=" + duration +
                '}';
    }

}
