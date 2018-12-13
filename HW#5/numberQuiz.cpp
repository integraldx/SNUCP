#include <iostream>
#include "EvalTree.hpp"
#include "StringPreprocessor.hpp"

using namespace std;

int main() {
    string str;
    getline(cin, str);
    EvalTree *evalTree;
    StringPreprocessor origString(str);

    bool isAnswer = false;

    evalTree = new EvalTree(origString.getProcessedString());

    cout << evalTree->evaluate() << endl;

    // while(!iter.isEnd()) {
    //     try {
    //         evalTree = new EvalTree(iter.getNext());
    //     }
    //     catch (const char*& ch) {
    //         continue;
    //     }
    //     if(evalTree->evaluate()) {
    //         cout << iter.getBoxNumString() << endl;
    //         isAnswer = true;
    //         break;
    //     }

    //     delete evalTree;
    // }

    // if(!isAnswer) {
    //     cout << "No solution" << endl;
    // }
    return 0;
}