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

    int getValue();

  private:
    int constant;
};

OperandNode::OperandNode(string str)
{
    constant = atoi(str.c_str());
}

int OperandNode::getValue() 
{
    return constant;
}