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
}

OperandNode::~OperandNode() {
    delete left;
    delete right;
}

double OperandNode::getValue() 
{
    return constant;
}