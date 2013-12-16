/*
 * Copyright (c) bdew, 2013
 * https://github.com/bdew/gendustry
 *
 * This mod is distributed under the terms of the Minecraft Mod Public
 * License 1.0, or MMPL. Please check the contents of the license located in
 * https://raw.github.com/bdew/gendustry/master/MMPL-1.0.txt
 */

package net.bdew.gendustry.nei

import codechicken.nei.api.{API, IConfigureNEI}
import net.bdew.gendustry.config.{Config, Items}

class NEIGendustryConfig extends IConfigureNEI {
  def getName: String = "Gendustry"
  def getVersion: String = "GENDUSTRY_VER"

  def addRecipeHandler(h: BaseRecipeHandler) {
    API.registerRecipeHandler(h)
    API.registerUsageHandler(h)
  }

  def loadConfig() {
    NEICache.load()
    if (Config.neiAddSamples)
      NEICache.speciesChromosomes.keys.foreach(x => API.addNBTItem(Items.geneSample.newStack(x)))
    addRecipeHandler(new MutagenProducerHandler)
    addRecipeHandler(new MutatronHandler)
  }
}
