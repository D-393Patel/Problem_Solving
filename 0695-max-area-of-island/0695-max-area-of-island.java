class Solution {
    public int dfs(int i,int j,int[][]grid,int[][]visited){
    if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0)
    return 0;
    grid[i][j]=0;
    return 1+(dfs(i-1,j,grid,visited)+dfs(i,j-1,grid,visited)+dfs(i+1,j,grid,visited)+dfs(i,j+1,grid,visited));
    }
    public int maxAreaOfIsland(int[][] grid) {
    int m=grid.length,n=grid[0].length,area=0,maxArea=0;
    int[][]visited=new int[m][n];
    // int[][]dirs={{0,1},{1,0},{0,-1},{-1,0}};
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            area=0;
            if(grid[i][j]==1 && visited[i][j]==0){
                area=dfs(i,j,grid,visited);
                maxArea=Math.max(maxArea,area);
            }
        }
    }
    return maxArea;
    }
}