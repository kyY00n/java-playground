package interviewscheduler;

import java.time.LocalDateTime;
import java.util.List;

public class RecruitmentFixture {

    public static Recruitment createRecruitment() {
        //given
        TimeSlot first = TimeSlot.of(2024, 3, 3, 10, 0, 30);
        TimeSlot second = TimeSlot.of(2024, 3, 3, 10, 30, 30);
        List<Candidate> candidates = List.of(
                new Candidate("mock@google.com", List.of(first, second)),
                new Candidate("hi@google.com", List.of(first))
        );

        //when
        return new Recruitment(candidates, List.of(first, second));
    }

}
