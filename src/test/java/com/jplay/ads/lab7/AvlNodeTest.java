package com.jplay.ads.lab7;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class AvlNodeTest {

    final int n = 10000;

    @Test
    public void testAvlTreeIsBalanced() {
        AvlNode<Integer> avlTree = generateIntegerAvlTree(n);
        assertTrue(isBalanced(avlTree));
    }

    @Test
    public void testAvlTreeIsSearchTree() {
        AvlNode<Integer> avlTree = generateIntegerAvlTree(n);
        assertTrue(isSearchTree(avlTree));
    }

    public AvlNode<Integer> generateIntegerAvlTree(int n) {
        AvlNode<Integer> avlTree = new AvlNode<>();

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            avlTree.add(random.nextInt());
        }

        return avlTree;
    }

    public boolean isBalanced(AvlNode<Integer> avlNode) {
        int heightLeft = avlNode.getHeight(avlNode.left),
            heightRight = avlNode.getHeight(avlNode.right);

        return Math.abs(heightLeft - heightRight) < 2
                && (heightLeft != 0 || isBalanced(avlNode.left))
                && (heightRight != 0 || isBalanced(avlNode.right));
    }

    public boolean isSearchTree(AvlNode<Integer> avlNode) {
        if (avlNode == null) {
            return true;
        }

        if (avlNode.left != null && avlNode.left.value > avlNode.value) {
            return false;
        }

        if (avlNode.right != null && avlNode.right.value <= avlNode.value) {
            return false;
        }

        return isSearchTree(avlNode.left) && isSearchTree(avlNode.right);
    }
}
