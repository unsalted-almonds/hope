package com.pecan.hope.yama;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Shilin_Gan on 12/6/2017.
 */
public class SuperWashingMachine {

    public static void main(String[] args) {
        String csvFile = "SuperWashingMachine.csv";
        String line = "";
        String cvsSplitBy = ",";
        int[] longInput = null;
        String[] parse = null;
        try (BufferedReader br = new BufferedReader(new FileReader("SuperWashingMachine.csv"))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                parse = line.split(cvsSplitBy);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        longInput = new int[parse.length];
        for (int i = 0; i < parse.length; i++) {
            longInput[i] = Integer.valueOf(parse[i]);
        }

        SuperWashingMachine test = new SuperWashingMachine();

        int res = test.findMinMoves(new int[]{1, 0, 5});
        System.out.println(res);

        res = test.findMinMoves(new int[]{0, 3, 0});
        System.out.println(res);

//        res = test.findMinMoves(longInput);
//        System.out.println(res);
        System.out.println("========");
        res = test.findMinMoves(new int[]{0, 0, 6});
        System.out.println(res);

    }

    public int findMinMoves(int[] machines) {
        int res = -1;
        if (machines == null || machines.length == 0) {
            return res;
        }

        int sum = 0;
        for (int n : machines) sum += n;

        if (sum % machines.length != 0) return res;

        int target = sum / machines.length;

        int leftSum = 0;
        int rightSum = 0;
        res = 0;
        for (int i = 0 ; i < machines.length; i++) {
            System.out.println(res);
            rightSum = sum - leftSum;
            leftSum += machines[i];

            if (leftSum > target * (i + 1) && rightSum > target * (machines.length - i)) {
                res = Math.max(res, leftSum - target * (i + 1) + rightSum - target * (machines.length - i));
                continue;
            }

            if (leftSum < target * (i + 1) && rightSum < target * (machines.length - i)) {
                res = Math.max(res, Math.max(target * (i + 1) - leftSum, target * (machines.length - i) - rightSum));
                continue;
            }

            // move workload to the right
            if (leftSum > target * (i + 1)) {
                res = Math.max(res, leftSum - target * (i + 1));
                continue;
            }
            // move workload to the left
            if (rightSum > target * (machines.length - i)) {
                res = Math.max(res, rightSum - target * (machines.length - i));
                continue;
            }


        }

        return res;
    }

    public int findMinMoves2(int[] machines) {
        int res = -1;
        if (machines == null || machines.length == 0) {
            return res;
        }

        int sum = 0;
        for (int n : machines) sum += n;

        if (sum % machines.length != 0) return res;

        int target = sum / machines.length;

        boolean keepMoving = false;

        int trailingSum = 0;
        res = 0;
        do {
            keepMoving = false;
            trailingSum = 0;
            for (int i = 0; i < machines.length; i++) {

                int load = machines[i];
                if (load < target) {
                    keepMoving = true;
                } else if (load > target) {
                    keepMoving = true;
                    int trailingLeft = trailingSum;
                    int targetLeft = target * i;
                    machines[i]--;
                    // left too much workload
                    if (targetLeft <= trailingLeft) {
                        if (i < machines.length - 1)
                            machines[i + 1]++;
                    } else {
                        if (i > 0) {
                            machines[i - 1]++;
                            trailingSum++;
                        }

                    }
                } else {
                    int trailingLeft = trailingSum;
                    int targetLeft = target * i;
                    // left too much workload
                    if (targetLeft < trailingLeft) {
                        if (i < machines.length - 1) {
                            machines[i + 1]++;
                            machines[i]--;
                        }
                        keepMoving = true;
                    } else if (targetLeft > trailingLeft) {
                        if (i > 0) {
                            machines[i - 1]++;
                            machines[i]--;
                            trailingSum++;
                        }
                        keepMoving = true;
                    }
                }
                trailingSum += machines[i];
            }
            //System.out.println(Arrays.toString(machines));
            if (!keepMoving) return res;
            res++;

        } while (keepMoving);

        return res;

    }
}
