package interviewscheduler;

import java.util.List;

public class Recruitment {

    private final List<Candidate> candidates;
    private final List<TimeSlot> interviewAvailable;

    public Recruitment(final List<Candidate> candidates, final List<TimeSlot> interviewAvailable) {
        this.candidates = candidates;
        this.interviewAvailable = interviewAvailable;
    }
    public Schedule schedule() {
        Scheduler scheduler = new Scheduler();
        return scheduler.execute(interviewAvailable, candidates);
    }

}
