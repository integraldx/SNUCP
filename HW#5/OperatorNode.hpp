#pragma once
#include <string>
#include "Node.hpp"

enum Op {ADD, SUB, MUL, DIV, MOD, POW};
int opOrder[] = {4, 4, 3, 3, 2, 1};

class OperatorNode : public Node{
    public:
    OperatorNode(string str);
    ~OperatorNode();


};

