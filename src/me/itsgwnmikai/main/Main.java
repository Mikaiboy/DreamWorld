package me.itsgwnmikai.main;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;

import me.itsgwnmikai.main.core.JoinListener;
import me.itsgwnmikai.main.kitmenu.KitpvpBoard;
import me.itsgwnmikai.main.kitmenu.compass;
import me.itsgwnmikai.main.listeners.compassOnJoin;
import me.itsgwnmikai.main.listeners.compassonrespawn;

public class Main extends JavaPlugin implements Listener{

	public void onEnable(){
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
		registerEvents();

		registerConfig();
		registerCommands();
		System.out.println("Flamenetwork kitpvp - Succesfully enabled.");
	}
	
	public void onDisable(){
		System.out.println("Flamenetwork kitpvp - Succesfully disabled.");
	}
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
    if(cmd.getName().equalsIgnoreCase("hub")) {
        sender.sendMessage(ChatColor.GOLD + "Sending you back to the hub...");
        Player p = (Player)sender;
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF("hub");
            } catch (IOException e) {
                e.printStackTrace();
            }
            p.sendPluginMessage(this, "BungeeCord", b.toByteArray());
    }if(cmd.getName().equalsIgnoreCase("skyblock")) {
        sender.sendMessage(ChatColor.GOLD + "Sending you to Skyblock...");
        Player p = (Player)sender;
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF("Skyblock");
            } catch (IOException e) {
                e.printStackTrace();
            }
            p.sendPluginMessage(this, "BungeeCord", b.toByteArray());
    }
	return false;
    }
	
	public void registerEvents(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		//pm.registerEvents(new menu(this), this);
		pm.registerEvents(this, this);
		pm.registerEvents(new compassOnJoin(this), this);
		pm.registerEvents(new compass(this), this);
		pm.registerEvents(new JoinListener(this), this);
		pm.registerEvents(new KitpvpBoard(this), this);
		pm.registerEvents(new compassonrespawn(this), this);
	}
	public void registerCommands(){
		//getCommand("COMMAND").setExecutor(new classname(this));
		getCommand("kit").setExecutor(new compass(this));
		getCommand("help").setExecutor(new JoinListener(this));
		getCommand("setrank").setExecutor(new JoinListener(this));
		getCommand("spawn").setExecutor(new JoinListener(this));
		getCommand("setspawn").setExecutor(new JoinListener(this));
		getCommand("announce").setExecutor(new JoinListener(this));
		getCommand("shutdown").setExecutor(new JoinListener(this));
		getCommand("flamekitpvp").setExecutor(new JoinListener(this));
	}
	public void registerConfig(){
        getConfig().addDefault("spawn.x", "");
        getConfig().addDefault("spawn.y", "");
        getConfig().addDefault("spawn.z", "");
        getConfig().addDefault("spawn.world", "");
        getConfig().addDefault("rank." + Bukkit.getPlayer(getName()) ,"Speler");
		getConfig().options().copyDefaults(true);
		saveConfig();
		

	}
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        getConfig().addDefault(e.getPlayer().getName() + ".kills","0");
        getConfig().addDefault(e.getPlayer().getName() + ".deaths","0");
        getConfig().addDefault("rank." + e.getPlayer().getName()  ,"Speler");
        getConfig().options().copyDefaults(true);
        saveConfig();
        new BukkitRunnable() {
                @Override
                public void run() {
                    if (e.getPlayer() == null || !e.getPlayer().isOnline()) {
                        cancel();
                        return;
                    }
                    final org.bukkit.scoreboard.Scoreboard s = Bukkit.getScoreboardManager().getNewScoreboard();
                    final Objective o = s.registerNewObjective("sidebar", "dummy");
                    o.setDisplaySlot(DisplaySlot.SIDEBAR);
                    o.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Kitpvp");
                    Score spacer = o.getScore(ChatColor.AQUA + "");
                    spacer.setScore(7);
                   
                    Score players = o.getScore(ChatColor.AQUA + "" + ChatColor.BOLD + "Welcome, " + ChatColor.GREEN + "" + ChatColor.BOLD + e.getPlayer().getName());
                    players.setScore(6);
                   
                    Score spacer1 = o.getScore(ChatColor.BLACK + "");
                    spacer1.setScore(5);
                   
                    String rank = getConfig().getString(  "rank." + e.getPlayer().getName(), "Speler");
                    Score r = o.getScore(ChatColor.AQUA + "" + ChatColor.BOLD + "Rank: " + ChatColor.GREEN + rank);
                    r.setScore(4);
                   
                    int killscounter = getConfig().getInt(e.getPlayer().getName() + ".kills");
                    Score kills = o.getScore(ChatColor.AQUA + "" + ChatColor.BOLD + "Kills: " + ChatColor.GREEN + killscounter);
                    kills.setScore(3);
                   
                    int deathscounter = getConfig().getInt(e.getPlayer().getName() + ".deaths");
                    Score deaths = o.getScore(ChatColor.AQUA + "" + ChatColor.BOLD + "Deaths: " + ChatColor.GREEN + deathscounter);
                    deaths.setScore(2);
                   
                    Score spacer2 = o.getScore(ChatColor.BLUE + "");
                    spacer2.setScore(1);
                   
                    Score ip = o.getScore(ChatColor.DARK_RED + "" + ChatColor.BOLD + "FlameNetwork.g-s.nu ");
                    ip.setScore(0);
                   
                    e.getPlayer().setScoreboard(s);
                }
            }.runTaskTimer(this, 10, 100);
    }
}
