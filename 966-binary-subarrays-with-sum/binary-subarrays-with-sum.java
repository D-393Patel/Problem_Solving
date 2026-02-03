class Solution {
    public int bf(int[]nums,int k){
        int n=nums.length,sum=0,count=0;
        for(int i=0;i<n;i++){
            sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                if(sum==k)
                count++;
            }
        }
        return count;
    }
    public int prefixSum(int[]nums,int k){
    int n=nums.length;
    int[]prefix=new int[n+1];
    for(int i=0;i<n;i++){
        prefix[i+1]=prefix[i]+nums[i];
    }
    int count=0;
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n+1;j++){
            if((prefix[j]-prefix[i])==k)
            count++;
        }
    }
    return count;
    }
    public int variableSlidingWindow(int[]nums,int k){
    int left=0,n=nums.length,sum=0,count=0;
    for(int right=0;right<n;right++){
        sum+=nums[right];
        while(sum>k && left<=right){
        sum-=nums[left++];
        }
        if(sum<=k) 
        count++;
    }
    return count;
    }
    public int prefixSumHashMap(int[]nums,int k){
    HashMap<Integer,Integer>map=new HashMap<>();
    int sum=0,count=0;
    map.put(0,1);
    for(int x:nums){
        sum+=x;
        count+=map.getOrDefault(sum-k,0);
        map.put(sum,map.getOrDefault(sum,0)+1);
    }
    return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
    if(nums==null ||nums.length<=0)
    return 0;
    // return bf(nums,goal);
    // return prefixSum(nums,goal);
    // return (variableSlidingWindow(nums,goal)-variableSlidingWindow(nums,goal-1));
    return prefixSumHashMap(nums,goal);
    }
}