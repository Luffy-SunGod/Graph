package practise;

import java.util.ArrayList;
import java.util.List;

class NaryTreeNode {
    int value;
    int lockedBy;
    boolean isLocked;
    List<NaryTreeNode> children;

    public NaryTreeNode(int value) {
        this.value = value;
        this.lockedBy = -1;
        this.isLocked = false;
        this.children = new ArrayList<>();
    }
}

class NaryTree {
    private NaryTreeNode root;

    public NaryTree(NaryTreeNode root) {
        this.root = root;
    }

    public synchronized boolean lock(NaryTreeNode node, int id) {
        if (node == null || isLocked(node) || hasLockedAncestors(node) || hasLockedDescendants(node))
            return false;

        node.isLocked = true;
        node.lockedBy = id;
        return true;
    }

    public synchronized boolean unlock(NaryTreeNode node, int id) {
        if (node == null || !isLocked(node) || node.lockedBy != id)
            return false;

        node.isLocked = false;
        node.lockedBy = -1;
        return true;
    }

    public synchronized boolean upgrade(NaryTreeNode node, int id) {
        if (node == null || isLocked(node) || hasLockedAncestors(node))
            return false;

        boolean hasLockedDescendants = hasLockedDescendants(node);
        boolean allDescendantsLockedBySameId = checkAllDescendantsLockedBySameId(node, id);

        if (hasLockedDescendants && allDescendantsLockedBySameId) {
            unlockDescendants(node);
            node.isLocked = true;
            node.lockedBy = id;
            return true;
        }

        return false;
    }

    private boolean isLocked(NaryTreeNode node) {
        return node.isLocked;
    }

    private boolean hasLockedAncestors(NaryTreeNode node) {
        NaryTreeNode current = node;
        while (current != null) {
            if (current.isLocked)
                return true;
            current = getParent(current);
        }
        return false;
    }

    private boolean hasLockedDescendants(NaryTreeNode node) {
        if (node.children.isEmpty())
            return false;

        for (NaryTreeNode child : node.children) {
            if (child.isLocked || hasLockedDescendants(child))
                return true;
        }
        return false;
    }

    private void unlockDescendants(NaryTreeNode node) {
        for (NaryTreeNode child : node.children) {
            if (child.isLocked) {
                child.isLocked = false;
                child.lockedBy = -1;
                unlockDescendants(child);
            }
        }
    }

    private boolean checkAllDescendantsLockedBySameId(NaryTreeNode node, int id) {
        if (node.children.isEmpty())
            return true;

        for (NaryTreeNode child : node.children) {
            if (!isLockedBySameId(child, id) || !checkAllDescendantsLockedBySameId(child, id))
                return false;
        }
        return true;
    }

    private boolean isLockedBySameId(NaryTreeNode node, int id) {
        return !node.isLocked || node.lockedBy == id;
    }

    private NaryTreeNode getParent(NaryTreeNode node) {
        // Implementation to get the parent of a node
        // Return null if the tree doesn't have explicit parent pointers
    }
}

