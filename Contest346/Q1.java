package Contest346;

import java.util.*;

public class Q1 {
     
    public static int  function(HashMap<Integer,List<Integer>> red,HashMap<Integer,List<Integer>> blue){
        int ans=0;

        for(int i:red.keySet()){
            ans+=dfs(i,red,0,"red",new HashSet<>());
        }

        return ans;
    }

    public  static int dfs(int src,HashMap<Integer,List<Integer>> map,int count,String col,Set<Integer> visited){
        if(visited.contains(src)&&count==3)return 1;
        if(visited.contains(src))return 0;
        int ans=0;
        visited.add(src);

        for(int i:map.get(src)){
            ans+=dfs(i,map,count+1,col,visited);
        }
        return ans;
    }

}



// 4
// 0 0 0 0 0
// 5 2 5 1 1