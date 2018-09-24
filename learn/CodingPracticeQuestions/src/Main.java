import chapter1.Q4_Palindrome;
import chapter4.Q1_Routes_Nodes;
import chapter4.Q2_Create_MinHeight_BinaryTree;
import chapter4.Q3_List_Of_Depths;
import chapter4.Q4_Check_Balanced;
import chapter4.Q5_Validate_BST;
import chapter4.Q6_Successor;

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
        // Invoke the run method for the class in the package.
        Class<?> c = Q6_Successor.class ;

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
