package io.github.mamizu0312.dropprobability;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDropItemEvent;

import java.util.Random;

public class ProbabilityEventListener implements Listener {

    private DropProbability plugin;

    public ProbabilityEventListener(DropProbability plugin) {

        this.plugin = plugin;

    }

    @EventHandler
    public void onDropItem(BlockDropItemEvent e) {

        Random random = new Random();

        int value = random.nextInt(100) + 1;

        e.setCancelled(value <= plugin.chanceofdrop);
    }

}
