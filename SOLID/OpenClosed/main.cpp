#include <bits/stdc++.h>
using namespace std;

void oldApproach(string country, int amount)
{
    if (country == "India")
    {
        cout << "18% tax charged" << endl;
        cout << 0.18 * amount + amount << endl;
    }
    else if (country == "Australia")
    {
        cout << "11% Tax charge" << endl;
        cout << 0.11 * amount + amount << endl;
    }
    else
    {
        cout << "No tax" << endl;
        cout << amount << endl;
    }
}

class TaxCalculation
{
protected:
    double tax = 0;

public:
    int calculateTax(double amount)
    {
        return amount * tax + amount;
    }
};

class IndiaTax : public TaxCalculation
{
public:
    IndiaTax()
    {
        tax = 0.5;
    }
};

class AustraliaTax : public TaxCalculation
{
public:
    AustraliaTax()
    {
        tax = 0.1;
    }
};

int main()
{

    TaxCalculation *tax = new IndiaTax();
    cout << tax->calculateTax(20);
}