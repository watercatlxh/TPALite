package com.cheatingfox.moeteleporter;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class TPAEventListener implements Listener {
    private TPARequestManager tpaManager;

    public TPAEventListener(TPARequestManager tpaManager) {
        this.tpaManager = tpaManager;
    }

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        String cmd = event.getMessage().split(" ")[0];
        Player targetPlayer = event.getPlayer();

        if (cmd.equalsIgnoreCase("/tpaccept")) {
            for (Player requester : tpaManager.tpaRequests.keySet()) {
                if (tpaManager.hasRequestFrom(targetPlayer, requester)) {
                    requester.teleport(targetPlayer); // Teleporting the requester to the target
                    tpaManager.removeRequest(requester);
                    requester.sendMessage("正在传送至 " + targetPlayer.getName());
                    targetPlayer.sendMessage("传送请求已同意");
                }
            }
        }
    }
}
