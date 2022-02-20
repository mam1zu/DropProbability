package com.github.mamizu0312.dropprobability;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ProbabilityCheckCommand implements CommandExecutor {

    DropProbability plugin;

    public ProbabilityCheckCommand(DropProbability plugin) {

        this.plugin  = plugin;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {

            sender.sendMessage("現在のアイテムドロップ確率は" + plugin.chanceofdrop + "%です");

            return true;

        }
        Player p = (Player) sender;

        if(!(p.hasPermission("changeprob.change"))) {

            p.sendMessage("あなたは権限を持っていません");
            return true;

        }

        p.sendMessage("現在のアイテムドロップ確率は" + plugin.chanceofdrop + "%です");

        return true;
    }
}
