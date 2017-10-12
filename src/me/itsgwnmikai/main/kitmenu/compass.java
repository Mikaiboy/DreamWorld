package me.itsgwnmikai.main.kitmenu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import me.itsgwnmikai.main.Main;

public class compass implements Listener, CommandExecutor{
	@SuppressWarnings("unused")
	private Main main;
	public compass(Main main){
		this.main = main;
	}
    public static Inventory flameinv = Bukkit.createInventory(null, 9, ChatColor.translateAlternateColorCodes('&', "&4&k;;&r&cFlameNetwork&4&k;;&r"));
    // The first parameter, is the inventory owner. I make it null to let everyone use it.
    //The second parameter, is the slots in a inventory. Must be a multiple of 9. Can be up to 54.
    //The third parameter, is the inventory name. This will accept chat colors
    static {
    	
    	
    	
    	
    	/*
		 * -----------------------------------------------------------------------
		 */
    	
    	
    	ItemStack Guardian = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta guardianmeta = Guardian.getItemMeta();
		
		guardianmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3&lGuardian"));
		Guardian.setItemMeta(guardianmeta);
		
		/*
		 * -----------------------------------------------------------------------
		 */
    	ItemStack Archer = new ItemStack(Material.BOW);
		ItemMeta Archermeta = Archer.getItemMeta();
		
		Archermeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3&lArcher"));
		Archer.setItemMeta(Archermeta);
		
		
		/*
		 * -----------------------------------------------------------------------
		 */
    	ItemStack Fisher = new ItemStack(Material.FISHING_ROD);
		ItemMeta Fishermeta = Fisher.getItemMeta();
		
		Fishermeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3&lFisher"));
		Fisher.setItemMeta(Fishermeta);
		
		
		/*
		 * -----------------------------------------------------------------------
		 */
    	ItemStack speed = new ItemStack(Material.POTION, 1, (short) 8194);
		ItemMeta speedmeta = speed.getItemMeta();
		
		
		speedmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3&lSpeed Kit"));
		speed.setItemMeta(speedmeta);
		
		
		/*
		 * -----------------------------------------------------------------------
		 */

		Potion potion = new Potion(PotionType.INSTANT_HEAL,1);
		potion.setSplash(true);

		ItemStack potkit = potion.toItemStack(1);
		ItemMeta potkitmeta = potkit.getItemMeta();
		
		potkitmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3&lPot Kit"));
		potkit.setItemMeta(potkitmeta);
		
		
		/*
		 * -----------------------------------------------------------------------
		 */
    	ItemStack tank = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta tankmeta = tank.getItemMeta();
		
		
		tankmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3&lTank Kit"));
		tank.setItemMeta(tankmeta);
		
		
		/*
		 * -----------------------------------------------------------------------
		 */
		
    		flameinv.setItem(0, Guardian);
    		flameinv.setItem(1, Archer);
    		flameinv.setItem(2, Fisher);
    		flameinv.setItem(6, speed);
    		flameinv.setItem(7, potkit);
    		flameinv.setItem(8, tank);
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
    Player player = (Player) event.getWhoClicked(); // The player that clicked the item
    ItemStack clicked = event.getCurrentItem(); // The item that was clicked
    Inventory inventory = event.getInventory(); // The inventory that was clicked in
    if (inventory.getName().equals(flameinv.getName())) {
    	ItemStack Guardian = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta guardianmeta = Guardian.getItemMeta();
		
		guardianmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3&lGuardian"));
		Guardian.setItemMeta(guardianmeta);
		
    	ItemStack ironhelm = new ItemStack(Material.IRON_HELMET);
    	ItemMeta ironhelmmeta = ironhelm.getItemMeta();
    	ironhelmmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Guardian Helmet"));
    	ironhelmmeta.spigot().setUnbreakable(true);
		ironhelm.setItemMeta(ironhelmmeta);
		
    	ItemStack ironchest = new ItemStack(Material.IRON_CHESTPLATE);
    	ItemMeta ironchestmeta = ironchest.getItemMeta();
    	ironchestmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Guardian Chestplate"));
    	ironchestmeta.spigot().setUnbreakable(true);
		ironchest.setItemMeta(ironchestmeta);
		
    	ItemStack chainlegs = new ItemStack(Material.CHAINMAIL_LEGGINGS);
    	ItemMeta chainlegsmeta = chainlegs.getItemMeta();
    	chainlegsmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Guardian Leggings"));
    	chainlegsmeta.spigot().setUnbreakable(true);
		chainlegs.setItemMeta(chainlegsmeta);
		
    	ItemStack ironboots = new ItemStack(Material.IRON_BOOTS);
    	ItemMeta ironbootsmeta = ironboots.getItemMeta();
    	ironbootsmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Guardian Boots"));
    	ironbootsmeta.spigot().setUnbreakable(true);
		ironboots.setItemMeta(ironbootsmeta);
		
    	ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 2);
    	ItemMeta gapplemeta = gapple.getItemMeta();
    	gapplemeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6&lGapples"));
		gapple.setItemMeta(gapplemeta);
		
    	ItemStack ironsword = new ItemStack(Material.IRON_SWORD, 1);
    	ItemMeta ironswordench = ironsword.getItemMeta();
    	ironswordench.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
    	ironsword.setItemMeta(ironswordench);
    	
    	ItemMeta ironswordmeta = ironsword.getItemMeta();
    	ironswordmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Guardian Sword"));
    	ironswordmeta.spigot().setUnbreakable(true);
		ironsword.setItemMeta(ironswordmeta);
		

		
    	if (clicked.getType() == Material.DIAMOND_SWORD) { // The item that the player clicked it dirt
    		event.setCancelled(true); // Make it so the dirt is back in its original spot
    		player.closeInventory(); // Closes there inventory
    		player.getInventory().clear();
    		player.getInventory().setHelmet(ironhelm);
    		player.getInventory().setChestplate(ironchest);
    		player.getInventory().setLeggings(chainlegs);
    		player.getInventory().setBoots(ironboots);
    		player.getInventory().addItem(ironsword);
    		player.getInventory().addItem(gapple);
    	
    		}
    }
	
