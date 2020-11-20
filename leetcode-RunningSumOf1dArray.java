class Solution {
    public int[] runningSum(int[] nums) {
        for(int i=nums.length-1;i>-1;i--){
            for(int j=0;j<i;j++){
                nums[i]+=nums[j];
            }
        }
        return nums;
    }
}
