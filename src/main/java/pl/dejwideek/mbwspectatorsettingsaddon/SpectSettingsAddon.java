package pl.dejwideek.mbwspectatorsettingsaddon;

import co.aikar.commands.BukkitCommandManager;
import de.marcely.bedwars.api.BedwarsAPI;
import de.marcely.bedwars.api.arena.Arena;
import de.marcely.bedwars.api.game.spectator.Spectator;
import de.marcely.bedwars.api.game.spectator.SpectatorItem;
import de.marcely.bedwars.api.game.spectator.SpectatorItemHandler;
import dev.dejvokep.boostedyaml.YamlDocument;
import dev.dejvokep.boostedyaml.dvs.versioning.BasicVersioning;
import dev.dejvokep.boostedyaml.settings.dumper.DumperSettings;
import dev.dejvokep.boostedyaml.settings.general.GeneralSettings;
import dev.dejvokep.boostedyaml.settings.loader.LoaderSettings;
import dev.dejvokep.boostedyaml.settings.updater.UpdaterSettings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import pl.dejwideek.mbwspectatorsettingsaddon.commands.ReloadCmd;
import pl.dejwideek.mbwspectatorsettingsaddon.events.InvClickEvent;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("ALL")
public class SpectSettingsAddon extends JavaPlugin implements Listener {

    public YamlDocument config;
    public YamlDocument menuConfig;

    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("MBedwars") != null) {
            final int supportedAPIVersion = 9;

            try {
                Class apiClass = Class.forName("de.marcely.bedwars.api.BedwarsAPI");
                int apiVersion = (int) apiClass.getMethod("getAPIVersion").invoke(null);

                if (apiVersion < supportedAPIVersion)
                    throw new IllegalStateException();
            } catch (Exception e) {
                this.getLogger().warning("Your MBedwars version is not supported. Supported version: 5.0.8 or higher!");
                Bukkit.getPluginManager().disablePlugin(this);
                return;
            }
        } else {
            this.getLogger().warning("MBedwars is not enabled!");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        try {
            config = YamlDocument.create(
                    new File(getDataFolder(), "config.yml"),
                    getResource("config.yml"),
                    GeneralSettings.DEFAULT,
                    LoaderSettings.builder().setAutoUpdate(true).build(),
                    DumperSettings.DEFAULT,
                    UpdaterSettings.builder().setVersioning(new BasicVersioning("config-version")).build());
            menuConfig = YamlDocument.create(
                    new File(getDataFolder(), "menu.yml"),
                    getResource("menu.yml"),
                    GeneralSettings.DEFAULT,
                    LoaderSettings.builder().setAutoUpdate(true).build(),
                    DumperSettings.DEFAULT,
                    UpdaterSettings.builder().setVersioning(new BasicVersioning("config-version")).build());

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        updateCheck();
        registerEvents();
        registerCommands();
        registerItem();
    }

    public void updateCheck() {
        new UpdateChecker(this, 104651).getVersion(version -> {
            if (this.getDescription().getVersion().equals(version)) {
                this.getLogger().info("You are using latest version.");
            }
            else {
                this.getLogger().info("There is a new update available. (v" + version + ")");
                this.getLogger().info("https://spigotmc.org/resources/104651/updates");
            }
        });
    }

    public void registerEvents() {
        PluginManager manager = Bukkit.getPluginManager();

        manager.registerEvents(new InvClickEvent(this), this);
    }

    public void registerCommands() {
        BukkitCommandManager manager =
                new BukkitCommandManager(this);

        manager.registerCommand(new ReloadCmd(this));
    }

    public void registerItem() {
        BedwarsAPI.onReady(() -> {
            BedwarsAPI.getGameAPI().registerSpectatorItemHandler(
                    new SpectatorItemHandler("spectator-settings", this) {
                        @Override
                        public void handleUse(Spectator spectator,
                                              SpectatorItem spectatorItem) {
                            Player p = spectator.getPlayer();
                            Menu menu = new Menu(
                                    SpectSettingsAddon.this, this);

                            p.openInventory(menu.menu(p));
                        }

                        @Override
                        public boolean isVisible(Spectator spectator,
                                                 SpectatorItem spectatorItem) {
                            Player p = spectator.getPlayer();
                            Arena a = BedwarsAPI.getGameAPI()
                                    .getArenaBySpectator(p);
                            Arena ap = BedwarsAPI.getGameAPI()
                                    .getArenaByPlayer(p);

                            if(a != ap) return true;
                            else return false;
                        }
                    });
        });
    }
}
