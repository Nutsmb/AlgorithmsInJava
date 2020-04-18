package FightClub;

import java.util.Random;

class Game {
    public static void main(String[] args) {

        Random randomStep = new Random();
        Random randomHealing = new Random();
        int round = 0;

        Hero[] team1 = new Hero[]{new Warrior("Тигрил")
                , new Assasin("Акали")
                , new Doctor("Жанна")};


        Hero[] team2 = new Hero[]{new Warrior("Минотавр")
                , new Assasin("Джинкс")
                , new Doctor("Зои")};



        while(isAnybodyLive(team1) && isAnybodyLive(team2)){
            for (int i = 0; i < team1.length; i++) {
                if(randomStep.nextInt(2) == 0) {
                    if(team1[i] instanceof Doctor) {
                        team1[i].healing(team1[randomHealing.nextInt(3)]);
                    } else {
                        team1[i].hit(team2[randomHealing.nextInt(3)]);
                    }
                } else {
                    if(team2[i] instanceof Doctor) {
                        team2[i].healing(team2[randomHealing.nextInt(3)]);
                    } else {
                        team2[i].hit(team1[randomHealing.nextInt(3)]);
                    }
                }
            }
            round++;
        }

        for (Hero t1: team1) {
            t1.info();
        }

        for (Hero t2: team2) {
            t2.info();
        }
        System.out.println("Победа за " + round + " раундов");
    }

    public static boolean isAnybodyLive(Hero[] _team){
        int result = 0;
        for (Hero t: _team) {
            result += t.getHealth();
        }
        return (result > 0);
    }
}