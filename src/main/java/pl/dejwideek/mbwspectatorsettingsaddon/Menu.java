package pl.dejwideek.mbwspectatorsettingsaddon;

import com.iridium.iridiumcolorapi.IridiumColorAPI;
import de.marcely.bedwars.api.game.spectator.SpectatorItemHandler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import pl.dejwideek.mbwspectatorsettingsaddon.xseries.XEnchantment;
import pl.dejwideek.mbwspectatorsettingsaddon.xseries.XMaterial;

import java.util.ArrayList;

@SuppressWarnings("ALL")
public class Menu {

    private static SpectSettingsAddon plugin;

    public Menu(SpectSettingsAddon plugin,
                SpectatorItemHandler handler) {
        this.plugin = plugin;
    }

    public Inventory menu(Player p) {
        String menuDisplayName = plugin.menuConfig
                .getString("Menu.Display-Name");
        int menuSize = plugin.menuConfig
                .getInt("Menu.Size");
        Inventory menu = Bukkit.createInventory(
                null, menuSize,
                IridiumColorAPI.process(menuDisplayName));
        String[] itemNames = new String[]{
                "No-Speed", "Speed-I", "Speed-II", "Speed-III", "Speed-IV", "Night-Vision"
        };

        for (String itemName : itemNames) {
            boolean isItemEnabled = plugin.menuConfig
                    .getBoolean("Items." + itemName + ".Enabled");
            boolean isItemEnchant = plugin.menuConfig
                    .getBoolean("Menu.Active-Effect-Item-Enchant");
            if (!isItemEnabled) continue;

            String itemMaterial = plugin.menuConfig
                    .getString("Items." + itemName + ".Material")
                    .toUpperCase();
            byte itemData = plugin.menuConfig
                    .getByte("Items." + itemName + ".Material-Data");
            int itemAmount = plugin.menuConfig
                    .getInt("Items." + itemName + ".Amount");
            String itemDisplayName = plugin.menuConfig
                    .getString("Items." + itemName + ".Display-Name");
            ItemStack item = new ItemStack(XMaterial.valueOf(itemMaterial)
                    .parseMaterial(), itemAmount, itemData);
            ItemMeta meta = item.getItemMeta();

            meta.setDisplayName(IridiumColorAPI
                    .process(itemDisplayName));
            ArrayList<String> loreList = new ArrayList<String>();
            if (!itemName.equals("Night-Vision")) {
                if (p.getWalkSpeed() == 0.2f) {
                    if (itemName.equals("No-Speed")) {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items.No-Speed.Lore.Selected")) {
                            loreList.add(IridiumColorAPI
                                    .process(loreString));
                        }
                        if (isItemEnchant) {
                            meta.addEnchant(XEnchantment.DAMAGE_ALL
                                    .getEnchant(), 1, true);
                        }
                    }
                    else {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items." + itemName + ".Lore.Select")) {
                            loreList.add(IridiumColorAPI
                                    .process(loreString));
                        }
                    }
                }
                if (p.getWalkSpeed() == 0.3f) {
                    if (itemName.equals("Speed-I")) {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items.Speed-I.Lore.Selected")) {
                            loreList.add(IridiumColorAPI
                                    .process(loreString));
                        }
                        if (isItemEnchant) {
                            meta.addEnchant(XEnchantment.DAMAGE_ALL
                                    .getEnchant(), 1, true);
                        }
                    } else {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items." + itemName + ".Lore.Select")) {
                            loreList.add(IridiumColorAPI
                                    .process(loreString));
                        }
                    }
                }
                if (p.getWalkSpeed() == 0.4f) {
                    if (itemName.equals("Speed-II")) {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items.Speed-II.Lore.Selected")) {
                            loreList.add(IridiumColorAPI
                                    .process(loreString));
                        }
                        if (isItemEnchant) {
                            meta.addEnchant(XEnchantment.DAMAGE_ALL
                                    .getEnchant(), 1, true);
                        }
                    } else {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items." + itemName + ".Lore.Select")) {
                            loreList.add(IridiumColorAPI
                                    .process(loreString));
                        }
                    }
                }
                if (p.getWalkSpeed() == 0.5f) {
                    if (itemName.equals("Speed-III")) {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items.Speed-III.Lore.Selected")) {
                            loreList.add(IridiumColorAPI
                                    .process(loreString));
                        }
                        if (isItemEnchant) {
                            meta.addEnchant(XEnchantment.DAMAGE_ALL
                                    .getEnchant(), 1, true);
                        }
                    } else {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items." + itemName + ".Lore.Select")) {
                            loreList.add(IridiumColorAPI
                                    .process(loreString));
                        }
                    }
                }
                if (p.getWalkSpeed() == 0.6f) {
                    if (itemName.equals("Speed-IV")) {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items.Speed-IV.Lore.Selected")) {
                            loreList.add(IridiumColorAPI
                                    .process(loreString));
                        }
                        if (isItemEnchant) {
                            meta.addEnchant(XEnchantment.DAMAGE_ALL
                                    .getEnchant(), 1, true);
                        }
                    }
                    else {
                        for (String loreString : plugin.menuConfig
                                .getStringList("Items." + itemName + ".Lore.Select")) {
                            loreList.add(IridiumColorAPI
                                    .process(loreString));
                        }
                    }
                }
            }
            else {
                if (p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                    for (String loreString : plugin.menuConfig
                            .getStringList("Items.Night-Vision.Lore.Disable")) {
                        loreList.add(IridiumColorAPI
                                .process(loreString));
                    }
                    if (isItemEnchant) {
                        meta.addEnchant(XEnchantment.DAMAGE_ALL
                                .getEnchant(), 1, true);
                    }
                } else {
                    for (String loreString : plugin.menuConfig
                            .getStringList("Items.Night-Vision.Lore.Enable")) {
                        loreList.add(IridiumColorAPI
                                .process(loreString));
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
            meta.setLore(loreList);
            item.setItemMeta(meta);

            menu.setItem(
                    plugin.menuConfig.getInt("Items." + itemName + ".Slot"),
                    item);
        }
        return menu;
    }
}
