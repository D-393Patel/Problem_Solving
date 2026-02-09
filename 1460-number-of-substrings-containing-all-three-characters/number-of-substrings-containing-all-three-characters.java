class Solution {
    public int bf(String s){
    int n=s.length(),count=0,ca=0,cb=0,cc=0;
    for(int i=0;i<n;i++){
        ca=0;
        cb=0;
        cc=0;
        for(int j=i;j<n;j++){
        char ch=s.charAt(j);
        if(ch=='a')
        ca++;
        if(ch=='b')
        cb++;
        if(ch=='c')
        cc++;
        if(ca>=1 && cb>=1 && cc>=1)
        count++;
        }
    }
    return count;
    }
    public int slidingWindow(String s){
    int[]freq=new int[3];
    int n=s.length(),count=0,left=0;
    for(int right=0;right<n;right++){
    char ch=s.charAt(right);
    freq[ch-'a']++;
    while(freq[0]>0 && freq[1]>0 && freq[2]>0){
        count+=n-right;
        char c=s.charAt(left);
        freq[c-'a']--;
        left++;
    }
    }
    return count;
    }
    public int numberOfSubstrings(String s) {
    if(s.length()<3)//not zero but three at minimum string is abc
    return 0;
    // return bf(s);
    return slidingWindow(s);
    }
}



















//for reminder of concepts :
// class Solution {
//     /**
//      * QUESTION: Why is this approach more efficient than the "atMost(k) - atMost(k-1)" pattern?
//      * ANSWER: Because we are looking for at least one of each (a, b, c). 
//      * Once the window [left, right] is valid, any substring starting at 'left' and 
//      * ending anywhere from 'right' to 'n-1' is also valid. 
//      * This allows us to count multiple substrings in one go.
//      */
//     public int slidingWindow(String s) {
//         // QUESTION: Why use an int array of size 3 instead of a HashMap?
//         // ANSWER: The character set is fixed and tiny ('a', 'b', 'c'). 
//         // An array provides O(1) access with zero hashing overhead and 
//         // better cache locality.
//         int[] freq = new int[3];
//         int n = s.length();
//         int count = 0;
//         int left = 0;

//         for (int right = 0; right < n; right++) {
//             freq[s.charAt(right) - 'a']++;

//             // QUESTION: What is the significance of the while loop condition?
//             // ANSWER: It defines our "Contract Phase." We shrink the window from the left 
//             // as long as it remains valid (contains at least one of each).
//             while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
//                 /**
//                  * QUESTION: Explain the math 'count += n - right'.
//                  * ANSWER: If s[left...right] contains 'a', 'b', and 'c', then any 
//                  * string starting at 'left' and ending at 'right', 'right+1'... 'n-1' 
//                  * also contains them. There are (n - 1 - right + 1) which equals (n - right) 
//                  * such strings.
//                  */
//                 count += (n - right);

//                 // Try to shrink from the left to find the next smallest valid window
//                 freq[s.charAt(left) - 'a']--;
//                 left++;
//             }
//         }
        
//         /**
//          * QUESTION: What are the Time and Space complexities?
//          * ANSWER: 
//          * Time: O(N) because each character is visited at most twice (by left and right).
//          * Space: O(1) because the frequency array size is constant (3).
//          */
//         return count;
//     }

//     public int numberOfSubstrings(String s) {
//         // Defensive check for empty or null strings
//         if (s == null || s.length() < 3) return 0;
//         return slidingWindow(s);
//     }
// }