package com.cheatingfox.moeteleporter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPACommand implements CommandExecutor {
    private TPARequestManager tpaManager;

    public TPACommand(TPARequestManager tpaManager) {
        this.tpaManager = tpaManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("只有玩家可以使用这个命令w~");
            return true;
        }

        Player player = (Player) sender;

        if (args.length != 1) {
            player.sendMessage("命令错了辣，使用方法是这样的 /tpa <playername>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            player.sendMessage("你想传送的那个人不在哦");
            return true;
        }

        tpaManager.addRequest(player, target);
        target.sendMessage(player.getName() + " 想传送到你这，使用指令 /tpaccept 来同意吧!");

        return true;
    }
}
