public class Test implements  AutoCloseable {
    boolean wasClosed = false;

    @Override
    public void close() throws Exception {
        wasClosed = true;
        throw new Exception("Inside close");
    }

    protected void finalize() throws  Exception {
        System.out.println("IN finalize.");

        if(!wasClosed){
            this.close();
        }

        System.out.println("blash");

    }
    public void print(){
        System.out.println("hahshshxxxxxwwwwwwwxxxszzzzz");
    }
}