	ItemStack chainhelm = new ItemStack(Material.CHAINMAIL_HELMET);
	ItemMeta chainhelmmeta = chainhelm.getItemMeta();
	chainhelmmeta.spigot().setUnbreakable(true);
	chainhelmmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Archer Helmet"));
	chainhelm.setItemMeta(chainhelmmeta);
	
	ItemStack ironchest = new ItemStack(Material.IRON_CHESTPLATE);
	ItemMeta ironchestmeta = ironchest.getItemMeta();
	ironchestmeta.spigot().setUnbreakable(true);
	ironchestmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Archer Chestplate"));
	ironchest.setItemMeta(ironchestmeta);
	
	ItemStack chainlegs = new ItemStack(Material.CHAINMAIL_LEGGINGS);
	ItemMeta chainlegsmeta = chainlegs.getItemMeta();
	chainlegsmeta.spigot().setUnbreakable(true);
	chainlegsmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Archer Leggings"));
	chainlegs.setItemMeta(chainlegsmeta);
	
	ItemStack chainboots = new ItemStack(Material.CHAINMAIL_BOOTS);
	ItemMeta chainbootsmeta = chainboots.getItemMeta();
	chainbootsmeta.spigot().setUnbreakable(true);
	chainbootsmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Archer Boots"));
	chainboots.setItemMeta(chainbootsmeta);
	
	ItemStack gapple = new ItemStack(Material.GOLDEN_APPLE, 2);
	ItemMeta gapplemeta = gapple.getItemMeta();
	gapplemeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6&lGapples"));
	gapple.setItemMeta(gapplemeta);
	
