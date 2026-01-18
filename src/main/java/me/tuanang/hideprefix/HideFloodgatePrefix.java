spackage me.tuanang.hideprefix;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class HideFloodgatePrefix extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);

        // Fix cho người đang online khi reload
        for (Player p : Bukkit.getOnlinePlayers()) {
            cleanName(p);
        }

        getLogger().info("HideFloodgatePrefix enabled");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        cleanName(e.getPlayer());
    }

    private void cleanName(Player p) {
        String name = p.getName();
        if (name.startsWith(".")) {
            String clean = name.substring(1);
            p.setDisplayName(clean);
            p.setPlayerListName(clean);
        }
    }
}
