package prac.unionFind;

public class UnionFindAttempt3 {

	private static int[] connections = null;
	private static int[] sizeOfTree = null;
	
	public static void main(String[] args) {
		UnionFindAttempt3 uf = new UnionFindAttempt3(12);
		uf.union(4,3);
		uf.union(3,8);
		uf.union(6,5);
		uf.union(9,4);
		uf.union(2,1);
		uf.union(8,9);
		uf.union(5,0);
		uf.union(7,2);
		uf.union(6,1);
		uf.union(10,11);
		
		System.out.println(uf.find(3,9));
		System.out.println(uf.find(2,6));
		System.out.println(uf.find(3,0));
		System.out.println(uf.find(11,0));
		
		uf.union(7,3);
		
		System.out.println(uf.find(3,9));
		System.out.println(uf.find(2,6));
		System.out.println(uf.find(3,0));
		System.out.println(uf.find(11,0));
	}

	public UnionFindAttempt3(int size) {
		connections = new int[size];
		sizeOfTree = new int[size];
		
		for(int i=0;i<size;i++) {
			connections[i] = i;
			sizeOfTree[i] = 1;
		}
	}

	private int findRoot(int num) {
		while(connections[num] != num) {
			num = connections[num];
		}
		
		return num;
	}

	public void union(int source, int target){
		int sourceRoot = findRoot(source);
		int targetRoot = findRoot(target);
		if(sourceRoot != targetRoot) {	
			if(sizeOfTree[targetRoot] >= sizeOfTree[sourceRoot]) {
				connections[sourceRoot] = targetRoot;
				sizeOfTree[targetRoot] += sizeOfTree[sourceRoot];			
			}
			else {
				connections[targetRoot] = sourceRoot;
				sizeOfTree[sourceRoot] += sizeOfTree[targetRoot]; 
			}
		}
	}
	
	public boolean find(int num1, int num2){
		return findRoot(num1) == findRoot(num2);
	}
}