package github.duykhanh09103.sword_elements.items;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class fire_sword extends Item {
    public fire_sword(Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
        textConsumer.accept(Text.translatable("itemTooltip.sword_elements.fire_sword_line1").formatted(Formatting.RED));
        textConsumer.accept(Text.translatable("itemTooltip.sword_elements.fire_sword_line2").formatted(Formatting.WHITE));
    }
    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        // Ensure we don't spawn the lightning only on the client.
        // This is to prevent desync.
        if (world.isClient()) {
            return ActionResult.PASS;
        }
        Vec3d playerLook = user.getRotationVector();

        world.spawnEntity(new FireballEntity(world,user,playerLook,2));
        return ActionResult.SUCCESS;
    }
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker){
        BlockPos targetPos = target.getBlockPos();

        LightningEntity lightingBolt = new LightningEntity(EntityType.LIGHTNING_BOLT,target.getWorld());
        lightingBolt.setPosition(targetPos.toCenterPos());
        target.getWorld().spawnEntity(lightingBolt);

        return;
    }


}
