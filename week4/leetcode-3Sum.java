/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.
Notice that the solution set must not contain duplicate triplets.
Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int c=-nums[i];
            if(i>0 && nums[i]==nums[i-1]) continue; // 2sum=0
            int j=i+1;
            int k=nums.length-1;
            while (j<k){
                if(j>i+1 && nums[j]==nums[j-1])j++; // 이전 결과 중복 제거
                else if(nums[j]+nums[k]<c) j++;
                else if(nums[j]+nums[k]>c) k--;
                else {
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++; k--;
                }
            }
        }
        return ans;
    }
}
