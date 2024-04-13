package interviewscheduler;

import java.time.LocalDateTime;

public class TimeSlot implements Comparable {
    private final LocalDateTime startTime;
    private final boolean selected;

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
