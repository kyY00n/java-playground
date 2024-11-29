package interviewscheduler.candidate;

import interviewscheduler.Candidate;
import interviewscheduler.TimeSlot;
import interviewscheduler.TimeSlotFixture;
import java.util.List;

public class CandidateFixture {
    public static Candidate createCandidate() {
        TimeSlot now = TimeSlotFixture.forNow(30);
        String email = "dev.kayoung@gmail.com";
        List<TimeSlot> inputSlots = List.of(now, TimeSlotFixture.after(now, 30));

        return new Candidate(email, inputSlots, true);
    }

    public static Candidate createCandidateWithAvailableTime(List<TimeSlot> availableTime) {
        String email = "dev.hong@google.com";
        return new Candidate(email, availableTime, true);
    }
}
