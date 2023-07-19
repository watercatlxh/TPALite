package com.cheatingfox.moeteleporter;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private TPARequestManager tpaManager;

    @Override
    public void onEnable() {
        tpaManager = new TPARequestManager();

        this.getCommand("tpa").setExecutor(new TPACommand(tpaManager));
        this.getServer().getPluginManager().registerEvents(new TPAEventListener(tpaManager), this);
    }
}
