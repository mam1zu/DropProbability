package io.github.mamizu0312.dropprobability;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ProbabilityChangeCommand implements CommandExecutor {

    private DropProbability plugin;

    private String CommandPrefix = "&c[DropProbabiloty]&f";

    public ProbabilityChangeCommand(DropProbability plugin) {

        this.plugin = plugin;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {

            if(!(args.length == 1)) {

                sendError(sender);
                return true;

            }

        }

        else {

            Player p = (Player) sender;

            if(!(p.hasPermission("dropprobability.change"))) {

                sendHasNoPermission(sender);
                return true;

            }

        }

        int input = 0;

        try {

            input = Integer.parseInt(args[0]);

        } catch (NumberFormatException e) {

            sendError(sender);
            return true;

        }

        if((input < 0) || (100 < input)) {
            sendError(sender);
        }

        plugin.chanceofdrop = input;

        plugin.config.set("dropprobability.chance", plugin.chanceofdrop);
        plugin.saveConfig();
        sender.sendMessage("アイテムのドロップ確率が" + plugin.chanceofdrop + "%になりました");

        return true;

    }

    public void sendError(CommandSender sender) {
        sender.sendMessage("0~100の整数を一つ入力してください");
    }

    public void sendHasNoPermission(CommandSender sender) {
        sender.sendMessage("あなたは権限を持っていません");
    }
}
