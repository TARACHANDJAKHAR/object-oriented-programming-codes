#include<iostream>
using namespace std;

class Employee{
    private:
        int emp_id;
        string emp_name;
        int age;
    public:
        Employee()
        {
            this->emp_id = 1;
            this->emp_name = "TARACHAND JAKHAR";
            this->age = 20;
        }
            Employee(int emp_id,string emp_name,int age)
            {
                this->emp_id = emp_id;
                this->emp_name = emp_name;
                this->age = age;
            }
    void search(int key)
    {
            if (key == this->emp_id)
            {
                cout<<"Id of Employee is : "<<this->emp_id<<endl;
                cout<<"Name of Employee is : "<<this->emp_name<<endl;
                cout<<"Age of Employee is : "<<this->age<<endl;
            }
    }
};

int main ()
{
        Employee e1;
        Employee e2(2,"sachin singh",21);
        Employee e3(3,"atharv katke",19);
        Employee e4(4,"sahil",18);
        Employee e5(5,"anurag",22);
        Employee e6(6,"aditya",21);
        Employee e7(7,"divyansh",20);
        Employee e8(8,"divyanshu",18);

        cout<<endl<<"enter the emp_id you want to search :- "<<endl;
        int key;
        cin>>key;

        e1.search(key);
        e2.search(key);
        e3.search(key);
        e4.search(key);
        e5.search(key);
        e6.search(key);
        e7.search(key);
        e8.search(key);

    return 0;
}