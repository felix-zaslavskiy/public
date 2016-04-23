public class Test3<T> {
    T t;

    Test3(T t) {
        this.t = t;
    }

    Integer test() {
        return (Integer)t;
    }
}
