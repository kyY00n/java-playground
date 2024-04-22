package interviewscheduler;

import java.util.List;

public class Applicant {

    private final String email;
    private final List<TimeSlot> selected;
    private final boolean isAccepted;

    public Applicant(final String email, final List<TimeSlot> able, final boolean isAccepted) {
        this.email = email;
        this.selected = able;
        this.isAccepted = isAccepted;
    }

    public Applicant(final String email, final List<TimeSlot> selected) {
        this.email = email;
        this.selected = selected;
        this.isAccepted = false;
    }

    public String getEmail() {
        return email;
    }

    public List<TimeSlot> getSelected() {
        return selected;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

}
