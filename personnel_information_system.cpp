#include <iostream>
#include <string>
using namespace std;

class Personnel {
private:
    string name, designation, department, dateOfJoining;
    int employeeId, age;
    double salary;

public:
    // Default Constructor
    Personnel() : name(""), designation(""), department(""), dateOfJoining(""), employeeId(0), age(0), salary(0.0) {
        cout << "Default Constructor called.\n";
    }

    // Copy Constructor
    Personnel(const Personnel& obj) {
        name = obj.name;
        designation = obj.designation;
        department = obj.department;
        dateOfJoining = obj.dateOfJoining;
        employeeId = obj.employeeId;
        age = obj.age;
        salary = obj.salary;
        cout << "Copy Constructor called.\n";
    }

    // Destructor
    ~Personnel() { cout << "Destructor called.\n"; }

    void readInput() {
        cin.ignore();
        cout << "Enter employee name: ";
        getline(cin, name);
        cout << "Enter designation: ";
        getline(cin, designation);
        cout << "Enter department: ";
        getline(cin, department);
        cout << "Enter date of joining: ";
        getline(cin, dateOfJoining);
        cout << "Enter employee ID: ";
        cin >> employeeId;
        cout << "Enter age: ";
        cin >> age;
        cout << "Enter salary: ";
        cin >> salary;
    }

    void display() const {
        cout << "\nPersonnel Information:\n";
        cout << "Name: " << name << "\nDesignation: " << designation
             << "\nDepartment: " << department << "\nDate of Joining: " << dateOfJoining
             << "\nEmployee ID: " << employeeId << "\nAge: " << age
             << "\nSalary: Rs. " << salary << "\n";
    }
};

int main() {
    Personnel p1;
    p1.readInput();
    p1.display();

    return 0;
}
