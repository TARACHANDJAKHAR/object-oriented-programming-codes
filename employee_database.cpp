#include <iostream>
#include <string>
using namespace std;

class Employee {
private:
    string name, designation;
    int code, experience, age;

public:
    // Constructors
    Employee() : name(""), code(0), designation(""), experience(0), age(0) {
        cout << "Default Constructor called.\n";
    }

    Employee(string n, int c, string d, int e, int a)
        : name(n), code(c), designation(d), experience(e), age(a) {
        cout << "Parameterized Constructor called.\n";
    }

    Employee(const Employee& obj) {
        name = obj.name;
        code = obj.code;
        designation = obj.designation;
        experience = obj.experience;
        age = obj.age;
        cout << "Copy Constructor called.\n";
    }

    ~Employee() { cout << "Destructor called.\n"; }

    void readInput() {
        cout << "Enter name: ";
        cin.ignore();
        getline(cin, name);
        cout << "Enter code: ";
        cin >> code;
        cout << "Enter designation: ";
        cin >> designation;
        cout << "Enter years of experience: ";
        cin >> experience;
        cout << "Enter age: ";
        cin >> age;
    }

    void display() const {
        cout << "Employee Details:\n";
        cout << "Name: " << name << "\n";
        cout << "Code: " << code << "\n";
        cout << "Designation: " << designation << "\n";
        cout << "Experience: " << experience << " years\n";
        cout << "Age: " << age << " years\n";
    }
};

int main() {
    Employee emp;
    emp.readInput();
    emp.display();
    return 0;
}
