// old code check UnionFindAttempt4
package prac.unionFind;

public class UnionFindOptimized {

	private static final int size = 12;
	private static int[] arr = new int[size];
	private static int[] childArr = new int[size];
	
	public static void main(String[] args) {
		init();
		union(4,3);
		union(3,8);
		union(6,5);
		union(9,4);
		union(2,1);
		union(5,0);
		union(7,2);
		union(6,1);
		union(7,3);
		
		union(10,11);
		
		System.out.println(connected(3,0));
		System.out.println(connected(11,0));
	}

	private static void union(int n1, int n2) {
		int root1 = root(n1);
		int root2 = root(n2);
		if(childArr[root1]>=childArr[root2]){
			arr[root2] = root1;
			childArr[root1] += childArr[root2];
		}
		else{
			arr[root1] = root2;
			childArr[root2] += childArr[root1];
		}
	}

	private static int root(int n) {
		while(arr[n] != n)
			n = arr[n];
		return n;
	}

	private static void init() {
		for(int i=0;i<size;i++){
			arr[i] = i;
			childArr[i] = 1;
		}
	}

	private static boolean connected(int n1, int n2) {
		int root1 = root(n1);
		int root2 = root(n2);
		if(root1 == root2){ // improvement 2 as discussed in robert sedgewick video. here while searching we point the lower leaves to root to minimize search time 
			arr[n1] = root1;
			arr[n2] = root1;
			return true;
		}
		return false;
	}
}

