#include<iostream>
using namespace std;

class Second;
class First 
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
    friend void avg(First &f,Second &s);
};

class Second 
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
    friend void avg(First &f,Second &s);
};

void avg ( First &f,Second &s ) 
{
    float mean = ( f.a + s.b )/2;
    cout<<" The mean of "<<f.a<<" and "<<s.b<<" is : "<<mean<<endl;
}

int main()
{
    First f;
    f.getA();
    f.displayA();

    Second s;
    s.getB();
    s.displayB();

    avg(f,s);
}