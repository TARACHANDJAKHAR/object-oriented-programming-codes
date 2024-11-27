#include<iostream>
using namespace std;

class Cuboid
{
    private:
        int l,h,b,area=0;
    public:
            void getCuboid()
            {
                this->l = 1;
                this->h = 1;
                this->b = 1;
            }
        void getCuboid(int l,int h,int b)
        {
            this->l = l;
            this->h = h;
            this->b = b;
        }
        void displayArea()
        {
            area = 2*( l*b + l*h + h*b );
            cout<<" height = "<<h<<endl;
            cout<<" base = "<<b<<endl;
            cout<<" width = "<<l<<endl;
            cout<<"Area of cuboid is : "<<area<<endl;
        }
};

class Cube
{
    private:
        int a,vol=0;
    public:
            void getCube()
            {
                this->a = 1;
            }
        void getCube(int a)
        {
            this->a = a;
        }
        void displayVol()
        {
            vol = a*a*a ;
            cout<<" height = "<<a<<endl;
            cout<<"Volume of cube is : "<<vol<<endl;
        }
};

int main () 
{
    Cuboid c1;
    c1.getCuboid(4,5,6);
    c1.displayArea();

    Cube c2;
    c2.getCube(4);
    c2.displayVol();
  return 0;
}