package org.helpshift.cacher;

import org.helpshift.entities.TrieNode;

/**
 * TrieRootNodeCacher helps us to maintain, tracking
 * and accessibility of root node of Trie Tree.
 *
 * We are taking help of Singleton Design pattern here.
 *
 */
public class TrieRootNodeCacher {

    private TrieNode trieNode = new TrieNode();

    private static TrieRootNodeCacher trieRootNodeCacher = new TrieRootNodeCacher();

    private TrieRootNodeCacher(){

    }

    public static TrieRootNodeCacher getInstance(){
        if(trieRootNodeCacher == null)
            trieRootNodeCacher = new TrieRootNodeCacher();
        return trieRootNodeCacher;
    }

    public TrieNode getRootNode(){
        return trieNode;
    }

}
