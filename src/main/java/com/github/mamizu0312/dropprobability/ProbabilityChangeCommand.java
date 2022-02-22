package com.github.mamizu0312.dropprobability;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ProbabilityChangeCommand implements CommandExecutor {

    private DropProbability plugin;

    public ProbabilityChangeCommand(DropProbability plugin) {

        this.plugin = plugin;

    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(sender instanceof Player)) {

            if(!(args.length == 1)) {

                sender.sendMessage("0~100の整数を一つだけ入力してください");
                return true;

            }
            int input;

            try {

                input = Integer.parseInt(args[0]);

            } catch (NumberFormatException e) {

                sender.sendMessage("0~100の整数を入力してください");
                return true;

            }

            if((input <= 0) || (100 <= input)) {
                sender.sendMessage("0~100の整数を入力して下さい");
            }

            return true;

        }
        Player p = (Player) sender;

        if(!(p.hasPermission("dropprobability.change"))) {

            p.sendMessage("あなたは権限を持っていません");
            return true;

        }

        if(!(args.length == 1)){
            p.sendMessage("0~100の整数を一つだけ入力してください");
            return true;
        }

        int input;

        try {

            input = Integer.parseInt(args[0]);
            if((input <= 0) || (100 <= input)) {
                p.sendMessage("0~100までの整数を入力してください");
                return true;
            }

        } catch (NumberFormatException e) {

            p.sendMessage("0~100までの整数を入力してください");
            return true;

        }

        plugin.chanceofdrop = input;

        plugin.config.set("dropprobability.chance", plugin.chanceofdrop);
        plugin.saveConfig();
        p.sendMessage("アイテムのドロップ確率が" + plugin.chanceofdrop + "%になりました");
        return true;



    }
}
