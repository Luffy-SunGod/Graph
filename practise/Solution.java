package practise;

import java.util.*;
class Solution{
    public static void main(String[] args) {
         Scanner s=new Scanner(System.in);
         int n=s.nextInt();
         int [][]e=new int[n-1][3];
         for(int i=0;i<e.length;i++){
            for(int j=0;j<3;j++){
                e[i][j]=s.nextInt();
            }
        }

        int q=s.nextInt();
        int [][]Queries=new int[q][2];
        for(int i=0;i<q;i++){
            for(int j=0;j<2;j++){
                Queries[i][j]=s.nextInt();
            }
        }
        int [] x=solve(n,e,q,Queries);
        System.out.println(Arrays.toString(x));
    }
    static int[] solve(int n, int[][] Edges, int Q, int[][] Queries){
         HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
         for(int i=1;i<=n;i++)map.put(i,new HashMap<>());
         List<Integer> list=new ArrayList<>();
         for(int []a:Edges){
            map.get(a[0]).put(a[1],a[2]);
            map.get(a[1]).put(a[0],a[2]);
        }
        int x[]=new int[Q];
        int idx=0;
        for(int []q:Queries){
            list=new ArrayList<>();
            if(q[0]==q[1]){
                idx++;
                continue;
            }
            bfs(map,q[0],q[1],new HashSet<>(),list);
            // System.out.println(list);
            int []nums=list.stream().mapToInt(i->i).toArray();
            int sum=findMedian(nums);
            // System.out.println(sum);
            int ans=0;
            for(int i:list){
                ans+=Math.abs(sum-i);
            }
            x[idx]=ans;
            idx++;
            
        }     
        
        return x;
     
     }

    public static boolean bfs(HashMap<Integer, HashMap<Integer, Integer>> map, int start, int des,HashSet<Integer> visited,List<Integer> list) {
        if(start==des)return true;
        visited.add(start);
        for(int i:map.get(start).keySet()){
            list.add(map.get(start).get(i));
            boolean x=false;
            if(!visited.contains(i)) x=bfs(map,i,des,visited,list);
            if(x)return true;
            else list.remove(list.size()-1);
        }
        visited.remove(start);
        return false;
    }

    public static int findMedian(int[] nums) {
        int n = nums.length;
        int k = (n + 1) / 2; // Index of the median element

        int median = quickSelect(nums, 0, n - 1, k);
        if (n % 2 == 0) {
            // If the array length is even, calculate the median of two middle elements
            int median2 = quickSelect(nums, 0, n - 1, k + 1);
            return  (median + median2) / 2;
        } else {
            // If the array length is odd, return the median directly
            return median;
        }
    }

    public static int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }

        int pivot = partition(nums, start, end);
        int pivotIndex = pivot - start + 1;

        if (k == pivotIndex) {
            return nums[pivot];
        } else if (k < pivotIndex) {
            return quickSelect(nums, start, pivot - 1, k);
        } else {
            return quickSelect(nums, pivot + 1, end, k - pivotIndex);
        }
    }

    public static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start - 1;

        for (int j = start; j <= end - 1; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, end);
        return i + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    
}


    
