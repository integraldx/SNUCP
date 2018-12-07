#include <iostream>
#include <memory>
#include "EvalTree.hpp"

using namespace std;
int main() {
    string str;
    getline(cin, str);
    EvalTree* evalTree = new EvalTree(str);

    cout << evalTree->evaluate() << endl;

    return 0;
}