package practise.link;

import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        var result = new HashSet<List<Integer>>();
        if (nums == null || nums.length < 3||nums[0]>0) {
            return new ArrayList<>();
        }
        int k  = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            if (i>0 && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates for i
            }
            while (j<k){
                if (nums[i]+nums[j]+nums[k]<0){
                    j++;
                }else if (nums[i]+nums[j]+nums[k]>0){
                    k--;
                }else{
                    result.add(
                            Arrays.asList(nums[i],nums[j],nums[k])
                    );
                    j++;
                    k--;
                }

            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 0, 0, 0, 0,0};
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result);
    }
}
