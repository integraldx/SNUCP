#include <iostream>
#include "cpScalar.hpp"

using namespace std;

int main() {
	cpScalar s1(10);
	cpScalar s2(5.0);

	int result1 = s1 + s2;
	int result2 = s1 - s2;
	int result3 = s1 * s2;
	int result4 = s1 / s2;

	cout << result1 << s1 + s2 << endl;
	cout << result2 << s1 - s2 << endl;
	cout << result3 << s1 * s2 << endl;
	cout << result4 << s1 / s2 << endl;

	return 0;
}
