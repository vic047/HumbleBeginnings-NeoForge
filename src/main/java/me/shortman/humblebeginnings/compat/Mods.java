package me.shortman.humblebeginnings.compat;

import me.shortman.humblebeginnings.compat.create.CreateCompat;
import me.shortman.humblebeginnings.compat.farmersdelight.FarmersCompat;
import net.minecraft.world.item.Item;


public class Mods {
    private static final Mods instance = null;
    private final boolean isCreate;
    private final boolean isFarmers;

    private Mods() {
        this.isCreate = CreateCompat.init();
        this.isFarmers = FarmersCompat.init();
    }

    public static Mods getInstance() {
        if (instance != null) {
            return instance;
        }
        return new Mods();
    }

    public boolean isCreate() {
        return isCreate;
    }

    public boolean isFarmers() {
        return isFarmers;
    }
}