	ItemStack stonesword = new ItemStack(Material.STONE_SWORD, 1);
	ItemMeta stoneswordench = stonesword.getItemMeta();
	stoneswordench.spigot().setUnbreakable(true);
	
	
	ItemMeta stoneswordmeta = stonesword.getItemMeta();
	stoneswordmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Archer Sword"));
	stoneswordmeta.spigot().setUnbreakable(true);
	stonesword.setItemMeta(stoneswordmeta);
	
	
	
	ItemStack bow = new ItemStack(Material.BOW, 1);
	ItemMeta bowench = bow.getItemMeta();
	bowench.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
	bow.setItemMeta(bowench);
	
	ItemMeta bowmeta = bow.getItemMeta();
	bowmeta.spigot().setUnbreakable(true);
	bowmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Archer Bow"));
	bow.setItemMeta(bowmeta);
	
	ItemStack arrow = new ItemStack(Material.ARROW, 1);
	ItemMeta arrowmeta = arrow.getItemMeta();
	arrowmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Archer Arrow"));
	arrow.setItemMeta(arrowmeta);
	
    if(inventory.getName().equals(flameinv.getName())){
    	if(clicked.getType() == Material.BOW) {
    		event.setCancelled(true);
    		player.closeInventory();
    		player.getInventory().clear();
    		player.getInventory().setHelmet(chainhelm);
    		player.getInventory().setChestplate(ironchest);
    		player.getInventory().setLeggings(chainlegs);
    		player.getInventory().setBoots(chainboots);
    		player.getInventory().addItem(stonesword);
    		player.getInventory().addItem(bow);
    		player.getInventory().addItem(gapple);
    		player.getInventory().setItem(9, arrow);
    		
    		
    	}
    }
	ItemStack ironhelm = new ItemStack(Material.IRON_HELMET);
	ItemMeta ironhelmmeta = ironhelm.getItemMeta();
	ironhelmmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Fisher Helmet"));
	ironhelmmeta.spigot().setUnbreakable(true);
	ironhelm.setItemMeta(ironhelmmeta);
	
	ItemStack ironchest1 = new ItemStack(Material.IRON_CHESTPLATE);
	ItemMeta ironchestmeta1 = ironchest1.getItemMeta();
	ironchestmeta1.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Fisher Chestplate"));
	ironchestmeta1.spigot().setUnbreakable(true);
	ironchest1.setItemMeta(ironchestmeta1);
	
	ItemStack chainlegs1 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
	ItemMeta chainlegsmeta1 = chainlegs1.getItemMeta();
	chainlegsmeta1.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Fisher Leggings"));
	chainlegsmeta1.spigot().setUnbreakable(true);
	chainlegs1.setItemMeta(chainlegsmeta1);
	
	ItemStack ironboots = new ItemStack(Material.IRON_BOOTS);
	ItemMeta ironbootsmeta = ironboots.getItemMeta();
	ironbootsmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Fisher Boots"));
	ironbootsmeta.spigot().setUnbreakable(true);
	ironboots.setItemMeta(ironbootsmeta);
	
	ItemStack stonesword1 = new ItemStack(Material.STONE_SWORD, 1);
	ItemMeta stoneswordench1 = stonesword1.getItemMeta();
	stoneswordench1.spigot().setUnbreakable(true);
	stoneswordench1.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
	stonesword1.setItemMeta(stoneswordench1);
	ItemMeta stoneswordmeta1 = stonesword1.getItemMeta();
	stoneswordmeta1.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Fisher Sword"));
	stoneswordmeta1.spigot().setUnbreakable(true);
	stonesword1.setItemMeta(stoneswordmeta1);
	
	ItemStack fisherrod = new ItemStack(Material.FISHING_ROD, 1);
	ItemMeta fisherrodench = fisherrod.getItemMeta();
	fisherrodench.spigot().setUnbreakable(true);
	fisherrod.setItemMeta(fisherrodench);
	
