package Contest346;

import java.util.*;

public class Q3 {
    public static int punishmentNumber(int n) {
        Set<Integer> list=new HashSet<>();
         
         list.add(1);
        
        for(int i=2;i<=n;i++){
            if(rec(""+(i*i),i)){
                list.add(i*i);
             }
        }
        int sum=0;
        for(int i:list)sum+=i;
        return sum;

    }
    public static boolean rec(String s,int n){
         if(n<0)return false;
        if(n==0&&s.length()==0){
            return true;
        }
        for(int i=1;i<=s.length();i++){
            boolean ans=rec(s.substring(i),n-Integer.parseInt(s.substring(0,i)));
            if(ans)return true;
        }
        return false;
    }
}
