package generics;

final class TypedAttribute<K, V> {
    private final K synchronizedKey = newTypedObject();
    private final V synchronizedValue = newTypedObject();

    K getKey() {
        return this.synchronizedKey;
    }

    V getValue() {
        return this.synchronizedValue;
    }

    private static <T> T newTypedObject() {
        return (T) new Object();
    }

    public static void main(String[] args) {
        TypedAttribute<String, Integer> instanceOne = new TypedAttribute<>();
        TypedAttribute<String, Integer> instanceTwo = new TypedAttribute<>();

        String key = instanceOne.getKey();
        Integer value = instanceTwo.getValue();
    }
}
