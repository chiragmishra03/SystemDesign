interface Logistic {
    void send();
}

class Road implements Logistic {

    @Override
    public void send() {
        System.out.println("Road is being used");
    }

}

class Air implements Logistic {

    @Override
    public void send() {
        System.out.println("Air way is being used");
    }

}

class LogisticService {
    public Logistic send(String mode) {
        if (mode.equalsIgnoreCase("Road")) {
            return new Road();
            // Logic of deciding which type of object is needed and returning it
        } else if (mode.equalsIgnoreCase("Air")) {
            return new Air();
            // Logic of deciding which type of object is needed and returning it
        }
        // if any new way comes add here
        return null;
    }
}

public class Traditional {
    public static void main(String[] args) {

    }
}
