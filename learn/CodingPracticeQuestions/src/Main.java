import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

        /*

        ArrayList1_UniqueChars.class;
        ArrayList2_CheckForPermutations.class;
        ArrayList3_StringEditInPlace.class;
        BasicGraph.class;
        BreadthFirstSearch.class;


        */
        // Invoke the run method for the class in the package.
        Class<?> c = DepthFirstSearch.class;

        Object t = c.newInstance();
        Method[] allMethods = c.getDeclaredMethods();
        for (Method m : allMethods) {
            String mname = m.getName();
            if(mname.equals("run")){
                m.invoke(t);
            }
        }

    }


}
