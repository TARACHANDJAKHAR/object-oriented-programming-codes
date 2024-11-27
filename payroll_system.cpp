#include <iostream>
#include <string>
using namespace std;

class Payroll {
private:
    string name, designation;
    int code, accountNumber;
    string dateOfJoining;
    float basicPay, da, hra, cca, deductions;

public:
    // Constructors
    Payroll() : name(""), designation(""), code(0), accountNumber(0), dateOfJoining(""),
                basicPay(0), da(0), hra(0), cca(0), deductions(0) {
        cout << "Default Constructor called.\n";
    }

    Payroll(const Payroll& obj) {
        name = obj.name;
        designation = obj.designation;
        code = obj.code;
        accountNumber = obj.accountNumber;
        dateOfJoining = obj.dateOfJoining;
        basicPay = obj.basicPay;
        da = obj.da;
        hra = obj.hra;
        cca = obj.cca;
        deductions = obj.deductions;
        cout << "Copy Constructor called.\n";
    }

    ~Payroll() { cout << "Destructor called.\n"; }

    void readInput() {
        cin.ignore();
        cout << "Enter employee name: ";
        getline(cin, name);
        cout << "Enter designation: ";
        cin >> designation;
        cout << "Enter code: ";
        cin >> code;
        cout << "Enter account number: ";
        cin >> accountNumber;
        cin.ignore();
        cout << "Enter date of joining: ";
        getline(cin, dateOfJoining);
        cout << "Enter basic pay: ";
        cin >> basicPay;
        cout << "Enter DA, HRA, CCA: ";
        cin >> da >> hra >> cca;
        cout << "Enter deductions: ";
        cin >> deductions;
    }

    void display() const {
        float grossPay = basicPay + da + hra + cca;
        float netPay = grossPay - deductions;

        cout << "\nPayroll Details:\n";
        cout << "Name: " << name << "\nDesignation: " << designation << "\nCode: " << code
             << "\nAccount Number: " << accountNumber << "\nDate of Joining: " << dateOfJoining
             << "\nGross Pay: Rs. " << grossPay << "\nNet Pay: Rs. " << netPay << "\n";
    }
};

int main() {
    Payroll payroll;
    payroll.readInput();
    payroll.display();
    return 0;
}
