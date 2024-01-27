package top.offsetmonkey538.disableshulkerteleport.mixin;

import net.minecraft.entity.mob.ShulkerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShulkerEntity.class)
public abstract class ShulkerEntityMixin {

    @Inject(
            method = "tryTeleport",
            at = @At(
                    value = "HEAD"
            ),
            cancellable = true
    )
    private void disableShulkerTeleport(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}
