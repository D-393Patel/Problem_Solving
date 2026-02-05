class Solution {
    public int bf(int[]nums,int k){
    int n=nums.length,prod=1,count=0;
    // List<Integer>l=new ArrayList<>();
    for(int i=0;i<n;i++){
        prod=1;
        for(int j=i;j<n;j++){
        prod*=nums[j];
        if(prod<k)
        count++;
    }
   
    }
     return count;
    }
    public int slidingWindowVariable(int[]nums,int k){
    int n=nums.length,left=0,count=0,prod=1;
    for(int right=0;right<n;right++){
        prod*=nums[right];
        
        while(prod>=k && left<=right){
        prod/=nums[left];
        left++;
        }
       if(prod<k){
        count+=right-left+1;// check only one time
        }

    }
    return count;
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
    if(nums==null||nums.length<=0|| k<=0)
    return 0;
    // return bf(nums,k);
    return slidingWindowVariable(nums,k);
    }
}