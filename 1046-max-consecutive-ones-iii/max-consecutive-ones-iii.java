class Solution {

    public int bf(int[]nums,int k){
    int n=nums.length,c=0,length=Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
        c=0;
        for(int j=i;j<n;j++){
            if(nums[j]==0)c++;
            if(c<=k){
            length=Math.max(length,j-i+1);
            }
            // else{
            //     break;
            // }
        }
    }
    return length;
    }
    public int slidingWindow(int[]nums,int k){
    int n=nums.length,left=0,length=0,c=0;
    for(int right=0;right<n;right++){
        if(nums[right]==0){
        c++;
        }
        while(c>k){
        if(nums[left++]==0){
            c--;
        }
        }
        length=Math.max(length,right-left+1);
    }
    return length;
    }
    public int longestOnes(int[] nums, int k) {
    if(nums==null||nums.length<=0|| k<0 || k>nums.length)
    return 0;
    // return bf(nums,k);
    return slidingWindow(nums,k);
    }
}




//For reminder:
// class Solution {

//     /**
//      * Optimized Sliding Window
//      * Time Complexity: O(n)
//      * Space Complexity: O(1)
//      */
//     public int slidingWindow(int[] nums, int k) {
//         int n = nums.length;
//         int left = 0;
//         int maxLength = 0; // Initialized to 0 for edge cases
//         int zeroCount = 0;

//         for (int right = 0; right < n; right++) {
//             if (nums[right] == 0) {
//                 zeroCount++;
//             }

//             // If we have more than k zeros, slide the left boundary
//             while (zeroCount > k) {
//                 if (nums[left] == 0) {
//                     zeroCount--;
//                 }
//                 left++;
//             }

//             // Update result: the current window [left...right] is valid
//             maxLength = Math.max(maxLength, right - left + 1);
//         }
//         return maxLength;
//     }

//     public int longestOnes(int[] nums, int k) {
//         // Defensive Check: Standard FAANG practice
//         if (nums == null || nums.length == 0) {
//             return 0;
//         }
        
//         // k is assumed to be >= 0 per problem constraints, 
//         // but handling k < 0 prevents logic failure.
//         if (k < 0) return 0;

//         return slidingWindow(nums, k);
//     }
// }