package me.cworldstar.sfdrugs.implementations.world.radiation;

import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

public class Radiation {
	public int RadiationIntensity;
	public Block localizedBlock;
	public int RadiationRadius;
	public BukkitRunnable RadiationRunnable;
	public Radiation(int RadiationIntensity, Block localizedBlock, int Radius) {
		this.RadiationIntensity = RadiationIntensity;
		this.localizedBlock = localizedBlock;
		this.RadiationRadius = Radius;
		this.RadiationRunnable = new BukkitRunnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
