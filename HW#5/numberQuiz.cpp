#include <iostream>
#include "EvalTree.hpp"
#include "StringNumIterator.hpp"

using namespace std;
int main() {
    string str;
    getline(cin, str);

    StringNumIterator iter(str);
    while(!iter.isEnd()) {
        cout << iter.getNext() << endl;
    }

    // EvalTree* evalTree = new EvalTree(str);

    // cout << evalTree->evaluate() << endl;

    return 0;
}