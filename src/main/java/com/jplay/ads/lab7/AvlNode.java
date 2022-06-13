package com.jplay.ads.lab7;

public class AvlNode<T extends Comparable<T>> {
    protected T value;
    protected AvlNode<T> left;
    protected AvlNode<T> right;
    protected int height;

    public AvlNode() {
        this(null);
    }

    public AvlNode(T value) {
        this.value = value;
        left = null;
        right = null;
    }

    public void add(T value) {
        addToSearchTree(value);
        balance();
    }

    private void balance() {
        if (left != null) left.balance();
        if (right != null) right.balance();

        updateHeight();

        int leftHeight = getHeight(left),
            rightHeight = getHeight(right);

        if (rightHeight - leftHeight >= 2) {
            int rightLeftHeight = getHeight(right.left),
                rightRightHeight = getHeight(right.right);
            if (rightLeftHeight <= rightRightHeight) {
                littleLeftRotate();
            } else {
                bigLeftRotate();
            }
        } else if (leftHeight - rightHeight >= 2) {
            int leftLeftHeight = getHeight(left.left),
                leftRightHeight = getHeight(left.right);
            if (leftLeftHeight >= leftRightHeight) {
                littleRightRotate();
            } else {
                bigRightRotate();
            }
        }
    }

    private void addToSearchTree(T value) {
        if (this.value == null) {
            this.value = value;
            return;
        }

        if (value.compareTo(this.value) <= 0) {
            if (left == null) {
                left = new AvlNode<>(value);
            } else {
                left.addToSearchTree(value);
            }
        } else {
            if (right == null) {
                right = new AvlNode<>(value);
            } else {
                right.addToSearchTree(value);
            }
        }
    }

    private void updateHeight() {
        int maxHeight = 1;
        if (left != null) {
            maxHeight = left.getHeight() + 1;
        }
        if (right != null) {
            maxHeight = Math.max(maxHeight, right.getHeight() + 1);
        }
        height = maxHeight;
    }

    protected int getHeight(AvlNode<T> node) {
        return (node == null) ? 0 : node.getHeight();
    }

    private int getHeight() {
        return height;
    }

    private void littleLeftRotate() {
        AvlNode<T> b = right,
                   l = left,
                   c = b.left,
                   r = b.right;

        // we can't change pointer of the root node,
        // so we will swap value pointers of root (A) and B nodes
        left = b;
        left.left = l;
        left.right = c;
        right = r;

        T temp = value;
        value = b.value;
        b.value = temp;
    }

    private void littleRightRotate() {
        AvlNode<T> b = left,
                   l = b.left,
                   c = b.right,
                   r = right;

        right = b;
        left = l;
        right.left = c;
        right.right = r;

        T temp = value;
        value = b.value;
        b.value = temp;
    }

    private void bigLeftRotate() {
        // we will swap A and C values there
        AvlNode<T> b = right,
                   c = b.left,
                   l = left,
                   m = c.left,
                   n = c.right;

        left = c;
        left.left = l;
        left.right = m;
        right.left = n;

        T temp = value;
        value = c.value;
        c.value = temp;
    }

    private void bigRightRotate() {
        AvlNode<T> b = left,
                   c = b.right,
                   m = c.left,
                   n = c.right,
                   r = right;

        right = c;
        left.right = m;
        right.left = n;
        right.right = r;

        T temp = value;
        value = c.value;
        c.value = temp;
    }

    public void showPreorder() {
        showPreorder("");
    }

    public void showPreorder(String prefix) {
        System.out.println(prefix + value);
        if (left != null) {
            left.showPreorder(prefix + "l ");
        }
        if (right != null) {
            right.showPreorder(prefix + "r ");
        }
    }
}
