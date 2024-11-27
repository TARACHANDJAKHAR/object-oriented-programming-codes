#include <iostream>
#include <string>
using namespace std;

class Patient {
private:
    string name, sex, illness, admissionDate;
    int age, wardNumber, bedNumber;

public:
    // Constructors
    Patient() : name(""), sex(""), illness(""), admissionDate(""), age(0), wardNumber(0), bedNumber(0) {
        cout << "Default Constructor called.\n";
    }

    Patient(const Patient& obj) {
        name = obj.name;
        sex = obj.sex;
        illness = obj.illness;
        admissionDate = obj.admissionDate;
        age = obj.age;
        wardNumber = obj.wardNumber;
        bedNumber = obj.bedNumber;
        cout << "Copy Constructor called.\n";
    }

    ~Patient() { cout << "Destructor called.\n"; }

    void readInput() {
        cin.ignore();
        cout << "Enter patient's name: ";
        getline(cin, name);
        cout << "Enter sex: ";
        cin >> sex;
        cout << "Enter age: ";
        cin >> age;
        cout << "Enter ward number: ";
        cin >> wardNumber;
        cout << "Enter bed number: ";
        cin >> bedNumber;
        cin.ignore();
        cout << "Enter nature of illness: ";
        getline(cin, illness);
        cout << "Enter date of admission: ";
        cin >> admissionDate;
    }

    void display() const {
        cout << "Patient Details:\n";
        cout << "Name: " << name << "\nSex: " << sex << "\nAge: " << age
             << "\nWard Number: " << wardNumber << "\nBed Number: " << bedNumber
             << "\nIllness: " << illness << "\nAdmission Date: " << admissionDate << "\n";
    }
};

int main() {
    Patient p;
    p.readInput();
    p.display();
    return 0;
}
