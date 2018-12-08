#include <iostream>
#include "EvalTree.hpp"
#include "StringNumIterator.hpp"

using namespace std;
int main() {
    string str;
    getline(cin, str);

    StringNumIterator iter(str);

    int answerCount = 0;

    while(!iter.isEnd()) {
        if(answerCount == 3) {
            break;
        }
        EvalTree evalTree(iter.getNext());
        if(evalTree.evaluate()) {
            cout << iter.getBoxNumString() << endl;
            answerCount++;
        }
    }

    if(answerCount == 0) {
        cout << "No solution" << endl;
    }


    return 0;
}