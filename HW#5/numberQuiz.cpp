#include <iostream>
#include "EvalTree.hpp"
#include "StringNumIterator.hpp"

using namespace std;
int main() {
    string str;
    getline(cin, str);

    StringNumIterator iter(str);
    while(!iter.isEnd()) {
        EvalTree evalTree(iter.getNext());
        if(evalTree.evaluate()) {
            cout << iter.getBoxNumString() << endl;
        }
    }


    return 0;
}