package net.fabric.examplemod.config;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.example.ConsoleMC;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static int EXAMPLE;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(ConsoleMC.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("example.keypair", 69), "whether or not to allow chat command execution.");
    }

    private static void assignConfigs() {
        EXAMPLE = CONFIG.getOrDefault("example.keypair", 420);

        SimpleConfig.LOGGER.info("All " + configs.getConfigsList().size() + " have been set properly");
    }
}
