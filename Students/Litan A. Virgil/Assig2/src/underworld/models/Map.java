package underworld.models;

import underworld.utils.Constants;
import underworld.utils.Resources;

public class Map {
	private int[] resources;
	
	public Map(){
		resources = new int[Constants.MAP_RESOURCES_NUMBER];
		for (int i = 0; i < Constants.MAP_RESOURCES_NUMBER; i++){
			resources[i] = 0;
		}
	}
	
	public void generateResources(){
		for (int i = 0; i < Constants.MAP_RESOURCES_NUMBER; i++){
			resources[i] = Resources.generateValuableResource();
		}
	}
	
	public boolean consumeResource(int resource){
		boolean found = false;
		
		for (int i = 0; i < Constants.MAP_RESOURCES_NUMBER; i++){
			if (resources[i] == resource){
				resources[i] = -1;
				found = true;
			}
		}
		return (found);
	}
	
	public void showResources()
	{
		System.out.println("[Map] The resources are:");
		for (int i = 0; i < Constants.MAP_RESOURCES_NUMBER; i++){
			System.out.println("[Map] At index " + i + " you got " + resources[i]);
		}
		System.out.println("[Map] --------end map--------");
	}
	
}
