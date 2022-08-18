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
                    if(p.hasPotionEffect(PotionEffectType.SPEED)) {
                        p.removePotionEffect(PotionEffectType.SPEED);
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
                        if(p.hasPotionEffect(PotionEffectType.SPEED)) {
                            PotionEffect potion = null;
                            for(PotionEffect pot : p.getActivePotionEffects()) {
                                if(pot.getType().equals(PotionEffectType.SPEED)) {
                                    potion = pot;
                                }
                            }
                            if(potion != null) {
                                if(potion.getAmplifier() != 0) {
                                    p.removePotionEffect(PotionEffectType.SPEED);
                                }
                                else return;
                            }
                            else return;
                        }

                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 0));
                        p.sendMessage(ChatColor
                                .translateAlternateColorCodes('&',
                                        plugin.config
                                                .getString("Messages.Selected.Speed-I")));
                        p.closeInventory();
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
                        if(p.hasPotionEffect(PotionEffectType.SPEED)) {
                            PotionEffect potion = null;
                            for(PotionEffect pot : p.getActivePotionEffects()) {
                                if(pot.getType().equals(PotionEffectType.SPEED)) {
                                    potion = pot;
                                }
                            }
                            if(potion != null) {
                                if(potion.getAmplifier() != 1) {
                                    p.removePotionEffect(PotionEffectType.SPEED);
                                }
                                else return;
                            }
                            else return;
                        }

                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 1));
                        p.sendMessage(ChatColor
                                .translateAlternateColorCodes('&',
                                        plugin.config
                                                .getString("Messages.Selected.Speed-II")));
                        p.closeInventory();
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
                        if(p.hasPotionEffect(PotionEffectType.SPEED)) {
                            PotionEffect potion = null;
                            for(PotionEffect pot : p.getActivePotionEffects()) {
                                if(pot.getType().equals(PotionEffectType.SPEED)) {
                                    potion = pot;
                                }
                            }
                            if(potion != null) {
                                if(potion.getAmplifier() != 2) {
                                    p.removePotionEffect(PotionEffectType.SPEED);
                                }
                                else return;
                            }
                            else return;
                        }

                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 2));
                        p.sendMessage(ChatColor
                                .translateAlternateColorCodes('&',
                                        plugin.config
                                                .getString("Messages.Selected.Speed-III")));
                        p.closeInventory();
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
                        if(p.hasPotionEffect(PotionEffectType.SPEED)) {
                            PotionEffect potion = null;
                            for(PotionEffect pot : p.getActivePotionEffects()) {
                                if(pot.getType().equals(PotionEffectType.SPEED)) {
                                    potion = pot;
                                }
                            }
                            if(potion != null) {
                                if(potion.getAmplifier() != 3) {
                                    p.removePotionEffect(PotionEffectType.SPEED);
                                }
                                else return;
                            }
                            else return;
                        }

                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000000, 3));
                        p.sendMessage(ChatColor
                                .translateAlternateColorCodes('&',
                                        plugin.config
                                                .getString("Messages.Selected.Speed-IV")));
                        p.closeInventory();
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
