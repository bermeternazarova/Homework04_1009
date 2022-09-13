import java.util.Random;

public class Main {
    public static int bossHealth = 700;
    public static int bossDemage = 80;
    public static String bossDefenceType;
    public static int[] heroesHealth = {300, 300, 400,};
    public static int[] heroesDemage = {25, 30, 20,};
    public static String[] heroesAttackType = {"Physical", "Magical", "Kinethik", };
    public static int medicHealth = 200;
    public static int  medicRevive = 100;

     public  static int  roundNumber = 0 ;


    public static void main(String[] args) {
        printStatictics ();
        playRound();
        while (!isGameFinished()) {
            playRound();}

    }

    public static void playRound() {
        roundNumber++;
        chooseBossDefence();
        bossHits();
        medicComing();
        heroesHits();
        printStatictics ();

    }
    public static void chooseBossDefence() {
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length);
        bossDefenceType = heroesAttackType[randomIndex];
    }

    public static void printStatictics () {
        System.out.println("Round " + roundNumber + "________________");
        System.out.println("Boss health : " + bossHealth + " ; damage " + bossDemage + "; defence: " +
                (bossDefenceType == null ? " No defence" : bossDefenceType));
        for (int i = 0; i < heroesHealth.length; i++) {
            System.out.println(heroesAttackType[i] + " health " + heroesHealth[i] + "; damage " + heroesDemage[i]);
        }
        System.out.println(" Medic health :" + medicHealth + "; Revive: " + medicRevive);
    }


    public static boolean isGameFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won !!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                allHeroesDead = false;
                break;
            }
        }

        if (allHeroesDead) {
            System.out.println("Boss won !!!");
        }
        return allHeroesDead;
    }

    public static void bossHits() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                if (heroesHealth[i] - bossDemage < 0) {
                    heroesHealth[i] = 0;

                } else {
                    heroesHealth[i] = heroesHealth[i] - bossDemage;
                }
            }
        }
        for (int i = 0; i <medicHealth ; i++) {
            if (medicHealth > 0  ){
                if (medicHealth - bossDemage > 0 ){
                    medicHealth  =  medicHealth - bossDemage ;
                }else {
                    medicHealth = 0;
                }
            }

        }
    }
    public static void heroesHits() {
        for (int i = 0; i < heroesDemage.length; i++) {
            if (heroesHealth[i] > 0 && bossHealth > 0) {
                int hit = heroesDemage[i];
                if (heroesAttackType[i] == bossDefenceType) {
                    Random random  = new Random();
                    int coeff = random.nextInt(10);
                    hit = coeff * heroesDemage[i];
                    System.out.println("Critical Damage of Round " + roundNumber + ": " + hit);
                }
                if (bossHealth - hit < 0) {
                    bossHealth = 0;
                } else {
                    bossHealth = bossHealth - hit;
                }}}}
    public static  boolean medicComing () {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (medicHealth > 0){
            if ( heroesHealth[i] > 0 && heroesHealth [i] <100) {
                heroesHealth[i] = heroesHealth[i] + medicRevive;
            }else {
                heroesHealth[i]= heroesHealth[i] + medicRevive;
            }}

    }return true;
    }







}


















