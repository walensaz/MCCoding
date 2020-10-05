import java.util.Random;

public class Main {

    public static void main(String[] args) {
        boolean checkForTwo = false;
        String name1 = "Summoning";
        String name2 = "Super Strength";
        int priceOfIng = 9816;
        int priceOfHerb = 16785;
        int priceOfPotion = 37698;
        int totalGoldToSpend = 28000000;
        if(!checkForTwo) {
            calculate("Good", priceOfIng, priceOfHerb, priceOfPotion, totalGoldToSpend);
            calculate("OK", (int) (priceOfIng * 1.05), (int) (priceOfHerb * 1.05), priceOfPotion, totalGoldToSpend);
            calculate("Worse", (int) (priceOfIng * 1.1), (int) (priceOfHerb * 1.05), (int) (priceOfPotion * .95), totalGoldToSpend);
            calculate("Worst", (int) (priceOfIng * 1.1), (int) (priceOfHerb * 1.1), (int) (priceOfPotion * .95), totalGoldToSpend);
            return;
        }
        int priceOfIng2 = 7069;
        int priceOfHerb2 = 10476;
        int priceOfPotion2 = 24125;
        betterProfit(name1, name2, priceOfIng, priceOfIng2, priceOfHerb, priceOfHerb2, priceOfPotion, priceOfPotion2, totalGoldToSpend);
    }

    private static void betterProfit(String nameOfPotion1, String nameOfPotion2, int priceOfIng1, int priceOfIng2,
                                     int priceOfHerb1, int priceOfHerb2,
                                     int priceOfPotion1, int priceOfPotion2, int totalGoldToSpend) {
        int bestprofit1 = calculate("Good", priceOfIng1, priceOfHerb1, priceOfPotion1, totalGoldToSpend);
        int worstprofit1 = calculate("Worst", (int)(priceOfIng1 * 1.1), (int)(priceOfHerb1 * 1.1), (int)(priceOfPotion1 * .95), totalGoldToSpend);
        int bestprofit2 = calculate("Good", priceOfIng2, priceOfHerb2, priceOfPotion2, totalGoldToSpend);
        int worstprofit2 = calculate("Worst", (int)(priceOfIng2 * 1.1), (int)(priceOfHerb2 * 1.1), (int)(priceOfPotion2 * .95), totalGoldToSpend);
        boolean bestprofit = bestprofit1 > worstprofit1;
        boolean worstprofit = worstprofit1 > worstprofit2;
        if(bestprofit)
            System.out.println("Best Profit is " + nameOfPotion1 + " at " + bestprofit1 + "\n " +
                    "Which beats " + nameOfPotion2 + " at " + bestprofit2+ "\n" +
                    "Difference is: " + (bestprofit1 - bestprofit2));
        else
            System.out.println("Best Profit is " + nameOfPotion2 + " at " + bestprofit2 + "\n " +
                    "Which beats " + nameOfPotion1 + " at " + bestprofit1+ "\n" +
                    "Difference is: " + (bestprofit2 - bestprofit1));

        if(worstprofit)
            System.out.println("Better Profit is " + nameOfPotion1 + " at " + worstprofit1 + "\n " +
                    "Which beats " + nameOfPotion2 + " at " + worstprofit2 + "\n" +
                    "Difference is: " + (worstprofit1 - worstprofit2));
        else
            System.out.println("Better Profit is " + nameOfPotion2 + " at " + worstprofit2 + "\n " +
                    "Which beats " + nameOfPotion1 + " at " + worstprofit1 + "\n" +
                    "Difference is: " + (worstprofit2 - worstprofit1));
    }



    private static int calculate(String title, int priceOfIng, int priceOfHerb, int endPriceOfPotion, int totalGoldToSpend) {
        int priceTogether = priceOfIng + priceOfHerb;

        double chanceToSave = 11;
        double chanceToDouble = 5;
        double downAmount = .05;

        int totalGoldGained = 0;
        double totalProfit = 0;

        int amountOfIng = totalGoldToSpend/priceTogether;

        int amountOfUnfinished = 0;
        int amountOfPotions = 0;

        Random random = new Random();

        for(int i = 0; i < amountOfIng; i++) {
            if(random.nextInt(100) < chanceToSave) {
                i--;
            }
            if(random.nextInt(100) < chanceToDouble) {
                amountOfUnfinished += 2;
                continue;
            }
            amountOfUnfinished += 1;
        }

        for(int i = 0; i < amountOfIng; i++) {
            if(random.nextInt(100) < chanceToSave) {
                i--;
            }
            if(random.nextInt(100) < chanceToDouble) {
                amountOfPotions += 2;
                continue;
            }
            amountOfPotions += 1;
        }

        int beforeConvertedPotions = amountOfPotions;
        amountOfPotions = (amountOfPotions * 3) /4;
        int goldSpent = amountOfIng * priceTogether;

        System.out.println("--------------" + title + "-------------");
        System.out.println("Unfinished Made: " + amountOfUnfinished);
        System.out.println("Potions made:" + beforeConvertedPotions);
        System.out.println("Decanted Potions: " + amountOfPotions);
        System.out.println("Total Gold Spent(estimate): " + goldSpent);
        System.out.println("Total Amount of Ingredients calculated: " + amountOfIng);
        System.out.println("Total gold gained: " + (totalGoldGained = amountOfPotions * endPriceOfPotion));
        totalProfit = totalGoldGained - totalGoldToSpend;
        System.out.println("Total profit: " + (int)totalProfit);
        System.out.println("Total profit with down amount(%): " + totalProfit * (1 - downAmount));
        System.out.println("--------------" + title + "-------------");
        return (int)totalProfit;
    }



}
