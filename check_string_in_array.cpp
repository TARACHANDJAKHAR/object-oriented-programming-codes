#include <iostream>
#include <vector>
#include <string>
using namespace std;

class StringChecker {
private:
    vector<string> array;
public:
    // Constructors
    StringChecker() { cout << "Default Constructor called.\n"; }
    StringChecker(const StringChecker& obj) {
        this->array = obj.array;
        cout << "Copy Constructor called.\n";
    }
    ~StringChecker() { cout << "Destructor called.\n"; }

    void readInput() {
        int n;
        cout << "Enter the number of lines: ";
        cin >> n;
        cin.ignore();
        for (int i = 0; i < n; ++i) {
            string line;
            cout << "Enter line " << i + 1 << ": ";
            getline(cin, line);
            array.push_back(line);
        }
    }

    void checkString(const string& s) {
        int count = 0;
        for (const auto& line : array) {
            if (line.find(s) != string::npos) {
                cout << "Found: " << line << "\n";
                count++;
            }
        }
        cout << "String \"" << s << "\" found " << count << " times.\n";
    }
};

int main() {
    StringChecker sc;
    sc.readInput();
    string s;
    cout << "Enter the string to check: ";
    cin >> s;
    sc.checkString(s);
    return 0;
}
