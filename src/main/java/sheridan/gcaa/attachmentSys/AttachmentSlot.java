package sheridan.gcaa.attachmentSys;

import java.util.*;

public class AttachmentSlot {
    public static final String ROOT = "__ROOT__";
    public static final String NONE = "__NONE__";
    public static final AttachmentSlot EMPTY = new AttachmentSlot(NONE, NONE, Set.of(), NONE, null);
    public final String slotName;
    public final String modelSlotName;
    private String attachmentId;

    private final Set<String> acceptedAttachments;
    private final Map<String, AttachmentSlot> children = new HashMap<>();
    private AttachmentSlot parent = EMPTY;
    private boolean root = false;
    private boolean locked = false;

    /**
     * Create a root slot of an attachment tree.
     **/
    protected AttachmentSlot() {
        root = true;
        slotName = ROOT;
        modelSlotName = NONE;
        attachmentId = NONE;
        acceptedAttachments = Set.of();
    }

    public static AttachmentSlot root() {
        return new AttachmentSlot();
    }

//    protected AttachmentSlot(String slotName, String modelSlotName, Set<String> acceptedAttachments, String attachmentId) {
//        this(slotName, modelSlotName, acceptedAttachments, attachmentId, EMPTY);
//    }

    protected AttachmentSlot(String slotName, String modelSlotName, Set<String> acceptedAttachments, String attachmentId, AttachmentSlot parent) {
        this.slotName = slotName;
        this.acceptedAttachments = new HashSet<>(acceptedAttachments);
        this.modelSlotName = modelSlotName;
        this.attachmentId = attachmentId;
        this.parent = parent;
    }

    public AttachmentSlot(String slotName, Set<String> acceptedAttachments) {
        this(slotName, "s_" + slotName, acceptedAttachments, NONE, EMPTY);
    }

    /**
     * Returns a mix of attachment item registry name that this slot accepts.
     * */
    public Set<String> getAcceptedAttachments() {
        return acceptedAttachments;
    }

    public boolean acceptsAttachment(String attachmentName) {
        return attachmentName != null && acceptedAttachments.contains(attachmentName);
    }

    public String getSlotName() {
        return slotName;
    }

    public String getModelSlotName() {
        return modelSlotName;
    }

    public AttachmentSlot getParent() {
        return parent;
    }

    public AttachmentSlot setParent(AttachmentSlot parent) {
        if (!isRoot() && this != EMPTY) {
            this.parent = parent;
        }
        return this;
    }

    /**
     * Add a child slot to this slot.
     *
     * @param child the child slot to add.
     * @return current slot.
     * */
    public AttachmentSlot addChild(AttachmentSlot child) {
        if (child != null) {
            child.setParent(this);
            this.children.put(child.getSlotName(), child);
        }
        return this;
    }

    /**
     * Add a mix of child slots to this slot.
     *
     * @param children the mix of child slots to add.
     * @return current slot.
     * */
    public AttachmentSlot addChildren(Set<AttachmentSlot> children) {
        for (AttachmentSlot child : children) {
            child.setParent(this);
            this.children.put(child.getSlotName(), child);
        }
        return this;
    }

    /**
     * Returns true if this slot has any children.
     * */
    public boolean hasChildren() {
        return !this.children.isEmpty();
    }

    /**
     * Gets the child slot by name. Not search its child slot.
     * */
    public AttachmentSlot getChild(String name) {
        return this.children.get(name);
    }

    /**
     * Searches the child slot by name. If not found, search its child slot.
     * */
    public AttachmentSlot searchChild(String name) {
        return searchChild(this, name);
    }

    /**
     * Searches the child slot by name of the given slot. If not found, search its child slot.
     * */
    public AttachmentSlot searchChild(AttachmentSlot slot, String name) {
        AttachmentSlot child = slot.getChild(name);
        if (child != null) {
            return child;
        }
        for (AttachmentSlot s : slot.children.values()) {
            child = searchChild(s, name);
            if (child != null) {
                return child;
            }
        }
        return null;
    }

    public void clean() {
        this.attachmentId = NONE;
        if (hasChildren()) {
            for (AttachmentSlot child : children.values())  {
                child.clean();
            }
        }
    }

    public void clear() {
        this.attachmentId = NONE;
    }

    public boolean isLocked() {
        return locked;
    }

    public AttachmentSlot setLocked(boolean locked) {
        this.locked = locked;
        return this;
    }

    public boolean isRoot() {
        return root;
    }

    /**
     * Deep copy this slot and its children.
     * */
//    public AttachmentSlot copy() {
//        AttachmentSlot slot = new AttachmentSlot(this.slotName, this.modelSlotName, this.acceptedAttachments, this.attachmentId, EMPTY);
//        if (hasChildren()) {
//            for (AttachmentSlot child : children.values()) {
//                slot.addChild(child.copy(this));
//            }
//        }
//        return slot;
//    }

    protected AttachmentSlot copy() {
        return new AttachmentSlot(this.slotName, this.modelSlotName, this.acceptedAttachments, this.attachmentId, EMPTY);
    }

    public static AttachmentSlot deepCopy(AttachmentSlot original) {
        if (original == null) {
            return null;
        }

        AttachmentSlot copiedSlot = original.copy();

        for (Map.Entry<String, AttachmentSlot> entry : original.children.entrySet()) {
            AttachmentSlot childCopy = deepCopy(entry.getValue());
            childCopy.parent = copiedSlot; // 设置父节点为当前复制的节点
            copiedSlot.children.put(entry.getKey(), childCopy);
        }

        return copiedSlot;
    }

    public boolean isEmpty() {
        return NONE.equals(attachmentId);
    }

    public Map<String, AttachmentSlot> getChildren() {
        return children;
    }

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        if (acceptsAttachment(attachmentId)) {
            this.attachmentId = attachmentId;
        }
    }

    public void setRoot(boolean root) {
        this.root = root;
    }

}
