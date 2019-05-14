package com.shojabon.man10chestv3;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.inventory.DoubleChestInventory;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SDoubleChestManager {

    public Location getDoubleChestLocation(DoubleChest chest ){
        Location l = chest.getLocation();
        for(Location loc : getLocationsBasedOnCenter(l)){
            Block b = loc.getBlock();
            if(b.getType() == Material.CHEST || b.getType() == Material.TRAPPED_CHEST){
                Chest che = ((Chest) b.getState());
                if(chest.getInventory() instanceof DoubleChestInventory){
                    DoubleChest chestt = ((DoubleChest) che.getInventory().getHolder());
                    if(Objects.requireNonNull(chestt).getLocation().equals(l)) return loc;
                    }
                }
            }
            return null;
        }

    private List<Location> getLocationsBasedOnCenter(Location l){
        l = new Location(l.getWorld(), ((int) l.getX()), ((int) l.getY()), ((int) l.getZ()));
        List<Location> loc = new ArrayList<>();
        loc.add(l.clone().add(new Vector(0,0,1)));
        loc.add(l.clone().add(new Vector(1,0,0)));
        loc.add(l.clone().add(new Vector(0,0,-1)));
        loc.add(l.clone().add(new Vector(-1,0,0)));
        return loc;
    }
}
