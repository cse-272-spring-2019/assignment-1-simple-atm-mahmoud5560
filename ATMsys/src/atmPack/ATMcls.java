package atmPack;

public class ATMcls {
	

	public boolean checkCode (String userCode, String inputCode)
	{
      
        if (userCode.equals(inputCode))
      {
    	  return true;
      }
      else 
      {
    	  return false;
      }
      
		
	}
	
}