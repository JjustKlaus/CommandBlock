package de.julian199;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onDisable() {

    }

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this,this);
        getConfig().options().copyDefaults(true);
        saveConfig();

    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        if(e.getMessage().toLowerCase().startsWith("/t set perm ally") || (e.getMessage().toLowerCase().startsWith("/town set perm ally")))
            return;

        if(e.getMessage().toLowerCase().startsWith("/t set perm") || e.getMessage().toLowerCase().startsWith("/town set perm")) {
            if(p.hasPermission("*")) {
                return;
            }
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&',getConfig().getString("Config.chatnachricht")));
        }
}
}
