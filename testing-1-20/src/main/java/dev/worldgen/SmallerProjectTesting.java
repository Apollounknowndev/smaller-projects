package dev.worldgen;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.nio.file.Path;


@Mod("smaller_project_testing")
public class SmallerProjectTesting {
    public SmallerProjectTesting() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::registerEnabledPacks);
    }

    private void registerEnabledPacks(final AddPackFindersEvent event) {
        if (event.getPackType() == PackType.SERVER_DATA) {
            registerDatapack(event, "underground_rivers");
            registerDatapack(event, "improved_village_placement");
        }
    }

    private void registerDatapack(final AddPackFindersEvent event, String name) {
        Path resourcePath = ModList.get().getModFileById("smaller_project_testing").getFile().findResource("resourcepacks/"+name);
        Pack dataPack = Pack.readMetaAndCreate("smaller_project_testing:"+name, Component.literal(name), false, string -> new PathPackResources(resourcePath.getFileName().toString(), resourcePath, false), PackType.SERVER_DATA, Pack.Position.TOP, PackSource.WORLD);
        event.addRepositorySource((packConsumer) -> packConsumer.accept(dataPack));
    }
}
