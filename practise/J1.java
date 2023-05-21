package practise;

import java.util.*;

public class J1 {
    public static void main(String[] args) {
        punishmentNumber(10);
    }
   public static int punishmentNumber(int n) {
        List<Integer> list=new ArrayList<>();
        for(int i=2;i<=10;i++){
            if(rec(""+(i*i),i)){
                list.add(i);
            }
        }
        // System.out.println(rec(5));
        int sum=0;
        for(int i:list)sum+=i;
        return sum;

    }
    public static boolean rec(String s,int n){
        if(n==0)return true;
        if(n<=0)return false;

        for(int i=1;i<s.length();i++){
            boolean ans=rec(s.substring(1),n-Integer.parseInt(s.substring(0,1)));
            if(ans)return true;
        }
        return false;
    }
}