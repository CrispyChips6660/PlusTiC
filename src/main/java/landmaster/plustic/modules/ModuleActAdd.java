package landmaster.plustic.modules;

import static slimeknights.tconstruct.library.materials.MaterialTypes.*;
import static slimeknights.tconstruct.library.utils.HarvestLevels.*;
import static slimeknights.tconstruct.tools.TinkerTraits.*;

import de.ellpeck.actuallyadditions.mod.items.InitItems;
import landmaster.plustic.*;
import landmaster.plustic.config.*;
import landmaster.plustic.traits.*;
import landmaster.plustic.util.Utils;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.*;
import net.minecraftforge.fml.common.*;
import slimeknights.tconstruct.library.*;
import slimeknights.tconstruct.library.materials.*;

public class ModuleActAdd implements IModule {

	public void init() {
		if (Config.actuallyAdditions && Loader.isModLoaded("actuallyadditions")) {
			Material blackQuartz = new Material("blackquartz_plustic", TextFormatting.BLACK);
			blackQuartz.addTrait(DevilsStrength.devilsstrength);
			blackQuartz.addTrait(crude2);
			blackQuartz.addItem("gemQuartzBlack", 1, Material.VALUE_Ingot);
			blackQuartz.setCraftable(true);
			PlusTiC.proxy.setRenderInfo(blackQuartz, 0x000000);
			TinkerRegistry.addMaterialStats(blackQuartz, new HeadMaterialStats(380, 6, 4.5f, DIAMOND),
					new HandleMaterialStats(0.8f, 0),
					new ExtraMaterialStats(50),
					PlusTiC.justWhy);
			PlusTiC.materials.put("blackquartz", blackQuartz);
			
			Material Void = new Material("void_actadd_plustic", TextFormatting.BLACK);
			Void.addTrait(Unnamed.unnamed, HEAD);
			Void.addTrait(crude, HEAD);
			Void.addTrait(crude);
			Void.setCraftable(true);
			PlusTiC.proxy.setRenderInfo(Void, 0x222222);
			TinkerRegistry.addMaterialStats(Void, new HeadMaterialStats(480, 7, 4.4f, OBSIDIAN),
					new HandleMaterialStats(1, 0),
					new ExtraMaterialStats(140),
					new BowMaterialStats(1, 1.3f, 3.5f));
			PlusTiC.materials.put("Void", Void);
		}
	}
	
	public void init2() {
		final Material Void = PlusTiC.materials.get("Void");
		if (Void != null) {
			ItemStack voidStack = new ItemStack(InitItems.itemCrystal, 1, 3);
			Void.addItem(voidStack, 1, Material.VALUE_Ingot);
			Void.setRepresentativeItem(voidStack);
		}
		
		// YOU TOO, ACTUALLY ADDITIONS?
		Utils.setDispItem(PlusTiC.materials.get("blackquartz"), "gemQuartzBlack");
	}
	
}
