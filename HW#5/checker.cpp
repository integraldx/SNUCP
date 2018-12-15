#include "cpScalar.hpp"
#include "cpVector.hpp"

using namespace std;

int main()
{
	cpScalar s1(10);
	cpScalar s2(5);
	cpScalar s3(5.0);
	cpScalar s8(5.3);
	cpScalar s4(6);
	cpScalar s5(3);
	cpScalar s6(5);
	cpScalar s7(4);
	cpScalar s_arr[4];
	cpScalar s_arr2[5];
	for (int i=0; i<4; i++) {
		s_arr[i] = cpScalar(i+1);
	}
	for (int i=0; i<5; i++) {
		s_arr2[i] = cpScalar(i+1);
	}
	cpVector v1(s_arr, 4);
	cpVector v2(s_arr2, 5);
	cout << "scalar print : " << endl <<"eresult : 10" << endl << "rresult : " << s1 << endl;
	cout << "scalar print2 : " << endl <<"eresult : 5" << endl << "rresult : " << s2 << endl;
	cout << "scalar print3 : " << endl <<"eresult : 5" << endl << "rresult : " << s3 << endl;
	cout << "scalar print4 : " << endl <<"eresult : 5.3" << endl << "rresult : " << s8 << endl;
	cout << "vector print : " << endl <<"eresult : [1, 2, 3, 4]" << endl << "rresult : " << v1 << endl;
	cout << "vector print2 : " << endl <<"eresult : [1, 2, 3, 4, 5]" << endl << "rresult : " << v2 << endl;
	cout << "scalar plus" << endl << "eresult : 15" << endl << "rresult : "<< s1 + s2 << endl;
	cout << "scalar plus2" << endl << "eresult : 10.3" << endl << "rresult : "<< s2 + s8 << endl;
	cout << "scalar minus" << endl << "eresult : 5" << endl << "rresult : "<< s1 - s2 << endl;
	cout << "scalar minus2" << endl << "eresult : 0.3" << endl << "rresult : "<< s8 - s2 << endl;
	cout << "scalar multiply" << endl << "eresult : 50" << endl << "rresult : "<< s1 * s2 << endl;
	cout << "scalar multiply2" << endl << "eresult : 53" << endl << "rresult : "<< s1 * s8 << endl;
	cout << "scalar multiply3" << endl << "eresult : 26.5" << endl << "rresult : "<< s2 * s8 << endl;
	cout << "scalar divide" << endl << "eresult : 0.5" << endl << "rresult : "<< s2 / s1 << endl;
	cout << "vector plus" << endl << "eresult : [2, 4, 6, 8]" << endl << "rresult : "<< v1 + v1 << endl;
	cout << "vector minus" << endl << "eresult : [0, 0, 0, 0]" << endl << "rresult : "<< v1 - v1 << endl;
	cout << "vector multiply" << endl << "eresult : 30" << endl << "rresult : "<< v1 * v1 << endl;
	cout << "vector divide" << endl << "eresult : [0.1, 0.2, 0.3, 0.4]" << endl << "rresult : "<< v1 / v1 << endl;
	cout << "scalar - vector" << endl << "eresult : 0" << endl << "rresult : "<< s1 - v1 << endl;
	cout << "vector - scalar" << endl << "eresult : [-9, -8, -7, -6]" << endl << "rresult : "<< v1 - s1 << endl;
	cout << "scalar + vector" << endl << "eresult : [11, 12, 13, 14]" << endl << "rresult : "<< s1 + v1 << endl;
	cout << "vector + scalar" << endl << "eresult : [11, 12, 13, 14]" << endl << "rresult : "<< v1 + s1 << endl;
	cout << "scalar * vector" << endl << "eresult : [10, 20, 30, 40]" << endl << "rresult : "<< s1 * v1 << endl;
	cout << "vector * scalar" << endl << "eresult : [10, 20, 30, 40]" << endl << "rresult : "<<v1 * s1 << endl;
	cout << "scalar / vector" << endl << "eresult : 0.333333" << endl << "rresult : "<< s2 / v2 << endl;
	cout << "vector / scalar" << endl << "eresult : [0.2, 0.4, 0.6, 0.8, 1]" << endl << "rresult : "<< v2 / s2 << endl;
}

