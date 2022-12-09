package demo;

import com.google.inject.*;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/*
 * https://github.com/google/guice/wiki/GettingStarted
 */
final class GuiceDemo {
    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    @interface Message {}

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    @interface SecondaryText {}

    static class DemoModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(String.class).annotatedWith(Message.class).toInstance("Hello World");
            bind(Integer.class).toInstance(3);
            bind(String.class).annotatedWith(SecondaryText.class).toInstance("secondaryText");
        }
    }

    static class Greeter {
        @Message
        private final String message;
        private final int count;
        @SecondaryText
        private final String secondaryText;

        @Inject
        public Greeter(@Message String message, int count, @SecondaryText String secondaryText) {
            this.message = message;
            this.count = count;
            this.secondaryText = secondaryText;
        }

        void sayHello() {
            for (int i = 0; i < count; i++) {
                System.out.println(message+", "+secondaryText);
            }
        }
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new DemoModule());
        Greeter greeter = injector.getInstance(Greeter.class);
        greeter.sayHello();
    }
}
