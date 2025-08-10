
// Thread unsafe but lazy loading
class SingletonLazyLoadingThreadUnsafe {

    private static SingletonLazyLoadingThreadUnsafe singletonLazyLoadingThreadUnsafe = null;

    private SingletonLazyLoadingThreadUnsafe() {
    }

    public static SingletonLazyLoadingThreadUnsafe getInstance() {
        if (singletonLazyLoadingThreadUnsafe == null) {
            singletonLazyLoadingThreadUnsafe = new SingletonLazyLoadingThreadUnsafe();
        }
        return singletonLazyLoadingThreadUnsafe;
    }

}

// Thread safe but performance less optimized
class SingletonLazyLoadingThreadSafe {
    // This will ensure that the object is thread safe and lazy loaded

    private static SingletonLazyLoadingThreadSafe singletonLazyLoadingThreadSafe = null;

    private SingletonLazyLoadingThreadSafe() {
    }

    public static synchronized SingletonLazyLoadingThreadSafe getInstance() {
        // Performance downgrade in function but thread safe
        if (singletonLazyLoadingThreadSafe == null) {
            singletonLazyLoadingThreadSafe = new SingletonLazyLoadingThreadSafe();
        }
        return singletonLazyLoadingThreadSafe;
    }
}

// Thread safe and performance optimized
class SingletonLazyLoadingBillPugh {

    private SingletonLazyLoadingBillPugh() {
    }

    // Inner classes in java are always lazy loaded and JVM ensures classes are
    // always loaded in serializable manner
    private static class Helper {
        private static final SingletonLazyLoadingBillPugh INSTANCE = new SingletonLazyLoadingBillPugh();
    }

    public static SingletonLazyLoadingBillPugh getInstance() {
        return Helper.INSTANCE;
    }

}

// Thread Safe
class SingletonEagerLoading {

    private static final SingletonEagerLoading singletonEagerLoading = new SingletonEagerLoading();

    private SingletonEagerLoading() {
    }

    public static SingletonEagerLoading getInstance() {
        return singletonEagerLoading;
    }
}

public class SingletonPattern {

    public static void main(String[] args) {

        // Service using EagerLoading
        SingletonEagerLoading service1 = SingletonEagerLoading.getInstance();
        SingletonEagerLoading service2 = SingletonEagerLoading.getInstance();
        System.out.println(service1);
        System.out.println(service2);

        // Service using LazyLoading Thread Unsafe
        SingletonLazyLoadingThreadUnsafe service3 = SingletonLazyLoadingThreadUnsafe.getInstance();
        SingletonLazyLoadingThreadUnsafe service4 = SingletonLazyLoadingThreadUnsafe.getInstance();
        System.out.println(service3);
        System.out.println(service4);

        // Service using LazyLoading Thread safe (unoptimized,performance issue)
        SingletonLazyLoadingThreadSafe service5 = SingletonLazyLoadingThreadSafe.getInstance();
        SingletonLazyLoadingThreadSafe service6 = SingletonLazyLoadingThreadSafe.getInstance();

        // Service using LazyLoading Bill Pugh
        SingletonLazyLoadingBillPugh service7 = SingletonLazyLoadingBillPugh.getInstance();
        SingletonLazyLoadingBillPugh service8 = SingletonLazyLoadingBillPugh.getInstance();
        System.out.println(service7);
        System.out.println(service8);
    }

}
