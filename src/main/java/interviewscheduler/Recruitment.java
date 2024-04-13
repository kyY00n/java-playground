package interviewscheduler;

import java.util.List;

public class Recruitment {

    private final List<Applicant> applicants;
    private final int interval;
    private final List<TimeSlot> interviewAvailable;

    public Recruitment(final List<Applicant> applicants, final int interval, final List<TimeSlot> interviewAvailable) {
        this.applicants = applicants;
        this.interval = interval;
        this.interviewAvailable = interviewAvailable;
    }

}
