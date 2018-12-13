#pragma once

#include <string>
#include <iostream>
#include <memory>
#include <vector>
#include "Node.hpp"

using namespace std;

class StringPreprocessor
{
  public:
    StringPreprocessor(string str);
    ~StringPreprocessor();
    string getProcessedString();

  private:
    string orignalString;
    int boxCount = 0;
    char *boxes;
    long long int iterationCount = 0;

    vector<int> seperators;

};

StringPreprocessor::StringPreprocessor(string str)
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

StringPreprocessor::~StringPreprocessor() {
    delete boxes;
}

string StringPreprocessor::getProcessedString()
{
    string toReturn;
    bool inBox = false;

    for(char ch : orignalString) {
        switch(ch) {
            case '[':
            toReturn.push_back('#');
            inBox = true;
            break;

            case ' ':
            case ']':
            break;

            default:
            toReturn.push_back(ch);
            break;
        }
    }
    return toReturn;
}
