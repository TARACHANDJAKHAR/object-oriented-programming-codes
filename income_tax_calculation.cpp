#include<iostream>
using namespace std;

class tax
{
  private:
  string name;
  int earning;
  int tax;

  public:
  void inputData()
  {
        cout<<"enter the name :";
        cin>>name;
        cout<<"enter the earning :";
        cin>>earning;
  }
         void comput()
        {
             if( earning <= 100000 ) {
                 tax = 0;
             }
             else if( earning<=150000 && earning>100000 ) 
             {
                 tax = (earning-100000)*0.1;
             }
             else if( earning<=200000 && earning>150000 ) 
             {
                 tax = 5000+(earning-150000)*0.2;
             }
             else{
                 tax = 15000+(earning-200000)*0.3;
             }
        }

         void print ()
        {
              cout<<" the name  is :"<<name<<endl<<"the earning is :"<<earning<<endl;
              cout<<"the due tax is :"<<tax<<endl;
        }

};

int main()
{
      tax a;
        a.inputData();
        a.comput();
        a.print();
   return 0;
}