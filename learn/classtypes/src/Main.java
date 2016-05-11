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

public class Main {

    static public void main(String[] args) {

        OuterClass.StaticNestedClass x = new OuterClass.StaticNestedClass();
        x.testMethod();


        OuterClass y =  new OuterClass();
        //y.x.testMethod();

    }


}



