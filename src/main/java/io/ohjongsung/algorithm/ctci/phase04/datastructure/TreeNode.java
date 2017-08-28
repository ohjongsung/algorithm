package io.ohjongsung.algorithm.ctci.phase04.datastructure;

import java.util.LinkedList;
import java.util.List;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-27
 * Description : 트리 노드 구현
 */
public class TreeNode<T> {
    private T data;
    private TreeNode<T> parent;
    private TreeNode<T> sibling;
    private List<TreeNode<T>> childNodes;
    private int index;

    public TreeNode(T data) {
        this.data = data;
        this.childNodes = new LinkedList<>();
        this.index = 0;
    }

    public void addChild(T child) {
        TreeNode<T> childNode = new TreeNode<T>(child);
        childNode.parent = this;
        childNode.index = this.childNodes.size();
        this.childNodes.add(childNode);
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public TreeNode<T> getChild(int index) {
        if (childNodes.size() > index) {
            return childNodes.get(index);
        } else {
            return null;
        }
    }

    public int getChildSize() {
        return childNodes.size();
    }

    public T getData() {
        return data;
    }

    public TreeNode<T> nextSibling() {
        if (parent == null) {
            return null; // root
        }

        final List<TreeNode<T>> siblings = parent.childNodes;
        final int siblingIndex = index + 1;
        if (siblings.size() > siblingIndex) {
            return siblings.get(siblingIndex);
        } else {
            return null;
        }
    }

    public TreeNode<T> previousSibling() {
        if (parent == null) {
            return null; // root
        }
        final List<TreeNode<T>> siblings = parent.childNodes;
        if (index > 0) {
            return siblings.get(index - 1);
        } else {
            return null;
        }
    }
}
