package com.company;

import java.util.Random;
import java.util.ArrayList;

/**
 * Reddit Daily Programmer (Ideas) - PowerBall (US) Simulator.
 * https://www.reddit.com/r/dailyprogrammer_ideas/comments/439eet/easyintermediate_powerball_simulator/
 * Program to simulate PowerBall being played.
 */

public class Main {

    public static int ballNumSize = 69;
    public static int powerBallNumSize = 26;
    public static Random rand = new Random();
    public static ArrayList<Integer> powerBallNumbers = new ArrayList<>();
    public static ArrayList<Integer> powerBallTicketGenerator = new ArrayList<>();
    public static String strPowerBall = "";
    public static String ticketBall;


    public static void main(String[] args) {
        int ticketCounter = 1;
        powerBallGenerate();
        do{
            ticketGenerator();
            //System.out.printf("Ticket #: %10d Played Numbers: %10s\n", ticketCounter, ticketBall);
            ticketCounter++;
        }while(!winningTicket());
        System.out.printf("Ticket #: %2d Played Numbers: %10s\n", ticketCounter, ticketBall);
    }

    /*
    Generator methods for PowerBall numbers and played ticket numbers.
     */
    public static void powerBallGenerate(){
        System.out.print("The winning numbers are: ");
        // loop to generate non-PowerBall balls
        for (int i = 0; i < 5; i++){
            powerBallNumbers.add(rand.nextInt(ballNumSize)+1); // adds randomly generated numbers to array list.
        }
        // generates PowerBall ball and adds to same array list.
        powerBallNumbers.add(rand.nextInt(powerBallNumSize)+1);

        for (Integer powerBallNumber : powerBallNumbers) {
            strPowerBall = strPowerBall + powerBallNumber.toString() + " ";
        }
        System.out.println(strPowerBall);
    }

    /*
     generates ticket numbers from given parameter "number".
     "Number" indicated the number of tickets purchased.
     */
    public static void ticketGenerator(){
        powerBallTicketGenerator.clear();
        ticketBall = "";
        for (int i = 0; i < 5; i++){
            powerBallTicketGenerator.add(rand.nextInt(ballNumSize)+1); // adds randomly generated numbers to array list.
        }
        // adds teh power ball number to the end of the array list.
        powerBallTicketGenerator.add(rand.nextInt(powerBallNumSize)+1);
        for (Integer ticketBallNum : powerBallTicketGenerator) {
            ticketBall = ticketBall + ticketBallNum.toString() + " ";
        }
    }

    /*
    Comparison methods for finding the winning ticket.
     */

    /**
     * Runs ticket checking methods to check if ticket is winner or not.
     * Can be removed and containing code is moved to main method.
     * Runs here (even though is semi-redundant) to simplify main method.
     *
     * returns true if ticket is winner
     * returns false if ticket is not winner.
     *
     * @return
     */
    public static boolean winningTicket(){
        if (winningTicketPowerBall(strPowerBall, ticketBall)) {
            System.out.println("You have 6 matching numbers. You won the Jackpot!!");
            return true;
        }
        else if (winningTicketNoPowerBall(powerBallNumbers, powerBallTicketGenerator)) {
            System.out.println("You have 5 matching numbers."); // needs to be uncommented.
            return true; // needs to be true.
        }
        return false;
    }

    /**
     *
     * Checks if PowerBall ticket number is winner by comparing if
     * PowerBall Winning Number matches Ticket Number.
     *
     * @param powerBallString
     * @param ticketBallString
     * @return
     *
     */
    public static boolean winningTicketPowerBall(String powerBallString, String ticketBallString){
        return ticketBallString.contentEquals(powerBallString);
    }

    /**
     *
     * Checks if PowerBall ticket number is winner by comparing if
     * PowerBall Winning Number matches Ticket Number.
     *
     * @param powerBallList
     * @param ticketList
     * @return
     */
    public static boolean winningTicketNoPowerBall(ArrayList<Integer> powerBallList, ArrayList<Integer> ticketList){
        String powerBall = "", ticketBall = "";
        for(int i = 0; i < (powerBallList.size() -1); i++){
            powerBall += powerBall + powerBallList.get(i).toString();
            ticketBall += ticketBall + ticketList.get(i).toString();
        }
        return ticketBall.equals(powerBall);
    }
}
