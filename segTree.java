class SegmentTree<T extends Number> {
	T[] arr;
	long[] st, lazy ;
	int n ;
	public SegmentTree(List<T> al) {
		n = al.size() ;
		arr = al.toArray((T[])new Object[0]) ;
		st = new long[4 * n] ;
		lazy = new long[4 * n] ;
	}
	public SegmentTree(T[] arr) {
		this.arr = Arrays.copyOfRange(arr , 0 , arr.length) ;
		n = arr.length ;
		System.out.println("n = " + n) ;
		st = new long[4 * n] ;
		lazy = new long[4 * n] ;
	}
	void build(int left , int right , int si) {
		if (left == right) {
			st[si] = (long)arr[left] ;
			lazy[si] = 0 ;
			return ;
		}
		int mid = (left + right) / 2 ;
		build(left , mid , 2 * si + 1) ;
		build(mid + 1 , right , 2 * si + 2) ;
	}
	void pointUpdate(int left , int right , int val , int pos , int si) {
		rangeUpdate(left , right , val , pos , pos , si) ;
	}
	void rangeUpdate(int left , int right , int val) {
		rangeUpdate(0 , n - 1 , val , left , right , 0) ;
	}		
	void rangeUpdate(int left , int right , int val , int lquery , int rquery , int si) {
		if (lazy[si] != 0) {
			st[si] += (right - left + 1) * lazy[si];
			if (left != right) {
				lazy[2 * si + 1] += lazy[si] ;
				lazy[2 * si + 2] += lazy[si] ;
			}
			lazy[si] = 0 ;
		}
		if (rquery < left || lquery > right) {
			return ;
		} else if ( lquery <= left && right <= rquery) {
			st[si] += (right - left + 1) * (long)val ;
			if (left != right) {
				lazy[2 * si + 1] += val ;
				lazy[2 * si + 2] += val ;
			}
			return ;
		}
		int mid = (left + right) / 2 ;
		rangeUpdate(left , mid , val , lquery , Math.min(mid , rquery) , 2 * si + 1) ;
		rangeUpdate(mid + 1 , right , val , Math.max(mid + 1 , lquery) , rquery , 2 * si + 2) ;
	}
	public long rangeQuery(int left , int right) {
		return rangeQuery(0 , n - 1 , left , right , 0) ;
	}
	private long rangeQuery(int left , int right , int lquery , int rquery , int si) {
		if (lazy[si] != 0) {
			st[si] += (right - left + 1) * lazy[si] ;
			if (left != right) {
				lazy[2 * si + 1] += lazy[si] ;
				lazy[2 * si + 2] += lazy[si] ;
			}
			lazy[si] = 0 ;
		}
		if (rquery < left || lquery > right) {
			return 0L ;
		} else if ( lquery <= left && right <= rquery) {
			return st[si] ;
		}
		int mid = (left + right) / 2 ;
		return rangeQuery(left , mid , lquery , Math.min(mid , rquery) , 2 * si + 1) + 
				rangeQuery(mid + 1 , right , Math.max(mid + 1 , lquery) , rquery , 2 * si + 2) ;
	}
}
class Solution {
	public static void main(String args[]) {
		SegmentTree<Integer> st = null ;
		Scanner ip = new Scanner(System.in) ;
		int t = ip.nextInt() ;
		for (int i = 0 ; i < t;  i++) {
			int type = ip.nextInt() ;
			if (type == 1) {
				Integer arr[] = new Integer[10] ;
				st = new SegmentTree<Integer>(arr) ;
			} else if (type == 2) {
				System.out.println("Enter the range and val") ;
				int l = ip.nextInt() , r = ip.nextInt() , val = ip.nextInt() ;
				st.rangeUpdate(l , r , val) ;
			} else if (type == 3) {
				System.out.println("Enter the range") ;
				int l = ip.nextInt() , r = ip.nextInt()  ;
				System.out.println(st.rangeQuery(l , r)) ;
			}
		}
	}
}
		
