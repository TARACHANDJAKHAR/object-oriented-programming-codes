#include<iostream>
using namespace std;

class bank{
    private:
    string name;
    long long int account;
    string type;
    int amount;

    public:
    void getData(string name,long long int account,string type,int amount)
    {
        this->name=name;
        this->account=account;
        this->type=type;
        this->amount=amount;
    }

    void deposit(int n){
        amount=amount+n;
    }

    void withdraw(int n){
        amount=amount-n;
    }

    void print(){
        cout<<"the name of the bank account  holder is : "<<name<<endl;
        cout<<"the account no is : "<<account<<endl;
        cout<<"the type of the account is : "<<type<<endl;
        cout<<"the amount in account is "<<amount<<endl;
    }

};
int main(){
    bank a;
    string name,type;
    long long int acc;
    int amount,deposit,withdraw;

    cout<<"enter your name : "<<endl;
    cin>>name;
    cout<<"enter your account number : "<<endl;
    cin>>acc;
    cout<<"enter your type of account : "<<endl;
    cin>>type;
    cout<<"enter amount in account : "<<endl;
    cin>>amount;
    
    cout<<"enter amount to deposit in account : "<<endl;
    cin>>deposit;
    cout<<"enter amount to withdraw from account : "<<endl;
    cin>>withdraw;

    a.getData(name,acc,type,amount);

    a.deposit(deposit);
    a.withdraw(withdraw);
    a.print();

    return 0;

}