#include <iostream>

class cpScalar {
public:
    cpScalar(int num);
    cpScalar(double num);

    cpScalar operator +(cpScalar scalar);
    cpScalar operator -(cpScalar scalar);
    cpScalar operator *(cpScalar scalar);
    cpScalar operator /(cpScalar scalar);
    operator int();
    operator double();

	friend std::ostream& operator <<(std::ostream& os, const cpScalar& sc);

private:
    double value;

};

cpScalar::cpScalar(int num) {
    this->value = num;
}

cpScalar::cpScalar(double num) {
    this->value = num;
}

cpScalar cpScalar::operator +(cpScalar scalar) {
    cpScalar toReturn(value + scalar.value);
    return toReturn;
} 

cpScalar cpScalar::operator -(cpScalar scalar) {
    cpScalar toReturn(value - scalar.value);
    return toReturn;
}

cpScalar cpScalar::operator *(cpScalar scalar) {
    cpScalar toReturn(value * scalar.value);
    return toReturn;
}

cpScalar cpScalar::operator /(cpScalar scalar) {
    cpScalar toReturn(value / scalar.value);
    return toReturn;
}

std::ostream& operator<<(std::ostream& os, const cpScalar& sc) {
	os << sc.value;
	return os;
}

cpScalar::operator int() {
    return (int)value;
}
