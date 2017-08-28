package io.ohjongsung.algorithm.ctci.phase04.datastructure;

import io.ohjongsung.algorithm.ctci.phase03.datastructure.Stack;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-28
 * Description : 순회 구현
 */
public class Traversor {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(0);
        root.addChild(1);
        root.addChild(2);
        root.getChild(0).addChild(3);
        root.getChild(0).addChild(4);
        root.getChild(0).getChild(0).addChild(7);
        root.getChild(0).getChild(0).addChild(8);
        root.getChild(0).getChild(1).addChild(9);
        root.getChild(0).getChild(1).addChild(10);
        root.getChild(1).addChild(5);
        root.getChild(1).addChild(6);
        root.getChild(1).getChild(0).addChild(11);
        preOrderTraverse(root);
        System.out.println();
        preOrderTraverseRecursion(root);
        System.out.println();
        postOrderTraverse(root);
        System.out.println();
        postOrderTraverseRecursion(root);
        System.out.println();
        inOrderTraverse(root);
        System.out.println();
        inOrderTraverseRecursion(root);

    }

    public static <T> void preOrderTraverseRecursion(TreeNode<T> node){
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        preOrderTraverseRecursion(node.getChild(0));
        preOrderTraverseRecursion(node.getChild(1));
    }

    public static <T> void preOrderTraverse(TreeNode<T> root){
        if (root == null) {
            return;
        }
        TreeNode<T> node = root;
        int depth = 0;

        while (node != null) {
            System.out.print(node.getData() + " ");
            if (node.getChildSize() > 0) {
                node = node.getChild(0);
                depth++;
            } else {
                while (node.nextSibling() == null && depth > 0) {
                    node = node.getParent();
                    depth--;
                }
                if (node == root) {
                    break;
                }
                node = node.nextSibling();
            }
        }
    }

    public static <T> void postOrderTraverseRecursion(TreeNode<T> node){
        if (node == null) {
            return;
        }
        postOrderTraverseRecursion(node.getChild(0));
        postOrderTraverseRecursion(node.getChild(1));
        System.out.print(node.getData() + " ");
    }

    public static <T> void postOrderTraverse(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        TreeNode<T> node = root;
        int depth = 0;

        while (node != null) {
            if (node.getChildSize() > 0) {
                node = node.getChild(0);
                depth++;
            } else {
                while (node.nextSibling() == null && depth > 0) {
                    System.out.print(node.getData() + " ");
                    node = node.getParent();
                    depth--;
                }
                System.out.print(node.getData() + " ");
                if (node == root) {
                    break;
                }
                node = node.nextSibling();

            }
        }
    }


    public static <T> void inOrderTraverseRecursion(TreeNode<T> node){
        if (node == null) {
            return;
        }

        inOrderTraverseRecursion(node.getChild(0));
        System.out.print(node.getData() + " ");
        inOrderTraverseRecursion(node.getChild(1));
    }

    public static <T> void inOrderTraverse(TreeNode<T> root){
        if (root == null) {
            return;
        }
        TreeNode<T> node = root;
        Stack<TreeNode<T>> stack = new Stack<>();

        while (node != null) {
            stack.push(node);
            node = node.getChild(0);
        }

        while (stack.size() > 0) {
            node = stack.pop();
            System.out.print(node.getData() + " ");
            if (node.getChild(1) != null) {
                node = node.getChild(1);

                while (node != null) {
                    stack.push(node);
                    node = node.getChild(0);
                }
            }
        }

    }
}
