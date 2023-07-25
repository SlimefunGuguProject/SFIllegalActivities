package me.cworldstar.sfdrugs.events;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.TradingRecipe;
import me.cworldstar.sfdrugs.implementations.gui.ATradingInterface;
import me.cworldstar.sfdrugs.implementations.gui.ATradingInterface.InventorySize;
import me.cworldstar.sfdrugs.implementations.traders.ATrader;
import me.cworldstar.sfdrugs.implementations.traders.CorporationTrader;
import me.cworldstar.sfdrugs.implementations.traders.HookerZombie;
import me.cworldstar.sfdrugs.utils.Items;
import me.cworldstar.sfdrugs.utils.Trading;
import net.md_5.bungee.api.ChatColor;

public class CorporationTraderEvent implements Listener {
	private SFDrugs plugin;
    public CorporationTraderEvent(SFDrugs plugin, Trading tradingRegistry) {
    	this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    private void Speak(Player p, String text) {
    	p.getWorld().playSound(p.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 0.6F, 0.2F);
    	p.sendMessage(ChatColor.translateAlternateColorCodes('&', text));
    }
	@EventHandler(priority = EventPriority.HIGH)
    private void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
    	Player p = event.getPlayer();
    	if(!event.getRightClicked().hasMetadata("SFDRUGS_IS_CORPORATION_TRADER") & !(event.getHand() == EquipmentSlot.HAND)) {
    		event.setCancelled(true);
    		return;
    	} else if(event.getRightClicked().hasMetadata("SFDRUGS_IS_CORPORATION_TRADER")) {
        	p.setMetadata("SFDRUGS_PLAYER_IS_RIGHTCLICKING_TRADER",new FixedMetadataValue(this.plugin,true));
            new BukkitRunnable() {
                @Override
                public void run() {
                	p.removeMetadata("SFDRUGS_PLAYER_IS_RIGHTCLICKING_TRADER", plugin);
               }
            }.runTaskLater(plugin, 20L);
            
        	PlayerInventory I = p.getInventory();
        	ATradingInterface TheTrading = new ATradingInterface(InventorySize.LARGE, new ItemStack(Material.BLACK_STAINED_GLASS_PANE), ATrader.TraderFromEntity(event.getRightClicked()));
        	TheTrading.Display(p);
    	}

    }
}
