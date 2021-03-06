import chapter1.Q4_Palindrome;
import chapter4.*;
import chapter8.Q2_RobotInGrid;
import chapter8.Q3_MagicIndex;
import chapter8.Q4_AllSubsets;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {

        /*

        chapter1.ArrayList1_UniqueChars.class;
        chapter1.ArrayList2_CheckForPermutations.class;
        chapter1.ArrayList3_StringEditInPlace.class;
        BasicGraph.class;
        BreadthFirstSearch.class;
        DepthFirstSearch.class

        */
        /* Invoke the run method for the class in the package. */
        Class<?> c = Q4_AllSubsets.class ;

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
