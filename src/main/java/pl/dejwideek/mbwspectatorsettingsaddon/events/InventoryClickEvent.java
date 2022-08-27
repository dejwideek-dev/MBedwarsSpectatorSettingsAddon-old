package pl.dejwideek.mbwspectatorsettingsaddon.events;

import de.marcely.bedwars.api.BedwarsAPI;
import de.marcely.bedwars.api.arena.Arena;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.dejwideek.mbwspectatorsettingsaddon.SpectSettingsAddon;

@SuppressWarnings("ALL")
public class InventoryClickEvent implements Listener {

    private final SpectSettingsAddon plugin;

    public InventoryClickEvent(SpectSettingsAddon plg) {
        plugin = plg;
    }

    @EventHandler
    public void onInvClick(org.bukkit.event.inventory.InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Arena a = BedwarsAPI.getGameAPI().getArenaByPlayer(p);

        Inventory inv = e.getClickedInventory();
        try {
            if(inv.getSize() == plugin.menuConfig
                    .getInt("Menu.Size")
                    && p.getOpenInventory()
                    .getTitle().equals(ChatColor
                            .translateAlternateColorCodes('&',
                                    plugin.menuConfig
                                            .getString("Menu.Display-Name")))) {
                ItemStack item = e.getCurrentItem();

                if(item.getType().equals(Material.valueOf(
                        plugin.menuConfig
                                .getString("Items.No-Speed.Material")))
                        && item.getItemMeta()
                        .getDisplayName().equals(ChatColor
                                .translateAlternateColorCodes('&',
                                        plugin.menuConfig
                                                .getString("Items.No-Speed.Display-Name")))) {
                    if(p.getWalkSpeed() != 0.2f && p.getFlySpeed() != 0.1f) {
                        p.setWalkSpeed(0.2f);
                        p.setFlySpeed(0.1f);
                        p.sendMessage(ChatColor
                                .translateAlternateColorCodes('&',
                                        plugin.config
                                                .getString("Messages.Selected.No-Speed")));
                        p.closeInventory();
                    }
                    else return;
                }
                if(item.getType().equals(Material.valueOf(
                        plugin.menuConfig
                                .getString("Items.Speed-I.Material")))
                        && item.getItemMeta()
                        .getDisplayName().equals(ChatColor
                                .translateAlternateColorCodes('&',
                                        plugin.menuConfig
                                                .getString("Items.Speed-I.Display-Name")))) {
                    if(p.hasPermission(plugin.config.getString("Permissions.Speed-I"))) {
                        if(p.getWalkSpeed() != 0.3f && p.getFlySpeed() != 0.2f) {
                            p.setWalkSpeed(0.3f);
                            p.setFlySpeed(0.2f);
                            p.sendMessage(ChatColor
                                    .translateAlternateColorCodes('&',
                                            plugin.config
                                                    .getString("Messages.Selected.Speed-I")));
                            p.closeInventory();
                        }
                        else return;
                    }
                    else {
                        p.sendMessage(ChatColor
                                .translateAlternateColorCodes('&',
                                        plugin.config
                                                .getString("Messages.No-Permission")
                                                .replaceAll("%permission%",
                                                        plugin.config
                                                                .getString("Permissions.Speed-I"))));
                    }
                }
                if(item.getType().equals(Material.valueOf(
                        plugin.menuConfig
                                .getString("Items.Speed-II.Material")))
                        && item.getItemMeta()
                        .getDisplayName().equals(ChatColor
                                .translateAlternateColorCodes('&',
                                        plugin.menuConfig
                                                .getString("Items.Speed-II.Display-Name")))) {
                    if(p.hasPermission(plugin.config.getString("Permissions.Speed-II"))) {
                        if(p.getWalkSpeed() != 0.4f && p.getFlySpeed() != 0.3f) {
                            p.setWalkSpeed(0.4f);
                            p.setFlySpeed(0.3f);
                            p.sendMessage(ChatColor
                                    .translateAlternateColorCodes('&',
                                            plugin.config
                                                    .getString("Messages.Selected.Speed-II")));
                            p.closeInventory();
                        }
                        else return;
                    }
                    else {
                        p.sendMessage(ChatColor
                                .translateAlternateColorCodes('&',
                                        plugin.config
                                                .getString("Messages.No-Permission")
                                                .replaceAll("%permission%",
                                                        plugin.config
                                                                .getString("Permissions.Speed-II"))));
                    }
                }
                if(item.getType().equals(Material.valueOf(
                        plugin.menuConfig
                                .getString("Items.Speed-III.Material")))
                        && item.getItemMeta()
                        .getDisplayName().equals(ChatColor
                                .translateAlternateColorCodes('&',
                                        plugin.menuConfig
                                                .getString("Items.Speed-III.Display-Name")))) {
                    if(p.hasPermission(plugin.config.getString("Permissions.Speed-III"))) {
                        if(p.getWalkSpeed() != 0.5f && p.getFlySpeed() != 0.4f) {
                            p.setWalkSpeed(0.5f);
                            p.setFlySpeed(0.4f);
                            p.sendMessage(ChatColor
                                    .translateAlternateColorCodes('&',
                                            plugin.config
                                                    .getString("Messages.Selected.Speed-III")));
                            p.closeInventory();
                        }
                        else return;
                    }
                    else {
                        p.sendMessage(ChatColor
                                .translateAlternateColorCodes('&',
                                        plugin.config
                                                .getString("Messages.No-Permission")
                                                .replaceAll("%permission%",
                                                        plugin.config
                                                                .getString("Permissions.Speed-III"))));
                    }
                }
                if(item.getType().equals(Material.valueOf(
                        plugin.menuConfig
                                .getString("Items.Speed-IV.Material")))
                        && item.getItemMeta()
                        .getDisplayName().equals(ChatColor
                                .translateAlternateColorCodes('&',
                                        plugin.menuConfig
                                                .getString("Items.Speed-IV.Display-Name")))) {
                    if(p.hasPermission(plugin.config.getString("Permissions.Speed-IV"))) {
                        if(p.getWalkSpeed() != 0.6f && p.getFlySpeed() != 0.5f) {
                            p.setWalkSpeed(0.6f);
                            p.setFlySpeed(0.5f);
                            p.sendMessage(ChatColor
                                    .translateAlternateColorCodes('&',
                                            plugin.config
                                                    .getString("Messages.Selected.Speed-IV")));
                            p.closeInventory();
                        }
                    }
                    else {
                        p.sendMessage(ChatColor
                                .translateAlternateColorCodes('&',
                                        plugin.config
                                                .getString("Messages.No-Permission")
                                                .replaceAll("%permission%",
                                                        plugin.config
                                                                .getString("Permissions.Speed-IV"))));
                    }
                }
                if(item.getType().equals(Material.valueOf(
                        plugin.menuConfig
                                .getString("Items.Night-Vision.Material")))
                        && item.getItemMeta()
                        .getDisplayName().equals(ChatColor
                                .translateAlternateColorCodes('&',
                                        plugin.menuConfig
                                                .getString("Items.Night-Vision.Display-Name")))) {
                    if(p.hasPermission(plugin.config.getString("Permissions.Night-Vision"))) {
                        if (!p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                            p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 0));
                            p.sendMessage(ChatColor
                                    .translateAlternateColorCodes('&',
                                            plugin.config
                                                    .getString("Messages.Night-Vision.Enabled")));
                            p.closeInventory();
                        } else {
                            p.removePotionEffect(PotionEffectType.NIGHT_VISION);
                            p.sendMessage(ChatColor
                                    .translateAlternateColorCodes('&',
                                            plugin.config
                                                    .getString("Messages.Night-Vision.Disabled")));
                            p.closeInventory();
                        }
                    }
                    else {
                        p.sendMessage(ChatColor
                                .translateAlternateColorCodes('&',
                                        plugin.config
                                                .getString("Messages.No-Permission")
                                                .replaceAll("%permission%",
                                                        plugin.config
                                                                .getString("Permissions.Night-Vision"))));
                    }
                }
               }
        }
        catch (Exception ex) {
            return;
        }
    }
}
