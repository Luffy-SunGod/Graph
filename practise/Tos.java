package practise;

// import java.util.*;

// public class Tos {
//     static class Node{
// 		String name;
// 		int id;
// 		boolean isLocked;
// 		Node parent;
// 		ArrayList<Node> child=new ArrayList<>();
// 		int ancestor_locked;
// 		int desc_locked;
// 		public String toString() {return ""+this.name;}
// 	}
	
// 	public static void change(Node node,int val) {
// 		if(node==null)return;
// 		node.ancestor_locked+=val;
// 		for(Node n:node.child)change(n, val);
// 	}
	
// 	public static boolean lock(Node node,int id) {
// 		if(node==null||node.isLocked||node.ancestor_locked>0||node.desc_locked>0)return false;
		
// 		Node parent=node.parent;
// 		while(parent!=null) {
// 			parent.desc_locked+=1;
// 			parent=parent.parent;
// 		}
// 		Node root=node;
// 		change(root, 1);
// 		node.isLocked=true;
// 		node.id=id;
// 		return true;
// 	}
// 	public static boolean unLock(Node node,int id) {
// 		if(!node.isLocked||node.id!=id)return false;
// 		Node parent=node.parent;
// 		while(parent!=null) {
// 			parent.desc_locked-=1;
// 			parent=parent.parent;
// 		}
// 		Node root=node;
// 		change(root, -1);
// 		node.isLocked=false;
// 		node.id=0;
// 		return true;
// 	}
	
// 	public static boolean getAllChilds(Node node,ArrayList<Node> a,int id) {
// 		if(node==null)return true;
		
// 		if(node.isLocked) {
// 			if(node.id!=id)return false;
// 			else a.add(node);
// 		}
// 		if(node.desc_locked==0)return true;
		
// 		for(Node n:node.child) {
// 			boolean isPossible=getAllChilds(n, a, id);
// 			if(!isPossible)return false;
// 		}
		
// 		return true;
		
// 	}
// 	public static boolean upGrade(Node node,int id) {
// 		if(node==null)return false;
// 		if(node.isLocked||node.ancestor_locked>0||node.desc_locked==0)return false;
// 		ArrayList<Node> a=new ArrayList<>();
		
// 		boolean isPossible=getAllChilds(node,a,id);
// 		if(!isPossible)return false;
		
// 		for(Node n:a) {
// 			unLock(n, id);
// 		}
// 		node.isLocked=true;
// 		node.id=id;
// 		return true;
// 	}
	
// 	public static void main(String[] args) {
// 		Scanner s=new Scanner(System.in);
// 		int n=s.nextInt();
// 		int k=s.nextInt();
		
// 		String arr[]=new String[n];
// 		HashMap<String, Node> map=new HashMap<>();
// 		for(int i=0;i<n;i++)arr[i]=s.next();
		
// 		Node rootNode=new Node();
// 		map.put(arr[0], rootNode);
// 		Queue<Node> queue=new LinkedList<>();
// 		queue.add(rootNode);
// 		int index=1;
// 		while(!queue.isEmpty()&&index<n) {
// 			int size=queue.size();
// 			while(size-->0) {
// 				Node rvNode=queue.remove();
// 				for(int i=1;i<=k&&index<n;i++) {
// 					Node newNode=new Node();
// 					map.put(arr[index], newNode);
// 					newNode.parent=rvNode;
// 					rvNode.child.add(newNode);
// 					index+=1;
// 					queue.add(newNode);
// 				}
// 			}
// //			System.out.println("lv1");
// 		}
// //		System.out.println("lv2");
// 		ArrayList<Boolean> list=new ArrayList<>();
// 		int query=s.nextInt();
// 		for(int i=1;i<=query;i++) {
// 			// System.out.println(i);
// 			int value=s.nextInt();
// 			String str=s.next();
// 			int id=s.nextInt();
// 			boolean ans=false;
// 			if(value==1) {
// 				ans=lock(map.get(str),id);
// 			}else if(value==2) {
// 				ans=unLock(map.get(str),id);
				
