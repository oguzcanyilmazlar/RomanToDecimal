package me.acablade.addon.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

@Mixin(Enchantment.class)
public abstract class EnchantMixin {

  @Shadow
  protected abstract boolean isCurse();

  @Shadow
  protected abstract int getMaxLevel();

  @Shadow
  protected abstract String getName();

  @Overwrite
  public ITextComponent getDisplayName(int level){
    TranslationTextComponent translationTextComponent = new TranslationTextComponent(getName());

    if(isCurse()){
      translationTextComponent.mergeStyle(TextFormatting.RED);
    }else {
      translationTextComponent.mergeStyle(TextFormatting.GRAY);
    }

    if(level != 1 || getMaxLevel() != 1){
      translationTextComponent.appendString(" ").appendString(level + "");
    }
    return translationTextComponent;

  }

}
