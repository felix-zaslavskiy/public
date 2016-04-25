import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args){

        Hashtable<String, Object> env = new Hashtable<String, Object>();
        env.put(Context.INITIAL_CONTEXT_FACTORY,
                "com.sun.jndi.ldap.LdapCtxFactory");

        env.put(Context.PROVIDER_URL, "ldap://192.168.99.100:389");
        env.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
        env.put(Context.SECURITY_CREDENTIALS, "secret");

        try {
            // Create initial context (first connection)
            DirContext ctx = new InitialDirContext(env);

            System.out.println(ctx.getAttributes(
                    "o=JNDITutorial, dc=example, dc=com"));

            // Get a child context
            Hashtable h = (Hashtable) ctx.lookup("cn=Hashtable,ou=Objects,cn=Rosanna Lee,ou=People,o=JNDITutorial, dc=example, dc=com");
            System.out.println( h.get("java.naming.factory.initial") );

            // Close the contexts when we're done
            ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }


}
