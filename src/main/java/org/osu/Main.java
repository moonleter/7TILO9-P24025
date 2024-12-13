package org.osu;

public class Main {
    public static void main(String[] args) {
        int targetFloor = 25;
        int targetStep = 4;

        long[] result = NPCClimbingAlgorithm.findPossibleWays(targetFloor, targetStep);

        System.out.println("Cesty do " + targetFloor + ". patra, " + targetStep + ". schodu:");
        System.out.println("1 schod: " + result[0]);
        System.out.println("2 schody: " + result[1]);
        System.out.println("3 schody: " + result[2]);
        System.out.println("Výtah: " + result[3]);
        System.out.println("Celkem cest: " + result[4]);
    }
}