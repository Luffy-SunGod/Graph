package practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
   int data;
   Node left;
   Node right;
   public Node(int data){
    this.data=data;
    this.left=null;
    this.right=null;
   }        
}
public class Tree {
    public static   Node build_tree(String s){
      if(s.length()==0||s.charAt(0)=='N')return null;
      String arr[]=s.split(" ");
       Node root=new Node(Integer.parseInt(arr[0]));
      int i=1;
      Queue<Node>q =new LinkedList<>();
      q.add(root);
      while(!q.isEmpty()&&i<arr.length){
            Node rv=q.remove();
            if(!arr[i].equals("N")){
                rv.left=new Node(Integer.parseInt(arr[i]));
                q.add(rv.left);
            }
            i++;
            if(i>arr.length)break;
            if(!arr[i].equals("N")){
                rv.right=new Node(Integer.parseInt(arr[i]));
                q.add(rv.right);
            }
            i++;
        }

        return root;
   }
   public static void main(String[] args) throws IOException {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       String s=br.readLine();
       Node root=build_tree(s);
       display(root);
    }

    public static void display(Node root){
        if(root==null)return ;
        String s="<-"+root.data+"->";
        if(root.left!=null){
            s=root.left.data+s;
        }else s="null"+s;
        if(root.right!=null){
            s=s+root.right.data;
        }else s=s+"null";
        System.out.println(s);
        display(root.left);
        display(root.right);
    }

}

