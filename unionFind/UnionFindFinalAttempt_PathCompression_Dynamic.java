package prac.unionFind;

import java.util.HashMap;
import java.util.Map;

public class UnionFindFinalAttempt_PathCompression_Dynamic {

	private static Map<Integer, Integer> connections = null;
	private static Map<Integer, Integer> sizeOfTree = null;
	
	public static void main(String[] args) {
		UnionFindFinalAttempt_PathCompression_Dynamic uf = new UnionFindFinalAttempt_PathCompression_Dynamic();
		
		uf.union(40,30);
		uf.union(30,80);
		uf.union(16,15);
		uf.union(19,40);
		uf.union(2,1);
		uf.union(80,9);
		uf.union(15,0);
		uf.union(7,2);
		uf.union(16,1);
		uf.union(10,11);
		
		System.out.println(uf.find(30,19));
		System.out.println(uf.find(2,16));
		System.out.println(uf.find(30,0));
		System.out.println(uf.find(11,0));
		System.out.println("==================");
		
		uf.union(7,30);
		System.out.println(uf.find(30,19));
		System.out.println(uf.find(2,16));
		System.out.println(uf.find(30,0));
		System.out.println(uf.find(11,0));
		System.out.println("==================");

		uf.union(11,0);
		System.out.println(uf.find(11,0));
	}

	public UnionFindFinalAttempt_PathCompression_Dynamic() {
		connections = new HashMap<>();
		sizeOfTree = new HashMap<>();
	}

	private int findRoot(int num) {
		if(!connections.containsKey(num)) {
			return num;
		}
		while(num != connections.get(num)) {
			connections.put(num, connections.get(connections.get(num)));
			num = connections.get(num);
		}

		return num;
	}

	public void union(int source, int target){
		if(!connections.containsKey(source)) {
			sizeOfTree.put(source, 1);
			connections.put(source, source);
		}
		
		if(!connections.containsKey(target)) {
			sizeOfTree.put(target, 1);
			connections.put(target, target);
		}
		
		int sourceRoot = findRoot(source);
		int targetRoot = findRoot(target);
		if(sourceRoot != targetRoot) {	
			if(sizeOfTree.get(targetRoot) >= sizeOfTree.get(sourceRoot)) {
				connections.put(sourceRoot, targetRoot);
				sizeOfTree.put(targetRoot, sizeOfTree.get(targetRoot)+sizeOfTree.get(sourceRoot));		
			}
			else {
				connections.put(targetRoot, sourceRoot);
				sizeOfTree.put(sourceRoot, sizeOfTree.get(targetRoot)+sizeOfTree.get(sourceRoot));		
			}
		}
	}
	
	public boolean find(int num1, int num2){
		return findRoot(num1) == findRoot(num2);
	}
}