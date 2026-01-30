class Solution {
    public boolean bfs(List<List<Integer>>l,int s,int d,int[]vis){   if(s==d) return true;
    Queue<Integer>q=new LinkedList<>();
    q.add(s);
    vis[s]=1;
    while(!q.isEmpty()){
        int el=q.poll();
        if(el == d)
        {
            return true;
        }
        for(int i:l.get(el)){
            if(vis[i]!=1){
            vis[i]=1;
            q.add(i);
            }
        }
    }
    return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
    //Convert edges into adjacency list
    if(edges.length<0)
    return false;
    List<List<Integer>>l=new ArrayList<>();
    for(int i=0;i<n;i++){
        l.add(new ArrayList<>());
    }
    for(int i=0;i<edges.length;i++){
        int s=edges[i][0];
        int ne=edges[i][1];
        l.get(s).add(ne);
        l.get(ne).add(s);
    }
    int[]vis=new int[n];
    return bfs(l,source,destination,vis);
    }
}