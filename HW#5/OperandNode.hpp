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

    virtual Rational getValue();

  private:
    Rational value;
};

OperandNode::OperandNode(string str)
{
    value = Rational(atoi(str.c_str()));
}

OperandNode::~OperandNode() {
}

Rational OperandNode::getValue() 
{
    return value;
}