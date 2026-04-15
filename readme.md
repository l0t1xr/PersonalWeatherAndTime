PersonalWeather & Time

PersonalWeather & Time is a lightweight, high-performance Spigot/Paper plugin that allows players to customize their own environment. Whether a player wants to build in perpetual sunlight or experience a permanent thunderstorm, this plugin gives them total control over their local weather and time without affecting other players or the server environment.

🚥 Dependencies

Luckperms
& PlaceHolderAPI

🚀 Features

* Individual Control: Weather and Time changes are "client-side"—only the player who sets them sees them.
* Persistent Settings: Your preferences are saved automatically and re-applied whenever you join the server.
* PlaceholderAPI Support: Easily display a player’s current weather or time preference on scoreboards or chat using custom placeholders.
* Configurable: Easily change default time values and messages via config.yml.
* Zero Lag: Uses PersistentDataContainer for efficient, database-free data storage.

🎮 In-Game Commands, Description & Luckperms Permission Required

* /w <clear|rain|thunder|reset> - Sets your personal weather type. - personalweather.weather
* /t <day|night|sunset|reset> - Sets your personal time of day. - personalweather.time

🔑 Permissions (LuckPerms)
Use these permissions to control who can use the plugin features:

* personalweather.weather – Allows use of the /w command.
* personalweather.time – Allows use of the /t command.
* personalweather.admin – Allows access to potential future admin/reload commands.

Quick LuckPerms Command Example:

/lp group default permission set personalweather.weather true
/lp group default permission set personalweather.time true

📊 Placeholders (PlaceholderAPI)
If you have PlaceholderAPI installed, you can use these placeholders in your scoreboard, MOTD, or chat plugins:

* %personalweather_weather% – Displays the player's current weather preference (e.g., Clear, Downfall).
* %personalweather_time% – Displays the player's current time preference (e.g., Day, Night, Sunset).

⚙️ Configuration (config.yml)
You can customize the plugin behavior in the generated config.yml file:

settings:
persistent-states: true  # Remember settings after relog
times:
day: 1000
night: 13000
sunset: 23000

messages:
prefix: "&7[&bPersonal&fWorld&7] "
weather-set: "&aYour personal weather has been set to &e%type%&a."
time-set: "&aYour personal time has been set to &e%type%&a."

🛠️ Installation

1, Download the latest .jar file.
2, Drop it into your server's /plugins folder.
3, Restart your server.

Built with ❤️ for a custom server experience by l0tixr.