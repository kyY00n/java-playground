package interviewscheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Schedule {

    private final Map<TimeSlot, Candidate> matched;
    private final List<Candidate> mismatched;

    public Schedule() {
        matched = new HashMap<>();
        mismatched = new ArrayList<>();
    }

    public Schedule(final Map<TimeSlot, Candidate> matched, final List<Candidate> mismatched) {
        this.matched = matched;
        this.mismatched = mismatched;
    }

    public void addSchedule(TimeSlot timeSlot, Candidate candidate) {
        if (matched.containsKey(timeSlot)) {
            return; // exception?
        }
        if (matched.containsValue(candidate)) {
            return; // exception?
        }
        matched.put(timeSlot, candidate);
    }

    public void addMismatched(Candidate candidate) {
        mismatched.add(candidate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<TimeSlot, Candidate> entry : matched.entrySet()) {
            TimeSlot timeslot = entry.getKey();
            Candidate candidate = entry.getValue();
            sb.append(timeslot + " : " + candidate + "\n");
        }
        return sb.toString() + "mismatched : " + mismatched;
    }

}
