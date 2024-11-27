#include <iostream>
#include <string>
using namespace std;

class Marks {
private:
    string name, rollNumber, subjectCode, subjectName;
    float internalMarks, externalMarks;

public:
    Marks() : name(""), rollNumber(""), subjectCode(""), subjectName(""), internalMarks(0), externalMarks(0) {
        cout << "Default Constructor called.\n";
    }

    Marks(const Marks& obj) {
        name = obj.name;
        rollNumber = obj.rollNumber;
        subjectCode = obj.subjectCode;
        subjectName = obj.subjectName;
        internalMarks = obj.internalMarks;
        externalMarks = obj.externalMarks;
        cout << "Copy Constructor called.\n";
    }

    ~Marks() { cout << "Destructor called.\n"; }

    void readInput() {
        cin.ignore();
        cout << "Enter student's name: ";
        getline(cin, name);
        cout << "Enter roll number: ";
        cin >> rollNumber;
        cin.ignore();
        cout << "Enter subject code: ";
        getline(cin, subjectCode);
        cout << "Enter subject name: ";
        getline(cin, subjectName);
        cout << "Enter internal marks: ";
        cin >> internalMarks;
        cout << "Enter external marks: ";
        cin >> externalMarks;
    }

    void display() const {
        float totalMarks = internalMarks + externalMarks;
        cout << "\nMarksheet Details:\n";
        cout << "Name: " << name << "\nRoll Number: " << rollNumber
             << "\nSubject Code: " << subjectCode << "\nSubject Name: " << subjectName
             << "\nInternal Marks: " << internalMarks << "\nExternal Marks: " << externalMarks
             << "\nTotal Marks: " << totalMarks << "\n";
    }
};

int main() {
    Marks marks;
    marks.readInput();
    marks.display();
    return 0;
}
