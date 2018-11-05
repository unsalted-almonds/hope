package com.pecan.hope.followup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Airplanes {
    /*
 * @param airplanes: An interval array
 * @return: Count of airplanes are in the sky.
 */
    public int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        int result = 0;

        if (airplanes == null || airplanes.isEmpty())
            return result;

        List<Integer> startTimes = new ArrayList<Integer>(airplanes.size());
        List<Integer> endTimes = new ArrayList<Integer>(airplanes.size());

        for (Interval interval : airplanes) {
            startTimes.add(interval.start);
            endTimes.add(interval.end);
        }

        Collections.sort(startTimes);
        Collections.sort(endTimes);

        int startIdx = 0;
        int endIdx = 0;
        int max = 0;
        while (startIdx < startTimes.size() && endIdx < startTimes.size()) {
            if (startTimes.get(startIdx) < endTimes.get(endIdx)) {
                result++;
                startIdx++;
            } else if (startTimes.get(startIdx) > endTimes.get(endIdx)) {
                result--;
                endIdx++;
            } else {
                startIdx++;
                endIdx++;
            }
            max = Math.max(max, result);
        }

        while (startIdx < startTimes.size()) {
            result++;
            startIdx++;
        }

        while (endIdx < endTimes.size()) {
            result--;
            endIdx++;
        }

        return Math.max(max, result);

    }


}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}



