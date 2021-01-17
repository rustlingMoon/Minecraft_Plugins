package ch.alaeberse.zensur;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void onEnable() {
		System.out.println("Zensur erfolgreich aktiviert!");

		Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
		
		loadConfig();
	}
	
	public void onDisable() {
		System.out.println("Zensur deaktiviert.");
	}
	
	void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
}
