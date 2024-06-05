package mjic.chp3;

final class LocalVariableExample {
    public static void main(String[] args) {
        int portNumber = 8080;
        //portNumber= 8081;
        Runnable r = () -> System.out.println(portNumber);

        r.run();
    }
}