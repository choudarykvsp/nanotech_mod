package fr.mcnanotech.kevin_68.nanotechmod.city.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public class GuiTimeKey extends GuiButton
{
	protected static final ResourceLocation textures = new ResourceLocation("nanotechmodcity:textures/gui/widget.png");
	
    public GuiTimeKey(int par1, int par2, int par3)
	{
		super(par1, par2, par3, 3, 3, "");
	}
    
    public void drawButton(Minecraft par1Minecraft, int par2, int par3)
    {
        if (this.drawButton)
        {
            par1Minecraft.getTextureManager().bindTexture(textures);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.field_82253_i = par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
            int k = this.getHoverState(this.field_82253_i);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 0, 3, 3);	
            this.mouseDragged(par1Minecraft, par2, par3);
        }
    }
    
    public boolean mousePressed(Minecraft par1Minecraft, int par2, int par3)
    {
        return this.enabled && this.drawButton && par2 >= this.xPosition && par3 >= this.yPosition && par2 < this.xPosition + this.width && par3 < this.yPosition + this.height;
    }
    
    protected int getHoverState(boolean par1)
    {
        byte b0 = 1;

        if (!this.enabled)
        {
            b0 = 0;
        }
        else if (par1)
        {
            b0 = 2;
        }

        return b0;
    }
}