package github.duykhanh09103.sword_elements;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sword_elements implements ModInitializer {
    public static final String MOD_ID = "sword_elements";
    public static final String PREFIX_MSG = "[SwordElements]";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    @Override
    public void onInitialize() {
          modItem.initialize();
    }

}

