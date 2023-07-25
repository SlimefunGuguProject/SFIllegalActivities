package me.cworldstar.sfdrugs.implementations.powerarmor;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.cworldstar.sfdrugs.SFDrugs;

public class PowerArmor extends SlimefunItem {

	private ItemStack Armor;

	public PowerArmor(ItemGroup itemGroup, ItemStack item, String id, RecipeType recipeType, ItemStack[] recipe) {
		super(itemGroup, item, id, recipeType, recipe);
		
		this.Armor = item;
		this.getItem().getItemMeta().getPersistentDataContainer().set(SFDrugs.createKey("power_armor_base"), PersistentDataType.INTEGER,1);
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<PowerArmorCoreUpgrade> getUpgrades(PowerArmor armorPiece) {

		
		return null;
	}

	public static PowerArmorCore getCore(PowerArmor armorPiece) {
		// TODO Auto-generated method stub
		return (PowerArmorCore) SlimefunItem.getById(armorPiece.getItem().getItemMeta().getPersistentDataContainer().get(SFDrugs.createKey("power_armor_core"),PersistentDataType.STRING));
	}

}
