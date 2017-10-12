package me.itsgwnmikai.main.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.itsgwnmikai.main.Main;
import me.itsgwnmikai.main.kitmenu.compass;

public class compassOnJoin implements Listener {
	@SuppressWarnings("unused")
	private Main main;

	public compassOnJoin(Main main) {
		this.main = main;
	}

	@EventHandler
	public void compassJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		ItemStack compass = new ItemStack(Material.COMPASS);
		ItemMeta compassmeta = compass.getItemMeta();

		compassmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&k;;&r&cFlameNetwork Kits&4&k;;&r"));
		compass.setItemMeta(compassmeta);
		
		if (p.hasPermission("kitpvp.compass")) {
			p.sendMessage(ChatColor.GREEN + "You didnt recieve the kit compass because you have the permission "
					+ ChatColor.RED + "kitpvp.compass");
		} else			
			p.getInventory().setItem(4, compass);
	}

	@EventHandler
	public void compassint(PlayerInteractEvent e2) {
		Player p = e2.getPlayer();
		Action action = e2.getAction();
		if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)
				|| action.equals(Action.LEFT_CLICK_AIR) || action.equals(Action.LEFT_CLICK_BLOCK)) {
			if (p.getItemInHand().getType() == Material.COMPASS) {
				p.openInventory(compass.flameinv);
			}
		}

	}
}
