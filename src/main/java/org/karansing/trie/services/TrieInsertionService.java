package org.karansing.trie.services;

import org.apache.commons.lang3.StringUtils;
import org.karansing.trie.cacher.TrieRootNodeCacher;
import org.karansing.trie.entities.TrieNode;

/**
 * The TrieInsertionService helps  to insert a new node(TrieNode)
 * in the Data Structure along with its value.
 *
 * We can use "Insert" command to insert new node.
 *
 * @author Karansing Rajput
 * @version 1.0
 * @since 2021-04-21
 *
 */
public class TrieInsertionService implements TrieService {

    /**
     * insert method is used to insert new <key, value> entry
     * to the Trie Data Structure.
     *
     * @param key Integer type key we want to insert.
     * @param value String type value getting stored for the key we are passing.
     *
     * @return This method returns nothing.
     */
    public void insert(Integer key, String value) throws Exception{
        int level;
        int index;

        if(key == null || value == null || StringUtils.isBlank(value)){
            throw new Exception("Invalid inputs key : " + key + ", value : " + value);
        }
        String keyString = key.toString();

        TrieNode node = TrieRootNodeCacher.getInstance().getRootNode();

        for(level = 0; level < keyString.length(); level++){

            index = (int)Integer.parseInt(Character.toString(keyString.charAt(level)));
            if(node.getChildrens()[index] == null){
                node.getChildrens()[index] = new TrieNode(index);
            }
            node = node.getChildrens()[index];
        }

        node.setValue(value);
        node.setEndOfKey(true);
    }
}
