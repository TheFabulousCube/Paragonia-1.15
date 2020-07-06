package com.thefabulouscube.paragonia;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.thefabulouscube.paragonia.init.BlockInit;
import com.thefabulouscube.paragonia.init.EntityInit;
import com.thefabulouscube.paragonia.init.ItemInit;
import com.thefabulouscube.paragonia.objects.blocks.FoodBlock;
import com.thefabulouscube.paragonia.util.CreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;

@Mod("paragonia")
@Mod.EventBusSubscriber(modid = Paragonia.MOD_ID, bus = Bus.MOD)
public class Paragonia {

	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "paragonia";
	public static Paragonia instance;

	public Paragonia() {
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		// Register the setup method for modloading
		modEventBus.addListener(this::setup);
//         Register the enqueueIMC method for modloading
		modEventBus.addListener(this::enqueueIMC);
//         Register the processIMC method for modloading
		modEventBus.addListener(this::processIMC);
//         Register the doClientStuff method for modloading
		modEventBus.addListener(this::doClientStuff);

//		SoundInit
		BlockInit.BLOCKS.register(modEventBus);
		ItemInit.ICONS.register(modEventBus);
		ItemInit.ITEMS.register(modEventBus);
		BlockInit.FOOD.register(modEventBus);
		BlockInit.FURNITURE.register(modEventBus);
		EntityInit.ENTITY_TYPES.register(modEventBus);

//		BeeEntity 

		instance = this;
		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void onRegisteringItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();

		BlockInit.BLOCKS.getEntries().parallelStream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(CreativeTabs.DECORATIONS);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});

		BlockInit.FOOD.getEntries().parallelStream().filter(block -> (block.get() instanceof FoodBlock))
				.map(RegistryObject::get).forEach(block -> {
					final Item.Properties properties = new Item.Properties().group(ItemGroup.FOOD)
							.food(((FoodBlock) block).getFood());
					final BlockItem blockItem = new BlockItem(block, properties);
					blockItem.setRegistryName(block.getRegistryName());
					registry.register(blockItem);
				});

		BlockInit.FURNITURE.getEntries().parallelStream().map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(CreativeTabs.FURNITURE);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});
	}

	/*
	 * @SubscribeEvent public static void onRegisterBiomes(final
	 * RegistryEvent.Register<Biome> event) { BiomeInit.registerBiomes(); }
	 * 
	 * private void setup(final FMLCommonSetupEvent event) {// K9#8016
	 * ComposterBlock.registerCompostable(0.6f, BlockInit.JAZZ_LEAVES.get());
	 * ComposterBlock.registerCompostable(0.4f, ItemInit.SEED_ITEM.get());
	 * DeferredWorkQueue.runLater(TutorialOreGen::generateOre);
	 * 
	 * DeferredWorkQueue.runLater(() -> { for (Biome biome : ForgeRegistries.BIOMES)
	 * { if (biome instanceof ExampleBiome) {
	 * biome.getSpawns(EntityClassification.MONSTER) .add(new
	 * Biome.SpawnListEntry(EntityType.ZOMBIE, 1000, 1, 4)); } } });
	 * 
	 * }
	 */

	/*
	 * public static void registerPlacementType(EntityType type,
	 * EntitySpawnPlacementRegistry.PlacementType placementType) {
	 * EntitySpawnPlacementRegistry.register(type, placementType,
	 * Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
	 * MonsterEntity::canMonsterSpawnInLight); }
	 */

	private void setup(final FMLCommonSetupEvent event) {
	}

	private void doClientStuff(final FMLClientSetupEvent event) {
		// do something that can only be done on the client
		RenderTypeLookup.setRenderLayer(BlockInit.APPLE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.BEET.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.ORANGE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.PIE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.APIARY.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.AXE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CANDLE_CANDELABRA_GOLD.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CANDLE_CANDELABRA_IRON.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CANDLE_CANDLESTICK_GOLD.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CANDLE_CANDLESTICK_IRON.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CANDLE_CHAMBERSTICK.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CANDLE_LARGE.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CANDLE_SKULL.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CANDLE_SMALL.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.CANDLES_RITUAL.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.STATION_PORTABLE_ENCHANTING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.STATION_PORTABLE_SMITHING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.STATION_PROVISIONING.get(), RenderType.getCutout());
//    	RenderTypeLookup.setRenderLayer(BlockInit.BANNER_SIMPLE_PURPLE.get(), RenderType.getCutout());
//    	RenderTypeLookup.setRenderLayer(BlockInit.BANNER_SIMPLE_RED.get(), RenderType.getCutout());
//    	RenderTypeLookup.setRenderLayer(BlockInit.BANNER_SIMPLE_WHITE.get(), RenderType.getCutout());
//    	RenderTypeLookup.setRenderLayer(BlockInit.BANNER_SIMPLE_YELLOW.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.BOOKREST.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.SCALE.get(), RenderType.getTranslucent());
	}

	private void enqueueIMC(final InterModEnqueueEvent event) {
		// some example code to dispatch IMC to another mod
		InterModComms.sendTo("examplemod", "helloworld", () -> {
			LOGGER.info("Hello world from the MDK");
			return "Hello world";
		});
	}

	private void processIMC(final InterModProcessEvent event) {
		// some example code to receive and process InterModComms from other mods
		LOGGER.info("Got IMC {}",
				event.getIMCStream().map(m -> m.getMessageSupplier().get()).collect(Collectors.toList()));
	}

	// You can use SubscribeEvent and let the Event Bus discover methods to call
	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
		// do something when the server starts
	}

	// You can use EventBusSubscriber to automatically subscribe events on the
	// contained class (this is subscribing to the MOD
	// Event bus for receiving Registry Events)
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {
		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
			// register a new block here
		}
	}
}
