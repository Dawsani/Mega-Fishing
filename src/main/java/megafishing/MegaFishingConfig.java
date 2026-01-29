package megafishing;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;

public class MegaFishingConfig {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String FILE_NAME = "mega-fishing.json";

    public float megaStoneChance = 0.0625f;
    public float blankMegaStoneChance = 0.00625f;

    public static MegaFishingConfig INSTANCE;

    public static void load() {
        Path configDir = FabricLoader.getInstance().getConfigDir();
        Path configFile = configDir.resolve(FILE_NAME);

        if (Files.exists(configFile)) {
            try {
                INSTANCE = GSON.fromJson(Files.readString(configFile), MegaFishingConfig.class);
            } catch (IOException e) {
                throw new RuntimeException("Failed to read config file", e);
            }
        } else {
            INSTANCE = new MegaFishingConfig();
            save();
        }
    }

    public static void save() {
        Path configDir = FabricLoader.getInstance().getConfigDir();
        Path configFile = configDir.resolve(FILE_NAME);

        try {
            Files.writeString(configFile, GSON.toJson(INSTANCE));
        } catch (IOException e) {
            throw new RuntimeException("Failed to write config file", e);
        }
    }
}
