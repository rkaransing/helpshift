package org.helpshift;

import org.helpshift.cacher.TrieRootNodeCacher;
import org.helpshift.commands.CommandHelperFactory;
import org.helpshift.services.TrieInsertionService;
import org.helpshift.services.TriePrintingService;
import org.helpshift.services.TrieSearchingService;
import org.helpshift.services.TrieService;

import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
        TrieService service;
        TrieInsertionService insertionService;
        TriePrintingService printingService;
        TrieSearchingService searchingService;

        while(true){
            Scanner sc = new Scanner(System.in);
            printOptions();

            int userInput = sc.nextInt();
            if(userInput < 1 || userInput > 3){
                System.out.println("Stopping Execution, Byeee...!!!");

                /**
                 * Here we can also throw an Exception which will smoothly stop the execution
                 * But throwing an Exception is more useful in case there is any other separate
                 * code or some other things like applet running on same JVM, as we have only this
                 * program we can stop it here using System.exit(0).
                 *
                 * * */
                System.exit(0);

            }else{
                try {
                    service = CommandHelperFactory.getInstance().getService(CommandHelperFactory.COMMAND.values()[userInput - 1].name());

                    if (service instanceof TrieInsertionService) {
                        insertionService = (TrieInsertionService) service;
                        printEnterKey();
                        int key = sc.nextInt();
                        sc.nextLine();
                        printEnterValue();
                        String value = sc.nextLine();
                        insertionService.insert(key, value);
                    } else if (service instanceof TrieSearchingService) {
                        searchingService = (TrieSearchingService) service;
                        printEnterKey();
                        int key = sc.nextInt();
                        String retrievedValue = searchingService.search(key);
                        if (retrievedValue == null)
                            System.out.println("No Entry found for key : " + key);
                        else
                            System.out.println("Retrieved value : " + retrievedValue);
                    } else if (service instanceof TriePrintingService) {
                        printingService = (TriePrintingService) service;
                        printingService.printAllNodes(TrieRootNodeCacher.getInstance().getRootNode());
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            printSeparator();
        }

    }

    /**
     * Below all are pre-formatted helper console-printing methods.
     */
    private static void printOptions(){
        System.out.println("Please choose your option number : ");
        System.out.println(" 1. Insert\n 2. Retrieve\n 3. Display current state\n 4. To Stop press any other number");
        System.out.print("Choice : ");
    }

    private static void printEnterKey(){
        System.out.print("Enter Key : ");
    }

    private static void printEnterValue(){
        System.out.print("Enter Value : ");
    }

    private static void printSeparator(){
        System.out.println("\n___________________________________\n");
    }
}
