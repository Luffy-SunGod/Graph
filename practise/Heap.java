package practise;
import java.util.*;
class Pq{
    ArrayList<Integer> list;
    public Pq(){
       this.list=new ArrayList<>();
    }
    public void add(int e){
        this.list.add(e);
        upheapify(this.list.size()-1);
    }
    public int remove(){
        swap(0,this.list.size()-1);
        int x=list.remove(list.size()-1);
        downheapify(0);
        return x;
        
    }
    public int peek(){
        return this.list.get(0);
    }

    private void downheapify(int pi){
        int leftchild=2*pi+1;
        int rightchild=2*pi+2;
        int mini=pi;
        if(rightchild<this.list.size()&&list.get(rightchild)<list.get(mini))mini=rightchild;
        if(leftchild<this.list.size()&&list.get(leftchild)<list.get(mini))mini=leftchild;
        if(mini!=pi){
            swap(mini,pi);
            downheapify(mini);
        }
        
    }
    private void upheapify(int ci) {
        int pi=(ci-1)/2;
        if(list.get(pi)>list.get(ci)){
            swap(pi,ci);
            upheapify(pi);
        }

    }
    private void swap(int pi, int ci) {
        int l=list.get(pi);
        int m=list.get(ci);
        list.set(pi, m);
        list.set(ci, l);
    }
    public int size(){
        return this.list.size();
    }
    public void display(){
        System.out.println(this.list);
    }

}
public class Heap {
    public static void main(String[] args) {
        Pq pq=new Pq();
        pq.add(25);
        pq.add(57);
        pq.add(48);
        pq.add(36);
        pq.add(12);
        pq.add(91);
        pq.add(86);
        pq.add(32);
        pq.display();
        int n=pq.size();
        
        for(int i=0;i<n;i++){
            if(pq.size()>0)System.out.println(pq.remove());
        }
    }
}
