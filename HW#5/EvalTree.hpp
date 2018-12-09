#pragma once 

#include <iostream>
#include <string>
#include <algorithm>
#include <math.h>
#include "Node.hpp"
#include "OperatorNode.hpp"
#include "OperandNode.hpp"

using namespace std;

class EvalTree {
    public:

    EvalTree(string str);
    ~EvalTree();

    bool evaluate();
    bool evaluate(int nums[], int size);
    int getBraketNum();

    private:
    Node* root;
    int result;


};

EvalTree::EvalTree(string str) {
    auto wat = str.find_last_of('=');
    string resultStr = str.substr(wat + 1, str.length() - wat);
    result = atoi(resultStr.c_str());
    
    string calc = str.substr(0, wat);

    
    if (Node::isThereOperators(calc)) {
        root = new OperatorNode(calc);
    }
    else {
        root = new OperandNode(calc);
    }
}

EvalTree::~EvalTree() {
    delete root;
}

bool EvalTree::evaluate() {
    double calcVal = root->getValue();
    if(abs(calcVal - result) < 0.0005) {
        return true;
    }
    else {
        return false;
    }
}