package me.shortman.humblebeginnings.foundation.utility;

import me.shortman.humblebeginnings.HumbleBeginnings;
import net.minecraft.resources.ResourceLocation;

public final class ModResourceLocationHelper {
    public static String removeNamespace(String path) {
        for (String ns : NameSpace.knownNameSpaces) {
            path = path.replace(ns + ":", "");
        }
        return path;
    }

    public static ResourceLocation withModId(String path) {
        return ResourceLocation.fromNamespaceAndPath(HumbleBeginnings.MOD_ID, removeNamespace(path));
    }
    public static ResourceLocation withMinecraftId(String path) {
        return ResourceLocation.fromNamespaceAndPath("minecraft", removeNamespace(path));
    }
    public static ResourceLocation withNameSpaceId(String namespace, String path) {
        return ResourceLocation.fromNamespaceAndPath("minecraft", removeNamespace(path));
    }
}
