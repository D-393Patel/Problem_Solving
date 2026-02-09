class Solution {
    public int bf(int[]nums,int k){
    int n=nums.length,l_count,count=0;
    for(int i=0;i<n;i++){
        l_count=0;
        for(int j=i;j<n;j++ ){
            if(nums[j]%2!=0)
            l_count++;
            if(l_count==k)
            count++;
            }
        }
    return count;
    }
    public int slidingWindow(int[]nums,int k){
    //edge case 
    if(k<0) return 0;
    int n=nums.length,count=0,left=0,length=0;
    for(int right=0;right<n;right++){
    if(nums[right]%2!=0){
        count++;
    }
    //where we will shrink the size of the window
    while(count>k){
    if(nums[left++]%2!=0){
        count--;
    }
    }
    length+=right-left+1;
    }
    return length;
    }
    public int numberOfSubarrays(int[] nums, int k) {
    if(nums.length<=0||k<0 || k>nums.length)
    return 0;
    // return bf(nums,k);
    //for count based problem -----not length based so for exact subarrays=f(k)-f(k-1)
    return slidingWindow(nums,k)-slidingWindow(nums,k-1);
    }
}











//for reminder:
// class Solution {
//     /**
//      * Calculates number of subarrays with AT MOST k odd numbers.
//      * Time: O(n), Space: O(1)
//      */
//     private int countAtMost(int[] nums, int k) {
//         if (k < 0) return 0; // Crucial for k-1 calls
        
//         int n = nums.length;
//         int oddCount = 0;
//         int left = 0;
//         int totalSubarrays = 0;

//         for (int right = 0; right < n; right++) {
//             // Bitwise check for odd numbers
//             if ((nums[right] & 1) != 0) {
//                 oddCount++;
//             }

//             while (oddCount > k) {
//                 if ((nums[left] & 1) != 0) {
//                     oddCount--;
//                 }
//                 left++;
//             }

//             // The number of subarrays ending at 'right' is the window size
//             totalSubarrays += (right - left + 1);
//         }
//         return totalSubarrays;
//     }

//     public int numberOfSubarrays(int[] nums, int k) {
//         if (nums == null || nums.length == 0 || k < 0) return 0;
        
//         // Exact k = At Most(k) - At Most(k-1)
//         return countAtMost(nums, k) - countAtMost(nums, k - 1);
//     }
// }