package love.digimons.digi_applimobs.gui.inv.band;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

import javax.annotation.Nonnull;

public class BandScreen extends AbstractContainerScreen<BandContainer> {

	private static final ResourceLocation TEX = new ResourceLocation("digi_applimobs", "textures/gui/band.png");

	public BandScreen(BandContainer container, Inventory invPlayer, Component title) {
		super(container, invPlayer, title);
		this.imageWidth = 500;
		this.imageHeight = 230;
	}

	@Override
	protected void renderBg(@Nonnull GuiGraphics matrix, float partialTicks, int MouseX, int MouseY) {
		matrix.setColor(1, 1, 1, 1);

		int x = (this.width - this.imageWidth) / 2;
		int y = (this.height - this.imageHeight) /2;

		matrix.blit(TEX, leftPos, topPos, 0, 0, imageWidth, imageHeight,512,256);
	}

	@Override
	protected void renderLabels(@Nonnull GuiGraphics matrix, int x, int y) {
	}

	@Override
	public void render(@Nonnull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

//	@Override
//	public void removed() {
//		if (false) {
//			super.removed();
//		}
//	}

	@Override
	public void init() {
		super.init();
	}
}