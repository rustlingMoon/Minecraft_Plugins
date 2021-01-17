package ch.alaeberse.zensur;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
	FileConfiguration cfg = Main.getPlugin(Main.class).getConfig();
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		if(getFile()) {
			String[] msg = e.getMessage().split("[^\\p{L}0-9']+");
			Player p = e.getPlayer();
			for(String s: cfg.getStringList("Zensierte_Woerter")) {
				for(String m : msg) {
					if(m.equalsIgnoreCase(s) || msg[0].equalsIgnoreCase(s)) {
						e.setCancelled(true);
						p.sendMessage("§cBitte unterlasse solche Ausdrücke! §7[" + s + "]");
					}
				}
			}
		}
	}
	
	Boolean getFile() {
		try {
			cfg.getStringList("Zensierte_Woerter");
		} catch (Exception error) {
			System.out.println("Das YML-File \"config\" ist beschädigt.");
			return false;
		}
		return true;
	}

}
