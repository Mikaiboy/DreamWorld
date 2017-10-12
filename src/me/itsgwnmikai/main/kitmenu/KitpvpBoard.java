package me.itsgwnmikai.main.kitmenu;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;


import com.nametagedit.plugin.NametagEdit;

import me.itsgwnmikai.main.Main;

public class KitpvpBoard implements Listener{
	
	private Main main;
	public KitpvpBoard(Main main){
		this.main = main;
	}

	@EventHandler
    public void onDie(PlayerDeathEvent e) {
        Player player = e.getEntity().getPlayer();
        Player killer = e.getEntity().getKiller();
        List<ItemStack> drops = e.getDrops();
        EntityDamageEvent ede = player.getLastDamageCause();
        EntityDamageEvent.DamageCause dc = ede.getCause();

        int beforedeaths = main.getConfig().getInt(player.getName() + ".deaths");
        int deaths = beforedeaths + 1;

        main.getConfig().set(player.getName() + ".deaths", deaths);

        drops.clear();

        if (killer != null) {
            e.setDeathMessage(ChatColor.GOLD + player.getName() + ChatColor.RED + " got killed by " + ChatColor.GOLD + killer.getName() + ChatColor.RED + "!");

            giveGoldenApple(killer);
            fullHealt(killer);
            
            killer.sendMessage(ChatColor.AQUA + "You have been rewarded 1 golden apple for killing " + ChatColor.RED + player.getName());

            int beforekills = main.getConfig().getInt(killer.getName() + ".kills");
            int kills = beforekills + 1;
            main.getConfig().set(killer.getName() + ".kills", kills);
        }

        if (dc == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION || dc == EntityDamageEvent.DamageCause.SUFFOCATION
                || dc == EntityDamageEvent.DamageCause.FALL || dc == EntityDamageEvent.DamageCause.DROWNING
                || dc == EntityDamageEvent.DamageCause.FIRE || dc == EntityDamageEvent.DamageCause.POISON
                || dc == EntityDamageEvent.DamageCause.SUICIDE) {
            e.setDeathMessage(ChatColor.GOLD + player.getName() + ChatColor.RED + " died!");
        }

        main.saveConfig();
    }

    public void giveGoldenApple(Player player) {
        ItemStack gapple1 = new ItemStack(Material.GOLDEN_APPLE, 1);
        ItemMeta gapplemeta1 = gapple1.getItemMeta();

        gapplemeta1.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6&lGapples"));
        gapple1.setItemMeta(gapplemeta1);

        player.getInventory().addItem(gapple1);
    }
    public void fullHealt(Player player) {
        player.setHealth(20);
    }
}
