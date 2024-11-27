#include<iostream>
using namespace std;

class Complex
{
    private:
        int real;
        int imag;
    public:
        Complex()
        {
            this->real = 1;
            this->imag = 1;
        }
        Complex(int real,int imag)
        {
            this->real = real;
            this->imag = imag;
        }
    inline void mul(Complex *a);
};

void Complex::mul(Complex *a)
{
    Complex result;
    result.real =  ( this->real * a->real ) - ( this->imag * a->imag );
    result.imag =  ( this->imag * a->imag ) + ( this->real * a->real );
    cout<<endl<<"First complex no. : "<<a->real<<" + i"<<a->imag<<" ."<<endl;
    cout<<"Second complex no. : "<<this->real<<" + i"<<this->imag<<" ."<<endl;
    cout<<"Multiplication of both complex no is : "<<result.real<<" + i"<<result.imag<<" ."<<endl<<endl;

}

int main () 
{
    Complex a(15,36);
    Complex b(18,10);

    b.mul(&a);

  return 0;
}