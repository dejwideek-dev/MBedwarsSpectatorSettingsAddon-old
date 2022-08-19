package pl.dejwideek.mbwspectatorsettingsaddon;

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
import org.bukkit.plugin.java.JavaPlugin;
import pl.dejwideek.mbwspectatorsettingsaddon.commands.ReloadCommand;
import pl.dejwideek.mbwspectatorsettingsaddon.events.InventoryClickEvent;

import java.io.File;
import java.io.IOException;

@SuppressWarnings("ALL")
public class SpectSettingsAddon extends JavaPlugin implements Listener {

    public YamlDocument config;
    public YamlDocument menuConfig;
    public Player menuPlayer;

    public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("MBedwars") != null) {
            final int supportedAPIVersion = 1;

            try {
                Class apiClass = Class.forName("de.marcely.bedwars.api.BedwarsAPI");
                int apiVersion = (int) apiClass.getMethod("getAPIVersion").invoke(null);

                if (apiVersion < supportedAPIVersion)
                    throw new IllegalStateException();
            } catch (Exception e) {
                this.getLogger().warning("Your MBedwars version is not supported. Supported version: 5.0 or higher!");
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
            this.getLogger().warning("Failed to load the configurations :(");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        new UpdateChecker(this, 104651).getVersion(version -> {
            if (this.getDescription().getVersion().equals(version)) {
                this.getLogger().info("You are using latest version.");
            }
            else {
                this.getLogger().info("There is a new update available. (v" + version + ")");
                this.getLogger().info("https://spigotmc.org/resources/104651/updates");
            }
        });

        Bukkit.getPluginManager().registerEvents(new InventoryClickEvent(this), this);
        this.getCommand("spectsettingsreload").setExecutor(new ReloadCommand(this));

        BedwarsAPI.onReady(() -> {
            BedwarsAPI.getGameAPI().registerSpectatorItemHandler(new SpectatorItemHandler("spectator-settings", this) {
                @Override
                public void handleUse(Spectator spectator, SpectatorItem spectatorItem) {
                    Player p = spectator.getPlayer();
                    MenuSystem menuSystem = new MenuSystem(SpectSettingsAddon.this, this);
                    menuPlayer = p;

                    p.openInventory(menuSystem.menuSystem());
                }

                @Override
                public boolean isVisible(Spectator spectator, SpectatorItem spectatorItem) {
                    Player p = spectator.getPlayer();
                    Arena a = BedwarsAPI.getGameAPI().getArenaBySpectator(p);
                    Arena ap = BedwarsAPI.getGameAPI().getArenaByPlayer(p);

                    if(a != ap) return true;
                    else return false;
                }
            });
        });
    }
}
