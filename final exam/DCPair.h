#ifndef DCPAIR_H_INCLUDED
#define DCPAIR_H_INCLUDED

#include <iostream>

class DCPair{
private:
    int dollar;
    int cent;
    //You may add more functions or variables.
public:
    DCPair(int a, int b);
    friend DCPair operator+(const DCPair& pairA, const DCPair& pairB);
    friend DCPair operator-(const DCPair& pairA, const DCPair& pairB);
    friend bool operator<(const DCPair& pairA, const DCPair& pairB);
    friend std::ostream& operator<<(std::ostream& os, const DCPair& dc);
    //void print();
    //You can add more functions.
};

#endif // DCPAIR_H_INCLUDED
