package Contest346;

import java.util.*;

public class Q1 {
    public int minLength(String s) {
        List<Character> list=new ArrayList<>();
         char c[]=s.toCharArray();
         for(char x:c)list.add(x);
 
         int i=0;
         while(i<list.size()-1){
              // System.out.println(list);
             if(list.get(i)=='A'&&list.get(i+1)=='B'){
                 
                 list.remove(i);
                 list.remove(i);
                 i=0;
             }
             else if(list.get(i)=='C'&&list.get(i+1)=='D'){
                 list.remove(i);
                 list.remove(i);
                 i=0;
             }
             else
             i++;
         }
        
         return list.size();
     }
}
