public class Test<T extends Integer> {
    T x;
    Test(T t) {
        x=t;
    }
    T test() {

        return x;
    }
}
