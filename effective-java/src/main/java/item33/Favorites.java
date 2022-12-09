package item33;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
final class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), instance);
    }
    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    public static void main(String[] args) {
        Favorites favorites1 = new Favorites();
        favorites1.putFavorite(List.class, List.of(1, 2, 3));

    }
}