	ItemMeta fishermeta = fisherrod.getItemMeta();
	fishermeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Fisher rod"));
	fishermeta.spigot().setUnbreakable(true);
	fisherrod.setItemMeta(fishermeta);
	

	
    if(inventory.getName().equals(flameinv.getName())){
    	if(clicked.getType()==Material.FISHING_ROD) {
    		event.setCancelled(true);
    		player.closeInventory();
    		player.getInventory().clear();
    		player.getInventory().setHelmet(ironhelm);
    		player.getInventory().setChestplate(ironchest1);
    		player.getInventory().setLeggings(chainlegs1);
    		player.getInventory().setBoots(ironboots);
    		player.getInventory().addItem(stonesword1);
    		player.getInventory().addItem(fisherrod);
    		player.getInventory().addItem(gapple);
    	}
    }
	ItemStack ironhelm1 = new ItemStack(Material.IRON_HELMET);
	ItemMeta ironhelmmeta1 = ironhelm1.getItemMeta();
	ironhelmmeta1.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Speed Helmet"));
	ironhelmmeta1.spigot().setUnbreakable(true);
	ironhelm1.setItemMeta(ironhelmmeta1);
	
	ItemStack chainchest = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
	ItemMeta chainchestmeta = chainchest.getItemMeta();
	chainchestmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Speed Chestplate"));
	chainchestmeta.spigot().setUnbreakable(true);
	chainchest.setItemMeta(chainchestmeta);
	
	ItemStack chainlegs11 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
	ItemMeta chainlegsmeta11 = chainlegs11.getItemMeta();
	chainlegsmeta11.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Speed Leggings"));
	chainlegsmeta11.spigot().setUnbreakable(true);
	chainlegs11.setItemMeta(chainlegsmeta11);
	
	ItemStack ironboots1 = new ItemStack(Material.IRON_BOOTS);
	ItemMeta ironbootsmeta1 = ironboots1.getItemMeta();
	ironbootsmeta1.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Speed Boots"));
	ironbootsmeta1.spigot().setUnbreakable(true);
	ironboots1.setItemMeta(ironbootsmeta1);
	
	ItemStack gapple1 = new ItemStack(Material.GOLDEN_APPLE, 3);
	ItemMeta gapplemeta1 = gapple1.getItemMeta();
	gapplemeta1.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6&lGapples"));
	gapple1.setItemMeta(gapplemeta1);
	
	ItemStack ironsword = new ItemStack(Material.IRON_SWORD, 1);
	ItemMeta ironswordench = ironsword.getItemMeta();
	ironswordench.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
	ironsword.setItemMeta(ironswordench);
	
	ItemMeta ironswordmeta = ironsword.getItemMeta();
	ironswordmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Speed Sword"));
	ironswordmeta.spigot().setUnbreakable(true);
	ironsword.setItemMeta(ironswordmeta);
	
	ItemStack speed = new ItemStack(Material.POTION, 1, (short) 8194);
	ItemMeta speedmeta = speed.getItemMeta();
	
	
	speedmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3&lSpeed Pots"));
	speed.setItemMeta(speedmeta);
    
    if(inventory.getName().equals(flameinv.getName())){
    	if(clicked.equals(speedies())){
    			event.setCancelled(true);
        		if(player.hasPermission("kitpvp.kit.speed")){
        			player.closeInventory();
        			player.getInventory().clear();
        			player.getInventory().setHelmet(ironhelm1);
        			player.getInventory().setChestplate(chainchest);
        			player.getInventory().setLeggings(chainlegs11);
        			player.getInventory().setBoots(ironboots);
        			player.getInventory().addItem(ironsword);
        			player.getInventory().addItem(gapple1);
        			player.getInventory().addItem(speed);
        			player.getInventory().addItem(speed);
        			player.getInventory().addItem(speed);
    		}else player.sendMessage(ChatColor.RED + "Hey there, you can buy a donator kit on http://flamenetworkmc.buycraft.net !");
    	}
    }	
    ItemStack ironhelm11 = new ItemStack(Material.IRON_HELMET);
	ItemMeta ironhelmmeta11 = ironhelm11.getItemMeta();
	ironhelmmeta11.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Pot Helmet"));
	ironhelmmeta11.spigot().setUnbreakable(true);
	ironhelm11.setItemMeta(ironhelmmeta11);
	
