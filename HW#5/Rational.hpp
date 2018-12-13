#pragma once
class Rational {
    public:
    Rational();
    Rational(const long long int& num);
    Rational(const long long int& num, const long long int& denom);

    long long int up;
    long long int down;
};

long long int gcd(const long long int left, const long long int right) {
    if (right == 0) {
        return left;
    }
    else {
        return gcd(right, left % right);
    }
}

Rational::Rational() {
    up = 0;
    down = 1;
}

Rational::Rational(const long long int& num) {
    up = num;
    down = 1;
}
Rational::Rational(const long long int &num, const long long int &denom) {
    up = num;
    down = denom;
}

Rational operator+(const Rational& left, const Rational& right) {
    long long int commonDenom = left.down * right.down;
    long long int totalNum = left.up * right.down + right.up * left.down;
    long long int hmmteresting = gcd(commonDenom, totalNum);

    return Rational(totalNum / hmmteresting, commonDenom / hmmteresting);
}

Rational operator-(const Rational& left, const Rational& right) {
    long long int commonDenom = left.down * right.down;
    long long int totalNum = left.up * right.down - right.up * left.down;
    long long int hmmteresting = gcd(commonDenom, totalNum);

    return Rational(totalNum / hmmteresting, commonDenom / hmmteresting);
}

Rational operator*(const Rational& left, const Rational& right) {
    return Rational(left.up * right.up, left.down * right.down);
}

Rational operator/(const Rational& left, const Rational& right) {
    return Rational(left.up * right.down, left.down * right.up);
}
