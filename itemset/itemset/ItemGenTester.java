package itemset;

import interfaces.IGenerator;
import interfaces.IManager;
import interfaces.IItem;

public class ItemGenTester
{
	public static void main(String[] args)
	{
		IManager<IItem> IM = new ItemManager();
		IGenerator IG = new ItemGenerator(IM);
		int eventID = 000;
      
		eventID = IG.build();
      
      if(eventID == 820)
      {
		 for(int index = 0; index < IM.size(); index++)
         {
            System.out.println("ID: " + IM.get(index).getID());
            System.out.println("EvID: " + IM.get(index).getEventID());
            System.out.println("Name: " + IM.get(index).getName());
            System.out.println("Effect Type: " + IM.get(index).getEffectType());
            System.out.println("Effect: " + IM.get(index).getEffect());
            System.out.println("PF Limit: " + IM.get(index).getPFLimit());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
         }
      }
      else
         System.out.println("816 error");
	}
}