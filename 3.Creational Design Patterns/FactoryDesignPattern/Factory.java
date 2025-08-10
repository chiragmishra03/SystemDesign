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

class LogisticFactory {
    public static Logistic getLogistic(String mode) {
        if (mode.equalsIgnoreCase("Road")) {
            return new Road();
        } else if (mode.equalsIgnoreCase("Air")) {
            return new Air();
        }
        throw new IllegalArgumentException("Invalid logistic mode: " + mode);
    }
}

class LogisticService {
    public static void send() {
        Logistic logistic = LogisticFactory.getLogistic("Road");
        logistic.send();
    }
}

public class Factory {

}
