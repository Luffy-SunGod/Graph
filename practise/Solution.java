package practise;

import java.util.*;
class Solution{
    public int countCompleteComponents(int n, int[][] edges) {
        List<Set<Integer>> set=new ArrayList<>();
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++)map.put(i,new ArrayList<>());
        for(int []a:edges){
            map.get(a[0]).add(a[1]);
            map.get(a[1]).add(a[0]);
        }
        bfs(map,n);
        return 0;
    }
    public void bfs(HashMap<Integer,List<Integer>> map,int n){
        Queue<Integer> q=new LinkedList<>();
        Set<Integer> visited=new HashSet<>();
        List<Set<Integer>> x=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(visited.contains(i))continue;
               Set<Integer> list=new HashSet<>();
            //    list.add(i);
               q.add(i);
               while(!q.isEmpty()){
                    int rv=q.remove();
                    if(visited.contains(rv))continue;
                    System.out.println(rv);
                    visited.add(rv);
                    list.add(rv);
                    for(int nbrs:map.get(rv))if(!visited.contains(rv))q.add(nbrs);
               }
               x.add(new HashSet<>(list));
        }
    }

}


   