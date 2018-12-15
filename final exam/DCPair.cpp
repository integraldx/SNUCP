#include <iostream>
#include "DCPair.h"

DCPair::DCPair(int a, int b) {
    dollar = a;
    cent = b;

    if(cent >= 100) {
        dollar++;
        cent = cent % 100;
    }
    else if (cent <= -100) {
        dollar--;
        cent = cent % 100;
    }

    if(dollar < 0 && cent > 0) {
        dollar++;
        cent -= 100;
    }
    else if (dollar > 0 && cent < 0)  {
        dollar--;
        cent += 100;
    }
}

DCPair operator+(const DCPair& pairA, const DCPair& pairB) {
    int dollar;
    int cent;
    dollar = pairA.dollar + pairB.dollar;
    cent = pairA.cent + pairB.cent;

    if(cent >= 100) {
        dollar++;
        cent = cent % 100;
    }
    else if (cent <= -100) {
        dollar--;
        cent = cent % 100;
    }

    if(dollar < 0 && cent > 0) {
        dollar++;
        cent -= 100;
    }
    else if (dollar > 0 && cent < 0)  {
        dollar--;
        cent += 100;
    }
    return DCPair(dollar, cent);
}
DCPair operator-(const DCPair& pairA, const DCPair& pairB) {
    int dollar;
    int cent;
    dollar = pairA.dollar - pairB.dollar;
    cent = pairA.cent - pairB.cent;
    if(cent >= 100) {
        dollar++;
        cent = cent % 100;
    }
    else if (cent <= -100) {
        dollar--;
        cent = cent % 100;
    }

    if(dollar < 0 && cent > 0) {
        dollar++;
        cent -= 100;
    }
    else if (dollar > 0 && cent < 0)  {
        dollar--;
        cent += 100;
    }
    return DCPair(dollar, cent);
}
bool operator<(const DCPair& pairA, const DCPair& pairB) {
    if(pairA.dollar < pairB.dollar) {
        return true;
    }
    else if (pairA.dollar == pairB.dollar) {
        if(pairA.cent < pairB.cent) {
            return true;
        }
        else {
            return false;
        }
    }
    else {
        return false;
    }

}
std::ostream& operator<<(std::ostream& os, const DCPair& dc) {
    if(dc.dollar >= 0) {
        os << dc.dollar << '.' << dc.cent;
    }
    else {
        os << '-' << dc.dollar << '.' << dc.cent;
    }

    return os;

}