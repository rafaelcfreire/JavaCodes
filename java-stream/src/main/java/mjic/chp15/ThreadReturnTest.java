package mjic.chp15;

final class ThreadReturnTest {

    void createAnotherThread() {
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("After letting the second thread sleep");
        }).start();
        System.out.println("Returning to main");
    }

    public static void main(String[] args) {
        ThreadReturnTest threadReturnTest = new ThreadReturnTest();
        threadReturnTest.createAnotherThread();
        System.out.println("Back to main thread");
    }
}