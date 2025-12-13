package net.BLS.createcobblemonindustry.registry.item;

public enum BallType {

    // Base
    IRON_BALL_BASE("iron_ball_base"),

    // Ball Lids
    RED("red_ball_lid"), BLUE("blue_ball_lid"), YELLOW("yellow_ball_lid"),
    GREEN("green_ball_lid"), PINK("pink_ball_lid"), BLACK("black_ball_lid"),
    WHITE("white_ball_lid"),

    GREAT("great_ball_lid"), ULTRA("ultra_ball_lid"),


    SAFARI("safari_ball_lid"), FAST("fast_ball_lid"), LEVEL("level_ball_lid"),
    LURE("lure_ball_lid"), HEAVY("heavy_ball_lid"), LOVE("love_ball_lid"),
    FRIEND("friend_ball_lid"), MOON("moon_ball_lid"), SPORT("sport_ball_lid"),
    PARK("park_ball_lid"), NET("net_ball_lid"), DIVE("dive_ball_lid"),
    NEST("nest_ball_lid"), REPEAT("repeat_ball_lid"), TIMER("timer_ball_lid"),
    LUXURY("luxury_ball_lid"), DUSK("dusk_ball_lid"), HEAL("heal_ball_lid"),
    QUICK("quick_ball_lid"), DREAM("dream_ball_lid"), BEAST("beast_ball_lid"),
    MASTER("master_ball_lid"),

    // Tumblestones
    TUMBLESTONE("tumblestone_lid"), SKY_TUMBLESTONE("sky_tumblestone_lid"),
    BLACK_TUMBLESTONE("black_tumblestone_lid"),

    // Ancient
    ANCIENT_RED("ancient_red_ball_lid"), ANCIENT_BLUE("ancient_blue_ball_lid"),
    ANCIENT_YELLOW("ancient_yellow_ball_lid"), ANCIENT_GREEN("ancient_green_ball_lid"),
    ANCIENT_PINK("ancient_pink_ball_lid"), ANCIENT_BLACK("ancient_black_ball_lid"),
    ANCIENT_WHITE("ancient_white_ball_lid"), ANCIENT_GREAT("ancient_great_ball_lid"),
    ANCIENT_ULTRA("ancient_ultra_ball_lid"), ANCIENT_FEATHER("ancient_feather_ball_lid"),
    ANCIENT_WING("ancient_wing_ball_lid"), ANCIENT_JET("ancient_jet_ball_lid"),
    ANCIENT_HEAVY("ancient_heavy_ball_lid"), ANCIENT_LEADEN("ancient_leaden_ball_lid"),
    ANCIENT_GIGATON("ancient_gigaton_ball_lid"),

    // Incomplete Pokéballs
    INCOMPLETE_POKE_BALL("incomplete_poke_ball"), INCOMPLETE_AZURE("incomplete_azure_ball"),
    INCOMPLETE_CHERISH("incomplete_cherish_ball"), INCOMPLETE_CITRINE("incomplete_citrine_ball"),
    INCOMPLETE_VERDANT("incomplete_verdant_ball"), INCOMPLETE_ROSEATE("incomplete_roseate_ball"),
    INCOMPLETE_SLATE("incomplete_slate_ball"), INCOMPLETE_PREMIER("incomplete_premier_ball"),
    INCOMPLETE_GREAT("incomplete_great_ball"), INCOMPLETE_ULTRA("incomplete_ultra_ball"),
    INCOMPLETE_SAFARI("incomplete_safari_ball"), INCOMPLETE_FAST("incomplete_fast_ball"),
    INCOMPLETE_LEVEL("incomplete_level_ball"), INCOMPLETE_LURE("incomplete_lure_ball"),
    INCOMPLETE_HEAVY("incomplete_heavy_ball"), INCOMPLETE_LOVE("incomplete_love_ball"),
    INCOMPLETE_FRIEND("incomplete_friend_ball"), INCOMPLETE_MOON("incomplete_moon_ball"),
    INCOMPLETE_SPORT("incomplete_sport_ball"), INCOMPLETE_PARK("incomplete_park_ball"),
    INCOMPLETE_NET("incomplete_net_ball"), INCOMPLETE_DIVE("incomplete_dive_ball"),
    INCOMPLETE_NEST("incomplete_nest_ball"), INCOMPLETE_REPEAT("incomplete_repeat_ball"),
    INCOMPLETE_TIMER("incomplete_timer_ball"), INCOMPLETE_LUXURY("incomplete_luxury_ball"),
    INCOMPLETE_DUSK("incomplete_dusk_ball"), INCOMPLETE_HEAL("incomplete_heal_ball"),
    INCOMPLETE_QUICK("incomplete_quick_ball"), INCOMPLETE_DREAM("incomplete_dream_ball"),
    INCOMPLETE_BEAST("incomplete_beast_ball"), INCOMPLETE_MASTER("incomplete_master_ball"),

    // Incomplete Ancient
    INCOMPLETE_ANCIENT_RED("incomplete_ancient_red_ball"), INCOMPLETE_ANCIENT_BLUE("incomplete_ancient_blue_ball"),
    INCOMPLETE_ANCIENT_YELLOW("incomplete_ancient_yellow_ball"), INCOMPLETE_ANCIENT_GREEN("incomplete_ancient_green_ball"),
    INCOMPLETE_ANCIENT_PINK("incomplete_ancient_pink_ball"), INCOMPLETE_ANCIENT_BLACK("incomplete_ancient_black_ball"),
    INCOMPLETE_ANCIENT_WHITE("incomplete_ancient_white_ball"), INCOMPLETE_ANCIENT_GREAT("incomplete_ancient_great_ball"),
    INCOMPLETE_ANCIENT_ULTRA("incomplete_ancient_ultra_ball"), INCOMPLETE_ANCIENT_FEATHER("incomplete_ancient_feather_ball"),
    INCOMPLETE_ANCIENT_WING("incomplete_ancient_wing_ball"), INCOMPLETE_ANCIENT_JET("incomplete_ancient_jet_ball"),
    INCOMPLETE_ANCIENT_HEAVY("incomplete_ancient_heavy_ball"), INCOMPLETE_ANCIENT_LEADEN("incomplete_ancient_leaden_ball"),
    INCOMPLETE_ANCIENT_GIGATON("incomplete_ancient_gigaton_ball");

    public final String id;

    BallType(String id) { this.id = id; }

    public String getId() {
        return id;
    }
}
