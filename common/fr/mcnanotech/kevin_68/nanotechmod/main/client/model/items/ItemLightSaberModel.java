/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.client.model.items;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.item.ItemStack;

public class ItemLightSaberModel extends ModelBase
{
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;

    public ItemLightSaberModel()
    {
        textureWidth = 64;
        textureHeight = 32;

        Shape1 = new ModelRenderer(this, 0, 0);
        Shape1.addBox(-0.5F, -3F, -0.5F, 1, 3, 1);
        Shape1.setRotationPoint(0F, 24F, 0F);
        Shape1.setTextureSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 4, 0);
        Shape2.addBox(-1F, -4F, -1F, 2, 1, 2);
        Shape2.setRotationPoint(0F, 24F, 0F);
        Shape2.setTextureSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 0, 4);
        Shape3.addBox(-0.5F, -18F, -0.5F, 1, 14, 1);
        Shape3.setRotationPoint(0F, 24F, 0F);
        Shape3.setTextureSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, 0F, 0F);
    }

    public void render(float f, ItemStack stack, boolean isColor)
    {
        if(!isColor)
        {
            Shape1.render(f);
            Shape2.render(f);
        }
        else if(isColor && stack.hasTagCompound())
        {
            if(stack.getTagCompound().hasKey("IsOn"))
            {
                if(stack.getTagCompound().getBoolean("IsOn"))
                {
                    Shape3.render(f);
                }
            }
        }
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}