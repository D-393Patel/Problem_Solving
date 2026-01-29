class Solution {
    public int mergeSort(int[]nums,int l,int r){
    if(l>=r) return 0; //base case was missing
    int mid=(l+(r-l)/2);
    int count=0;
    count+=mergeSort(nums,l,mid);
    count+=mergeSort(nums,mid+1,r);
    count+=mergeImprove(nums,l,mid,r);
    return count;
    }
    public int mergeImprove(int []nums,int l,int mid,int r){
    //Handling array
    //arrays 
    int n1=mid-l+1;
    int n2=r-mid;
    int[]L=new int[n1];
    int[]R=new int[n2];
    for(int i=0;i<n1;i++){
        L[i]=nums[l+i];
    }
    for(int j=0;j<n2;j++){
        R[j]=nums[mid+1+j];
    }
    int count=0,j=0;
    
    for(int i=0;i<n1;i++){
    //  current_count+=last_count;
    //  for(int j=last_index;j<n2;j++){
    //     if((long)L[i]>2L*R[j]){
    //         current_count++;
    //     }
    //     else{
    //         last_count=current_count;
    //         last_index=j;
    //         break;
    //     }
     while(j<n2 && (long)L[i]>2L*R[j]){
        j++;
     }
     count+=j;
     }
    int i=0,k=l;
    j=0;
    while(i<n1 && j<n2){
        
        if(L[i]<=R[j]){
            nums[k++]=L[i++];
        }
        else{
           nums[k++]=R[j++];
        }
    }
    while(i<n1){
        nums[k++]=L[i++];
    }
    while(j<n2){
        nums[k++]=R[j++];
    }
    return count;
    }

    public int reversePairs(int[] nums) {
    //merge
    //mergeSort
    
    if(nums.length==0 || nums==null)
    return 0;
    int l=0,r=nums.length-1;
    return mergeSort(nums,l,r);
    }
}