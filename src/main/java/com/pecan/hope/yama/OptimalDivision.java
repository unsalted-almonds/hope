package com.pecan.hope.yama;

/**
 * Given a list of positive integers, the adjacent integers will perform the float division. For example, [2,3,4] -> 2 / 3 / 4.

 However, you can add any number of parenthesis at any position to change the priority of operations. You should find out how to add parenthesis to get the maximum result, and return the corresponding expression in string format. Your expression should NOT contain redundant parenthesis.

 Example:
 Input: [1000,100,10,2]
 Output: "1000/(100/10/2)"
 Explanation:
 1000/(100/10/2) = 1000/((100/10)/2) = 200
 However, the bold parenthesis in "1000/((100/10)/2)" are redundant,
 since they don't influence the operation priority. So you should return "1000/(100/10/2)".

 Other cases:
 1000/(100/10)/2 = 50
 1000/(100/(10/2)) = 50
 1000/100/10/2 = 0.5
 1000/100/(10/2) = 2
 Note:

 The length of the input array is [1, 10].
 Elements in the given array will be in range [2, 1000].
 There is only one optimal division for each test case.
 */
public class OptimalDivision {

    /**
     class Solution {
     public:
     string optimalDivision(vector<int>& nums) {
     if(nums.empty()) return "";
     else if(nums.size() == 1) return to_string(nums[0]);
     else if(nums.size() == 2) return to_string(nums[0]) + '/' + to_string(nums[1]);
     string ret = to_string(nums[0]) + "/(" + to_string(nums[1]);
     for(int i=2; i<nums.size(); i++){
     ret += '/';
     ret += to_string(nums[i]);
     }
     ret += ')';
     return ret;
     }
     };

     **/
    public String optimalDivision(int[] nums) {
        String res = "";

        if (nums == null || nums.length == 0) {
            return res;
        }

        if (nums.length == 1) {
            return res + nums[0];
        }

        StringBuilder sb = new StringBuilder();
        // only this way can construct the biggest result a/(b/c/d) = a * c * d / b
        for (int i = 0; i < nums.length; i++) {
            if (i == 1 && nums.length > 2) {
                sb.append("(").append(nums[i]).append("/");
                continue;
            }
            if (i == nums.length - 1 && nums.length > 2) {
                sb.append(nums[i]).append(")");
                continue;
            }
            if (i < nums.length - 1 ) {
                sb.append(nums[i]).append("/");
            } else {
                sb.append(nums[i]);
            }

        }

        return sb.toString();

    }
}
