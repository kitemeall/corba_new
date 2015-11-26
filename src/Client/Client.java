package Client;

import StringLengthApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.util.Scanner;


public class Client {

    private StringLength stringLengthImpl;

    public Client(String args[]) {
        try {
            // create and initialize the ORB
       ;
            ORB orb = ORB.init(args, null);

            // get the root naming context
            org.omg.CORBA.Object objRef
                    = orb.resolve_initial_references("NameService");
            // Use NamingContextExt instead of NamingContext. This is 
            // part of the Interoperable naming Service.  
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // resolve the Object Reference in Naming
            String name = "StringLength";
            stringLengthImpl = StringLengthHelper.narrow(ncRef.resolve_str(name));

            //helloImpl.shutdown();
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
    
    public String getStringLength(String s){
        return stringLengthImpl.getStringLength(s);
    }

    public static void main(String args[]) {
       
        
       Client client = new Client(args);
       Scanner in = new Scanner(System.in);
       String text = in.nextLine();
       in.close();  
       
       System.out.println(client.getStringLength(text));
 
    }

}
