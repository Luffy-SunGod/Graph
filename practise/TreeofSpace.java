package practise;

import java.util.*;
public class TreeofSpace {
    static class Node{
        String name;
        boolean isLocked;
        int id;
        Node parent;
        int anc_locked;
        int des_locked;
        ArrayList<Node> child = new ArrayList<>();
        public String toString(){return ""+this.name;}
    }
    static void change(Node node , int val){// ancestor marking
        if(node == null){
            return;
        }
        node.anc_locked += val;
        for(Node i : node.child){
            change(i , val);
        }
    }
    
    static boolean lock(Node node , int id){
        if(node.isLocked||node.anc_locked > 0 || node.des_locked > 0)return false;
        Node parent = node.parent;
        while(parent != null){
            parent.des_locked += 1;
            parent = parent.parent;
        }
        change(node , 1);
        node.isLocked = true;
        node.id = id;
        return true;
    }
    
    static boolean unlock(Node node , int id){
        
        if(!node.isLocked || node.id != id){
            return false;
        }
        
        Node parent = node;
        while(parent != null){
            parent.des_locked -= 1;
            parent = parent.parent;
        }
        
        change(node , -1);
        node.isLocked = false;
        node.id = 0;
        return true;
        
    }
    
    static boolean getAllChilds(Node node , ArrayList<Node> a , int id){
        if(node == null){
            return true;
        }
        if(node.isLocked){
            if(id != node.id)
                return false;
            else
                a.add(node);
        }
        if(node.des_locked == 0){
            return true;
        }
        for(Node i : node.child){
            boolean ans = getAllChilds(i , a , id);
            if(ans == false) return false;
        }
        return true;        
    }
    
    static boolean upgrade(Node node , int id){
        if(node==null)return false;
        if(node.isLocked || node.anc_locked > 0 || node.des_locked == 0){
            return false;
        }
        ArrayList<Node> a = new ArrayList<>();
        boolean can = getAllChilds(node , a , id);
        if(!can) return false; 
        change(node , 1);
        for(Node i : a){
            unlock(i , id);
        }
        node.isLocked = true;
        node.id = id;
        return true;
    }
    
    public static void main(String[] agrs){
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        // [‘World’, ‘Asia’, ‘Africa’, ‘China’, ‘India’, ‘SouthAfrica’, ‘Egypt’],
        HashMap<String , Node> hash = new HashMap<>();
        String[] arr = new String[n];
        for(int i=0 ; i<n; i++){
            arr[i] = scn.next();
        }
        // System.out.println(Arrays.toString(arr));
        
        Node root = new Node();
        // root.str = arr[0];
        hash.put(arr[0] , root);
        
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        
        int index = 1;
        while(que.size()>0 && index < n){
    
            int size = que.size();
            while(size-- > 0){
    
                Node rem = que.remove();
                for(int i=1; i<=k && index<n ; i++){
                    Node newNode = new Node();
                    newNode.parent = rem;
                    newNode.name=arr[index];
                    hash.put(arr[index] , newNode);
                    rem.child.add(newNode);
                    que.add(newNode);
                    index+=1;
                }
                
            }
            
        }
        List<Boolean> list=new ArrayList<>();
        int q = scn.nextInt();
        for(int i=0 ; i<q; i++){
            int val = scn.nextInt();
            String str = scn.next();
            int id = scn.nextInt();
            
            boolean ans = false;
            if(val == 1){
                ans = lock(hash.get(str) , id);
            }else if(val == 2){
                ans = unlock(hash.get(str) , id);
            }else if(val == 3){
                ans = upgrade(hash.get(str) , id);
            }
            list.add(ans);
        }        
        System.out.println(list);
    }
}

// 7
// 2
// World
// Asia
// Africa
// India
// China
// SouthAfrica
// Egypt
// 5
// 1 
// China
// 9
// 1 
// India 
// 9
// 3 
// Asia
// 9
// 2
// India
// 9
// 2
// Asia
// 9