	ItemStack chainchest1 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
	ItemMeta chainchestmeta1 = chainchest1.getItemMeta();
	chainchestmeta1.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Pot Chestplate"));
	chainchestmeta1.spigot().setUnbreakable(true);
	chainchest1.setItemMeta(chainchestmeta1);
	
	ItemStack chainlegs111 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
	ItemMeta chainlegsmeta111 = chainlegs111.getItemMeta();
	chainlegsmeta111.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Pot Leggings"));
	chainlegsmeta111.spigot().setUnbreakable(true);
	chainlegs111.setItemMeta(chainlegsmeta111);
	
	ItemStack chainboots1 = new ItemStack(Material.CHAINMAIL_BOOTS);
	ItemMeta chainbootsench = chainboots1.getItemMeta();
	chainbootsench.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
	chainboots1.setItemMeta(chainbootsench);
	
	ItemMeta chainbootsmeta1 = chainboots1.getItemMeta();
	chainbootsmeta1.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Pot Boots"));
	chainbootsmeta1.spigot().setUnbreakable(true);
	chainboots1.setItemMeta(chainbootsmeta1);
	
	
	ItemStack stonesword11 = new ItemStack(Material.STONE_SWORD, 1);
	ItemMeta stoneswordench11 = stonesword11.getItemMeta();
	stoneswordench11.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
	stonesword11.setItemMeta(stoneswordench11);
	
	ItemMeta stoneswordmeta11 = stonesword11.getItemMeta();
	stoneswordmeta11.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Pot Sword"));
	stoneswordmeta11.spigot().setUnbreakable(true);
	stonesword11.setItemMeta(stoneswordmeta11);
	
	Potion potion = new Potion(PotionType.INSTANT_HEAL,1);
	potion.setSplash(true);

	ItemStack potkit = potion.toItemStack(1);
	ItemMeta potkitmeta = potkit.getItemMeta();
	
	potkitmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3&lHeal Pots"));
	potkit.setItemMeta(potkitmeta);
	
    
    if(inventory.getName().equals(flameinv.getName())){
    	if(clicked.equals(potkits())){
       		event.setCancelled(true);
    		if(player.hasPermission("kitpvp.kit.pots")){
    			player.closeInventory();
	    		player.getInventory().clear();
	    		player.getInventory().setHelmet(ironhelm11);
	    		player.getInventory().setChestplate(chainchest1);
	    		player.getInventory().setLeggings(chainlegs111);
	    		player.getInventory().setBoots(chainboots1);
	    		player.getInventory().addItem(stonesword11);
	    		player.getInventory().addItem(potkit);
	    		player.getInventory().addItem(potkit);
	    		player.getInventory().addItem(potkit);
    			player.getInventory().addItem(potkit);
    			player.getInventory().addItem(potkit);
			}else player.sendMessage(ChatColor.RED + "Hey there, you can buy a donator kit on http://flamenetworkmc.buycraft.net !");
    	}
    }
    
	ItemStack chainhelm1 = new ItemStack(Material.CHAINMAIL_HELMET);
	ItemMeta chainhelmench = chainhelm1.getItemMeta();
	chainhelmench.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
	chainhelm1.setItemMeta(chainhelmench);
	
	ItemMeta chainhelmmeta1 = chainhelm1.getItemMeta();
	chainhelmmeta1.spigot().setUnbreakable(true);
	chainhelmmeta1.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Tank Helmet"));
	chainhelm1.setItemMeta(chainhelmmeta1);
	
