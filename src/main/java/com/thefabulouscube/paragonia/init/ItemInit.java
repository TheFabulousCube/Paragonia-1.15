package com.thefabulouscube.paragonia.init;

import com.thefabulouscube.paragonia.Paragonia;
import com.thefabulouscube.paragonia.objects.items.GhostSpawnEgg;
import com.thefabulouscube.paragonia.objects.items.MySpawnEggItem;
import com.thefabulouscube.paragonia.objects.items.WoodSpriteSpawnEgg;
import com.thefabulouscube.paragonia.util.CreativeTabs;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	public static final DeferredRegister<Item> ICONS = new DeferredRegister<>(ForgeRegistries.ITEMS, Paragonia.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, Paragonia.MOD_ID);
	
	public static final RegistryObject<Item> DECORATIONS = ICONS.register("decorations", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> CREATURES = ICONS.register("creatures", () -> new Item(new Item.Properties()));
	public static final RegistryObject<Item> FURNITURE = ICONS.register("furniture", () -> new Item(new Item.Properties()));
	
	public static final RegistryObject<MySpawnEggItem> GHOST_SPAWN_EGG = ITEMS.register("ghost_spawn_egg", () -> new GhostSpawnEgg(new Item.Properties().group(CreativeTabs.CREATURES)));


	public static final RegistryObject<MySpawnEggItem> WOOD_SPRITE_SPAWN_EGG = ITEMS.register("wood_sprite_spawn_egg", () -> new WoodSpriteSpawnEgg(new Item.Properties().group(CreativeTabs.CREATURES)));

//	public static final RegistryObject<MySpawnEggItem> WOOD_SPRITE_SPAWN_EGG = ITEMS.register("wood_sprite_spawn_egg", () -> new MySpawnEggItem((() -> EntityType.Builder.create(WoodSpriteEntity::new, EntityClassification.CREATURE)
//			.size(0.6F, 1.7F).build("ghost")), 	8606770, 	6192150, (new Item.Properties().group(CreativeTabs.CREATURES))));


}
