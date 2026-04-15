package com.playerinteraction;

import org.bukkit.NamespacedKey;
import org.bukkit.WeatherType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinListener implements Listener {
    private final PersonalWeather plugin;
    private final NamespacedKey weatherKey;
    private final NamespacedKey timeKey;

    public PlayerJoinListener(PersonalWeather plugin) {
        this.plugin = plugin;
        this.weatherKey = new NamespacedKey(plugin, "player_weather");
        this.timeKey = new NamespacedKey(plugin, "player_time");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // 20 ticks = 1 second delay to ensure other plugins finish loading first
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!player.isOnline()) return;

                // Re-apply Weather
                if (player.getPersistentDataContainer().has(weatherKey, PersistentDataType.STRING)) {
                    String saved = player.getPersistentDataContainer().get(weatherKey, PersistentDataType.STRING);
                    player.setPlayerWeather(WeatherType.valueOf(saved));
                }

                // Re-apply Time
                if (player.getPersistentDataContainer().has(timeKey, PersistentDataType.STRING)) {
                    String saved = player.getPersistentDataContainer().get(timeKey, PersistentDataType.STRING);
                    player.setPlayerTime(saved.equalsIgnoreCase("day") ? 1000L : 13000L, false);
                }
            }
        }.runTaskLater(plugin, 20L);
    }
}