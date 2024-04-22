package interviewscheduler;

import java.time.LocalDateTime;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RecruitmentTest {

    @Test
    void 모집을_생성할_수_있다() {
        //given
        List<Applicant> applicants = List.of(
                new Applicant("mock@google.com", List.of(new TimeSlot(LocalDateTime.now())), true));

        //when
        final var recruitment = new Recruitment(applicants, 30, List.of(new TimeSlot(LocalDateTime.now())));

        //then
        assertThat(recruitment).isInstanceOf(Recruitment.class);
    }

}
