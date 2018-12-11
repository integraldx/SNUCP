#pragma once

#include <string>
#include <iostream>
#include <memory>
#include <vector>
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

    vector<int> seperators;

};

StringNumIterator::StringNumIterator(string str)
{
    orignalString = str;
    bool succesive = true;

    for (int i = 0; i < str.length(); i++) {
        char ch = str[i];

        if (ch == '[')
        {
            boxCount++;
            if (!succesive) {
                seperators.push_back(boxCount);
            }
            succesive = true;
        }
        else if (ch != ']') {
            succesive = false;
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
        else if (ch == ' ')
        {
            
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
    int sepCount = 0;

    for (int i = 0; i < boxCount - 1; i++) {
        toReturn.push_back(boxes[i] + '0');
        if(seperators[sepCount] - 2 == i) {
            toReturn.push_back(',');
            toReturn.push_back(' ');
            sepCount++;
        }
    }

    toReturn.push_back(boxes[boxCount - 1] + '0');


    return toReturn;
}