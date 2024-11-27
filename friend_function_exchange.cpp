#include<iostream>
using namespace std;

class Class2;
class Class1 
{
    private:
        float a;
    public:
        void getA()
        {
            cout<<"Enter value for a : "<<endl;
            cin>>a;
        }
        void displayA()
        {
            cout<<"value of a : "<<a<<endl;
        }
    friend void exchange(Class1 &c1,Class2 &c2);
};

class Class2 
{
    private:
        float b;
    public:
        void getB()
        {
            cout<<"Enter value for b : "<<endl;
            cin>>b;
        }
        void displayB()
        {
            cout<<"value of b : "<<b<<endl;
        }
    friend void exchange(Class1 &c1,Class2 &c2);
};

void exchange ( Class1 &c1,Class2 &c2 ) 
{
    c1.a = c1.a+c2.b;
    c2.b = c1.a-c2.b;
    c1.a = c1.a-c2.b;
}

int main()
{
    Class1 c1;
    c1.getA();

    Class2 c2;
    c2.getB();
    cout<<endl<<"Before exchange :- "<<endl;
    c1.displayA();
    c2.displayB();

    cout<<endl<<"After exchange :- "<<endl;
    exchange(c1,c2);
    c1.displayA();
    c2.displayB();
}