class Solution {
    public int firstUniqChar(String s) {
    int n=s.length();
    if(n<=0)
    return -1;
    HashMap<Character,Integer>h=new HashMap<>();
    for(int i=0;i<n;i++){
        h.put(s.charAt(i),h.getOrDefault(s.charAt(i),0)+1);
    }
    for(int i=0;i<n;i++){
        char ch=s.charAt(i);
        if(h.get(ch)==1)
        return i;
    }
    return -1;
    }
}