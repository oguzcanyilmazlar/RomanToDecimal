package me.acablade.addon;

import net.labymod.addon.AddonTransformer;
import net.labymod.api.TransformerType;

public class RomanToDecimalAddonTransformer extends AddonTransformer {

  @Override
  public void registerTransformers() {
    this.registerTransformer(TransformerType.VANILLA, "enchant.mixin.json");
  }
}
