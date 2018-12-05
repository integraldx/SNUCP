#include <iostream>
#include "cpScalar.hpp"
#include "cpVector.hpp"

using namespace std;

int main()
{
	cpScalar s1(10);
	cpScalar s2(5.0);
	cpScalar arr1[] = {cpScalar(1.0), cpScalar(2.0), cpScalar(3.0)};
	cpVector v1(arr1, 3);
	cpScalar arr2[] = {cpScalar(6.0), cpScalar(5.0), cpScalar(4.0)};
	cpVector v2(arr2, 3);

	int result1 = s1 + s2;
	int result2 = s1 - s2;
	int result3 = s1 * s2;
	int result4 = s1 / s2;

	cout << v1 << endl;
	cout << v1 + s1 << endl;
	cout << v1 - s1 << endl;
	cout << v1 * s1 << endl;
	cout << v1 / s1 << endl;

	// cout << result1 << " " << s1 + s2 << endl;
	// cout << result2 << " " << s1 - s2 << endl;
	// cout << result3 << " " << s1 * s2 << endl;
	// cout << result4 << " " << s1 / s2 << endl;

	return 0;
}
