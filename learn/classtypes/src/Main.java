import java.util.function.Predicate;

enum TestEnum {
    Value1,
    Value2,
    Value3

}

class OuterClass {

    int i = 0;

    public static class StaticNestedClass {

        void testMethod() {

        }

    }
    interface Helper {}

    private class InnerClass implements  Helper {

        void testMethod() {
            System.out.println(this);
            System.out.println(OuterClass.this);
        }

    }

    public void localClass() {
        class Test {

            Test() {
                i = 2;
            }
        }
        Test t = new Test();
    }

    InnerClass x = new InnerClass();
}

class SuperClass {
    {
        System.out.println("In superclass initializer");
    }
    SuperClass() {
        System.out.println("In Superclass default constructor.");
    }
    SuperClass(int i ) {
        this();
        System.out.println("In Superclass 1 constructor.");
    }
}

class SubClass extends  SuperClass {
    {
        System.out.println("In Subclass initializer");
    }
    SubClass() {
        super(1);
        System.out.println("In Subclass default constructor.");
    }

    SubClass(int i) {
        this();
        System.out.println("In Subclass 1 constructor.");
    }

    SubClass(boolean x) {
        System.out.println("In Subclass 2 constructor.");
    }
}

public class Main {

    static public void main(String[] args) {

        OuterClass.StaticNestedClass x = new OuterClass.StaticNestedClass();
        x.testMethod();


        OuterClass y =  new OuterClass();
        //y.x.testMethod();

        SubClass s = new SubClass(1);

        // Lambda


    }


    public static <T> void takeLamba(Predicate<T> p){

    }
}




