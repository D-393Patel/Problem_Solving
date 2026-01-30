class Solution {
    public int[] runningSum(int[] nums) {
    //Basically there it is asking about cumulitative sum or prefix sum
    int n=nums.length;
    // if(n<=0)
    // return prefix;
    int[]prefix=new int[n];
    prefix[0]=nums[0];
    for(int i=1;i<n;i++){
    prefix[i]=nums[i]+prefix[i-1];
    }
    return prefix;
    }
}