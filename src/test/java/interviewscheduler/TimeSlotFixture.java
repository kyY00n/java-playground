package interviewscheduler;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TimeSlotFixture {

    public static TimeSlot forNow(int duration) {
        return new TimeSlot(LocalDateTime.now(), duration);
    }

    public static TimeSlot before(TimeSlot compared, int minutes) {
        LocalDateTime startTime = compared.getStartTime();
        return new TimeSlot(startTime.minus(minutes, ChronoUnit.MINUTES), compared.getDuration());
    }

    public static TimeSlot after(TimeSlot compared, int minutes) {
        LocalDateTime startTime = compared.getStartTime();
        return new TimeSlot(startTime.plus(minutes, ChronoUnit.MINUTES), compared.getDuration());
    }

}
