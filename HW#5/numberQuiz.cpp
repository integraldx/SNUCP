#include <iostream>
#include "EvalTree.hpp"
#include "StringNumIterator.hpp"

using namespace std;

int main() {
    string str;
    getline(cin, str);
    EvalTree *evalTree;
    StringNumIterator iter(str);

    bool isAnswer = false;

    while(!iter.isEnd()) {
        try {
            evalTree = new EvalTree(iter.getNext());
        }
        catch (const char*& ch) {
            continue;
        }
        if(evalTree->evaluate()) {
            cout << iter.getBoxNumString() << endl;
            isAnswer = true;
            break;
        }

        delete evalTree;
    }

    if(!isAnswer) {
        cout << "No solution" << endl;
    }
    return 0;
}