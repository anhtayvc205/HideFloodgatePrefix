package me.tuanang.hideprefix;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.geysermc.floodgate.api.FloodgateApi;

public final class HideFloodgatePrefix extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        getLogger().info("HideFloodgatePrefix enabled (1.21.1)");
    }

    @EventHandler
    public void onLogin(PlayerLoginEvent e) {
        var player = e.getPlayer();

        // Chỉ xử lý Bedrock
        if (!FloodgateApi.getInstance().isFloodgatePlayer(player.getUniqueId())) return;

        // Xóa prefix dấu chấm
        String cleanName = player.getName().replace(".", "");

        try {
            player.setDisplayName(cleanName);
            player.setPlayerListName(cleanName);
        } catch (Exception ignored) {}
    }
}
