package com.playerinteraction;

import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

public class TimeCommand implements CommandExecutor {
    private final PersonalWeather plugin;
    private final NamespacedKey timeKey;

    public TimeCommand(PersonalWeather plugin) {
        this.plugin = plugin;
        this.timeKey = new NamespacedKey(plugin, "player_time");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (!(sender instanceof Player player)) return true;
        if (args.length == 0) return false;

        String input = args[0].toLowerCase();
        long timeTicks;

        if (input.equals("day")) {
            timeTicks = 1000L;
        } else if (input.equals("night")) {
            timeTicks = 13000L;
        } else {
            player.sendMessage("§cUsage: /t <day|night>");
            return true;
        }

        player.getPersistentDataContainer().set(timeKey, PersistentDataType.STRING, input);
        player.setPlayerTime(timeTicks, false);
        player.sendMessage("§aPersonal time set to " + input);
        return true;
    }
}