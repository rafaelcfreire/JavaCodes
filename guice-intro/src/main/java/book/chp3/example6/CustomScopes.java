package book.chp3.example6;

import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Scope;

public final class CustomScopes {
    public static final Scope DEFAULT = new Scope() {
        @Override
        public <T> Provider<T> scope(final Key<T> key, final Provider<T> creator) {
            System.out.println("Scoping: "+key);
            return creator;
        }

        @Override
        public String toString() {
            return CustomScopes.class.getSimpleName()+".DEFAULT";
        }
    };
}