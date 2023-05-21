package practise;

import java.util.*;

public class Graphclient {
    class Pair{
        int cost;
        int v;
        public Pair(int cost,int v){
            this.cost=cost;
            this.v=v;
        }
    }
    int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s){
        HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
        for(int i=0;i<v;i++)map.put(i,new HashMap<>());
        for(int i=0;i<adj.size();i++){
            ArrayList<ArrayList<Integer>> list=adj.get(i);
            for(int j=0;j<list.size();j++){
                map.get(i).put(list.get(j).get(0),list.get(j).get(1));
                map.get(list.get(j).get(0)).put(i,list.get(j).get(1));
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int []dist=new int[v];
        Arrays.fill(dist,(int)1e9);
        dist[s]=0;
        pq.add(new Pair(0,s));
        while(!pq.isEmpty()){
            Pair rv=pq.remove();
            int node=rv.v;
            int c=rv.cost;
            for(int i:map.get(node).keySet()){
                if(dist[i]>c+map.get(node).get(i)){
                    dist[i]=c+map.get(node).get(i);
                    pq.add(new Pair(c+map.get(node).get(i), i));
                }
            }
        }
        return dist;
    }
}
