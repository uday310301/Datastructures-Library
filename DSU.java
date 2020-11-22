import java.util.* ;
class DSU {
	int parent[] ;
	int rank[] ;
	int size ;
	public DSU(int n) {
		size = n ;
		parent = new int[n] ;
		size = new int[n] ;
		for (int i = 0 ; i < n ; i++) {
			parent[i] = i ;
			rank[i] = 1 ;
		}
	}
	public int find(int a) {
		if (parent[a] != a) {
			parent[a] = find(parent[a]) ;
		}
		return parent[a] ;
	}
	public void union(int a , int b) {
		int x = find(a) ;
		int y = find(b) ;
		if (x == y) {
			continue ;
		}
		if (rank[x] < rank[y]) {
			rank[y] += rank[x] ;
			parent[x] = y ;
		} else {
			rank[x] += rank[y] ;
			parent[y] = x ;
		}
	}
	boolean isConnected(int a , int b) {
		return find(a) == find(b) ;
	}
}
	