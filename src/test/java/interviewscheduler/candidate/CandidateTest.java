package interviewscheduler.candidate;

import interviewscheduler.Candidate;
import interviewscheduler.TimeSlot;
import interviewscheduler.TimeSlotFixture;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CandidateTest {

    @Test
    void 인터뷰_가능_시간을_입력받으면_지원자_정보를_생성할_수_있다() {
        //given
        TimeSlot now = TimeSlotFixture.forNow(30);
        String email = "dev.kayoung@gmail.com";
        List<TimeSlot> inputSlots = List.of(now, TimeSlotFixture.after(now, 30));

        //when
        final var candidate = new Candidate(email, inputSlots, true);

        //then
        assertThat(candidate).isInstanceOf(Candidate.class);
    }

    @Test
    void 인터뷰_가능_시간을_확인할_수_있다() {
        //given
        TimeSlot availableTime = TimeSlotFixture.forNow(30);
        Candidate candidate = CandidateFixture.createCandidateWithAvailableTime(
                List.of(availableTime)
        );

        //when
        boolean actual = candidate.canInterviewAt(availableTime);

        //then
        assertThat(actual).isTrue();
    }

}
