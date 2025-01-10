package dev.worldgen;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class SmallerProjectTesting implements ModInitializer {
    @Override
    public void onInitialize() {
        registerDatapack("underground_rivers");
        registerDatapack("improved_village_placement");
    }

    private void registerDatapack(String name) {
        ResourceManagerHelper.registerBuiltinResourcePack(
            ResourceLocation.fromNamespaceAndPath("smaller_project_testing", name),
            FabricLoader.getInstance().getModContainer("smaller_project_testing").get(),
            Component.literal(name),
            ResourcePackActivationType.NORMAL
        );
    }
}
