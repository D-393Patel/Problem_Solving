class Solution {
    public int orangesRotting(int[][] grid) {
    int m=grid.length,n=grid[0].length;
    int fresh=0;
    Queue<int[]>q=new LinkedList<>();
    //Counting fresh oranges and iniitalizing sources to queue of multisource bfs
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(grid[i][j]==2)
            q.offer(new int[]{i,j});
            else if(grid[i][j]==1)
            fresh++;
        }
    }
    if(fresh==0)
    return 0;
    //directions
    int t=0;
    int[][]d={{-1,0},{0,1},{1,0},{0,-1}};
    //level by level bfs traversal
    while(!q.isEmpty() && fresh>0){
       
        boolean spread=false;
        //We need to count how many oranges are rotten at the start of the minute 
        int size=q.size();
        for(int j=0;j<size;j++){
            int []curr=q.poll();
            for(int i=0;i<4;i++){
            int r=curr[0]+d[i][0];
            int c=curr[1]+d[i][1];
            if(r<m && r>=0 && c>=0 && c<n && grid[r][c]==1){
            grid[r][c]=2;
            q.offer(new int[]{r,c});
            fresh--;
            spread=true;
            }
        }
        }
        if(spread)
        t++;
    }
    return (fresh==0)?t:-1;
    }
}