package br.com.ehnois.chp4.pc;

final class SharedArray {
    private int count = 0;
    private volatile int[] resource = new int[0];

    public synchronized void addElement(int element) {
        int resourceLength = resource.length;
        int[] newResource = new int[resourceLength + 1];

        for (int i = 0; i < resourceLength; i++) {
            newResource[i] = resource[i];
        }
        newResource[resourceLength] = element;
        resource = newResource;
        count++;
        System.out.println(String.format("Element %d added to the resource%n", element));
    }

    public synchronized void consumeLast() {
        if (count == 0) {
            throw new RuntimeException("The resource is empty");
        }
        int resourceLength = resource.length;
        int[] newResource = new int[resourceLength - 1];
        int lastElement = resource[resourceLength - 1];

        for (int i = 0; i < resourceLength - 1; i++) {
            newResource[i] = resource[i];
        }
        resource = newResource;
        count--;
        System.out.println(String.format("Element %d removed from the resource", lastElement));
    }
}