// 			}else {
// 				ans=upGrade(map.get(str),id);
// 			}
// 			list.add(ans);
// 			// System.out.println(ans);
// 		}
// 		System.out.println(list);
// 	}

  
// }

import java.util.*;
import java.util.concurrent.*;

public class Tos {
    static class Node {
        String name;
        int id;
        boolean isLocked;
        Node parent;
        ArrayList<Node> child = new ArrayList<>();
        int ancestor_locked;
        int desc_locked;

        public synchronized String toString() {
            return "" + this.name;
        }
    }

    public static synchronized void change(Node node, int val) {
        if (node == null)
            return;
        node.ancestor_locked += val;
        for (Node n : node.child)
            change(n, val);
    }

    public static synchronized boolean lock(Node node, int id) {
        if (node == null || node.isLocked || node.ancestor_locked > 0 || node.desc_locked > 0)
            return false;

        Node parent = node.parent;
        while (parent != null) {
            parent.desc_locked += 1;
            parent = parent.parent;
        }
        Node root = node;
        change(root, 1);
        node.isLocked = true;
        node.id = id;
        return true;
    }

    public static synchronized boolean unLock(Node node, int id) {
        if (!node.isLocked || node.id != id)
            return false;
        Node parent = node.parent;
        while (parent != null) {
            parent.desc_locked -= 1;
            parent = parent.parent;
        }
        Node root = node;
        change(root, -1);
        node.isLocked = false;
        node.id = 0;
        return true;
    }

    public static synchronized boolean getAllChilds(Node node, ArrayList<Node> a, int id) {
        if (node == null)
            return true;

        if (node.isLocked) {
            if (node.id != id)
                return false;
            else
                a.add(node);
        }
        if (node.desc_locked == 0)
            return true;

        for (Node n : node.child) {
            boolean isPossible = getAllChilds(n, a, id);
            if (!isPossible)
                return false;
        }

        return true;
    }

    public static synchronized boolean upGrade(Node node, int id) {
        if (node == null)
            return false;
        if (node.isLocked || node.ancestor_locked > 0 || node.desc_locked == 0)
            return false;
        ArrayList<Node> a = new ArrayList<>();

        boolean isPossible = getAllChilds(node, a, id);
        if (!isPossible)
            return false;

        for (Node n : a) {
            unLock(n, id);
        }
        node.isLocked = true;
        node.id = id;
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();

        String arr[] = new String[n];
        HashMap<String, Node> map = new HashMap<>();
        for (int i = 0; i < n; i++)
            arr[i] = s.next();

        Node rootNode = new Node();
        map.put(arr[0], rootNode);
        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);
        int index = 1;
        while (!queue.isEmpty() && index < n) {
            int size = queue.size();
            while (size-- > 0) {
                Node rvNode = queue.remove();
                for (int i = 1; i <= k && index < n; i++) {
                    Node newNode = new Node();
                    map.put(arr[index], newNode);
                    newNode.parent = rvNode;
                    rvNode.child.add(newNode);
                    index += 1;
                    queue.add(newNode);
                }
            }
        }

        int query = s.nextInt();
        List<Callable<Boolean>> tasks = new ArrayList<>();

        for (int i = 1; i <= query; i++) {
            int value = s.nextInt();
            String str = s.next();
            int id = s.nextInt();

            Callable<Boolean> task = () -> {
                boolean ans = false;
                if (value == 1) {
                    ans = lock(map.get(str), id);
                } else if (value == 2) {
                    ans = unLock(map.get(str), id);
                } else {
                    ans = upGrade(map.get(str), id);
                }
                return ans;
            };

            tasks.add(task);
        }

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try {
            List<Future<Boolean>> results = executor.invokeAll(tasks);
            List<Boolean> list = new ArrayList<>();
            for (Future<Boolean> result : results) {
                list.add(result.get());
            }
            System.out.println(list);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
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