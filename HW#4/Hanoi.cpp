#include <iostream>
#include <vector>
#include <stack>
#include <string>

using namespace std;

struct Tower {
    vector<int> disks[3];
};

Tower tower;

int n;
int displayCounter = 0;

void move(int from, int to);

void display();

void recursive(int from, int to, int n);

int main() {
    cin >> n;

    for(int i = 0; i < n; i++) {
        tower.disks[0].push_back(i + 1);
    }
    
    display();
    
    recursive(0, 2, n);

    return 0;
}

void recursive(int from, int to, int n) {
    if(n == 1){
        move(from, to);
    }
    else {
        int mid;
        if ((from == 0 && to == 2) || (from == 2 && to == 0)) {
            mid = 1;
        }
        else if ((from == 1 && to == 2) || (from == 2 && to == 1)) {
            mid = 0;
        }
        else {
            mid = 2;
        }

        recursive(from, mid, n - 1);
        recursive(from, to, 1);
        recursive(mid, to, n - 1);
    }
    return;
}

void move(int from, int to) {
    int disk;
    disk = (tower.disks[from]).front();
    tower.disks[from].erase(tower.disks[from].begin());
    tower.disks[to].insert(tower.disks[to].begin(), disk);
    
    display();
    return;
}

void display(){
    if(displayCounter != 0){
        cout << displayCounter << ":" << endl;
    }
    string toDisplays[3][9];
    for (int i = 0; i < 3; i++) { 
        for (int j = 0; j < n; j++) {
            int disk;
            if(j < n - tower.disks[i].size()){
                disk = 0;
            }
            else {
                disk = tower.disks[i][j - (n - tower.disks[i].size())];
            }
            if (disk == 0) {
                for (int k = 0; k < n - 1; k++) {
                    toDisplays[i][j] += " ";
                }
                toDisplays[i][j] += "|";
                for (int k = 0; k < n - 1; k++) {
                    toDisplays[i][j] += " ";
                }
            }
            else {
                for (int k = 0; k < n - disk; k++) {
                    toDisplays[i][j] += " ";
                }
                for (int k = 0; k < 2 * disk - 1; k++) {
                    toDisplays[i][j] += "*";
                }
                for (int k = 0; k < n - disk; k++) {
                    toDisplays[i][j] += " ";
                }
            }

        }
    }

    for (int i = 0; i < n; i++) {
        cout << "    ";
        for (int j = 0; j < 3; j++) {
            cout << toDisplays[j][i];
            cout << "     ";
        }
        cout << endl;
    }


    for(int i = 0; i < 6 * n + 15; i++) {
        cout << "-";
    }
    
    cout << endl << endl;
    displayCounter++;
}