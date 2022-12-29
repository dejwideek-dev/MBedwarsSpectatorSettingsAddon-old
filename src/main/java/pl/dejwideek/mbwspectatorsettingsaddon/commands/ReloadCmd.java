package pl.dejwideek.mbwspectatorsettingsaddon.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Description;
import com.iridium.iridiumcolorapi.IridiumColorAPI;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import pl.dejwideek.mbwspectatorsettingsaddon.SpectSettingsAddon;

import java.io.IOException;

@SuppressWarnings("ALL")
public class ReloadCmd extends BaseCommand {

    private static SpectSettingsAddon plugin;

    public ReloadCmd(SpectSettingsAddon plugin) {
        this.plugin = plugin;
    }

    @CommandAlias("spectatorsettingsreload|spectsettingsreload|ssareload|ssreload")
    @Description("Reload config files")
    public void reload(CommandSender commandSender) {
        if(commandSender instanceof Player) {
            Player p = (Player) commandSender;
            String reloadedMsg = plugin.config
                    .getString("Messages.Reloaded");
            String noPermsMsg = plugin.config
                    .getString("Messages.No-Permission");
            String permission = plugin.config
                    .getString("Permissions.Reload");

            if(p.hasPermission(permission)) {
                try {
                    plugin.config.reload();
                    plugin.menuConfig.reload();
                }
                catch (IOException e) {
                    throw new RuntimeException(e);
                }

                p.sendMessage(IridiumColorAPI.process(reloadedMsg));
                plugin.getLogger().info("Reloaded configuration files!");
            }
            else {
                p.sendMessage(IridiumColorAPI
                        .process(noPermsMsg
                                .replaceAll("%permission%",
                                        permission)));
            }
        }

        if(commandSender instanceof ConsoleCommandSender) {
            try {
                plugin.config.reload();
                plugin.menuConfig.reload();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }

            plugin.getLogger().info("Reloaded configuration files!");
        }
        return;
    }
}
