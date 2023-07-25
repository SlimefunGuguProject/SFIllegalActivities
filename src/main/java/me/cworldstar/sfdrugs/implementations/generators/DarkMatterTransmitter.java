package me.cworldstar.sfdrugs.implementations.generators;

import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import io.github.mooy1.infinitylib.machines.AbstractMachineBlock;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockPlaceHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import me.cworldstar.sfdrugs.SFDrugs;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

public class DarkMatterTransmitter extends SlimefunItem implements DarkMatter, Listener {

	public SFDrugs plugin;
	
	public void tickTransmit() {
	
	}
	
	
	public DarkMatterTransmitter(SFDrugs plugin, ItemGroup category, SlimefunItemStack item, RecipeType recipeType,
			ItemStack[] recipe) {
		super(category, item, recipeType, recipe);
		// TODO Auto-generated constructor stub
		if(item.getItem() instanceof Block) {
			((Block) item).setMetadata("dark-matter-transmitter", new FixedMetadataValue(plugin,true));
		};
	}
	
	@Override
	public void preRegister() {		
		this.addItemHandler(new BlockPlaceHandler(false) {
			@Override
			public void onPlayerPlace(BlockPlaceEvent e) {
				// TODO Auto-generated method stub
				//Block PlacedBlock = this.
				
			}
		});
	}


	@Override
	public SFDrugs getPlugin() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getDarkMatterCapacity() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void onExplode(Block b) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onBreakdown(Block b, double integrity) {
		// TODO Auto-generated method stub
		
	}




}
 