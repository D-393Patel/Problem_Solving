class Solution {
    public int[][] updateMatrix(int[][] mat) {
    int m=mat.length,n=mat[0].length;
    Queue<int[]>q=new LinkedList<>();
    //Initializing multisource queue of bfs
    for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(mat[i][j]==0)
            q.offer(new int[]{i,j});
            else
            mat[i][j]=-1;
        }
    }
    //directions
    int[][]d={{0,1},{0,-1},{1,0},{-1,0}};
    //level by level bfs traversal
    while(!q.isEmpty()){
        int []curr=q.poll();
        for(int i=0;i<4;i++){
            int r=curr[0]+d[i][0];
            int c=curr[1]+d[i][1];
            if(r<m && r>=0 && c<n && c>=0 && mat[r][c]==-1)
            {
                mat[r][c]=mat[curr[0]][curr[1]]+1;
                q.offer(new int[]{r,c});
            }
        }
    }
    return mat;
    }
}