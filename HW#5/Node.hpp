#pragma once

#include <string>

using namespace std;
class Node
{
  public:
    static bool isThereOperators(string str)
    {
        bool toReturn = false;
        for (char ch : str)
        {
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^' || ch == '%')
            {
                toReturn = true;
            }
        }

        return toReturn;
    }
    virtual double getValue() = 0;

  protected:
    Node *left;
    Node *right;
};

int integerPow(int a, int n) {
    if(n == 1) {
        return a;
    }
    else if (n == 0) {
        return 1;
    }
    else {
        if(n % 2 == 1) {
            return integerPow(a, n / 2) * integerPow(a, n / 2 + 1);
        }
        else {
            return integerPow(a, n / 2) * integerPow(a, n / 2);
        }
    }
}