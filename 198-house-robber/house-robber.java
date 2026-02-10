class Solution {
    public int recursion(int i,int[]nums){
    if(i<0)
    return 0;
    int skip=recursion(i-1,nums);
    int rob=nums[i]+recursion(i-2,nums);
    return Math.max(skip,rob);
    }
    //Memoize it
    public int memoization(int i,int[]nums,int[]memo){
    if(i<0)
    return 0;
    if(memo[i]!=-1)
    return memo[i];
    int skip=memoization(i-1,nums,memo);
    int rob=nums[i]+memoization(i-2,nums,memo);
    memo[i]=Math.max(skip,rob);
    return memo[i];
    }
    public int tabulation(int[]nums){
    int[]tabu=new int[nums.length];
    tabu[0]=nums[0];
    tabu[1]=Math.max(nums[0],nums[1]);
    for(int i=2;i<nums.length;i++){
        tabu[i]=Math.max(tabu[i-1],nums[i]+tabu[i-2]);
    }
    return tabu[nums.length-1];
    }
    public int rob(int[] nums) {
    //since we have an alternate preventing condition we will use recursion
    if(nums==null || nums.length<=0)
    return 0;
    if(nums.length==1)
    return nums[0];
    // return recursion(nums.length-1,nums);
    // int[]memo=new int[nums.length+1];
    // Arrays.fill(memo,-1);
    // return memoization(nums.length-1,nums,memo);
    return tabulation(nums);
    }

}