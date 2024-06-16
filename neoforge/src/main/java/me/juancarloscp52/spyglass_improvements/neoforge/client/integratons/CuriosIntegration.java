package me.juancarloscp52.spyglass_improvements.neoforge.client.integratons;

import me.juancarloscp52.spyglass_improvements.client.integrations.IEquipmentIntegration;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

import java.util.concurrent.atomic.AtomicBoolean;

public class CuriosIntegration implements IEquipmentIntegration {

    public void registerRenderer (){
        CuriosRendererRegistry.register(Items.SPYGLASS, () -> new SpyglassCuriosRenderer(this));
    }

    @Override
    public boolean isPlayerUsingSpyglass(Player player) {
        AtomicBoolean spyglassInCurios = new AtomicBoolean(false);
        CuriosApi.getCuriosInventory(player).ifPresent(iCuriosItemHandler -> {
            // Find if a spyglass is in player curio slots
            if (iCuriosItemHandler.findFirstCurio(Items.SPYGLASS).isPresent()) {
                spyglassInCurios.set(true);
            }
        });

        return spyglassInCurios.get();
    }
}
