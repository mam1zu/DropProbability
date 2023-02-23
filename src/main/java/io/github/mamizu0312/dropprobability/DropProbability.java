package io.github.mamizu0312.dropprobability;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class DropProbability extends JavaPlugin {

    private ProbabilityEventListener event = new ProbabilityEventListener(this);

    FileConfiguration config = this.getConfig();

    public int chanceofdrop;

    @Override
    public void onEnable() {
        getCommand("probchange").setExecutor(new ProbabilityChangeCommand(this));
        getCommand("probcheck").setExecutor(new ProbabilityCheckCommand(this));

        getServer().getPluginManager().registerEvents(event, this);

        saveDefaultConfig();
        chanceofdrop = config.getInt("dropprobability.chance");

        getLogger().info("現在のアイテムドロップ確率は" + chanceofdrop + "%です");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
