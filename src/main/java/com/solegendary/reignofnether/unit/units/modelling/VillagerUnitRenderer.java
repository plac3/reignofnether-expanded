package com.solegendary.reignofnether.unit.units.modelling;

import com.mojang.blaze3d.vertex.PoseStack;
import com.solegendary.reignofnether.unit.units.villagers.VillagerUnit;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

// based on VindicatorRenderer
@OnlyIn(Dist.CLIENT)
public class VillagerUnitRenderer extends AbstractVillagerUnitRenderer<VillagerUnit> {
    private static final ResourceLocation VILLAGER_UNIT = new ResourceLocation("reignofnether", "textures/entities/villager_unit.png");

    public VillagerUnitRenderer(EntityRendererProvider.Context p_174439_) {
        super(p_174439_, new VillagerUnitModel<>(p_174439_.bakeLayer(ModelLayers.VINDICATOR)), 0.5F);
        this.addLayer(new ItemInHandLayer<VillagerUnit, VillagerUnitModel<VillagerUnit>>(this, p_174439_.getItemInHandRenderer()) {
            public void render(PoseStack pose, MultiBufferSource mbs, int p_116354_, VillagerUnit unit, float p_116356_, float p_116357_, float p_116358_, float p_116359_, float p_116360_, float p_116361_) {
                if (unit.getBuildRepairGoal().isBuilding() || unit.getGatherResourceGoal().isGathering()) {
                    super.render(pose, mbs, p_116354_, unit, p_116356_, p_116357_, p_116358_, p_116359_, p_116360_, p_116361_);
                }
            }
        });
    }

    public ResourceLocation getTextureLocation(VillagerUnit p_116324_) {
        return VILLAGER_UNIT;
    }
}