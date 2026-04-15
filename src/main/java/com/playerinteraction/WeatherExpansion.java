package com.playerinteraction;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class WeatherExpansion extends PlaceholderExpansion {
    private final PersonalWeather plugin;

    public WeatherExpansion(PersonalWeather plugin) { this.plugin = plugin; }
    @Override public @NotNull String getIdentifier() { return "personalweather"; }
    @Override public @NotNull String getAuthor() { return "YourName"; }
    @Override public @NotNull String getVersion() { return "1.1.3"; }

    @Override
    public String onPlaceholderRequest(Player p, @NotNull String params) {
        if (p == null) return "";
        NamespacedKey key = new NamespacedKey(plugin, params.equals("weather_status") ? "player_weather" : "player_time");
        return p.getPersistentDataContainer().getOrDefault(key, PersistentDataType.STRING, "Default");
    }
}