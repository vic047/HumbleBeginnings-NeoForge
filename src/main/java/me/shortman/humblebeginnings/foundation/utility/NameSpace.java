package me.shortman.humblebeginnings.foundation.utility;

import me.shortman.humblebeginnings.HumbleBeginnings;

import java.util.List;

public class NameSpace {
    public static final String VANILLA = "minecraft";
    public static final String FORGE = "forge";
    public static final String MOD = HumbleBeginnings.MOD_ID;
    public static final String CREATE = "create";
    public static final String FARMERS = "farmersdelight";

    public static final List<String> knownNameSpaces = List.of(
        VANILLA, FORGE, MOD, CREATE, FARMERS
    );
}
