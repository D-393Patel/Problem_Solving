class Solution {
    public void dfs(int i,int j,char[][]grid,int[][]visited,int[][]dirs){
        
        int m=grid.length,n=grid[0].length;
        if(i<0||j<0||i>=m||j>=n)
        return;
        if(grid[i][j]=='0' || visited[i][j]==1)
        return;
        visited[i][j]=1;
        for(int[]d:dirs)
        dfs(i+d[0],j+d[1],grid,visited,dirs);
        
    }
    public void dfs1(int i,int j,char[][]grid,int[][]visited){
    if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0' || visited[i][j]==1)
    return;
    visited[i][j]=1;
    dfs1(i-1,j,grid,visited);
    dfs1(i,j-1,grid,visited);
    dfs1(i+1,j,grid,visited);
    dfs1(i,j+1,grid,visited);
    }
    public int numIslands(char[][] grid) {
    //to count the number of such islands
    int count=0,m=grid.length,n=grid[0].length;
    int [][]visited=new int[m][n];
     int[][]dirs={{1,0},{0,1},{-1,0},{0,-1}};
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]=='1' && visited[i][j]==0){
            // dfs(i,j,grid,visited,dirs);
            dfs1(i,j,grid,visited);
            count++;
            }
        }
    }
    return count;
    }
}