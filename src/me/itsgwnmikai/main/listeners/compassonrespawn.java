package me.itsgwnmikai.main.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.itsgwnmikai.main.Main;

public class compassonrespawn implements Listener{
	private Main main;
	public compassonrespawn(Main main) {
		this.main = main;
	}
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		ItemStack compass = new ItemStack(Material.COMPASS);
		ItemMeta compassmeta = compass.getItemMeta();

		compassmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&k;;&r&cFlameNetwork Kits&4&k;;&r"));
		compass.setItemMeta(compassmeta);
		
		Player player = event.getPlayer();
		player.getInventory().setItem(4, compass);


	}
}
