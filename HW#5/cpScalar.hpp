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

cpScalar::operator int() {
    return value;
}