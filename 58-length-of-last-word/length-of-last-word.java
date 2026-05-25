class Solution {
    public int lengthOfLastWord(String s) {
    String st=s.trim();
    int i=st.length()-1,len=0;
    while(i>=0 && st.charAt(i)!=' '){
    len++;
    i--;
    }
    return len;
    }
}