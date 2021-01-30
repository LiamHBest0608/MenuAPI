package me.liamhbest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public final class MenuAPI extends JavaPlugin {
    public static ArrayList<String> lore = new ArrayList<>();
    public static Inventory inventory;
    public static Player p;

    public static void mainGUI(Player player){
        MenuAPI gui = MenuAPI.createGUI(player);
        gui.setSlots(54);
        gui.setTitle("&a&lEPIC DOOR GUI");
        gui.addItem(Material.ACACIA_DOOR, "&6My Cool Door", lore, 0);
        gui.create();
    }

    public static MenuAPI createGUI(Player player){
        return new MenuAPI(player);
    }

    private MenuAPI(Player player){
        p = player;
    }

    public ItemStack addItem(Material material, String displayName, ArrayList<String> lore, int slot){
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta =item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));
        itemMeta.setLore(lore);
        inventory.setItem(slot, item);
        return item;
    }

    public String setTitle(String name){
        return ChatColor.translateAlternateColorCodes('&', name);
    }

    public int setSlots(int slots){
        return slots;
    }

    public void create(){
        p.openInventory(inventory);
        p.getWorld();
    }

}










