package ru.theone_ss.vanilla_knifes;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.util.Identifier;
import ru.theone_ss.vanilla_knifes.compat.WinterlyIntegration;
import ru.theone_ss.vanilla_knifes.registry.VanillaKnifesEffects;
import ru.theone_ss.vanilla_knifes.registry.VanillaKnifesItems;

public class VanillaKnifes implements ModInitializer {

	public static final String MOD_ID = "vanilla_knifes";

	@Override
	public void onInitialize() {
		VanillaKnifesItems.init();
		VanillaKnifesEffects.init();
		if(FabricLoader.getInstance().isModLoaded("winterly")) {
			WinterlyIntegration.init();
		}
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}

}
