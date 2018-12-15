#pragma once
#include <iostream>

class cpScalar {
public:
    cpScalar();
    cpScalar(int num);
    cpScalar(double num);

    friend cpScalar operator +(cpScalar& left, cpScalar& right);
    friend cpScalar operator -(cpScalar& left, cpScalar& right);
    friend cpScalar operator *(cpScalar& left, cpScalar& right);
    friend cpScalar operator /(cpScalar& left, cpScalar& right);
    operator int();
    operator double();

	friend std::ostream& operator <<(std::ostream& os, const cpScalar& sc);

private:
    double value;

};

cpScalar::cpScalar() {
    this->value = 0;
}

cpScalar::cpScalar(int num) {
    this->value = num;
}

cpScalar::cpScalar(double num) {
    this->value = num;
}

cpScalar operator +(cpScalar& left, cpScalar& right) {
    cpScalar toReturn(left.value + right.value);
    return toReturn;
} 

cpScalar operator -(cpScalar& left, cpScalar& right) {
    cpScalar toReturn(left.value - right.value);
    return toReturn;
}

cpScalar operator *(cpScalar& left, cpScalar& right) {
    cpScalar toReturn(left.value * right.value);
    return toReturn;
}

cpScalar operator /(cpScalar& left, cpScalar& right) {
    cpScalar toReturn(left.value / right.value);
    return toReturn;
}

std::ostream& operator <<(std::ostream& os, const cpScalar& sc) {
	os << sc.value;
	return os;
}

cpScalar::operator int() {
    return (int)value;
}

cpScalar::operator double() {
    return value;
}