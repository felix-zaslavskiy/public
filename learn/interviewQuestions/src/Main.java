import java.util.LinkedList;

public class Main {

    public static void detectCycle(LinkedList<String> x) {

        if(x.size() == 0 ) return;

        String currentSeen =  x.getFirst();

        x.removeFirst();

        for(String item: x) {

            if(item.equals(currentSeen)) {
                System.out.print(currentSeen);
                break;
            }



        }

        detectCycle(x);

    }



    public static void main(String[] args) {

        LinkedList<String> ls = new LinkedList<>();
        ls.add("A");
        ls.add("B");

        ls.add("C");

        ls.add("B");

        detectCycle(ls);

    }


}
