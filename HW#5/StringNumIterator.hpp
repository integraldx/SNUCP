#pragma once

#include <string>
#include <iostream>
#include <memory>
#include "Node.hpp"

using namespace std;

class StringNumIterator
{
  public:
    StringNumIterator(string str);
    ~StringNumIterator();
    string getNext();
    bool isEnd();
    string getBoxNumString();

  private:
    string orignalString;
    int boxCount = 0;
    char *boxes;
    long long int iterationCount = 0;

};

StringNumIterator::StringNumIterator(string str)
{
    orignalString = str;

    for (char ch : str)
    {
        if (ch == '[')
        {
            boxCount++;
        }
    }

    boxes = (char *)calloc(boxCount, sizeof(char));

    for (int i = 0; i < boxCount; i++)
    {
        boxes[i] = 0;
    }

}

StringNumIterator::~StringNumIterator() {
    delete boxes;
}

string StringNumIterator::getNext()
{
    if (iterationCount != 0)
    {
        bool carry = false;
        boxes[boxCount - 1]++;

        if (boxes[boxCount - 1] >= 10)
        {
            carry = true;
            boxes[boxCount - 1] %= 10;
        }
        for (int i = boxCount - 2; i >= 0; i--)
        {
            if (carry)
            {
                boxes[i]++;
                carry = false;
            }

            if (boxes[i] >= 10)
            {
                carry = true;
                boxes[i] = boxes[i] % 10;
            }

        }
    }

    string toReturn;
    bool box = false;
    int i = 0;
    for (char ch : orignalString)
    {
        if (box)
        {
            box = false;
            continue;
        }

        if (ch == '[')
        {
            toReturn.push_back(boxes[i] + '0');
            box = true;
            i++;
        }
        else
        {
            toReturn.push_back(ch);
        }
    }

    iterationCount++;
    return toReturn;
}

bool StringNumIterator::isEnd()
{
    if (iterationCount == integerPow(10, boxCount))
    {
        return true;
    }
    else
    {
        return false;
    }
}

string StringNumIterator::getBoxNumString() {
    string toReturn;

    for (int i = 0; i < boxCount; i++) {
        toReturn.push_back(boxes[i] + '0');
        toReturn.push_back(' ');
    }

    return toReturn;
}