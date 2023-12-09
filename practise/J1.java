package practise;

import java.util.*;

public class J1 {
    Set<String> set=new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
       for(String str:wordDict)set.add(str);
        return rec(s);

    }
    public boolean rec(String s){
        // if(s.length()<0)return false;
        if(s.length==0)return true;
        boolean ans=false;
        for(int i=1;i<=s.length;i++){
            if(set.contains(s.substring(0,i))){
                ans=rec(s.substring(i));
            }
        }
        return ans;

    }
}
