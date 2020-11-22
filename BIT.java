import java.util.* ;
/*
What all it can do?
It can perform range sum in O(logn) 
It
 should take an array
*/ 
class FenwickTree<T extends Number> {
	private T BITadd[], BITsub[] ;
	private int max_length ;
	public FenwickTree(T arr[]) {
		max_length = arr.length + 1 ;
		BITadd = (T[]) new Object[max_length + 1] ;
		BITsub = (T[]) new Object[max_length + 1] ;
	}
	public FenwickTree(List<T> al) {
		max_length = al.size() ;
		BITadd = (T[]) new Object[max_length + 1] ;
		BITsub = (T[]) new Object[max_length + 1] ;
	}
	private void add(T arr[] , int idx , T val) {
		while (idx <= max_length) {
			arr[idx] += val ;
                        idx += idx & -idx ;
                }
        }
        private T sum(T arr[] , int idx) {
                T ret = T.valueOf("" + 0) ;
                while (idx > 0) {
                        ret += arr[idx] ;
                        idx -= idx &-idx ;
                }
                return ret ;
        }
        private T prefixSum(int idx) {
        	return sum(BITadd , idx) * T.valueOf("" + idx) - sum(BITsub , idx) ;
        }
        public void updatePoint(int idx , T val) {
        	updateRange(idx , idx , val) ;
        }
        public void updateRange(int left , int right , T val) {
        	add(BITadd , left , val) ;
        	add(BITadd , right + 1 , -val) ;
        	add(BITsub , left , T.valueOf(" " + (left - 1)) * val) ;
        	add(BITsub , right + 1 , -T.valueOf("" + right) * val) ;
        }
        public T getValueAt(int idx) {
        	return getRangeSum(idx , idx) ;
        }
        public T getRangeSum(int left , int right) {
        	return prefixSum(right) - prefixSum(left - 1) ;
        }						                                       
}
