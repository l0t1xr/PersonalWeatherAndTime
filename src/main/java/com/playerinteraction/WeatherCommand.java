package com.playerinteraction;

import org.bukkit.NamespacedKey;
import org.bukkit.WeatherType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class WeatherCommand implements CommandExecutor {
    private final PersonalWeather plugin;
    private final NamespacedKey weatherKey;

    public WeatherCommand(PersonalWeather plugin) {
        this.plugin = plugin;
        this.weatherKey = new NamespacedKey(plugin, "player_weather");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) return true;
        if (args.length == 0) return false;

        String input = args[0].toLowerCase();
        WeatherType type;

        // Map inputs to valid Bukkit WeatherTypes
        if (input.equals("sun") || input.equals("clear")) {
            type = WeatherType.CLEAR;
        } else if (input.equals("rain") || input.equals("thunder")) {
            type = WeatherType.DOWNFALL; // Only DOWNFALL is valid for rain/thunder
        } else {
            player.sendMessage("§cUsage: /w <clear|rain|thunder>");
            return true;
        }

        // Save to PersistentDataContainer
        player.getPersistentDataContainer().set(weatherKey, PersistentDataType.STRING, type.name());
        player.setPlayerWeather(type);
        player.sendMessage("§aWeather set to " + input);

        return true;
    }
}