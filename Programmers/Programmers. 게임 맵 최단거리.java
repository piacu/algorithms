import java.util.*;

class Solution {
    int[] dr = {1,-1,0,0};
    int[] dc = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        int answer = bfs(0, 0, maps);
        
        return answer;
    }
    
    public int bfs(int sr, int sc, int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        int res = Integer.MAX_VALUE;
        
        q.add(new int[] {sr, sc, 1});
        
        while(!q.isEmpty()){
            int[] loc = q.poll();
            int r = loc[0];
            int c = loc[1];
            int cnt = loc[2];
            
            if(r == maps.length-1 && c == maps[0].length-1){
                return cnt;
            }
            
            for(int i=0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(nr>=0 && nr<maps.length && nc>=0 && nc<maps[0].length && maps[nr][nc] == 1){
                    maps[nr][nc] = 0;
                    q.add(new int[]{nr, nc, cnt+1});
                }
            }
        }
        return -1;
    }
}