#include <iostream>
#include <string>
using namespace std;

class Book {
private:
    int accessionNumber;
    string author, title, publisher;
    int year;
    float cost;

public:
    Book() : accessionNumber(0), author(""), title(""), publisher(""), year(0), cost(0) {
        cout << "Default Constructor called.\n";
    }

    Book(const Book& obj) {
        accessionNumber = obj.accessionNumber;
        author = obj.author;
        title = obj.title;
        publisher = obj.publisher;
        year = obj.year;
        cost = obj.cost;
        cout << "Copy Constructor called.\n";
    }

    ~Book() { cout << "Destructor called.\n"; }

    void readInput() {
        cin.ignore();
        cout << "Enter accession number: ";
        cin >> accessionNumber;
        cin.ignore();
        cout << "Enter author's name: ";
        getline(cin, author);
        cout << "Enter title of the book: ";
        getline(cin, title);
        cout << "Enter publisher's name: ";
        getline(cin, publisher);
        cout << "Enter year of publication: ";
        cin >> year;
        cout << "Enter cost of the book: ";
        cin >> cost;
    }

    void display() const {
        cout << "\nLibrary Book Details:\n";
        cout << "Accession Number: " << accessionNumber << "\nAuthor: " << author
             << "\nTitle: " << title << "\nPublisher: " << publisher
             << "\nYear: " << year << "\nCost: Rs. " << cost << "\n";
    }
};

int main() {
    Book book;
    book.readInput();
    book.display();
    return 0;
}
