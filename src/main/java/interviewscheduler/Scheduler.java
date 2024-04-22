package interviewscheduler;

import java.util.Arrays;
import java.util.List;

public class Scheduler {

    private int sizeOfSlot;
    private int sizeOfCandidates;
    private int[][] candidateToAvailableSlot;
    private int[] candidatesTo;
    private int[] timeslotsTo;
    private boolean[] visited;

    public Schedule execute(List<TimeSlot> entireSlots, List<Candidate> candidates) {
        // 일단 인덱스로 바꿔봐
        sizeOfSlot = entireSlots.size();
        sizeOfCandidates = candidates.size();

        candidateToAvailableSlot = new int[sizeOfCandidates][sizeOfSlot];
        candidatesTo = new int[sizeOfCandidates];
        timeslotsTo = new int[sizeOfSlot];
        Arrays.fill(candidatesTo, -1);
        Arrays.fill(timeslotsTo, -1);


        for(int candidateNo = 0; candidateNo < sizeOfCandidates; candidateNo++) {
            Candidate candidate = candidates.get(candidateNo);
            List<TimeSlot> available = candidate.getAvailable();
            for(int timeslotNo = 0; timeslotNo < sizeOfSlot; timeslotNo++) {
                if (available.contains(entireSlots.get(timeslotNo))) {
                    this.candidateToAvailableSlot[candidateNo][timeslotNo] = 1;
                }
            }
        }

        for (int candidateNo = 0; candidateNo < sizeOfCandidates; candidateNo++) {
            visited = new boolean[sizeOfCandidates];
            dfs(candidateNo);
        }

        Schedule schedule = new Schedule();
        for(int candidateNo = 0; candidateNo < sizeOfCandidates; candidateNo++) {
            if (candidatesTo[candidateNo] == -1) {
                schedule.addMismatched(candidates.get(candidateNo));
            }
        }
        for(int timeslotNo = 0; timeslotNo < sizeOfSlot; timeslotNo++) {
            TimeSlot timeSlot = entireSlots.get(timeslotNo);
            int index = timeslotsTo[timeslotNo];
            if (index != -1) {
                Candidate candidate = candidates.get(index);
                schedule.addSchedule(timeSlot, candidate);
            }

        }
        return schedule;
    }

    private boolean dfs(int candidateNo) {
        if (visited[candidateNo]) {
            return false;
        }
        visited[candidateNo] = true;
        for(int slotNo = 0; slotNo < sizeOfSlot; slotNo++) {
            if (candidateToAvailableSlot[candidateNo][slotNo] == 1) {
                if (timeslotsTo[slotNo] == -1 || dfs(timeslotsTo[slotNo])) {
                    candidatesTo[candidateNo] = slotNo;
                    timeslotsTo[slotNo] = candidateNo;
                    return true;
                }
            }
        }
        return false;
    }


}
