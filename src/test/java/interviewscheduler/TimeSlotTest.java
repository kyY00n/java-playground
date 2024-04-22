package interviewscheduler;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TimeSlotTest {

    @Test
    void 시작시간이_빠르면_더_우선이다() {
        //given
        TimeSlot now = new TimeSlot(LocalDateTime.now(), 30);
        TimeSlot after30minutes = new TimeSlot(LocalDateTime.now().plus(30, ChronoUnit.MINUTES), 30);

        //when
        int actual = now.compareTo(after30minutes);

        //then
        assertThat(actual).isNegative();
    }

    @Test
    void 시작시간이_느리면_우선이_아니다() {
        //given
        TimeSlot now = new TimeSlot(LocalDateTime.now(), 30);
        TimeSlot before30Minutes = new TimeSlot(LocalDateTime.now().minus(30, ChronoUnit.MINUTES), 30);

        //when
        int actual = now.compareTo(before30Minutes);

        //then
        assertThat(actual).isPositive();
    }

    @Test
    void 시작시간이_같으면_비교시_동등하다() {
        //given
        LocalDateTime sameTime = LocalDateTime.now();
        TimeSlot now = new TimeSlot(sameTime, 30);
        TimeSlot other = new TimeSlot(sameTime, 30);

        //when
        int actual = now.compareTo(other);

        //then
        assertThat(actual).isZero();
    }

}
