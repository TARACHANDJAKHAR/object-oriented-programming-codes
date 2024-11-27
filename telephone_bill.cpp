#include<iostream>
using namespace std;

class bill
{
  private:
  string name;
  int noc;
  int amount;

  public:
  void inputData()
  {
        cout<<"enter the name :";
        cin>>name;
        cout<<"enter the no of the call :";
        cin>>noc;
  }
  void comput()
  {
    if(noc<=100)
    {
        amount=200;
    }
    else if(noc<=150&&noc>100)
    {
        amount=200+(noc-100)*0.6;
    }
    else if(noc<=200&&noc>150)
    {
        amount=230+(noc-150)*0.5;
    }
    else
    {
        amount=255+(noc-200)*0.4;
    }
  }
  void print()
  {
   cout<<" the name  is :"<<name<<endl;
   cout<<"the no of call is :"<<noc<<endl;
   cout<<"the bill is :"<<amount<<endl;
  }
};

int main()
{
    bill a;
    a.inputData();
    a.comput();
    a.print();
    return 0;
}