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

    bool isEnd();
    void moveNext();

    friend OperandNode;

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
    // for (int i = 0; i < nums.size(); i++)
    // {
    //     cout << nums[i] << ", ";
    // }

    // cout << endl;

    Rational calcVal;
    try {
        calcVal = root->getValue();
    }
    catch(const char*& str) {
        return false;
    }
    if((calcVal.up % calcVal.down == 0) && (calcVal.up / calcVal.down == result)) {
        return true;
    }
    else {
        return false;
    }
}

bool EvalTree::isEnd() {
    for (int i : nums) {
        if (i != 9) {
            return false;
        }
    }

    return true;
}

void EvalTree::moveNext() {
    // for (int i = 0; i < nums.size(); i++)
    // {
    //     cout << nums[i] << ", ";
    // }

    // cout << endl;
    bool carry = false;
    nums[0] += 1;
    for (int i = 0; i < nums.size(); i++) {
        if(carry) {
            nums[i] += 1;
            carry = false;
        }
        if(nums[i] / 10 != 0) {
            nums[i] = nums[i] % 10;
            carry = true;
        }
    }
}