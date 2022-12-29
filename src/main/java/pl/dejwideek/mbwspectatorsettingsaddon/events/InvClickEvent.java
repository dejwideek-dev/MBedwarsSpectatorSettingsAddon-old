package pl.dejwideek.mbwspectatorsettingsaddon.events;

import com.iridium.iridiumcolorapi.IridiumColorAPI;
import de.marcely.bedwars.api.BedwarsAPI;
import de.marcely.bedwars.api.arena.Arena;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pl.dejwideek.mbwspectatorsettingsaddon.SpectSettingsAddon;
import pl.dejwideek.mbwspectatorsettingsaddon.xseries.XMaterial;

@SuppressWarnings("ALL")
public class InvClickEvent implements Listener {

    private static SpectSettingsAddon plugin;

    public InvClickEvent(SpectSettingsAddon plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Arena a = BedwarsAPI.getGameAPI().getArenaByPlayer(p);
        Inventory inv = e.getClickedInventory();

        String menuDisplayName = plugin.menuConfig
                .getString("Menu.Display-Name");
        int menuSize = plugin.menuConfig
                .getInt("Menu.Size");
        String noSpeedMaterial = plugin.menuConfig
                .getString("Items.No-Speed.Material")
                .toUpperCase();
        String noSpeedDisplayName = plugin.menuConfig
                .getString("Items.No-Speed.Display-Name");
        String noSpeedSelectedMsg = plugin.config
                .getString("Messages.Selected.No-Speed");
        String speed1Material = plugin.menuConfig
                .getString("Items.Speed-I.Material")
                .toUpperCase();
        String speed1DisplayName = plugin.menuConfig
                .getString("Items.Speed-I.Display-Name");
        String speed1SelectedMsg = plugin.config
                .getString("Messages.Selected.Speed-I");
        String speed1Permission = plugin.config
                .getString("Permissions.Speed-I");
        String speed2Material = plugin.menuConfig
                .getString("Items.Speed-II.Material")
                .toUpperCase();
        String speed2DisplayName = plugin.menuConfig
                .getString("Items.Speed-II.Display-Name");
        String speed2SelectedMsg = plugin.config
                .getString("Messages.Selected.Speed-II");
        String speed2Permission = plugin.config
                .getString("Permissions.Speed-II");
        String speed3Material = plugin.menuConfig
                .getString("Items.Speed-III.Material")
                .toUpperCase();
        String speed3DisplayName = plugin.menuConfig
                .getString("Items.Speed-III.Display-Name");
        String speed3SelectedMsg = plugin.config
                .getString("Messages.Selected.Speed-III");
        String speed3Permission = plugin.config
                .getString("Permissions.Speed-III");
        String speed4Material = plugin.menuConfig
                .getString("Items.Speed-IV.Material")
                .toUpperCase();
        String speed4DisplayName = plugin.menuConfig
                .getString("Items.Speed-IV.Display-Name");
        String speed4SelectedMsg = plugin.config
                .getString("Messages.Selected.Speed-IV");
        String speed4Permission = plugin.config
                .getString("Permissions.Speed-IV");
        String nightVisionMaterial = plugin.menuConfig
                .getString("Items.Night-Vision.Material")
                .toUpperCase();
        String nightVisionDisplayName = plugin.menuConfig
                .getString("Items.Night-Vision.Display-Name");
        String nightVisionEnabledMsg = plugin.config
                .getString("Messages.Night-Vision.Enabled");
        String nightVisionDisabledMsg = plugin.config
                .getString("Messages.Night-Vision.Disabled");
        String nightVisionPermission = plugin.config
                .getString("Permissions.Night-Vision");
        String noPermsMsg = plugin.config
                .getString("Messages.No-Permission");

        try {
            if(inv.getSize() == menuSize
                    && p.getOpenInventory()
                    .getTitle().equals(IridiumColorAPI
                            .process(menuDisplayName))) {
                ItemStack item = e.getCurrentItem();

                if(item.getType().equals(XMaterial
                        .valueOf(noSpeedMaterial).parseMaterial())
                        && item.getItemMeta()
                        .getDisplayName().equals(IridiumColorAPI
                                .process(noSpeedDisplayName))) {
                    if(p.getWalkSpeed() != 0.2f && p.getFlySpeed() != 0.1f) {
                        p.setWalkSpeed(0.2f);
                        p.setFlySpeed(0.1f);
                        p.sendMessage(IridiumColorAPI
                                .process(noSpeedSelectedMsg));
                        p.closeInventory();
                    }
                    else return;
                }
                if(item.getType().equals(XMaterial
                        .valueOf(speed1Material).parseMaterial())
                        && item.getItemMeta()
                        .getDisplayName().equals(IridiumColorAPI
                                .process(speed1DisplayName))) {
                    if(p.hasPermission(speed1Permission)) {
                        if(p.getWalkSpeed() != 0.3f && p.getFlySpeed() != 0.2f) {
                            p.setWalkSpeed(0.3f);
                            p.setFlySpeed(0.2f);
                            p.sendMessage(IridiumColorAPI
                                    .process(speed1SelectedMsg));
                            p.closeInventory();
                        }
                        else return;
                    }
                    else {
                        p.sendMessage(IridiumColorAPI
                                .process(noPermsMsg
                                        .replaceAll("%permission%",
                                            speed1Permission)));
                    }
                }
                if(item.getType().equals(XMaterial
                        .valueOf(speed2Material).parseMaterial())
                        && item.getItemMeta()
                        .getDisplayName().equals(IridiumColorAPI
                                .process(speed2DisplayName))) {
                    if(p.hasPermission(speed2Permission)) {
                        if(p.getWalkSpeed() != 0.4f && p.getFlySpeed() != 0.3f) {
                            p.setWalkSpeed(0.4f);
                            p.setFlySpeed(0.3f);
                            p.sendMessage(IridiumColorAPI
                                    .process(speed2SelectedMsg));
                            p.closeInventory();
                        }
                        else return;
                    }
                    else {
                        p.sendMessage(IridiumColorAPI
                                .process(noPermsMsg
                                        .replaceAll("%permission%",
                                                speed2Permission)));
                    }
                }
                if(item.getType().equals(XMaterial
                        .valueOf(speed3Material).parseMaterial())
                        && item.getItemMeta()
                        .getDisplayName().equals(IridiumColorAPI
                                .process(speed3DisplayName))) {
                    if(p.hasPermission(speed3Permission)) {
                        if(p.getWalkSpeed() != 0.5f && p.getFlySpeed() != 0.4f) {
                            p.setWalkSpeed(0.5f);
                            p.setFlySpeed(0.4f);
                            p.sendMessage(IridiumColorAPI
                                    .process(speed3SelectedMsg));
                            p.closeInventory();
                        }
                        else return;
                    }
                    else {
                        p.sendMessage(IridiumColorAPI
                                .process(noPermsMsg
                                        .replaceAll("%permission%",
                                                speed3Permission)));
                    }
                }
                if(item.getType().equals(XMaterial
                        .valueOf(speed4Material).parseMaterial())
                        && item.getItemMeta()
                        .getDisplayName().equals(IridiumColorAPI
                                .process(speed4DisplayName))) {
                    if(p.hasPermission(speed4Permission)) {
                        if(p.getWalkSpeed() != 0.6f && p.getFlySpeed() != 0.5f) {
                            p.setWalkSpeed(0.6f);
                            p.setFlySpeed(0.5f);
                            p.sendMessage(IridiumColorAPI
                                    .process(speed4SelectedMsg));
                            p.closeInventory();
                        }
                    }
                    else {
                        p.sendMessage(IridiumColorAPI
                                .process(noPermsMsg
                                        .replaceAll("%permission%",
                                                speed4Permission)));
                    }
                }
                if(item.getType().equals(XMaterial
                        .valueOf(nightVisionMaterial).parseMaterial())
                        && item.getItemMeta()
                        .getDisplayName().equals(IridiumColorAPI
                                .process(nightVisionDisplayName))) {
                    if(p.hasPermission(nightVisionPermission)) {
                        if (!p.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                            p.addPotionEffect(new PotionEffect(
                                    PotionEffectType.NIGHT_VISION,
                                    1000000, 0));
                            p.sendMessage(IridiumColorAPI
                                    .process(nightVisionEnabledMsg));
                            p.closeInventory();
                        } else {
                            p.removePotionEffect(PotionEffectType.NIGHT_VISION);
                            p.sendMessage(IridiumColorAPI
                                    .process(nightVisionDisabledMsg));
                            p.closeInventory();
                        }
                    }
                    else {
                        p.sendMessage(IridiumColorAPI
                                .process(noPermsMsg
                                        .replaceAll("%permission%",
                                                nightVisionPermission)));
                    }
                }
            }
        }
        catch (Exception ex) {
            return;
        }
    }
}
