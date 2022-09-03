package me.cworldstar.sfdrugs.implementations.items;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.ProtectionType;
import io.github.thebusybiscuit.slimefun4.core.attributes.ProtectiveArmor;
import io.github.thebusybiscuit.slimefun4.implementation.items.armor.SlimefunArmorPiece;
import me.cworldstar.sfdrugs.SFDrugs;

public class PlatedHazmat extends SlimefunArmorPiece implements ProtectiveArmor {
	private SFDrugs plugin;
	public PlatedHazmat(SFDrugs plugin,ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe,
			PotionEffect[] effects) {
		super(itemGroup, item, recipeType, recipe, effects);
		this.plugin = plugin;
		// TODO Auto-generated constructor stub
	}

	@Override
	public ProtectionType[] getProtectionTypes() {
		// TODO Auto-generated method stub
		return new ProtectionType[] { ProtectionType.RADIATION };
	}

	@Override
	public boolean isFullSetRequired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public NamespacedKey getArmorSetId() {
		// TODO Auto-generated method stub
		return new NamespacedKey(this.plugin,"SFDRUGS_PLATED_HAZMAT");
	}

	public static SlimefunItemStack getByInteger(int i) {
		switch(i) {
			case 0:
				return new SlimefunItemStack("SFDRUGS_PLATED_HAZMAT_HELMET",new ItemStack(Material.NETHERITE_HELMET),"&7强化潜水头盔","","&6全套效果:","&e- 免疫辐射","&e- 免疫蜜蜂蜇","&e- 更多盔甲!");
			case 1:
				return new SlimefunItemStack("SFDRUGS_PLATED_HAZMAT_CHESTPLATE",new ItemStack(Material.NETHERITE_CHESTPLATE),"&7强化防护服","","&6全套效果:","&e- 免疫辐射","&e- 免疫蜜蜂蜇","&e- 更多盔甲!");
			case 2:
				return new SlimefunItemStack("SFDRUGS_PLATED_HAZMAT_LEGGINGS",new ItemStack(Material.NETHERITE_LEGGINGS),"&7强化防护护腿","","&6全套效果:","&e- 免疫辐射","&e- 免疫蜜蜂蜇","&e- 更多盔甲!");
			case 3:
				return new SlimefunItemStack("SFDRUGS_PLATED_HAZMAT_BOOTS",new ItemStack(Material.NETHERITE_BOOTS),"&7强化防护靴","","&6全套效果:","&e- 免疫辐射","&e- 免疫蜜蜂蜇","&e- 更多盔甲!");
		}
		return new SlimefunItemStack("SFDRUGS_ERROR", new ItemStack(Material.BARRIER));
	}


}
