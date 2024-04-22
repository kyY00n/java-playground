package interviewscheduler;

import java.util.List;

public class Candidate {

    private final String email;
    private final List<TimeSlot> available;
    private final boolean isAccepted;

    public Candidate(final String email, final List<TimeSlot> available, final boolean isAccepted) {
        this.email = email;
        this.available = available;
        this.isAccepted = isAccepted;
    }

    public Candidate(final String email, final List<TimeSlot> available) {
        this.email = email;
        this.available = available;
        this.isAccepted = false;
    }

    public String getEmail() {
        return email;
    }

    public List<TimeSlot> getAvailable() {
        return available;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "email='" + email + '\'' +
                '}';
    }

}
