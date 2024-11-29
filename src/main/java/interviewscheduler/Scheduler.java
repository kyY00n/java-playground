package interviewscheduler;

import java.util.Arrays;
import java.util.List;

public class Scheduler {

    private final List<TimeSlot> timeSlots;
    private final List<Candidate> candidates;
    private int[][] candidateToAvailableTimeslot;
    private int[] candidatesTo;
    private int[] timeslotsTo;
    private boolean[] visited;

    public Scheduler(final List<TimeSlot> timeSlots, final List<Candidate> candidates) {
        this.timeSlots = timeSlots;
        this.candidates = candidates;
    }

    public Schedule execute() {
        initialize();

        for (int candidateNo = 0; candidateNo < candidates.size(); candidateNo++) {
            visited = new boolean[candidates.size()];
            canChangeSlot(candidateNo);
        }

        return toSchedule(timeSlots, candidates);
    }

    private void initialize() {
        this.candidateToAvailableTimeslot = new int[candidates.size()][timeSlots.size()];
        this.candidatesTo = new int[candidates.size()];
        this.timeslotsTo = new int[timeSlots.size()];
        Arrays.fill(candidatesTo, -1);
        Arrays.fill(timeslotsTo, -1);

        for(int candidateNo = 0; candidateNo < candidates.size(); candidateNo++) {
            Candidate candidate = candidates.get(candidateNo);
            for(int timeslotNo = 0; timeslotNo < timeSlots.size(); timeslotNo++) {
                if (candidate.canInterviewAt(timeSlots.get(timeslotNo))) {
                    this.candidateToAvailableTimeslot[candidateNo][timeslotNo] = 1;
                }
            }
        }
    }

    private Schedule toSchedule(final List<TimeSlot> entireSlots, final List<Candidate> candidates) {
        Schedule schedule = new Schedule();
        for(int candidateNo = 0; candidateNo < candidates.size(); candidateNo++) {
            if (isNotMatched(candidateNo)) {
                schedule.addMismatched(candidates.get(candidateNo));
            }
        }
        for(int timeslotNo = 0; timeslotNo < timeSlots.size(); timeslotNo++) {
            TimeSlot timeSlot = entireSlots.get(timeslotNo);
            if (isMatched(timeslotNo)) {
                Candidate candidate = candidates.get(timeslotsTo[timeslotNo]);
                schedule.addSchedule(timeSlot, candidate);
            }

        }
        return schedule;
    }

    private boolean isMatched(final int timeslotNo) {
        return timeslotsTo[timeslotNo] != -1;
    }

    private boolean isNotMatched(final int candidateNo) {
        return candidatesTo[candidateNo] == -1;
    }

    private boolean canChangeSlot(int candidateNo) {
        if (visited[candidateNo]) {
            return false;
        }
        visited[candidateNo] = true;
        for(int slotNo = 0; slotNo < timeSlots.size(); slotNo++) {
            if (candidateToAvailableTimeslot[candidateNo][slotNo] == 1) {
                if (timeslotsTo[slotNo] == -1 || canChangeSlot(timeslotsTo[slotNo])) {
                    candidatesTo[candidateNo] = slotNo;
                    timeslotsTo[slotNo] = candidateNo;
                    return true;
                }
            }
        }
        return false;
    }


}
