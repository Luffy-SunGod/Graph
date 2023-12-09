package Contest346;


import java.util.*;

public class Q2 {
    public int deleteAndEarn(int[] nums) {
        Set<Integer> set=new HashSet<Integer>();
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
            set.add(1);           
        }
        int[]a=new int[set.size()];
        int idx=0;
        for(int i:set){
            a[idx]=i;
            idx++;
        }


    }
    public int rec(int[]a,int i,int prev){
        if(i==a.length)return 0;
        int take=0,not=0;
        if(prev==0||a[i]!=prev-1||a[i]!=prev+1)take=a[i]+rec(a,i+1,a[i]);
        not=rec(a,i+1,prev);
        return Math.max(take,not);
    }
}
