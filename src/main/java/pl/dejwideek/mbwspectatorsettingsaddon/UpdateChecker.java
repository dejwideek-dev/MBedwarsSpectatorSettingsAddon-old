package pl.dejwideek.mbwspectatorsettingsaddon;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.util.function.Consumer;

@SuppressWarnings("ALL")
public class UpdateChecker {

    private final JavaPlugin plugin;
    private final int id;

    public UpdateChecker(JavaPlugin plugin, int id) {
        this.plugin = plugin;
        this.id = 104651;
    }

    public void getVersion(final Consumer<String> consumer) {
        Bukkit.getScheduler().runTaskAsynchronously(this.plugin, () -> {
            try (InputStream inputStream =
                         new URL("https://api.spigotmc.org/legacy/update.php?resource="
                                 + this.id).openStream();
                 Scanner scanner =
                         new Scanner(inputStream)) {
                if (scanner.hasNext()) {
                    consumer.accept(scanner.next());
                }
            } catch (IOException exception) {
                plugin.getLogger().info("Unable to check for updates: " + exception.getMessage());
            }
        });
    }
}
