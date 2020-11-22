import java.util.Scanner ;
import java.util.Random ;
class Vector<T> {
	private int idx = 0 , max_idx  = 0 ;
	private T arr[] ;
	public Vector(T arr[]) {
		max_idx = Integer.highestOneBit(arr.length) << 1;
		this.arr = (T[])new Object[max_idx] ;
		for (int i = 0 ; i < arr.length ; i++) {
			this.arr[i] = arr[i] ;
		}
		idx = arr.length ;
	}
	public Vector() {
		/*Initial size of the array is fixed to 2
		 */
		max_idx = 2 ;
		this.arr = (T[])new Object[max_idx] ;
	}

	/*
	 *Similar to add function in ArrayList
	 *Adda an element at the end of the vector
	 */

	public boolean push_back(T val) {
		if (idx == max_idx) {
			//allocate a new array
			T temp[] = this.arr ;
			max_idx <<= 1 ;
			this.arr = (T[]) new Object[max_idx] ;
			for (int i = 0 ; i <idx ; i++) {
				this.arr[i] = temp[i] ;
			}
				
		}
		arr[idx++] = val ;
		return true ;	
	}

	/*
	 * Return the size of the vector
	 */

	public int size() {
		return idx ;
	}

	/*
	 * Deletes the last element of the vector
	 */
	public boolean pop_back() throws ArrayIndexOutOfBoundsException {
		if (idx == 0) {
			throw new ArrayIndexOutOfBoundsException() ;
		}
		--idx ;
		return true ;
	}

	/*
	 * Returns the last element of the vector
	 */

	public T back() throws ArrayIndexOutOfBoundsException {
		if(idx == 0) {
			throw new ArrayIndexOutOfBoundsException() ;
		}
		return arr[idx - 1] ;
	}
	
	/*
	 * Inserts an element at the specified position
	 */

	public boolean insert(int index , T val) throws ArrayIndexOutOfBoundsException {
		if (!check(index)) {
			throw new ArrayIndexOutOfBoundsException() ;
		}
		if (idx1 == max_idx - 1) {
			max_idx <<= 1 ;
			System.arraycopy(arr , index , arr , index + 1 , idx - index) ;
			arr[index] = val ;
		} else {
			System.arraycopy(arr , index , arr , index + 1 , idx - index) ;
			arr[index] = val ;
		}
		idx++ ;
	}

	/*
	 * Returns the first element of the vector
	 */
		
	public T front() throws ArrayIndexOutOfBoundsException {
		if (empty()) {
			throw new ArrayIndexOutOfBoundsException() ;
		}
		return arr[0] ;
	}

	/*
	 * Checks whether the vector is empty or not
	 */	

	public boolean empty() {
		return idx == 0 ;
	}

	/*
	 * Swaps the contents of the elements
	 */
	public void swap(int idx1 , int idx2) throws ArrayIndexOutOfBoundsException {
		if (!(check(idx1) && check(idx2))) {
			throw new ArrayIndexOutOfBoundsException() ;
		}
		T temp = arr[idx1] ;
		arr[idx1] = arr[idx2] ;
		arr[idx2] = temp ;
	}
	public void clear() {
		idx = 0 ;
	       	max_idx = 2 ;
		arr = (T[]) new Object[max_idx] ;
	}

	/*
	 * Returns the Stringified value of the vector
	 * Used to print the vector
	 */
	
	public String toString() {
		StringBuilder sb = new StringBuilder() ;
		for (int i = 0 ; i < idx ; i++) {
			sb.append(arr[i] + " ") ;
		}
		return sb.toString() ;
	}
		
}
class Solution {
	public static void main(String args[]) {
		
		Vector<Integer> v = new Vector<>() ;
		Scanner ip =new Scanner(System.in) ;
		int t = ip.nextInt() ;
		for (int i = 0 ; i < t ; i++) {
			int n = ip.nextInt() ;
			v.push_back(n) ;
		}
	}
}













