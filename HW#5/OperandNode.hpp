#pragma once
#include <iostream>
#include <string>
#include <vector>
#include "Node.hpp"

using namespace std;

vector<int> nums;

class OperandNode : public Node
{
  public:
    OperandNode(string str);
    ~OperandNode();

    virtual Rational getValue();
    void fetchInts(string str);


  private:
    Rational value;
    bool referenced = false;
    int offset;
    vector<int> mults;
};

OperandNode::OperandNode(string str)
{

    if(str.find('#') != str.npos) {
        referenced = true;
        fetchInts(str);
    }
    else {
        value = Rational(atoi(str.c_str()));
    }
}


OperandNode::~OperandNode() {
}

Rational OperandNode::getValue() 
{
    if(referenced) {
        long long int shift = 0;
        for (int i = 0; i < mults.size(); i++) {
            shift += nums[offset + i] * integerPow(10, mults[i]);
        }

        return Rational(value.up + shift);
    }
    else {
        return value;
    }
}

void OperandNode::fetchInts(string str) {
    offset = nums.size();

    for (int i = 0; i < str.length(); i++) {
        if(str[i] == '#') {
            nums.push_back(0);
            mults.push_back(str.length() - i - 1);
        }
        else {
            value.up += integerPow(10, str.length() - i - 1) * (str[i] - '0');
        }
    }
}