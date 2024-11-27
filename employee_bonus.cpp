#include<iostream>
using namespace std;

class employee{
    private:
    string name;
    int earning;
    int bonus;
    public:
    void inputData(){
        cout<<"enter the name :";
        cin>>name;
        cout<<"enter the earning earned :";
        cin>>earning;
    }
    void comput()
    {
        if(earning>=2000){
            bonus=earning/10;
        }
        else{
            bonus=0;
        }
    }
    void print(){
        cout<<"the name of the employee is :"<<name<<endl;
        cout<<"the earning earned by the employee is :"<<earning<<endl;
        cout<<"the bonus is :"<<bonus<<endl;
    }
};
int main(){
    employee a;
    a.inputData();
    a.comput();
    a.print();
    return 0;
}