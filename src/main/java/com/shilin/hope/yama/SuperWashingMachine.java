package com.shilin.hope.yama;

/**
 * Created by Shilin_Gan on 12/6/2017.
 */
public class SuperWashingMachine {

    /*
     0 0 0 0 0 999 0 0 0 0 0 1
    */
    public int findMinMoves(int[] machines) {
        int res = -1;
        if (machines == null || machines.length == 0) {
            return res;
        }

        int sum = 0;
        for (int n : machines) sum += n;

        if (sum % machines.length != 0) return res;

        int target = sum / machines.length;

        boolean keepMoving = false;

        do {
            int trailingSum = 0;
            for (int i = 0; i < machines.length; i++) {
                if (machines[i] <= target) {
                    trailingSum += machines[i];
                    continue;
                }
                // pick which side to move one workload to

            }
        } while (keepMoving);

        return res;
    }
}
