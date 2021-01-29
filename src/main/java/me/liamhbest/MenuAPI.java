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

    public static void mainGUI(Player p){
        MenuAPI api = MenuAPI.createGUI(p);
        api.setName("&6This name");
        api.setSlots(27);
        api.addItem(Material.SIGN_POST, "&6Cool", lore, 27);
        api.create(p);
    }

    public static MenuAPI createGUI(Player player){
        return new MenuAPI(player);
    }

    private MenuAPI(Player player){

    }

    public ItemStack addItem(Material material, String displayName, ArrayList<String> lore, int slot){
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta =item.getItemMeta();
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', displayName));
        itemMeta.setLore(lore);
        inventory.setItem(slot, item);
        return item;
    }

    public String setName(String name){
        return ChatColor.translateAlternateColorCodes('&', name);
    }

    public int setSlots(int slots){
        return slots;
    }

    public void create(Player player){

    }

}










