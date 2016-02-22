package de.zkaface.ultistuffmod.init;

import de.zkaface.ultistuffmod.blocks.TileEntityTeleporter;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class UsmTeleportTileEntities {

	public static void register(){
		GameRegistry.registerTileEntity(TileEntityTeleporter.class, "usmTeleporter");
	}

}
