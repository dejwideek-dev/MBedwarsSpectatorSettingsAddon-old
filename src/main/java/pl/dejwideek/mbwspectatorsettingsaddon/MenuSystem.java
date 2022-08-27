package pl.dejwideek.mbwspectatorsettingsaddon;

import de.marcely.bedwars.api.game.spectator.SpectatorItemHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class MenuSystem {

    private SpectSettingsAddon plugin;

    public Player menuPlayer() {
        return null;
    }

    public MenuSystem(SpectSettingsAddon plugin, SpectatorItemHandler plg) {
        Player menuPlayer;
        this.plugin = plugin;
    }

    public Inventory menuSystem() {
        Inventory menu = Bukkit.createInventory(
                null,
                plugin.menuConfig.getInt("Menu.Size"),
                ChatColor.translateAlternateColorCodes('&',
                        plugin.menuConfig.getString("Menu.Display-Name")));
        String[] itemNames = new String[]{
                "No-Speed", "Speed-I", "Speed-II", "Speed-III", "Speed-IV", "Night-Vision"
        };

        for (String itemName : itemNames) {
            if (plugin.menuConfig.getBoolean("Items." + itemName + ".Enabled").equals(false))
                continue;

            ItemStack item = new ItemStack(
                    Material.valueOf(plugin.menuConfig.getString("Items." + itemName + ".Material")),
                    plugin.menuConfig.getInt("Items." + itemName + ".Amount"));
            ItemMeta meta = item.getItemMeta();

            meta.setDisplayName(
                    ChatColor.translateAlternateColorCodes(
                            '&',
                            plugin.menuConfig.getString("Items." + itemName + ".Display-Name")));
            ArrayList<String> loreList = new ArrayList<String>();
            if (!itemName.equals("Night-Vision")) {
                Player mp = plugin.menuPlayer;

                if (mp.getWalkSpeed() == 0.2f) {
                    if (itemName.equals("No-Speed")) {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items.No-Speed.Lore.Selected")) {
                            loreList.add(ChatColor
                                    .translateAlternateColorCodes('&',
                                            loreString));
                            meta.setLore(loreList);
                        }
                        if (plugin.menuConfig
                                .getBoolean("Menu.Active-Effect-Item-Enchant").equals(true)) {
                            meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                        }
                    }
                    else {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items." + itemName + ".Lore.Select")) {
                            loreList.add(ChatColor
                                    .translateAlternateColorCodes('&',
                                            loreString));
                            meta.setLore(loreList);
                        }
                    }
                }
                if (mp.getWalkSpeed() == 0.3f) {
                    if (itemName.equals("Speed-I")) {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items.Speed-I.Lore.Selected")) {
                            loreList.add(ChatColor
                                    .translateAlternateColorCodes('&',
                                            loreString));
                            meta.setLore(loreList);
                        }
                        if (plugin.menuConfig
                                .getBoolean("Menu.Active-Effect-Item-Enchant").equals(true)) {
                            meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                        }
                    } else {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items." + itemName + ".Lore.Select")) {
                            loreList.add(ChatColor
                                    .translateAlternateColorCodes('&',
                                            loreString));
                            meta.setLore(loreList);
                        }
                    }
                }
                if (mp.getWalkSpeed() == 0.4f) {
                    if (itemName.equals("Speed-II")) {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items.Speed-II.Lore.Selected")) {
                            loreList.add(ChatColor
                                    .translateAlternateColorCodes('&',
                                            loreString));
                            meta.setLore(loreList);
                        }
                        if (plugin.menuConfig
                                .getBoolean("Menu.Active-Effect-Item-Enchant").equals(true)) {
                            meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                        }
                    } else {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items." + itemName + ".Lore.Select")) {
                            loreList.add(ChatColor
                                    .translateAlternateColorCodes('&',
                                            loreString));
                            meta.setLore(loreList);
                        }
                    }
                }
                if (mp.getWalkSpeed() == 0.5f) {
                    if (itemName.equals("Speed-III")) {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items.Speed-III.Lore.Selected")) {
                            loreList.add(ChatColor
                                    .translateAlternateColorCodes('&',
                                            loreString));
                            meta.setLore(loreList);
                        }
                        if (plugin.menuConfig
                                .getBoolean("Menu.Active-Effect-Item-Enchant").equals(true)) {
                            meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                        }
                    } else {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items." + itemName + ".Lore.Select")) {
                            loreList.add(ChatColor
                                    .translateAlternateColorCodes('&',
                                            loreString));
                            meta.setLore(loreList);
                        }
                    }
                }
                if (mp.getWalkSpeed() == 0.6f) {
                    if (itemName.equals("Speed-IV")) {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items.Speed-IV.Lore.Selected")) {
                            loreList.add(ChatColor
                                    .translateAlternateColorCodes('&',
                                            loreString));
                            meta.setLore(loreList);
                        }
                        if (plugin.menuConfig
                                .getBoolean("Menu.Active-Effect-Item-Enchant").equals(true)) {
                            meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                        }
                    }
                    else {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items." + itemName + ".Lore.Select")) {
                            loreList.add(ChatColor
                                    .translateAlternateColorCodes('&',
                                            loreString));
                            meta.setLore(loreList);
                        }
                    }
                }
            }
            else {
                Player p = plugin.menuPlayer;

                if (p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                    for (String loreString : plugin.menuConfig
                            .getStringList("Items.Night-Vision.Lore.Disable")) {
                        loreList.add(ChatColor
                                .translateAlternateColorCodes('&',
                                        loreString));
                        meta.setLore(loreList);
                    }
                    if (plugin.menuConfig
                            .getBoolean("Menu.Active-Effect-Item-Enchant").equals(true)) {
                        meta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                    }
                } else {
                    for (String loreString : plugin.menuConfig
                            .getStringList("Items.Night-Vision.Lore.Enable")) {
                        loreList.add(ChatColor
                                .translateAlternateColorCodes('&',
                                        loreString));
                        meta.setLore(loreList);
                    }
                }
            }
            meta.addItemFlags(
                    ItemFlag.HIDE_ATTRIBUTES,
                    ItemFlag.HIDE_ENCHANTS,
                    ItemFlag.HIDE_DESTROYS,
                    ItemFlag.HIDE_POTION_EFFECTS,
                    ItemFlag.HIDE_UNBREAKABLE,
                    ItemFlag.HIDE_PLACED_ON);
            item.setItemMeta(meta);

            menu.setItem(
                    plugin.menuConfig.getInt("Items." + itemName + ".Slot"),
                    item);
        }
        return menu;
    }
}
