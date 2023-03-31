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

import java.util.ArrayList;
import java.util.List;

import com.mojang.datafixers.util.Pair;

import net.minecraft.block.entity.BannerPattern;
import net.minecraft.block.entity.BannerPatterns;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.DyeColor;

public record PrideBanner(String name, Item base, List<Pair<RegistryKey<BannerPattern>, DyeColor>> patterns) {
    public static final List<PrideBanner> BANNERS = new ArrayList<>();

    static {
        BANNERS.add(new PrideBanner("Pride", Items.YELLOW_BANNER, List.of(
            Pair.of(BannerPatterns.STRIPE_TOP, DyeColor.ORANGE),
            Pair.of(BannerPatterns.TRIANGLES_TOP, DyeColor.RED),
            Pair.of(BannerPatterns.HALF_HORIZONTAL_BOTTOM, DyeColor.GREEN),
            Pair.of(BannerPatterns.STRIPE_BOTTOM, DyeColor.BLUE),
            Pair.of(BannerPatterns.TRIANGLES_BOTTOM, DyeColor.PURPLE)
        )));
        BANNERS.add(new PrideBanner("Lesbian", Items.ORANGE_BANNER, List.of(
            Pair.of(BannerPatterns.STRIPE_TOP, DyeColor.RED),
            Pair.of(BannerPatterns.HALF_HORIZONTAL_BOTTOM, DyeColor.PINK),
            Pair.of(BannerPatterns.STRIPE_BOTTOM, DyeColor.MAGENTA),
            Pair.of(BannerPatterns.STRIPE_MIDDLE, DyeColor.WHITE)
        )));
        BANNERS.add(new PrideBanner("Bisexual", Items.MAGENTA_BANNER, List.of(
            Pair.of(BannerPatterns.HALF_HORIZONTAL_BOTTOM, DyeColor.BLUE),
            Pair.of(BannerPatterns.STRIPE_MIDDLE, DyeColor.PURPLE)
        )));
        BANNERS.add(new PrideBanner("Transgender", Items.PINK_BANNER, List.of(
            Pair.of(BannerPatterns.STRIPE_TOP, DyeColor.LIGHT_BLUE),
            Pair.of(BannerPatterns.STRIPE_BOTTOM, DyeColor.LIGHT_BLUE),
            Pair.of(BannerPatterns.STRIPE_MIDDLE, DyeColor.WHITE)
        )));
    }
}