	ItemStack ironchest11 = new ItemStack(Material.IRON_CHESTPLATE);
	ItemMeta ironchestmeta11 = ironchest11.getItemMeta();
	ironchestmeta11.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Tank Chestplate"));
	ironchestmeta11.spigot().setUnbreakable(true);
	ironchest11.setItemMeta(ironchestmeta11);
	
	ItemStack ironleggs = new ItemStack(Material.CHAINMAIL_LEGGINGS);
	ItemMeta ironleggsench = ironleggs.getItemMeta();
	ironleggsench.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
	ironleggs.setItemMeta(ironleggsench	);
	
	ItemMeta ironleggsmeta = ironleggs.getItemMeta();
	ironleggsmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Tank Leggings"));
	ironleggsmeta.spigot().setUnbreakable(true);
	ironleggs.setItemMeta(ironleggsmeta);
	
	ItemStack ironboots11 = new ItemStack(Material.IRON_BOOTS);
	ItemMeta ironbootsench1 = ironboots11.getItemMeta();
	ironbootsench1.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
	ironboots11.setItemMeta(ironbootsench1);
	
	ItemMeta ironbootsmeta11 = ironboots11.getItemMeta();
	ironbootsmeta11.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Tank Boots"));
	ironbootsmeta11.spigot().setUnbreakable(true);
	ironboots11.setItemMeta(ironbootsmeta11);
	
	
	
	
	ItemStack gapple11 = new ItemStack(Material.GOLDEN_APPLE, 4);
	ItemMeta gapplemeta11 = gapple11.getItemMeta();
	gapplemeta11.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6&lGapples"));
	gapple11.setItemMeta(gapplemeta11);
	
	ItemStack woodsword = new ItemStack(Material.WOOD_SWORD, 1);
	ItemMeta woodswordench = woodsword.getItemMeta();
	woodswordench.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
	woodsword.setItemMeta(woodswordench);
	
	ItemMeta woodswordmeta = woodsword.getItemMeta();
	woodswordmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3Tank Sword"));
	woodswordmeta.spigot().setUnbreakable(true);
	woodsword.setItemMeta(woodswordmeta);
	
    if(inventory.getName().equals(flameinv.getName())){
    	if(clicked.getType() == Material.IRON_CHESTPLATE){
			event.setCancelled(true);
    		if(player.hasPermission("kitpvp.kit.tank")){
	    		player.closeInventory();
	    		player.getInventory().clear();
	    		player.getInventory().setHelmet(chainhelm1);
	    		player.getInventory().setChestplate(ironchest11);
	    		player.getInventory().setLeggings(ironleggs);
	    		player.getInventory().setBoots(ironboots11);
	    		player.getInventory().addItem(woodsword);
	    		player.getInventory().addItem(gapple11);
			}else player.sendMessage(ChatColor.RED + "Hey there, you can buy a donator kit on http://flamenetworkmc.buycraft.net !");
    	}
    }
  }
    
	public boolean onCommand(CommandSender s, Command cmd, String l, String[] args) {
		Player p = (Player) s;
		if(l.equalsIgnoreCase("kit")){
			if(s instanceof Player){
				if(p.hasPermission("kitpvp.kit")){
					p.openInventory(flameinv);
			}else p.sendMessage(ChatColor.RED + "You dont have permission, this command is for staff only.");
		}
		return false;
	}
		return false;
	}
	public ItemStack speedies(){
    	ItemStack speed = new ItemStack(Material.POTION, 1, (short) 8194);
		ItemMeta speedmeta = speed.getItemMeta();
		
		
		speedmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3&lSpeed Kit"));
		speed.setItemMeta(speedmeta);
		return speed;
		
	}
	public ItemStack potkits(){
		Potion potion = new Potion(PotionType.INSTANT_HEAL,1);
		potion.setSplash(true);

		ItemStack potkit = potion.toItemStack(1);
		ItemMeta potkitmeta = potkit.getItemMeta();
		
		potkitmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3&lPot Kit"));
		potkit.setItemMeta(potkitmeta);
		return potkit;
	}
}


