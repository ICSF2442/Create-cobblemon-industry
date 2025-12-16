package net.BLS.createcobblemonindustry.registry.fluid;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import com.tterrag.registrate.builders.FluidBuilder;
import net.BLS.createcobblemonindustry.CreateCobblemonIndustry;
import net.BLS.createcobblemonindustry.registry.CreateCobblemonIndustryRegistrate;

import net.createmod.catnip.theme.Color;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import com.tterrag.registrate.util.entry.FluidEntry;
import net.neoforged.neoforge.fluids.FluidStack;
import org.joml.Vector3f;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class CreateCobblemonIndustryModFluids {



    private static final CreateCobblemonIndustryRegistrate REGISTRATE =
            CreateCobblemonIndustry.registrate();

    public static final Map<FluidType, FluidEntry<BaseFlowingFluid.Flowing>> FLUID_MAP =
            new EnumMap<>(FluidType.class);

    static {
        for (FluidType type : FluidType.values()) {
            FLUID_MAP.put(type, register(type));
        }
    }

    @SubscribeEvent
    public static void onRegisterClientExtensions(RegisterClientExtensionsEvent event) {

        for (FluidEntry<BaseFlowingFluid.Flowing> entry
                : CreateCobblemonIndustryModFluids.FLUID_MAP.values()) {

            var fluidType = entry.get().getFluidType();

            if (fluidType instanceof
                    CreateCobblemonIndustryModFluids.TintedFluidType tinted) {

                event.registerFluidType(
                        tinted.createClientExtensions(),
                        fluidType
                );
            }
        }
    }

    private static FluidEntry<BaseFlowingFluid.Flowing> register(FluidType type) {
        return REGISTRATE
                .standardFluid(
                        type.getId(),
                        SolidRenderedPlaceableFluidType.create(
                                type.fogColor(),
                                type.fogDistance()
                        )
                )
                .properties(b -> b
                        .density(type.density())
                        .viscosity(type.viscosity())
                        .temperature(type.temperature())
                )
                .fluidProperties(p -> p
                        .tickRate(type.tickRate())
                        .levelDecreasePerBlock(type.levelDecreasePerBlock())
                        .slopeFindDistance(type.slopeFindDistance())
                )
                .source(BaseFlowingFluid.Source::new)
                .block()
                .build()
                .bucket()
                .build()
                .register();
    }

    public static abstract class TintedFluidType extends net.neoforged.neoforge.fluids.FluidType {

        protected static final int NO_TINT = 0xffffffff;
        protected final ResourceLocation stillTexture;
        protected final ResourceLocation flowingTexture;

        protected TintedFluidType(
                Properties properties,
                ResourceLocation stillTexture,
                ResourceLocation flowingTexture
        ) {
            super(properties);
            this.stillTexture = stillTexture;
            this.flowingTexture = flowingTexture;
        }

        public IClientFluidTypeExtensions createClientExtensions() {
            return new IClientFluidTypeExtensions() {

                @Override
                public ResourceLocation getStillTexture() {
                    return stillTexture;
                }

                @Override
                public ResourceLocation getFlowingTexture() {
                    return flowingTexture;
                }

                @Override
                public int getTintColor(FluidStack stack) {
                    return TintedFluidType.this.getTintColor(stack);
                }

                @Override
                public int getTintColor(FluidState state, BlockAndTintGetter getter, BlockPos pos) {
                    return TintedFluidType.this.getTintColor(state, getter, pos);
                }

                @Override
                public Vector3f modifyFogColor(
                        Camera camera, float partialTick, ClientLevel level,
                        int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor
                ) {
                    Vector3f customFogColor = TintedFluidType.this.getCustomFogColor();
                    return customFogColor == null ? fluidFogColor : customFogColor;
                }

                @Override
                public void modifyFogRender(
                        Camera camera, FogRenderer.FogMode mode, float renderDistance,
                        float partialTick, float nearDistance, float farDistance, FogShape shape
                ) {
                    float modifier = TintedFluidType.this.getFogDistanceModifier();
                    if (modifier != 1f) {
                        RenderSystem.setShaderFogShape(FogShape.CYLINDER);
                        RenderSystem.setShaderFogStart(-8);
                        RenderSystem.setShaderFogEnd(96.0f * modifier);
                    }
                }
            };
        }

        protected abstract int getTintColor(FluidStack stack);
        protected abstract int getTintColor(FluidState state, BlockAndTintGetter getter, BlockPos pos);

        protected Vector3f getCustomFogColor() {
            return null;
        }

        protected float getFogDistanceModifier() {
            return 1f;
        }
    }



    private static class SolidRenderedPlaceableFluidType extends TintedFluidType {

        private Vector3f fogColor;
        private Supplier<Float> fogDistance;

        public static FluidBuilder.FluidTypeFactory create(int fogColor, Supplier<Float> fogDistance) {
            return (p, still, flowing) -> {
                SolidRenderedPlaceableFluidType type =
                        new SolidRenderedPlaceableFluidType(p, still, flowing);
                type.fogColor = new Color(fogColor, false).asVectorF();
                type.fogDistance = fogDistance;
                return type;
            };
        }

        private SolidRenderedPlaceableFluidType(
                Properties properties,
                ResourceLocation still,
                ResourceLocation flowing
        ) {
            super(properties, still, flowing);
        }

        @Override
        protected int getTintColor(FluidStack stack) {
            return NO_TINT;
        }

        @Override
        protected int getTintColor(FluidState state, BlockAndTintGetter world, BlockPos pos) {
            return 0x00ffffff; // Optifine workaround preserved
        }

        @Override
        protected Vector3f getCustomFogColor() {
            return fogColor;
        }

        @Override
        protected float getFogDistanceModifier() {
            return fogDistance.get();
        }
    }


    // force class loading
    public static void register() {}
}
