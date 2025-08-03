
class TaxPay {
    double tax = 0;

    double calculateTax(float amount) {
        return tax * amount + amount;
    }
}

class IndiaTax extends TaxPay {
    IndiaTax() {
        tax = 0.18;
    }
}

class NZTax extends TaxPay {
    NZTax() {
        tax = 0.20;
    }
}

public class OC {

    public static void main(String[] args) {
        System.out.println(new IndiaTax().calculateTax(30));
        System.out.println(new NZTax().calculateTax(30));
    }

}
