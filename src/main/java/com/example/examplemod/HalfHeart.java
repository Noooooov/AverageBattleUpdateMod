package com.example.examplemod;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.xml.stream.Location;

@Mod("examplemod")
public class HalfHeart {
    public HalfHeart() {
        MinecraftForge.EVENT_BUS.register(this);
    }
    @SubscribeEvent
    public void onPlayerConnection(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(1);
        if(player.level() instanceof ServerLevel serverLevel) {
            for (int i = 0; i < 10; i++) {
                Zombie zomb = EntityType.ZOMBIE.create(serverLevel);
                double x = player.getX()+Math.random()*10-5;
                double y = player.getY()+1;
                double z = player.getZ()+Math.random()*10-5;
                zomb.setPos(x, y, z);
                serverLevel.addFreshEntity(zomb);
            }
        }
    }

    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        Player player = event.getEntity();
        player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(1);
        if(player.level() instanceof ServerLevel serverLevel) {
            for (int i = 0; i < 10; i++) {
                Zombie zomb = EntityType.ZOMBIE.create(serverLevel);
                double x = player.getX()+Math.random()*10-5;
                double y = player.getY()+1;
                double z = player.getZ()+Math.random()*10-5;
                zomb.setPos(x, y, z);
                serverLevel.addFreshEntity(zomb);
            }
        }
    }
}
