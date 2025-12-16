package net.BLS.createcobblemonindustry.registry.fluid;

import net.minecraft.resources.ResourceLocation;
import net.BLS.createcobblemonindustry.CreateCobblemonIndustry;

import java.util.function.Supplier;

public enum FluidType {

    medicinal_brew(
            "medicinal_brew",
            1200,   // density
            1500,   // viscosity
            500,    // temperature
            20,     // tick rate
            2,      // level decrease
            3,      // slope find
            0xE67E22,           // fog color
            () -> 0.6f          // fog distance multiplier
    ),
    burn_heal(
            "burn_heal",
            1200,
            1500,
            500,
            20,
            2,
            3,
            0xE67E22,
            () -> 0.4f
    );

    private final String id;
    private final int density;
    private final int viscosity;
    private final int temperature;
    private final int tickRate;
    private final int levelDecreasePerBlock;
    private final int slopeFindDistance;
    private final int fogColor;
    private final Supplier<Float> fogDistance;

    FluidType(
            String id,
            int density,
            int viscosity,
            int temperature,
            int tickRate,
            int levelDecreasePerBlock,
            int slopeFindDistance,
            int fogColor,
            Supplier<Float> fogDistance
    ) {
        this.id = id;
        this.density = density;
        this.viscosity = viscosity;
        this.temperature = temperature;
        this.tickRate = tickRate;
        this.levelDecreasePerBlock = levelDecreasePerBlock;
        this.slopeFindDistance = slopeFindDistance;
        this.fogColor = fogColor;
        this.fogDistance = fogDistance;
    }

    public String getId() {
        return id;
    }

    public int density() {
        return density;
    }

    public int viscosity() {
        return viscosity;
    }

    public int temperature() {
        return temperature;
    }

    public int tickRate() {
        return tickRate;
    }

    public int levelDecreasePerBlock() {
        return levelDecreasePerBlock;
    }

    public int slopeFindDistance() {
        return slopeFindDistance;
    }

    public int fogColor() {
        return fogColor;
    }

    public Supplier<Float> fogDistance() {
        return fogDistance;
    }

    public ResourceLocation stillTexture() {
        return ResourceLocation.fromNamespaceAndPath(
                CreateCobblemonIndustry.MODID,
                "fluid/" + id + "_still"
        );
    }

    public ResourceLocation flowingTexture() {
        return ResourceLocation.fromNamespaceAndPath(
                CreateCobblemonIndustry.MODID,
                "fluid/" + id + "_flow"
        );
    }
}
