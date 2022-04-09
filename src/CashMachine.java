/**
 * That is a program, which is emulates functionality of the real cash machine (with some assumptions).
 */

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Scanner;

public class CashMachine {

    private int id;
    private BigDecimal cashAmountTotal;
    private HashMap<String, Integer> cashBox;

    public void startMachine() {
        System.out.println("\nHello, dear client! This is Bank's of Top_country cash machine (ATM-"
                + getId() + ").\n\nPlease, select an option:");
    }

    public CashMachine() {
        setId(generateId());
        cashBox = new HashMap<>();
        cashBox.put("$1", generateCash());
        cashBox.put("$5", generateCash());
        cashBox.put("$10", generateCash());
        cashBox.put("$50", generateCash());
        cashBox.put("$100", generateCash());
        cashAmountTotal = BigDecimal.valueOf(0);

        for (String key : cashBox.keySet()) {
//            System.out.println(key + " " + cashBox.get(key));
            int cost = Integer.parseInt(key.substring(1)) * cashBox.get(key);
            cashAmountTotal = cashAmountTotal.add(BigDecimal.valueOf(cost));
        }
//        System.out.println("Total amount of cash is - $" + cashAmountTotal);
    }

    public int generateId() {
        return (int) (Math.random() * 9999) + 1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static int generateCash() {
        return (int) ((Math.random() * 999) + 1);
    }

    public static void main(String[] args) {
        CashMachine cashMachine = new CashMachine();
        cashMachine.startMachine();
        cashMachine.chooseStartAction();
    }

    public void chooseStartAction() {
        System.out.println("1 - You are already a customer of the bank.");
        System.out.println("2 - You want to become a customer of the bank.");
        System.out.print("Your choice: ");
        Scanner sc = new Scanner(System.in);
        String choose = sc.nextLine();
        boolean correctChoice = false;
        while (!correctChoice) {
            try {
                int chooseNum = Integer.parseInt(choose);
                if (chooseNum == 1 || chooseNum == 2) {
                    correctChoice = true;
                    System.out.println("Your choice is - " + chooseNum);
                } else {
                    System.out.println("Please, enter an \"1\", \"2\" or \"3\"");
                    choose = sc.nextLine();
                }

            } catch (NumberFormatException e) {
                System.out.println("Please, enter an \"1\", \"2\" or \"3\"");
                choose = sc.nextLine();
            }
        }
    }
}