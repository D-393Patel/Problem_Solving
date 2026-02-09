class Solution {
    public int bf(int []nums,int k){
    int n=nums.length,count=0,good=0;
    for(int i=0;i<n;i++){
        count=0;
        HashSet<Integer>set=new HashSet<>();
        for(int j=i;j<n;j++){
            if(!set.contains(nums[j])){
                set.add(nums[j]);
                count++;
            }
            if(count==k){
            good++;
            }
        }
        set.clear();
    }
    return good;
    }
    public int slidingWindow(int[]nums,int k){
    int n=nums.length,left=0,count=0;
    HashMap<Integer,Integer>freq=new HashMap<>();
    //why HashSet not works for slidngwindow approach because?
    for(int right=0;right<n;right++){
    freq.put(nums[right],freq.getOrDefault(nums[right],0)+1);
    if(freq.get(nums[right])==1){
        k--;
    }
    while(k<0){
        freq.put(nums[left],freq.getOrDefault(nums[left],0)-1);
        if(freq.get(nums[left])==0)
        k++;
        left++;
    }
    count+=right-left+1;
    }
    return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
    if(nums==null||nums.length<=0||k<0||k>nums.length)
    return 0;
    // return bf(nums,k);
    return slidingWindow(nums,k)-slidingWindow(nums,k-1);
    }
}














//reminder of concepts:
// class Solution {
//     /**
//      * QUESTION: Why are we calling this twice? (atMost(k) - atMost(k-1))
//      * ANSWER: Sliding window naturally finds ranges for "at most". By subtracting 
//      * "at most k-1" from "at most k", we are left with the exact count of 
//      * subarrays that have exactly k distinct elements.
//      */
//     public int subarraysWithKDistinct(int[] nums, int k) {
//         if (nums == null || k <= 0) return 0;
//         return atMost(nums, k) - atMost(nums, k - 1);
//     }

//     private int atMost(int[] nums, int k) {
//         if (k == 0) return 0;
        
//         int n = nums.length;
//         // QUESTION: Why use an array instead of a HashMap?
//         // ANSWER: The problem constraints often specify nums[i] <= nums.length. 
//         // An array provides O(1) access without the overhead of hashing or object 
//         // creation, making it significantly faster in high-throughput environments.
//         int[] freq = new int[n + 1]; 
        
//         int left = 0;
//         int distinctCount = 0;
//         int totalSubarrays = 0;

//         for (int right = 0; right < n; right++) {
//             // QUESTION: How do we track 'distinct' elements efficiently?
//             // ANSWER: We only increment distinctCount when a frequency transitions 
//             // from 0 to 1.
//             if (freq[nums[right]] == 0) {
//                 distinctCount++;
//             }
//             freq[nums[right]]++;

//             // QUESTION: When do we shrink the window?
//             // ANSWER: The moment distinctCount exceeds our limit k. 
//             // This maintains the invariant that the window [left, right] 
//             // always contains <= k distinct elements.
//             while (distinctCount > k) {
//                 freq[nums[left]]--;
//                 if (freq[nums[left]] == 0) {
//                     distinctCount--;
//                 }
//                 left++;
//             }

//             // QUESTION: Why does (right - left + 1) represent the number of subarrays?
//             // ANSWER: For a valid window [left, right], every subarray ending at 'right' 
//             // and starting at any index from 'left' to 'right' is also valid. 
//             // There are exactly (right - left + 1) such subarrays.
//             totalSubarrays += (right - left + 1);
//         }
        
//         /**
//          * QUESTION: What is the Time and Space Complexity?
//          * ANSWER: 
//          * Time: O(N) - Each pointer (left/right) moves from 0 to N once per call.
//          * Space: O(N) - To store the frequency array of size N.
//          */
//         return totalSubarrays;
//     }
// }