class Solution {
    //Maximum array you can store is 10^6 as int locally and 10^7 globally then why are these 
    //constraints 
    //1 <= nums.length <= 10^5
  //-10^4 <= nums[i] <= 10^4
    //will give TLE
    //for this bruteforce solution.
    public List<Integer>bruteForce(int[]nums){
        List<Integer>result=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            int count=0;
            for(int j=i+1;j<n;j++){
                if(nums[i]>nums[j]){
                count++;
                }
            }
            result.add(count);
        }
        return result;
    }
    //optimization 1
    //We can use Two Sort but the problem here is that we need to take care of indices 
    //there are always problems where sorting+two pointer doesn't work because of indices.
    //How to resolve those problems and do optimization 1 
    //Sorting:O(nlogn)+ TwoPointer:O(n) overall:O(nlogn)===MergeSort() is it the only answer
    // public List<Integer>optimization1(int[]nums){
    
    // }
    // public List<Integer>optimization2(int[]nums){
    
    // }
    class Pair{
        int val;
        int ind;
        Pair(int val,int ind){
            this.val=val;
            this.ind=ind;
        }
    }
    public void mergeSort(Pair[]nums,int l,int r,     int[]ans){
    if(l>=r) 
    return ;//base Case
    // int count=0;
    int mid=(l+(r-l)/2);
    mergeSort(nums,l,mid,ans);
    mergeSort(nums,mid+1,r,ans);
    merge(nums,l,mid,r,ans);
    // return countArray.add(count);
    }
    public void merge(Pair[]nums,int l,int mid,int r,int[]ans){
    int n1=mid-l+1;
    int n2=r-mid;
    Pair[]L=new Pair[n1];
    Pair[]R=new Pair[n2];
    for(int i=0;i<n1;i++){
    L[i]=nums[l+i];
    }
    for(int j=0;j<n2;j++){
    R[j]=nums[mid+1+j];
    }
    int i=0,j=0,k=l,rightMoved=0;
    while(i<n1 &&j<n2){
        if(L[i].val<=R[j].val){
            ans[L[i].ind]+=rightMoved;
            nums[k++]=L[i++];
        }
        else{
            rightMoved++;
            nums[k++]=R[j++];
        }
    }
    while(i<n1){
    ans[L[i].ind]+=rightMoved;
    nums[k++]=L[i++];
    
    }
    while(j<n2)
    nums[k++]=R[j++];
    }
    //Using Stack O(n)----taking reference from next greater/next smaller element
    public List<Integer> countSmaller(int[] nums) {
    //brute force O(n^2) for 
    int n=nums.length;
    
    List<Integer>countArray=new ArrayList<>();
    if(n<=0||nums==null)
    return countArray;
    Pair[] num=new Pair[n];
    for(int i=0;i<n;i++){
        num[i]=new Pair(nums[i],i);
    }
    int[]ans=new int[n];
    mergeSort(num,0,n-1,ans);
    for(int i=0;i<n;i++){
        countArray.add(ans[i]);
    }
    return countArray;
    }
}