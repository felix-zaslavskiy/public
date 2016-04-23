public class Main {
    public static void  main(String[] args){
        Test<Integer> t = new Test<>(new Integer(3));
        Integer y = t.test();

        Test2<Integer> t2 = new Test2<>(new Integer(2));
        Integer x = t2.test();

        Test3<Integer> t3 = new Test3<>(new Integer(1));
        Integer m = t3.test();

        // Test2 does not have upper bound so can store anything
        Test2<String> l = new Test2<>("blah");
        String p  = l.test();

        // Test3 - wont compile
        //Integer q = l.test();

        // Won't compile
        //Integer q = (Integer)l.test();

        // Runtime error
        //Raw r = new Raw("blah");
        //Integer i = (Integer)r.test();

        Test2<TestSubclass> xy = new Test2<>(new TestSubclass());
        TestSuper ui = xy.test();

        Raw r = new Raw(new TestSubclass());
        TestSuper ux = (TestSuper)r.test();

        Holder e = new Holder(new TestSubclass());
        TestSuper lx = e.test();


        // Up the hieriarchy? Reqiures casts.. no matter if using Generics
        Test2<TestSuper> we = new Test2<>(new TestSubclass());
        TestSubclass mx = (TestSubclass)we.test();

        Holder ex = new Holder(new TestSubclass());
        TestSubclass vn = (TestSubclass)ex.test();

        Raw cv = new Raw(new TestSubclass());
        TestSubclass mk = (TestSubclass) cv.test();


        GenericHolder<TestSubclass> iu = new GenericHolder<>(new TestSubclass());
        TestSuper io = iu.test();

        GenericHolder<TestSuper> qe = new GenericHolder<>(new TestSubclass());
        TestSubclass oy = (TestSubclass)qe.test(); // Still need cast to go up.


    }
}
