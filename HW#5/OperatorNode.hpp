#pragma once
#include <string>
#include "Node.hpp"
#include "OperandNode.hpp"

enum Op {ADD, SUB, MUL, DIV, MOD, POW};
int opOrder[] = {4, 4, 3, 3, 2, 1};

using namespace std;

class OperatorNode : public Node{
    public:
    OperatorNode(string str);
    ~OperatorNode();
    virtual int getValue();

    private:
    Op operation;
};

OperatorNode::OperatorNode(string str)
{
    size_t targetOperationIndex;
    auto add = str.find_last_of('+');
    auto sub = str.find_last_of('-');
    if (add != str.npos || sub != str.npos)
    {
        if (add == str.npos)
        {
            targetOperationIndex = sub;
        }
        else if (sub == str.npos)
        {
            targetOperationIndex = add;
        }
        else
        {
            if (add > sub)
            {
                targetOperationIndex = add;
            }
            else
            {
                targetOperationIndex = sub;
            }
        }
    }
    else
    {
        auto mul = str.find_last_of('*');
        auto div = str.find_last_of('/');

        if (mul != str.npos || div != str.npos)
        {
            if (mul == str.npos)
            {
                targetOperationIndex = div;
            }
            else if (div == str.npos)
            {
                targetOperationIndex = mul;
            }
            else
            {
                if (mul > div)
                {
                    targetOperationIndex = mul;
                }
                else
                {
                    targetOperationIndex = div;
                }
            }
        }
        else {
            auto mod = str.find_last_of('%');
            if(mod != str.npos)
            {
                targetOperationIndex = mod;
            }
            else {
                auto pow = str.find_last_of('^');
                if(pow != str.npos)
                {
                    targetOperationIndex = pow;
                }
            }
        }
    }

    switch(str[targetOperationIndex]) 
    {
        case '+':
        operation = ADD;
        break;
        case '-':
        operation = SUB;
        break;
        case '*':
        operation = MUL;
        break;
        case '/':
        operation = DIV;
        break;
        case '%':
        operation = MOD;
        break;
        case '^':
        operation = POW;
        break;
    }

    string leftStr = str.substr(0, targetOperationIndex);
    string rightStr = str.substr(targetOperationIndex + 1, str.length() - targetOperationIndex);
    if (Node::isThereOperators(leftStr)) {
        left = new OperatorNode(leftStr);
    }
    else {
        left = new OperandNode(leftStr);
    }

    if (Node::isThereOperators(rightStr)) {
        right = new OperatorNode(rightStr);
    }
    else {
        right = new OperandNode(rightStr);
    }

}

int OperatorNode::getValue()
{
    int toReturn;
    switch(operation) {
        case ADD:
        toReturn = left->getValue() + right->getValue();
        break;
        case SUB:
        toReturn = left->getValue() - right->getValue();
        break;
        case MUL:
        toReturn = left->getValue() * right->getValue();
        break;
        case DIV:
        toReturn = left->getValue() / right->getValue();
        break;
        case MOD:
        toReturn = left->getValue() % right->getValue();
        break;
        case POW:
        toReturn = integerPow(left->getValue(), right->getValue());
        break;
    }

    return toReturn;
}

