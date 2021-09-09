class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int[] visited = new int[graph.length];
        Arrays.fill(visited, -1);
        boolean ans = true;
        for(int i = 0; i < graph.length; i++) {
            if(visited[i] == -1) {
                ans = isGraphBipartite(graph, i, visited);
                if(!ans) return false;   
            }
        }
        return true;
    }
    
    
    public boolean isGraphBipartite(int[][] graph, int src, int[] visited) {
        
        Queue<Integer> q = new ArrayDeque<>();
        
        q.add(src);
        int color = 0;
        
        while(q.size() != 0 && graph[src].length != 0) {
            int rs = q.size();
            
            while(rs-->0) {
                int rm = q.remove();
                
                if(visited[rm] != -1) {
                if(visited[rm] != color) {
                    return false;
                } else continue;
            } 
            
            visited[rm] = color;
            
            for(int nbr : graph[rm]) {
                    q.add(nbr);
            }   
            }
            
            color = (color + 1) % 2;
        }
        return true;
    }
}