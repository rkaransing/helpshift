package org.karansing.trie.services;

import org.karansing.trie.entities.TrieNode;

/**
 * The TriePrintingService helps to print all the keys along with its values
 * in the format of <key, value> for all the entries present in the Data Structure.
 *
 * We can use "Display current state" command to print all present entries.
 *
 * @author Karansing Rajput
 * @version 1.0
 * @since 2021-04-21
 *
 */
public class TriePrintingService implements TrieService {
    public static int counter = 0;
    /**
     * This is Delegating helper method for printing all nodes where
     * we are passing simply rootNode only and all other locally required
     * params like keyArray and position we are passing from here.
     *
     * @param rootNode
     */
    public void printAllNodes(TrieNode rootNode){
        printAllNodes(rootNode, new int[100], 0);
    }

    /**
     * This method recursively traversing through all the nodes
     * inserted in the Trie Data Structure and Printing in the form of <key, value>
     *
     * @param rootNode TrieNode as root node.
     * @param keyArray Supportive integer array for storing key's for which recursion is taking place
     * @param position Supportive integer variable for keyArray, initially set to value 0.
     */
    private void printAllNodes(TrieNode rootNode, int [] keyArray, int position){
        if(rootNode == null)
            return;

        if(rootNode.isEndOfKey()){
            counter++;
            printEntry(keyArray, position, rootNode);
        }

        for(int counter = 0; counter < TrieNode.SIZE; counter++){
            if(rootNode.getChildrens()[counter] != null){
                keyArray[position] = rootNode.getChildrens()[counter].getNodeKey();
                printAllNodes(rootNode.getChildrens()[counter], keyArray, position + 1);
            }
        }
    }

    /**
     * This is helper method used for formatting of key value pair getting printed on
     * console(as per current implementation) in format <key, value>
     *
     * @param keyArray Array containing key of the entry
     * @param size size of key
     * @param node Final end Node in which we are storing the value
     */
    private void printEntry(int [] keyArray, int size, TrieNode node){
        System.out.print("<");
        for(int i = 0; i < size; i++){
            System.out.print(keyArray[i]);
        }
        System.out.println(", " + node.getValue() + ">");
    }
}
