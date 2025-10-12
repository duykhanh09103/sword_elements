package github.duykhanh09103.sword_elements.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class ice_sword extends Item {
    public ice_sword(Settings settings) {
        super(settings);
    }
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable("itemTooltip.sword_elements.ice_sword_line1").formatted(Formatting.BLUE));
        textConsumer.accept(Text.translatable("itemTooltip.sword_elements.ice_sword_line2").formatted(Formatting.WHITE));
    }
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker){
        BlockPos targetPos = target.getBlockPos().down();

        BlockPos min = targetPos.add(-5, 0, -5);
        BlockPos max = targetPos.add(+5, 0, +5);

        for (BlockPos pos : BlockPos.iterate(min, max)) {
            if (pos.getSquaredDistance(targetPos) <= 5 * 5) {
                BlockState current = target.getWorld().getBlockState(pos);
                if (current.isAir()) continue;
                target.getWorld().setBlockState(pos, Blocks.ICE.getDefaultState());
            }
        }




        return;
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext usageContext) {
        World world = usageContext.getWorld();
        if (world.isClient()) {
            return ActionResult.PASS;
        }
        BlockPos pos = usageContext.getBlockPos();
        world.setBlockState(pos,Blocks.ICE.getDefaultState());

        return ActionResult.SUCCESS;
    }
}
