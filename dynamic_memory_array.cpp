#include<iostream>
using namespace std;

int main ()
{
    int size;
    cout<<"Enter the size for array :- ";
    cin>>size;

    int *A = new int[size];

    for(int i=0; i<size; i++)
    {
        cout<<"Enter "<<i+1<<"th value in array :- ";
        cin>>A[i];
    }
        cout<<endl;
    for(int i=0; i<size; i++)
    {
        cout<<i+1<<"th value in array is : "<<A[i]<<endl;
    } 
}