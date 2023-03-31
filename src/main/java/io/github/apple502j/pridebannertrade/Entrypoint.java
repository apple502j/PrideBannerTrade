/*
 * Copyright (c) 2023 apple502j
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.apple502j.pridebannertrade;

import net.minecraft.block.entity.BannerPattern;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;

public final class Entrypoint implements ModInitializer {
    @Override
    public void onInitialize() {
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.SHEPHERD, 5, factories -> PrideBanner.BANNERS.forEach(banner -> {
            BannerPattern.Patterns patterns = new BannerPattern.Patterns();
            banner.patterns().forEach(pattern -> patterns.add(pattern.getFirst(), pattern.getSecond()));
            ItemStack stack = new ItemStack(banner.base());
            stack.setCustomName(Text.literal(banner.name() + " Flag"));
            NbtCompound nbt = new NbtCompound();
            nbt.put("Patterns", patterns.toNbt());
            BlockItem.setBlockEntityNbt(stack, BlockEntityType.BANNER, nbt);
            factories.add((e, r) -> new TradeOffer(new ItemStack(Items.EMERALD, 10), stack.copy(), 12, 3, 0.5f));
        }));
    }
}
