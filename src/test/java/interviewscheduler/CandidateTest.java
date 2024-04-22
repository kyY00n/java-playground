package interviewscheduler;

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
        final var applicant = new Candidate(email, inputSlots, true);

        //then
        assertThat(applicant).isInstanceOf(Candidate.class);
    }

}