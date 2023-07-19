package com.cheatingfox.moeteleporter;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class TPARequestManager {
    Map<Player, Player> tpaRequests = new HashMap<>();

    public void addRequest(Player requester, Player target) {
        tpaRequests.put(requester, target);
    }

    public boolean hasRequestFrom(Player target, Player requester) {
        return tpaRequests.get(requester) == target;
    }

    public void removeRequest(Player requester) {
        tpaRequests.remove(requester);
    }
}
