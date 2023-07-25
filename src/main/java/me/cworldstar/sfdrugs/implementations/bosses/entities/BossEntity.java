package me.cworldstar.sfdrugs.implementations.bosses.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootTable;
import org.bukkit.metadata.FixedMetadataValue;

import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.bosses.entities.EntityDialog.Personality;



public abstract class BossEntity implements Listener  {
	private LivingEntity entity;
	public abstract void applyEntityEdits(SFDrugs plugin, Zombie z);
	public abstract EntityDialog registerDialogs();
	
	public abstract void addDialog(String dialog);
	
	private List<Skill> skills = new ArrayList<Skill>();
	public BossEntity(EntityType Entity,World world,Location location, String unlocalized_id) {
		SFDrugs plugin = SFDrugs.getPlugin(SFDrugs.class);
		this.entity = (LivingEntity) world.spawnEntity(location, Entity);
		this.applyEntityEdits(plugin, (Zombie) this.entity);
		this.entity.setMetadata("SFDRUGS_CUSTOM_MOB",new FixedMetadataValue(plugin,unlocalized_id));
	}
	
	public BossEntity(Zombie z, String unlocalized_id) {
		this.entity = z;
		this.applyEntityEdits(SFDrugs.getPlugin(SFDrugs.class), z);
		this.entity.setMetadata("SFDRUGS_CUSTOM_MOB",new FixedMetadataValue(SFDrugs.getPlugin(SFDrugs.class),unlocalized_id));
	}
	
	public LivingEntity getEntity() {
		return this.entity;
	}
	public void setEntity(LivingEntity entity) {
		this.entity = entity;
	}

	/**
	 *
	 * ItemStack Helmet, ItemStack Chestplate, ItemStack Leggings, ItemStack Boots.
	 *
	 * @author cworldstar
	 * @param ItemStack, ItemStack, ItemStack, ItemStack
	 * 
	 */
	public void setArmor(ItemStack helmet,ItemStack chest,ItemStack leggings,ItemStack boots) {
		this.entity.getEquipment().setArmorContents(new ItemStack[] {boots, leggings, chest, helmet});
	}
	/**
	 * 
	 * uses a random skill from the skill database.
	 * 
	 * @author cworldstar
	 * 
	 */
	public void useRandomSkill() {
		Bukkit.getScheduler().runTask(SFDrugs.getPlugin(SFDrugs.class), this.skills.get(new Random().nextInt(skills.size()))::use);
	}
	/**
	 * 
	 * Adds a skill to an entity.
	 * 
	 * @author cworldstar
	 * @param Skill
	 */
	public void addSkillToEntity(Skill Skill) {
		this.skills.add(Skill);
	}
	
	public List<Skill> getSkills() {
		return this.skills;
	}

	public boolean hasSkill(Skill s) {
		return (this.skills.contains(s));
	}
}
