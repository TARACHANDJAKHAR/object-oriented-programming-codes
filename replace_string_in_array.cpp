#include <iostream>
#include <vector>
#include <string>
using namespace std;

class StringReplacer {
private:
    vector<string> array;
public:
    // Constructors
    StringReplacer() { cout << "Default Constructor called.\n"; }
    StringReplacer(const StringReplacer& obj) {
        this->array = obj.array;
        cout << "Copy Constructor called.\n";
    }
    ~StringReplacer() { cout << "Destructor called.\n"; }

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

    void replaceString(const string& s1, const string& s2) {
        for (auto& line : array) {
            size_t pos = line.find(s1);
            if (pos != string::npos) {
                line.replace(pos, s1.length(), s2);
            }
        }
    }

    void displayArray() {
        cout << "Updated Array:\n";
        for (const auto& line : array) {
            cout << line << "\n";
        }
    }
};

int main() {
    StringReplacer sr;
    sr.readInput();
    string s1, s2;
    cout << "Enter the string to replace (S1): ";
    cin >> s1;
    cout << "Enter the replacement string (S2): ";
    cin >> s2;
    sr.replaceString(s1, s2);
    sr.displayArray();
    return 0;
}
