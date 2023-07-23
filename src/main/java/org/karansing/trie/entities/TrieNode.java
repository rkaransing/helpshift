package org.karansing.trie.entities;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

/**
 * TrieNode is base class for the each node we will be storing in the
 * Trie Tree.
 *
 *  @author Karansing Rajput
 *  @version 1.0
 *  @since 2021-04-20
 */
public class TrieNode {
    public static final int SIZE = 10;
    private int nodeKey;
    private TrieNode childrens[] = new TrieNode[SIZE];
    private boolean isEndOfKey;
    private String value;

    public TrieNode(int nodeKey){
        this.nodeKey = nodeKey;
        isEndOfKey = false;
        Arrays.fill(childrens, null);
        value = StringUtils.EMPTY;
    }

    public TrieNode(){
        isEndOfKey = false;
        Arrays.fill(childrens, null);
        value = StringUtils.EMPTY;
    }

    public TrieNode[] getChildrens() {
        return childrens;
    }

    public boolean isEndOfKey() {
        return isEndOfKey;
    }

    public void setEndOfKey(boolean endOfKey) {
        isEndOfKey = endOfKey;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getNodeKey() {
        return nodeKey;
    }

    public void setNodeKey(int nodeKey) {
        this.nodeKey = nodeKey;
    }
}
