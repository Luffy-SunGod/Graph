package practise;

import java.util.*;

public class Graph {
    HashMap<Integer,HashMap<Integer,Integer>> map;
    public Graph(int v){
        map=new HashMap<>();
        for(int i=1;i<=v;i++){
            map.put(i,new HashMap<>());
        }
    }
    public void addedge( int v1,int v2,int cost){
            map.get(v1).put(v2,cost);
            map.get(v2).put(v1,cost);
    }
    public void addVertex(int v){
        if(map.containsKey(v))return ;
        map.put(v,new HashMap<>());
    }
    public void Display() {
		for (int key : map.keySet()) {
			System.out.println(key + " --> " + map.get(key));
		}
	}

    public boolean HashPath(int src, int dis, HashSet<Integer> visited) {
		if(src==dis)return true;
        visited.add(src);
        for(int i:map.get(src).keySet()){
            if(!visited.contains(i)){
                boolean res=HashPath(i, dis, visited);
                if(res)return res;
            }
        }
        return false;
	}
    public void printallpath(int src,int des,HashSet<Integer> visited,String ans){
        if(src==des){
            System.out.println(ans+src);
            return;
        }
        visited.add(src);
        for(int i:map.get(src).keySet()){
            if(!visited.contains(i)){
                printallpath(i, des, visited, ans+src+"->");
            }
        }
        visited.remove(src);
    }
    
    public boolean bfs(int src,int des){
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        while(!q.isEmpty()){
            int rv=q.remove();
            if(rv==des)return true;
            if(visited.contains(rv))continue;
            for(int i:map.get(rv).keySet()){
                if(!visited.contains(i)){
                    q.add(i);
                }
            }
        }
        return false;
    }


    
}
