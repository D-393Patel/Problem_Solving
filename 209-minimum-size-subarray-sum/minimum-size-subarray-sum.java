class Solution {
    public int bf(int []nums,int k){
    int n=nums.length,sum=0,length=Integer.MAX_VALUE;
    for(int i=0;i<n;i++){
        sum=0;
        for(int j=i;j<n;j++){
         sum+=nums[j];
         if(sum>=k){
            length=Math.min(length,j-i+1);
         }
        }
    }
    return length==Integer.MAX_VALUE?0:length;
    }
    public int slidingWindowVariable(int []nums,int k){
    int n=nums.length,left=0,length=Integer.MAX_VALUE,sum=0;
    for(int right=0;right<n;right++){
    sum+=nums[right];
    while(sum>=k){
        length=Math.min(length,right-left+1);
        sum-=nums[left++];
    }
    }
    return length==Integer.MAX_VALUE?0:length;
    }
    public int minSubArrayLen(int target, int[] nums) {
    if(nums==null ||nums.length<=0)
    return 0;
    // return bf(nums,target);
    return slidingWindowVariable(nums,target);
    }
}