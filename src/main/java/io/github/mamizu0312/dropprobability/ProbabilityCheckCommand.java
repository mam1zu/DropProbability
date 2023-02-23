package io.github.mamizu0312.dropprobability;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ProbabilityCheckCommand implements CommandExecutor {

    private DropProbability plugin;

    public ProbabilityCheckCommand(DropProbability plugin) {

        this.plugin = plugin;

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {

            Player p = (Player) sender;

            if(!(p.hasPermission("dropprobability.check"))) {

                senderHasNoPermission(sender);
                return true;

            }
        }

        sendChanceOfDrop(sender);
        return true;

    }

    public void sendChanceOfDrop(CommandSender sender) {
        sender.sendMessage("現在のアイテムドロップ確率は" + plugin.chanceofdrop + "%です");
    }

    public void senderHasNoPermission(CommandSender sender) {
        sender.sendMessage("あなたは権限を持っていません");
    }

}
