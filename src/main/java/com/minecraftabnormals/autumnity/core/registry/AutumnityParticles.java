package com.minecraftabnormals.autumnity.core.registry;

import com.minecraftabnormals.autumnity.client.particle.FallingMapleLeafParticle;
import com.minecraftabnormals.autumnity.core.Autumnity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AutumnityParticles {
	public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Autumnity.MOD_ID);

	public static final RegistryObject<BasicParticleType> FALLING_MAPLE_LEAF = PARTICLES.register("falling_maple_leaf", () -> new BasicParticleType(false));

	@Mod.EventBusSubscriber(modid = Autumnity.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegisterParticleFactories {

		@SubscribeEvent(priority = EventPriority.LOWEST)
		public static void registerParticleTypes(ParticleFactoryRegisterEvent event) {
			ParticleManager manager = Minecraft.getInstance().particleEngine;
			if (FALLING_MAPLE_LEAF.isPresent()) {
				manager.register(FALLING_MAPLE_LEAF.get(), FallingMapleLeafParticle.Factory::new);
			}
		}
	}
}