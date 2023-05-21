package practise;

import java.util.*;
  class p2{
    public String predictPartyVictory(String senate) {
        List<Character> list=new LinkedList<>();
        for(char c:senate.toCharArray())list.add(c);
        while(true){
            for(char c:list){
                if(c=='R'){
                    if(!isPresent(list, true))return "Radiant";
                }else{
                    if(!isPresent(list, false))return "Dire";
                }
            }
        }
    }
    public boolean isPresent(List<Character> list,boolean r ){
            if(r){
                for(int i=0;i<list.size();i++){
                    if(list.get(i)=='D'){
                        list.set(i, '$');
                        return true;
                    }
                }
            }else{
                for(int i=0;i<list.size();i++){
                    if(list.get(i)=='R'){
                        list.set(i, '$');
                        return true;
                    }
                }

            }
            return false;
    }
  }




