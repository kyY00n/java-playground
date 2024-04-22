package interviewscheduler;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RecruitmentTest {

    @Test
    void 모집을_생성할_수_있다() {
        //given
        List<Candidate> candidates = List.of(
                new Candidate("mock@google.com", List.of(new TimeSlot(LocalDateTime.now(), 30)), true));

        //when
        final var recruitment = new Recruitment(candidates, List.of(new TimeSlot(LocalDateTime.now(), 30)));

        //then
        assertThat(recruitment).isInstanceOf(Recruitment.class);
    }

    @Test
    void 스케줄을_짤_수_있다() {
        //given
        TimeSlot first = TimeSlot.of(2024, 3, 3, 10, 0, 30);
        TimeSlot second = TimeSlot.of(2024, 3, 3, 10, 30, 30);
        TimeSlot third = TimeSlot.of(2024, 3, 3, 11, 0, 30);
        List<Candidate> candidates = List.of(
                new Candidate("mock@google.com", List.of(first, second)),
                new Candidate("hi@google.com", List.of(first)),
                new Candidate("bye@google.com" , List.of(third))
        );

        Recruitment recruitment = new Recruitment(candidates, List.of(first, second, third));

        //when
        Schedule schedule = recruitment.schedule();

        //then
        System.out.println(schedule.toString());
    }

    @Test
    void 최선의_스케줄을_수_있다() {
        //given
        TimeSlot first = TimeSlot.of(2024, 3, 3, 10, 0, 30);
        TimeSlot second = TimeSlot.of(2024, 3, 3, 10, 30, 30);
        TimeSlot third = TimeSlot.of(2024, 3, 3, 11, 0, 30);
        List<Candidate> candidates = List.of(
                new Candidate("mock@google.com", List.of(first, second)),
                new Candidate("hi@google.com", List.of(first)),
                new Candidate("bye@google.com" , List.of(first))
        );

        Recruitment recruitment = new Recruitment(candidates, List.of(first, second, third));

        //when
        Schedule schedule = recruitment.schedule();

        //then
        System.out.println(schedule.toString());
    }

}
