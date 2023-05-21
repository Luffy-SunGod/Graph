package practise;

import java.util.*;

public   class Dsu{
   int []parent; 
   int []rank; 
   int []size;
   public Dsu(int n){
       this.parent=new int[n];
       for(int i=0;i<n;i++)parent[i]=i;
       this.rank=new int[n];
       this.size=new int[n];
       Arrays.fill(size,1);
   } 
   public int findParent(int node){
       if(node==parent[node])return node;
       return parent[node]=findParent(parent[node]);
   }
   public void union(int a,int b){
       int ulp_a=findParent(a);
       int ulp_b=findParent(b);
       if(ulp_a==ulp_b)return;
       if(rank[ulp_a]>rank[ulp_b]){
           parent[ulp_b]=ulp_a;
       }else if(rank[ulp_b]>rank[ulp_a]){
           parent[ulp_a]=ulp_b;
       }else {
           parent[ulp_b]=ulp_a;
           rank[ulp_a]++;
       }
   }
   public void display(){
       System.out.println(Arrays.toString(this.parent));
   }

   public void unionBySize(int a,int b){
       int ulp_a=findParent(a);
       int ulp_b=findParent(b);
       if(ulp_a==ulp_b)return;
       if(size[ulp_b]>size[ulp_a]){
            parent[ulp_a]=ulp_b;
           size[ulp_b]+=size[ulp_a];
       }else {
           parent[ulp_b]=ulp_a;
          size[ulp_a]+=size[ulp_b];
       }
   }        
   public static void main(String[] args) {
        Dsu ds=new Dsu(10);
        System.out.println(ds);
        
   }
}
