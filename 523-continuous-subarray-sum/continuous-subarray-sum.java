class Solution {
    public int bf(int[]nums,int k){
    int n=nums.length,sum=0,count=0;
    for(int i=0;i<n;i++){
        sum=0;
        for(int j=i;j<n;j++){
            sum+=nums[j];
            if(sum%k==0 && (j-i>1)){
                count++;
            }
        }
    }
    return count;
    }
    public int prefixSum(int[]nums,int k){
    int n=nums.length;
    int []prefix=new int[n+1];
    prefix[0]=0;
    for(int i=0;i<n;i++){
        prefix[i+1]=prefix[i]+nums[i];
    }
    int count=0;
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n+1;j++){
            if((prefix[j]-prefix[i])%k==0  &&(j-i>2))
            count++;
        }
    }
    return count;
    }
    public boolean prefixSumHashMap(int[]nums,int k){
    int sum=0;
    HashMap<Integer,Integer>map=new HashMap<>();
    map.put(0,-1);
    for(int i=0;i<nums.length;i++){
        //map storing indices for checking the existence and sum in case of counting
        sum+=nums[i];
        int res=(k==0)?sum:((sum%k)+k)%k;
        if(map.containsKey(res)){
        if(i-map.get(res)>=2){
            return true;
        }
        }
        else{
            map.put(res,i);
        }
        
        
    
    }
    // return count;
    //problem faced here: How do ensure length in hashMap
        /*A good subarray is a subarray where:
        its length is at least two */
        return false;
    }
    //Wrong logic:-what we are maintaining is not monotonic
    // public int variableSlideWindow(int[]nums,int k){
    // int left=0,n=nums.length,sum=0;
    // for(int right=0;right<n;right++){
    //     sum+=nums[right];
    //     while(sum%k!=0){
    //         sum-=nums[left++];
    //     }
    //     if(sum%k==0){
    //         count++;
    //     }
    // }
    // return count;
    // }
    // }
    public boolean checkSubarraySum(int[] nums, int k) {
    if(nums.length<2)
    return false;
    // return (bf(nums,k)>0?true:false);
    // return (prefixSum(nums,k)>0?true:false);
    return prefixSumHashMap(nums,k);
    }
}