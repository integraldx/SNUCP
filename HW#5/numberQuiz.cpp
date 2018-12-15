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
    auto sep = seperators.begin();
    sep++;

    if (evalTree->evaluate())
    {
        for (int i = 0; i < nums.size(); i++)
        {
            cout << nums[i];
            if (*sep == i && sep != seperators.end())
            {
                cout << ", ";
                sep++;
            }
        }
        cout << endl;
        isAnswer = true;
    }
    else {
        while (!evalTree->isEnd())
        {
            evalTree->moveNext();
            if (evalTree->evaluate())
            {
                for (int i = 0; i < nums.size(); i++)
                {
                    cout << nums[i];
                    if (*sep == i && sep != seperators.end())
                    {
                        cout << ", ";
                        sep++;
                    }
                }

                cout << endl;
                isAnswer = true;
                break;
            }
        }
    }
    if(!isAnswer) {
        cout << "No solution" << endl;
    }
    return 0;
}