package org.helpshift;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.helpshift.cacher.TrieRootNodeCacher;
import org.helpshift.commands.CommandHelperFactory;
import org.helpshift.services.TrieInsertionService;
import org.helpshift.services.TriePrintingService;
import org.helpshift.services.TrieSearchingService;
import org.helpshift.services.TrieService;
import org.junit.Test;

/**
 * Unit test for Trie App.
 */
public class AppTest 
{
    TrieService service;
    TrieInsertionService insertionService;
    TrieSearchingService searchingService;
    TriePrintingService printingService;

    /**
     * This is a simple insertion test for 3 pairs of <key, value> pairs.
     *
     * @throws Exception getting thrown by the getService() method of SearchingService
     */
    @Test
    public void insertTest() throws Exception {
        service = CommandHelperFactory.getInstance().getService(CommandHelperFactory.COMMAND.INSERT.name());
        insertionService = (TrieInsertionService) service;
        insertionService.insert(100, "HelpShift_100");
        insertionService.insert(200, "HelpShift_200");
        insertionService.insert(300, "HelpShift_300");
        service = CommandHelperFactory.getInstance().getService(CommandHelperFactory.COMMAND.DISPLAY_CURRENT_STATE.name());

        System.out.println("insertTest() all nodes.");
        printingService = (TriePrintingService)service;

        printingService.printAllNodes(TrieRootNodeCacher.getInstance().getRootNode());
        System.out.println("------------------------");
        assertTrue( TriePrintingService.counter == 11);
    }



    /**
     * This is testing for EMPTY string value passed with key
     */
    @Test
    public void emptyValueInputs(){
        try{
            service = CommandHelperFactory.getInstance().getService(CommandHelperFactory.COMMAND.INSERT.name());
            insertionService = (TrieInsertionService) service;
            insertionService.insert(100, "");
            assertFalse(true);
        }catch (Exception e){
            assertTrue(e.getMessage().contains("Invalid inputs"));
        }
    }



    /**
     * This is testing for 'null' string value passed with key
     */
    @Test
    public void invalidValueInputs(){
        try{
            service = CommandHelperFactory.getInstance().getService(CommandHelperFactory.COMMAND.INSERT.name());
            insertionService = (TrieInsertionService) service;
            insertionService.insert(100, null);
            assertFalse(true);
        }catch (Exception e){
            assertTrue(e.getMessage().contains("Invalid inputs"));
        }
    }



    /**
     * This test case is testing for null input of key.
     */
    @Test
    public void insertionWithNullKeys(){
        try{
            service = CommandHelperFactory.getInstance().getService(CommandHelperFactory.COMMAND.INSERT.name());
            insertionService = (TrieInsertionService) service;
            insertionService.insert(null, "");
            assertFalse(true);
        }catch (Exception e){
            assertTrue(e.getMessage().contains("Invalid inputs"));
        }
    }



    /**
     * This test case is testing for all inserted <key, value> pairs getting printed when we hit DISPLAY_CURRENT_STATE
     * We are using 'counter' variable logic here.
     */
    @Test
    public void retrieveAllInsertedKeys(){
        try{
            service = CommandHelperFactory.getInstance().getService(CommandHelperFactory.COMMAND.INSERT.name());
            insertionService = (TrieInsertionService) service;
            insertionService.insert(101, "HelpShift_101");
            insertionService.insert(203, "HelpShift_203");
            insertionService.insert(305, "HelpShift_305");
            insertionService.insert(407, "HelpShift_407");
            service = CommandHelperFactory.getInstance().getService(CommandHelperFactory.COMMAND.DISPLAY_CURRENT_STATE.name());

            System.out.println("retrieveInsertedKeys() all nodes.");
            printingService = (TriePrintingService)service;

            printingService.printAllNodes(TrieRootNodeCacher.getInstance().getRootNode());
            System.out.println("------------------------");
            assertTrue( TriePrintingService.counter == 4);
        }catch (Exception e){
            assertFalse(true);
        }
    }



    /**
     * We are testing & cross checking for an existing value of a key.
     */
    @Test
    public void retrievalOfExistingKey(){
        try{
            service = CommandHelperFactory.getInstance().getService(CommandHelperFactory.COMMAND.INSERT.name());
            insertionService = (TrieInsertionService) service;
            insertionService.insert(101, "HelpShift_101");
            insertionService.insert(203, "HelpShift_203");

            service = CommandHelperFactory.getInstance().getService(CommandHelperFactory.COMMAND.RETRIEVE.name());

            searchingService = (TrieSearchingService) service;
            String retrievedValue = searchingService.search(203);

            assertTrue( retrievedValue.contains("HelpShift_203"));
        }catch (Exception e){
            assertFalse(true);
        }
    }



    /**
     * We are testing & cross checking for non-existing value of a key does not present in our data structure.
     */
    @Test
    public void retrievalOfNonExistingKey(){
        try{
            service = CommandHelperFactory.getInstance().getService(CommandHelperFactory.COMMAND.INSERT.name());
            insertionService = (TrieInsertionService) service;
            insertionService.insert(101, "HelpShift_101");
            insertionService.insert(203, "HelpShift_203");
            insertionService.insert(305, "HelpShift_305");
            insertionService.insert(407, "HelpShift_407");
            service = CommandHelperFactory.getInstance().getService(CommandHelperFactory.COMMAND.RETRIEVE.name());

            searchingService = (TrieSearchingService) service;
            String retrievedValue = searchingService.search(1010);

            assertTrue( retrievedValue == null);
        }catch (Exception e){
            assertFalse(true);
        }
    }



    /**
     * This test case is testing for sub-key, sub-key is nothing but part of key is also key, more explained as below
     *
     * sub-key concept : In below example '110' is sub-key of key '11012', where they
     * are containing values 'HelpShift_305' and 'HelpShift_203' respectively.
     */
    @Test
    public void testForSubKey(){
        try{
            service = CommandHelperFactory.getInstance().getService(CommandHelperFactory.COMMAND.INSERT.name());
            insertionService = (TrieInsertionService) service;
            insertionService.insert(101, "HelpShift_101");
            insertionService.insert(11012, "HelpShift_203");
            insertionService.insert(110, "HelpShift_305");
            insertionService.insert(407, "HelpShift_407");
            service = CommandHelperFactory.getInstance().getService(CommandHelperFactory.COMMAND.RETRIEVE.name());

            searchingService = (TrieSearchingService) service;
            String firstRetrievedValue = searchingService.search(11012);
            String secondRetrievedValue = searchingService.search(110);
            assertTrue( firstRetrievedValue.equals("HelpShift_203") && secondRetrievedValue.equals("HelpShift_305"));

        }catch (Exception e){
            assertFalse(true);
        }
    }

}
