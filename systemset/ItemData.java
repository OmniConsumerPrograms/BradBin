package systemset;

import interfaces.IGetData;
import interfaces.IItem;

public class ItemData implements IGetData<IItem>
{	
	private String[] effectNames;
	private int[] effectEIDs;
	
	public ItemData()
	{
		effectNames = new String[25];
		effectEIDs = new int[25];
		
		buildSets();
	}
	
	private void buildSets()
	{
		effectNames[0] = "Healing HP";
		effectNames[1] = "Restoring MP";
		effectNames[2] = "Restoring HP/MP";
		effectNames[3] = "Reviving from KO";
		effectNames[4] = "Restoring durability";
		effectNames[5] = "Cures poison";
		effectNames[6] = "Cures rage";
		effectNames[7] = "Cures panic";
		effectNames[8] = "Cures confusion";
		effectNames[9] = "Boosts Attack";
		effectNames[10] = "Boosts magic attack";
		effectNames[11] = "Boosts defence";
		effectNames[12] = "Boosts attack speed";
		effectNames[13] = "Boosts magic defence";
		effectNames[14] = "Boosts accuracy";
		effectNames[15] = "Escape battle";
		effectNames[16] = "Stops enemy attack";
		effectNames[17] = "Cures nerf";
		effectNames[18] = "Cures buff";
		effectNames[19] = "Boosts HP";
		effectNames[20] = "Boosts MP";
		effectNames[21] = "Boosts HP/MP";
		effectNames[22] = "Boosts all stats";
		effectNames[23] = "Blows up enemy party";
		effectNames[24] = "Ends the battle";
		
		effectEIDs[0] = 100;
		effectEIDs[1] = 140;
		effectEIDs[2] = 120;
		effectEIDs[3] = 780;
		effectEIDs[4] = 600;
		effectEIDs[5] = 740;
		effectEIDs[6] = 750;
		effectEIDs[7] = 760;
		effectEIDs[8] = 770;
		effectEIDs[9] = 200;
		effectEIDs[10] = 230;
		effectEIDs[11] = 210;
		effectEIDs[12] = 220;
		effectEIDs[13] = 240;
		effectEIDs[14] = 260;
		effectEIDs[15] = 500;
		effectEIDs[16] = 510;
		effectEIDs[17] = 520;
		effectEIDs[18] = 530;
		effectEIDs[19] = 110;
		effectEIDs[20] = 150;
		effectEIDs[21] = 130;
		effectEIDs[22] = 274;
		effectEIDs[23] = 540;
		effectEIDs[24] = 560;
	}
	
	private String findType(IItem item)
	{
		String s = "";
		
		for(int index = 0; index < effectEIDs.length; index++)
		{
			if(item.getEventID() == effectEIDs[index])
				s = effectNames[index];
		}
		
		return s;
	}
	
	public String getData(IItem item)
	{
		String s = "";
		
		s += item.getName() + "\n";
		s += item.getEffectType() + "\n";
		s += "Effect: " + item.getEffect() + "% : type: " + findType(item) + "\n";
		
		return s;
	}

}
