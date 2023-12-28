package br.com.ehnois.chp7;

final class InterruptionExercise implements Runnable{
    @Override
    public void run() {
        int temp = 0;

        while (true) {
            System.out.println(String.format("Value is %d", temp++));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        InterruptionExercise ie = new InterruptionExercise();
        Thread t = new Thread(ie);
        t.start();
        System.out.println("Before call interrupt:"+t.isInterrupted());
        t.interrupt();
        System.out.println("After call interrupt: "+t.isInterrupted());
    }
}
