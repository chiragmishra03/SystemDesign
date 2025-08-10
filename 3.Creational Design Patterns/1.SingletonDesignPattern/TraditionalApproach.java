public class TraditionalApproach {
    public static void main(String[] args) {
        Analytics analytics = new Analytics();
        analytics.countRun();
        analytics.getRun();
    }
}

class Analytics {
    private int run = 0;

    public void countRun() {
        run++;
    }

    public int getRun() {
        System.out.println(run);
        return run;
    }

}

// Each and every object would be isolated and will get its own behaviour and
// properties in accordance to class