#include<iostream>
using namespace std;

class Publication 
{
    private:
    string title;
    int price;
    string name;
    public:
        void getData()
        {
            cout<<"Enter Title of BOOK : "<<endl;
            cin>>title;
            cout<<"Enter price of BOOK : "<<endl;
            cin>>price;
            cout<<"Enter name of author : "<<endl;
            cin>>name;
        }
        void displayData()
        {
            cout<<"Title of BOOK  is : "<<title<<endl;
            cout<<"Price of BOOK  is : "<<price<<endl;
            cout<<"Author of BOOK  is : "<<name<<endl;
        }

};

class Book : public Publication 
{
    private:
    int pcount;
    public:
        void getData()
        {
            cout<<"enter page count : "<<endl;
            cin>>pcount;
            pcount++;
        }
        void displayData()
        {
            cout<<"Total page count : "<<pcount<<endl;
        }
};

class Ebook : public Publication 
{
    private:
    int ptime;
    public:
        void getData()
        {
            cout<<"enter page time : "<<endl;
            cin>>ptime;
            ptime++;
        }
        void displayData()
        {
            cout<<"Total page time : "<<ptime<<endl;
        }
};

int main ()
{
    Publication p;
    p.getData();
    p.displayData();

    Book b;
    b.getData();
    b.displayData();

    Ebook e;
    e.getData();
    e.displayData();
  return 0;
}