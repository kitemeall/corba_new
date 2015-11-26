package Server;
import StringLengthApp.StringLengthPOA;
import org.omg.CORBA.ORB;

class StringLengthImpl extends StringLengthPOA
{
	private ORB orb;
	public void setORB(ORB orb_val) 
	{
		orb = orb_val; 
	}
        @Override
	public String getStringLength( String str) 
	{
		System.out.println("Server recieved message: " + str);
		try {
    		Thread.sleep(5000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
    		Thread.currentThread().interrupt();
		}




		return  String.valueOf(str.length());
	}
        @Override
	public void shutdown() 
	{
		orb.shutdown(true);
	}
}