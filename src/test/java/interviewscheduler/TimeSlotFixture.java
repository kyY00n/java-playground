package interviewscheduler;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeSlotFixture {

    public static TimeSlot forNow() {
        return new TimeSlot(LocalDateTime.now());
    }

    public static TimeSlot before(TimeSlot compared, int minutes) {
        LocalDateTime startTime = compared.getStartTime();
        return new TimeSlot(startTime.minus(minutes, ChronoUnit.MINUTES));
    }

    public static TimeSlot after(TimeSlot compared, int minutes) {
        LocalDateTime startTime = compared.getStartTime();
        return new TimeSlot(startTime.plus(minutes, ChronoUnit.MINUTES));
    }

}
