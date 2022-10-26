package demo;

import com.google.inject.*;

import javax.inject.Inject;
import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class GuiceDemo {
    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    @interface Message {}

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    @interface Count {}

    @Qualifier
    @Retention(RetentionPolicy.RUNTIME)
    @interface Text {}

    static class DemoModule extends AbstractModule {
//        @Provides
//        @Count
//        static Integer provideCount() {
//            return 3;
//        }
//
//        @Provides
//        @Message
//        static String provideMessage() {
//            return "Hello World";
//        }

        @Override
        protected void configure() {
            bind(String.class).annotatedWith(Message.class).toInstance("Hello World");
            bind(String.class).annotatedWith(Text.class).toInstance("Another text");
            bind(Integer.class).toInstance(3);

        }
    }

    static class Greeter {

        @Message
        private final String message;
        private final int count;

        @Text
        private final String text;

        @Inject
        Greeter(@Message String message, int count, @Text String text) {
            this.message = message;
            this.count = count;
            this.text = text;
        }

        void sayHello() {
            for (int i = 0; i < count; i++) {
                System.out.println(message+", "+text);
            }
        }
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new DemoModule());

        Greeter greeter = injector.getInstance(Greeter.class);

        greeter.sayHello();
    }
}
