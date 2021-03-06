package mrtjp.projectred.expansion

import cpw.mods.fml.relauncher.{Side, SideOnly}
import java.util.{List => JList}
import mrtjp.projectred.ProjectRedTransportation
import net.minecraft.client.renderer.texture.IconRegister
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{ItemStack, Item}
import org.lwjgl.input.Keyboard

class ItemCPU(id:Int) extends Item(id)
{
    setUnlocalizedName("projectred.transportation.cpu")
    setCreativeTab(ProjectRedTransportation.tabTransportation)
    setHasSubtypes(true)
    setMaxStackSize(1)

    override def getSubItems(id:Int, tab:CreativeTabs, list:JList[_])
    {
        val list2 = list.asInstanceOf[JList[ItemStack]]
        list2.add(new ItemStack(this))
    }

    override def getUnlocalizedName(stack:ItemStack) = super.getUnlocalizedName+"|"+stack.getItemDamage

    @SideOnly(Side.CLIENT)
    override def registerIcons(reg:IconRegister)
    {
        itemIcon = reg.registerIcon("projectred:cpu")
    }

    override def getIconFromDamage(meta:Int) =
    {
        super.getIconFromDamage(meta)
    }

    override def addInformation(stack:ItemStack, player:EntityPlayer, list:JList[_], par4:Boolean)
    {
        val list2 = list.asInstanceOf[JList[String]]
        if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) if (stack.hasTagCompound)
            list2.add(stack.getTagCompound.getDouble("cycles")+" cycles remaining")
    }
}