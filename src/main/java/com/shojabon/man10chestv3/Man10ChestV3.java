package com.shojabon.man10chestv3;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class Man10ChestV3 extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this,this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e){
        if(e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if(e.isCancelled()) return;
        if(e.getClickedBlock() == null) return;
        if(e.getClickedBlock().getType() != Material.CHEST && e.getClickedBlock().getType() != Material.TRAPPED_CHEST) return;
        if(!(e.getClickedBlock().getState() instanceof Chest)) return;
        Chest chest = ((Chest) e.getClickedBlock().getState());
        if(chest.getInventory() instanceof DoubleChestInventory){
            DoubleChest chestt = ((DoubleChest) chest.getInventory().getHolder());
            SDoubleChestManager manager = new SDoubleChestManager();
            Location lc = chestt.getLocation();
            Bukkit.broadcastMessage(String.valueOf(new Location(lc.getWorld(), ((int) lc.getX()), ((int) lc.getY()), ((int) lc.getZ())).toVector()));
            Location l = manager.getDoubleChestLocation(chestt);
            Bukkit.broadcastMessage(String.valueOf(l.toVector()));
        }else{
            Bukkit.broadcastMessage("CHEST !!");
        }
    }
}
