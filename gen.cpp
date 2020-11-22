#include <bits/stdc++.h>
using namespace std ;
int main() {
	int n ;
	n = rand() % 1000000 ;
	cout << n << "\n" ;
	for (int i = 0 ; i < n ; i++) {
		cout << rand() << " " ;
	}
	return 0 ;
}
