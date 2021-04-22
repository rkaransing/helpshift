package org.helpshift.services;

import org.apache.commons.lang3.StringUtils;
import org.helpshift.cacher.TrieRootNodeCacher;
import org.helpshift.entities.TrieNode;

/**
 * The TrieSearchingService helps to Search a value stored in the Data Structure
 * by using its key.
 *
 * We can use "Retrieve" command to retrieve/search particular value stored for a key.
 *
 * @author Karansing Rajput
 * @version 1.0
 * @since 2021-04-22
 *
 */
public class TrieSearchingService implements TrieService {

    /**
     *
     * @param key
     *
     * @return This method returns String value stored for the particular key
     */
    public String search(Integer key){
        int level;
        int index;
        String keyString = key.toString();

        TrieNode node = TrieRootNodeCacher.getInstance().getRootNode();

        for(level = 0; level < keyString.length(); level++){
            index = (int) Integer.parseInt(Character.toString(keyString.charAt(level)));

            if(node.getChildrens()[index] == null)
                return null;

            node = node.getChildrens()[index];
        }

        return StringUtils.isNotBlank(node.getValue()) ? node.getValue() : null;
    }
}
