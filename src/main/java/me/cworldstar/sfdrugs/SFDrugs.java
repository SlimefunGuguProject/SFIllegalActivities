package me.cworldstar.sfdrugs;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.command.CommandMap;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.cworldstar.sfdrugs.events.CorporationTraderEvent;
import me.cworldstar.sfdrugs.events.DrugSuitDamaged;
import me.cworldstar.sfdrugs.events.DrugSuitWearerDamaged;
import me.cworldstar.sfdrugs.events.LaserProjectileHit;
import me.cworldstar.sfdrugs.events.MysteriousTraderEvent;
import me.cworldstar.sfdrugs.events.RobotArmorDamaged;
import me.cworldstar.sfdrugs.events.RobotArmorPieceEquipped;
import me.cworldstar.sfdrugs.events.SFHookerEvent;
import me.cworldstar.sfdrugs.implementations.commands.TestCorporationEnemy;
import me.cworldstar.sfdrugs.implementations.events.ArmorListener;
import me.cworldstar.sfdrugs.utils.Items;
import me.cworldstar.sfdrugs.utils.Trading;

public class SFDrugs extends JavaPlugin implements SlimefunAddon {
	@SuppressWarnings("unused")
	@Override
    public void onEnable() {
        // Give your Category a unique id.
    	Items ItemRegistry = new Items(this);
		getServer().getPluginManager().registerEvents(new ArmorListener(new ArrayList<String>()), this);
    	DrugSuitDamaged DamageEvent = new DrugSuitDamaged(this);
    	DrugSuitWearerDamaged DamageEvent2 = new DrugSuitWearerDamaged(this);
    	ItemRegistry.register();
    	Trading TradingRegistry = new Trading(this);
    	TradingRegistry.register();
    	SFHookerEvent HookerEvent = new SFHookerEvent(this,TradingRegistry);
    	CorporationTraderEvent TraderEvent = new CorporationTraderEvent(this,TradingRegistry);
    	MysteriousTraderEvent TraderEvent2 = new MysteriousTraderEvent(this,TradingRegistry);
    	RobotArmorDamaged RobotArmorEvent = new RobotArmorDamaged(this);
    	RobotArmorPieceEquipped RobotArmorPieceEquipped = new RobotArmorPieceEquipped(this);
    	LaserProjectileHit LaserProjectileHitEvent = new LaserProjectileHit(this);
    	TestCorporationEnemy Command = new TestCorporationEnemy(this);
    	this.getCommand("test").setExecutor(Command);
    	Logger x = getLogger();
    	x.log(Level.INFO, "============================================");
    	x.log(Level.INFO, "====                                     ===");
    	x.log(Level.INFO, "====         SF DRUGS ENABLED            ===");
    	x.log(Level.INFO, "====             v 4.2.0                 ===");
    	x.log(Level.INFO, "====         by China Worldstar          ===");
    	x.log(Level.INFO, "====                                     ===");
    	x.log(Level.INFO, "============================================");
    }
    @Override
    public void onDisable() {}
 
    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }
    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}
