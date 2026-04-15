package com.playerinteraction;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.Objects;

public class PersonalWeather extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        // 1. Register Commands
        getCommand("w").setExecutor(new WeatherCommand(this));
        getCommand("t").setExecutor(new TimeCommand(this));

        // 2. Register the Listener
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);

        // 3. Register Expansion
        new WeatherExpansion(this).register();
        }
    }