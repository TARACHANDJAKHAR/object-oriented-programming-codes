#include<iostream>
using namespace std;

class Integer
{
    int a;
        public:
        Integer()
        {
            this->a = 1;
        }
    Integer(int a)
    {
        this->a = a;
    }
        friend Integer operator+(Integer &A,Integer &B);
        void display()
        {
            cout<<"The no is : "<<a<<endl;
        }
};

Integer operator+(Integer &A,Integer &B)
{
    Integer C;
    C.a = ( A.a + B.a );
    return C;
}

int main ()
{
    Integer a(5);
    Integer b(9);
    Integer c = a+b;
    c.display();
  return 0;
}