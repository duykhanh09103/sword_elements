package github.duykhanh09103.sword_elements.client;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import github.duykhanh09103.sword_elements.modItem;
import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

public class Sword_elementsRecipeProvider extends FabricRecipeProvider {
    public Sword_elementsRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
                createShaped(RecipeCategory.COMBAT, modItem.FIRE_SWORD)
                        .pattern("lll")
                        .pattern("lil")
                        .pattern("lll")
                        .input('l',Items.LAVA_BUCKET)
                        .input('i',Items.DIAMOND_SWORD)
                        .criterion(hasItem(modItem.FIRE_SWORD),conditionsFromItem(modItem.FIRE_SWORD))
                        .offerTo(exporter);
                createShaped(RecipeCategory.COMBAT, modItem.ICE_SWORD)
                        .pattern("lll")
                        .pattern("lil")
                        .pattern("lll")
                        .input('l',Items.ICE)
                        .input('i',Items.DIAMOND_SWORD)
                        .criterion(hasItem(modItem.ICE_SWORD),conditionsFromItem(modItem.ICE_SWORD))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Sword_elementsRecipeProvider";
    }
}