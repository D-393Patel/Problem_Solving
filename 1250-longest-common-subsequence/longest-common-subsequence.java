class Solution {
    public int lcsR(int i,int j,String s1,String s2){
    if(i>=s1.length() || j>=s2.length())
    return 0;
    //choice 
    int c=0;
    if(s1.charAt(i)==s2.charAt(j))
    c=1+lcsR(i+1,j+1,s1,s2);
    int nc=Math.max(lcsR(i+1,j,s1,s2),lcsR(i,j+1,s1,s2));
    return Math.max(c,nc);
    }
    public int lcsM(int i,int j,String s1,String s2,int[][]memo){
    if(memo[i][j]!=-1)
    return memo[i][j];
    if(i>=s1.length() || j>=s2.length())
    return 0;
    int c=0;
    if(s1.charAt(i)==s2.charAt(j))
    c=1+lcsM(i+1,j+1,s1,s2,memo);
    int nc=Math.max(lcsM(i+1,j,s1,s2,memo),lcsM(i,j+1,s1,s2,memo));
    return memo[i][j]=Math.max(c,nc);
    }
    public int lcT(String s1,String s2){
    int[][]tabu=new int[s1.length()+1][s2.length()+1];
    //filling the base case (0) length string
    for(int i=0;i<s1.length()+1;i++){
        for(int j=0;j<s2.length()+1;j++)
        {
            if(i==0 || j==0)
            tabu[i][j]=0;
        }
    }
    //let's fill the matrix m*n
    for(int i=1;i<s1.length()+1;i++){
        for(int j=1;j<s2.length()+1;j++){
        if(s1.charAt(i-1)==s2.charAt(j-1))
        tabu[i][j]=1+tabu[i-1][j-1];
        else 
        tabu[i][j]=Math.max(tabu[i][j-1],tabu[i-1][j]);
        }
    }
    return tabu[s1.length()][s2.length()];
    }
    public int longestCommonSubsequence(String text1, String text2) {
    //Since subsequence doesn't need to be contiguous so they can be done with the help of recursion
    //Base case when no subproblems left i.e. our search space reach the end
    //if(i>=text1.length|| j>=text2.length)  
    //return 0;
    //at each point f(i,j) we have two choices if(text1.charAt(i)==text2.charAt(j)) then 1+(f(i+1,j+1)) else Math.max(f(i+1,j),f(i,j+1))
    
    if(text1.length()<=0 || text2.length()<=0)
    return 0;
    // return lcsR(0,0,text1,text2);
    //memoization
    // int [][]memo=new int[text1.length()+1][text2.length()+1];
    // for(int[]mem:memo)
    // Arrays.fill(mem,-1);

    // return lcsM(0,0,text1,text2,memo);

    return lcT(text1,text2);
    }
}