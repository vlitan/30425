package underworld.models;

import underworld.utils.Constants;
import underworld.utils.Resources;

public class Miner {
	private String name;
	private int[] backpack;
	private int backpackIndex;
	
	public Miner(String name){
		backpack = new int[Constants.MINER_BACKPACK_SIZE];
		backpackIndex = 0;
		this.name = name;
		for (int i = 0; i < Constants.MINER_BACKPACK_SIZE; i++){
			backpack[i] = -1;
		}
	}
	//public methods
	public int dig(){
		if (isBackpackFull()){
			return (-1);
		}
		else{
			backpack[backpackIndex++] = Resources.generateResource();
			return (backpack[backpackIndex - 1]);
		}
	}
	
	public int sleep(){
		return (Resources.generateResource());
	}
	
	public void showBackpack(){
		System.out.println("[Miner] The backpack of miner '" + this.name +"' contains:");
		for (int i = 0; i < Constants.MINER_BACKPACK_SIZE; i++){
			System.out.println("[Miner] in slot " + i + " the resource " + backpack[i]);
		}
		System.out.println("[Miner] --------end backpack--------");
	}
	//name field getter/setter
	public String getName(){
		return (this.name);
	}
	
	public void	setName(String name){
		this.name = name;
	}
	//private
	private boolean isBackpackFull(){
		return (getNumberOfBackpackSlots() <= 0);
	}
	
	private int getNumberOfBackpackSlots(){
		return (Constants.MINER_BACKPACK_SIZE - backpackIndex);
	}
}
