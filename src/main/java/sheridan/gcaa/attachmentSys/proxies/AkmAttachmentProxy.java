package sheridan.gcaa.attachmentSys.proxies;

import net.minecraft.world.item.ItemStack;
import sheridan.gcaa.attachmentSys.AttachmentSlot;
import sheridan.gcaa.attachmentSys.AttachmentSlotProxy;
import sheridan.gcaa.attachmentSys.proxies.utils.BinaryExclusiveProxy;
import sheridan.gcaa.items.attachments.IAttachment;
import sheridan.gcaa.items.attachments.functional.GrenadeLauncher;
import sheridan.gcaa.items.gun.IGun;

public class AkmAttachmentProxy extends AttachmentSlotProxy {
    private final BinaryExclusiveProxy binaryMutuallyExclusiveProxy;

    public AkmAttachmentProxy(AttachmentSlot root) {
        super(root);
        binaryMutuallyExclusiveProxy = new BinaryExclusiveProxy(root, "rail_set", "dust_cover");
        binaryMutuallyExclusiveProxy.addExclusive((prevSlot, other, prevAttachment, otherAttachment) ->
                !prevSlot.isEmpty() || !other.isEmpty());
    }

    @Override
    public IAttachment.AttachResult onCanAttach(IAttachment attachment, ItemStack stack, IGun gun, AttachmentSlot root, AttachmentSlot prevSlot) {
        return binaryMutuallyExclusiveProxy.onCanAttach(attachment, stack, gun, root, prevSlot);
    }

    @Override
    public IAttachment.AttachResult onCanDetach(IAttachment attachment, ItemStack stack, IGun gun, AttachmentSlot root, AttachmentSlot prevSlot) {
        return attachment.canDetach(stack, gun, root, prevSlot);
    }
}
