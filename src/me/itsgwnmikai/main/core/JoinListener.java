package me.itsgwnmikai.main.core;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

import com.connorlinfoot.titleapi.TitleAPI;
import com.nametagedit.plugin.NametagEdit;

import me.itsgwnmikai.main.Main;

public class JoinListener implements Listener, CommandExecutor{
	
	private Main main;
	public JoinListener(Main main){
		this.main = main;
	}
	//JoinEvent
	@EventHandler
	    public void onJoin(PlayerJoinEvent e) {
	            e.getPlayer().performCommand("spawn");
	            TitleAPI.sendTitle(e.getPlayer(), 30, 5 * 20, 10, ChatColor.RED + "Welcome!", "to Flamenetwork pvp.");
	            Player target = e.getPlayer();
	            if(main.getConfig().get("rank." + e.getPlayer().getName()).equals("Owner")) {
	                String prefix = "&7[&4Owner&7]&6";
	                NametagEdit.getApi().setPrefix(target, prefix);
	            }
	            if(main.getConfig().get("rank." + e.getPlayer().getName()).equals("Moderator")) {
	                String prefix = "&7[&2Mod&7]&6";
	                NametagEdit.getApi().setPrefix(target, prefix);
	            }
	            if(main.getConfig().get("rank." + e.getPlayer().getName()).equals("Helper")) {
	                String prefix = "&7[&3Helper&7]&6";
	                NametagEdit.getApi().setPrefix(target, prefix);
	            }
	            if(main.getConfig().get("rank." + e.getPlayer().getName()).equals("Admin")) {
	                String prefix = "&7[&1Admin&7]&6";
	                NametagEdit.getApi().setPrefix(target, prefix);
	            }
	            if(main.getConfig().get("rank." + e.getPlayer().getName()).equals("Speler")) {
	                String prefix = "&7[&3Member&7]&6";
	                NametagEdit.getApi().setPrefix(target, prefix);
	            }
	    if(main.getConfig().get("rank." + e.getPlayer().getName()).equals("Speler")) {
	            if(main.getConfig().get("lockdown").equals("true")) {
	                e.setJoinMessage("");
	                String lockreason = main.getConfig().getString("lockreason");
	                e.getPlayer().kickPlayer(lockreason);
	            }
	            if(main.getConfig().get("lockdown").equals("false")) {
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage(ChatColor.GRAY + "_____________________________________________");
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "                  <FlameNetwork>");
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "      Welcome to kitpvp, " + e.getPlayer().getName() + "!");
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "      Select a kit with " + ChatColor.GREEN + "" + ChatColor.BOLD + "the compass" + ChatColor.GOLD + "" + ChatColor.BOLD + " to start!");
	                e.getPlayer().sendMessage("");
	                e.getPlayer().sendMessage(ChatColor.GRAY + "_____________________________________________");
	                e.setJoinMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + ChatColor.GRAY + e.getPlayer().getName());
	            }
	        } else {
	            e.getPlayer().performCommand("staff");
	            e.setJoinMessage("");
	            e.getPlayer().sendMessage("");
	            e.getPlayer().sendMessage("");
	            e.getPlayer().sendMessage("");
	            e.getPlayer().sendMessage("");
	            e.getPlayer().sendMessage("");
	            e.getPlayer().sendMessage("");
	            e.getPlayer().sendMessage("");
	            e.getPlayer().sendMessage("");
	            e.getPlayer().sendMessage("");
	            e.getPlayer().sendMessage("");
	            e.getPlayer().sendMessage("");
	            e.getPlayer().sendMessage("");
	            e.getPlayer().sendMessage("");
	            e.getPlayer().sendMessage("");
	            e.getPlayer().sendMessage("");
	            e.getPlayer().sendMessage("");
	            e.getPlayer().sendMessage(ChatColor.GRAY + "_____________________________________________");
	            e.getPlayer().sendMessage("");
	            e.getPlayer().sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "                  <FlameNetwork>");
	            e.getPlayer().sendMessage("");
	            e.getPlayer().sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "      Welcome to kitpvp, " + e.getPlayer().getName() + "!");
	            e.getPlayer().sendMessage("");
	            e.getPlayer().sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "      Staffmode has enabled.");
	            e.getPlayer().sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "      Your invisible for other people.");
	            e.getPlayer().sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "      Turn off staffmode using " + ChatColor.GOLD + "/staff!");
	            e.getPlayer().sendMessage(ChatColor.GRAY + "_____________________________________________");
	            return;
	        }
	    }
	//Quitevent
	@EventHandler
	    public void onLeave(PlayerQuitEvent e) {
	        e.setQuitMessage("");
	    }
	 
	//BlockbreakEvent
	@EventHandler  
	    public void onBlockBreak(BlockBreakEvent e){
	        if(e.getPlayer().hasPermission("flamepvpcore.world")) {
	            e.setCancelled(false);
	        } else {
	            e.setCancelled(true);
	        }
	    }
	 
	//BlockplaceEvent
	@EventHandler  
	    public void onBlockPlace(BlockPlaceEvent e){
	        if(e.getPlayer().hasPermission("flamepvpcore.world")) {
	            e.setCancelled(false);
	        } else {
	            e.setCancelled(true);
	        }
	    }
	 
	//PlayerDamageEvent
	@EventHandler  
	    public void playerDamage(EntityDamageEvent e){
	    Entity entity = e.getEntity();
	    if(entity instanceof Player) {
	        if(e.getCause() == EntityDamageEvent.DamageCause.FALL) {
	            e.setCancelled(true);
	        } else {
	            return;
	        }
	        }
	    }
	 
	//Foodlossevent
	@EventHandler
	    public void onFoodLoss(FoodLevelChangeEvent e) {
	    e.setCancelled(true);
	}
	//CommandBlocker
	@EventHandler
	    public void onCommand(PlayerCommandPreprocessEvent e) {
	    if(main.getConfig().get("rank." + e.getPlayer().getName()).equals("Speler")) {
	    if(e.getMessage().contains("plugins")) {
	        e.getPlayer().sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You cant use this command!");
	        e.setCancelled(true);
	    }
	    if(e.getMessage().contains("pl")) {
	        e.getPlayer().sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You cant use this command!");
	        e.setCancelled(true);
	    }
	    if(e.getMessage().contains("?")) {
	        e.getPlayer().sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You cant use this command!");
	        e.setCancelled(true);
	    }
	    if(e.getMessage().contains("bukkit:help")) {
	        e.getPlayer().sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You cant use this command!");
	        e.setCancelled(true);
	    }
	    if(e.getMessage().contains("version")) {
	        e.getPlayer().sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You cant use this command!");
	        e.setCancelled(true);
	    }
	    if(e.getMessage().contains("about")) {
	        e.getPlayer().sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You cant use this command!");
	        e.setCancelled(true);
	    }
	    } else {
	        return;
	    }
	}
	 
	//Commands
	    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
	        //help
	        if(cmd.getName().equalsIgnoreCase("help")) {
	            sender.sendMessage(ChatColor.GRAY + "_____________________________________________");
	            sender.sendMessage("");
	            sender.sendMessage(ChatColor.GOLD + "/hub: " + ChatColor.GREEN + "Go back to hub!");
	            sender.sendMessage("");
	            sender.sendMessage(ChatColor.GRAY + "_____________________________________________");
	            return true;
	        }
	        //Setrank
	        if(cmd.getName().equalsIgnoreCase("setrank")) {
	            if(sender.hasPermission("FlameHubManager.admin")) {
	            if(args.length == 0) {
	                sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[FlameNetwork] " + ChatColor.GREEN + "/setrank (player) (rank)");
	                return true;
	            }
	            if(args.length == 1) {
	                sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[FlameNetwork] " + ChatColor.GREEN + "/setrank (player) (rank)");
	                return true;
	            }
	            if(args.length == 2) {
	                Player target = Bukkit.getServer().getPlayer(args[0]);
	                if (target == null) {
	                    sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[FlameNetwork] " + ChatColor.GREEN + "Could not find player " + args[0] + ChatColor.RED + " !");
	                    return true;
	                }
	                main.getConfig().set("rank." + target.getName(), args[1]);
	                target.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[FlameNetwork] " + ChatColor.GREEN + "Your rank has been updated to: " + main.getConfig().getString("rank." + target.getName()) + ChatColor.RED + " !");
	                main.saveConfig();
	                if(args[1].equalsIgnoreCase("owner")) {
	                    String prefix = "&7[&4Owner&7]&6";
	                    NametagEdit.getApi().setPrefix(target, prefix);
	                }
	                if(args[1].equalsIgnoreCase("admin")) {
	                    String prefix = "&7[&1Admin&7]&6";
	                    NametagEdit.getApi().setPrefix(target, prefix);
	                }
	                if(args[1].equalsIgnoreCase("moderator")) {
	                    String prefix = "&7[&2Mod&7]&6";
	                    NametagEdit.getApi().setPrefix(target, prefix);
	                }
	                if(args[1].equalsIgnoreCase("builder")) {
	                    String prefix = "&7[&eBuilder&7]&6";
	                    NametagEdit.getApi().setPrefix(target, prefix);
	                }
	                if(args[1].equalsIgnoreCase("speler")) {
	                    NametagEdit.getApi().clearNametag(target);
	                }
	                sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[FlameNetwork] " + ChatColor.GREEN + "Player " + args[0] + " got now got the rank: " + args[1] + " !");
	                }
	        } else {
		        sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You cant use this command!");
	        }
	        }
	        //kingdom BUNGEE
	        if(cmd.getName().equalsIgnoreCase("spawn")) {
	            Player p = (Player) sender;
	            if(!(p.hasPermission("kitpvp.spawn"))) {
	                sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[FlameNetwork] " + ChatColor.RED + "You cant use this command.");
	            } else {
	            sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[FlameNetwork] " + ChatColor.GREEN + "Teleporting...");
	            double x = main.getConfig().getDouble("spawn.x");
	            double y = main.getConfig().getDouble("spawn.y");
	            double z = main.getConfig().getDouble("spawn.z");
	            World w = Bukkit.getServer().getWorld(main.getConfig().getString("spawn.world"));
	            p.teleport(new Location(w,x,y,z));
	            }
	        }
	       
	        if(cmd.getName().equalsIgnoreCase("setspawn")) {
	            if(main.getConfig().get("rank." + sender.getName()).equals("Speler")) {
	    	        sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You cant use this command!");
	            } else {
	            Player p = (Player) sender;
	            double x = p.getLocation().getX();
	            double y = p.getLocation().getY();
	            double z = p.getLocation().getZ();
	            String world = p.getLocation().getWorld().getName();
	            main.getConfig().set("spawn.x", x);
	            main.getConfig().set("spawn.y", y);
	            main.getConfig().set("spawn.z", z);
	            main.getConfig().set("spawn.world", world);
	            main.saveConfig();
	            sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[FlameNetwork] " + ChatColor.RED + "Location of spawn set!");
	            }
	        }
	        if(cmd.getName().equalsIgnoreCase("flamekitpvp")) {
	            if(main.getConfig().get("rank." + sender.getName()).equals("Speler")) {
	    	        sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You cant use this command!");
	            } else {
	            if(args.length == 0) {
	                sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[FlameNetwork] " + ChatColor.GREEN + "/flamekitpvp [reload/stop]");
	            }
	            if(args.length == 1) {
	                if(args[0].equalsIgnoreCase("reload")) {
	                    sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[FlameNetwork] " + ChatColor.GREEN + "reloading...");
	                    Bukkit.getServer().getPluginManager().disablePlugin((Plugin) this);
	                    Bukkit.getServer().getPluginManager().enablePlugin((Plugin) this);
	                    sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[FlameNetwork] " + ChatColor.GREEN + "Reload finished!");
	                }
	                if(args[0].equalsIgnoreCase("stop")) {
	                    sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[FlameNetwork] " + ChatColor.GREEN + "stopping Flamekitpvpcore...");
	                    Bukkit.getServer().getPluginManager().disablePlugin((Plugin) this);
	                }
	            	}
	            }
	        }
	   

	            if(cmd.getName().equalsIgnoreCase("shutdown")) {
	                if(main.getConfig().get("rank." + sender.getName()).equals("Speler")) {
		    	        sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You cant use this command!");
	                } else {
	                for(Player player : Bukkit.getServer().getOnlinePlayers()) {
	                TitleAPI.sendTitle(player, 30, 5 * 20, 10, ChatColor.RED + "Attention!", "Server is gonna restart in 5 seconds.!");
	                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) this, new Runnable() {
	                    public void run() {
	                        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Server is about to restart.!");
	                        Bukkit.shutdown();
	                        return;
	                    }
	                }, 100);
	            }
	                }
	            }
	            //announce command
	            if(cmd.getName().equalsIgnoreCase("announce")) {
	                if(main.getConfig().get("rank." + sender.getName()).equals("Speler")) {
		    	        sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "You cant use this command!");
	                } else {
	                for(Player player : Bukkit.getServer().getOnlinePlayers()) {
	                if(args.length == 0) {
	                    sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[FlameNetwork] " + ChatColor.RED + "Invalid syntax!");
	                    return true;
	                }
	                if(args.length == 1) {
	                    String message = args[0];
	                    TitleAPI.sendTitle(player, 30, 5 * 20, 10, ChatColor.RED + "Attention!", message);
	                    return true;
	                }
	                if(args.length == 2) {
	                    String message = args[0] + " " + args[1];
	                    TitleAPI.sendTitle(player, 30, 5 * 20, 10, ChatColor.RED + "Attention!", message);
	                    return true;
	                }
	                if(args.length == 3) {
	                    String message = args[0] + " " + args[1] + " " + args[2];
	                    TitleAPI.sendTitle(player, 30, 5 * 20, 10, ChatColor.RED + "Attention!", message);
	                    return true;
	                }
	                if(args.length == 4) {
	                    String message = args[0] + " " + args[1] + " " + args[2] + " " + args[3];
	                    TitleAPI.sendTitle(player, 30, 5 * 20, 10, ChatColor.RED + "Attention!", message);
	                    return true;
	                }
	                if(args.length >= 4) {
	                    sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "[FlameNetwork] " + ChatColor.RED + "Maximum of 5 words.");
	                    return true;
	                		}
	                	}
	                }
	            }
			return true;
	   }	
}
