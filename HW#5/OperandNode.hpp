#pragma once
#include <iostream>
#include <string>
#include <vector>

using namespace std;

class OperandNode : public Node
{
  public:
    OperandNode(string str);
    ~OperandNode();

    virtual double getValue();

  private:
    int constant;
};

OperandNode::OperandNode(string str)
{
    constant = atoi(str.c_str());


    if(constant == 0 && (str.length() != 1)) {
        throw "ZERO";
    }
    else if (integerPow(10, str.length() - 1) > constant) {
        throw "LENGTH MISMATCH";
    }
}

OperandNode::~OperandNode() {
}

double OperandNode::getValue() 
{
    return constant;
}