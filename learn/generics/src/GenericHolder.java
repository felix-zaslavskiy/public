public class GenericHolder< T extends  TestSuper> {
    T t;
    GenericHolder(T t) {
        this.t = t;
    }

    T test(){
        return t;
    }
}
