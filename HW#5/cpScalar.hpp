#include <iostream>

class cpScalar {
public:
    cpScalar(int num);
    cpScalar(double num);

private:
    int value;
    double value;

};

cpScalar::cpScalar(int num) {
    this->value = num;
}

cpScalar::cpScalar(double num) {
    this->value = num;
}
