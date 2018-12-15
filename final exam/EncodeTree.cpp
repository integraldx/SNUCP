#pragma once
#include <string>
#include "Node.h"

using namespace std;

string encode(Node* node) {
    string toReturn = "";
    toReturn.push_back(node->label);
    if(node->left != nullptr) {
        toReturn = toReturn + encode(node->left);
    }
    if (node->right != nullptr) {
        toReturn = toReturn + encode(node->right);
    }
    toReturn.push_back(node->label);

    return toReturn;
}