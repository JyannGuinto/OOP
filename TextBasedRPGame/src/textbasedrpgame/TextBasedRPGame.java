/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package textbasedrpgame;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jyann 2
 */
class IntroScene implements Introduction 
{
    public void playIntroduction() 
    {
        System.out.println("Are you ready?");
        wait(3);
        System.out.println("Welcome to the world to Ravenwood");
        wait(3);
        System.out.println("This is a world of magic");
        wait(3);
        System.out.println("Where everything is possible");
        wait(3);
        System.out.println("Unluckily, you were born without magic, meaning, you are worthless");
        wait(3);
        System.out.println("This is a tale of how a have-nots will triumph over have-yachts");
        wait(3);
        System.out.println("...");
        wait(3);
        System.out.println("You wake up in the middle of nowhere");
        wait(3);
        System.out.println("You observe the vast horizon that takes mesmerizes you. ");
        wait(3);
        System.out.println("After observing, you found a sign that says Mezzo, which means you're in Mezzo right now.");
        wait(3);
        System.out.println("\n------------------------------------------------------------------\n");
    }
    public void wait(int numSeconds)
    {
    try 
    {
        Thread.sleep(numSeconds * 1000);
    } 
    catch (InterruptedException e) {}
    }
}

class BattleScene implements Battle {
    public void playBattle() {
        System.out.println("A fierce battle ensues!");
    }
}

class EndScene implements Conclusion{
    public void playConclusion() {
        System.out.println("Congratulations! You've finished the game.");
        System.out.println("This game is made by Jyann Margaux V. Guinto.");
        System.exit(1);
    }
}
public class TextBasedRPGame {
    
    Scanner scan = new Scanner(System.in);
    int choice;
    Player player= new Player();
    Monster monster;
    String playerWeapon;
    Weapon weap = new Weapon();
    int rescue;
    int completion=0;
    Introduction intro = new IntroScene();
    Battle battle = new BattleScene();
    Conclusion end = new EndScene();
    
    public static void main(String[] args) 
    {
        TextBasedRPGame game;
        game = new TextBasedRPGame();
        game.defaultSetup();
         Scanner scn = new Scanner(System.in);
        while(true){
        String choice1 = scn.nextLine();
        if(choice1.equalsIgnoreCase("P"))
        { 
        System.out.println("Press 1 or 2 to select your game mode.");
        System.out.println("1 - Story");
        System.out.println("2 - Survival");
        int play2 =0;
        while(play2 != 1){
        int choice2 = scn.nextInt();
            if(choice2 == 1)
            {
            game.story();
            }
            else if(choice2 == 2)
            {
            game.survival();
            }
        }
        }
        else if(choice1.matches("[A-Za-z]"))
        {
            System.out.println("Enter the right letter.");
        }
        }
    }
    
    public void defaultSetup()
    {
        player.HP = 10;
        player.currentWeapon = new Weapon_Knife();
        playerWeapon = "Knife";
        player.money = 10;
        player.name = null;
        player.score = 0;
        
        System.out.print("Enter your name: ");
        player.name = scan.nextLine();
        System.out.println("Your HP: " + player.HP);
	System.out.println("Your Weapon: " + playerWeapon);
        System.out.println("Your Money: " + player.money);
        System.out.println("Press P to start playing, " + player.name);
    }
    public void story()
    {
        intro.playIntroduction();
        Mezzo(); 
    }
    public void survival()
    {
        survivalMenu();
    }
    public void survivalMenu()
    {
        Scanner scn2 = new Scanner(System.in);
        System.out.println("1 - Play");
        System.out.println("2 - Instructions");
        System.out.println("3 - Shop");
        System.out.println("4 - Hotspring");
        int choice3 = scn2.nextInt();
        switch(choice3)
        {
            case 1:
                survivalMode();
            case 2:
                instructions();
            case 3:
                survivalAlingNenangShop();  
            case 4: 
                hotSpringSurvival();
            default:
                survivalMenu();
        }
    }
    public void survivalMode()
    {
        System.out.println("This is the first floor.");
        System.out.println("1 - Start");
        System.out.println("2 - Back");
        int choice = scan.nextInt();
        switch(choice)
        {
            case 1:
                floors();
            case 2:
                survivalMenu();
        }
    }
    public void instructions()
    {
        System.out.println("This is the survival mode.");
        System.out.println("There is 3 floors in this survival mode. ");
        System.out.println("The goal is simple, you need to survive and beat 10 floors.");
        System.out.println("You can buy weapons in the shop if you want to get stronger.");
        System.out.println("You can go to the hotspring to heal.");
        System.out.println("Hint: monsters drop loot, use those loot to buy more gear to help you.");
        System.out.println("1 - Go back");
        int choice = scan.nextInt();
        switch(choice){
            case 1: 
                survivalMenu();
            default:
                instructions();
                
    }
    }
    public void score()
    {
        System.out.println("Score:");
        System.out.println("Jyann: 99999999");
        System.out.println(player.name + ": " + player.score);
        survivalMenu();
    }
    public void Mezzo()
    {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You are at Mezzo. You see three places, a hotspring, a town, and a dungeon");
		System.out.println("1: Go to the hotspring");
		System.out.println("2: Go to the town");
		System.out.println("3: Go to the dungeon");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = scan.nextInt();

		if (choice == 1) {
			hotSpring();
		} else if (choice == 2) {
			town();
		} else if (choice == 3) {
			dungeon();
		} else {
                    Mezzo();
		}
	}
    public void hotSpringHeal()
    { 
        player.HP = player.HP + 5;
        if(player.HP >= player.maxHP)
        {
            player.HP = player.maxHP;
            System.out.println("Player HP is maxed.");
        }
    }
    public void hotSpringSurvival()
    {
        player.HP = player.maxHP;
        System.out.println("Player HP is maxed.");
        System.out.println("1 - Back");
        int choice = scan.nextInt();
        switch(choice)
        {
            case 1:
            survivalMenu();
        
            case 2:
            hotSpringSurvival();
        }
    
    }
    public void hotSpring() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("There is a Hotspring. You drink the undress and jump to the hotspring like a champ.");
                wait(1);
                System.out.println("You feel like you're in nirvana.");
                wait(1);
		System.out.println("Your HP is recovered.");
                wait(1);
		hotSpringHeal();
		System.out.println("Your HP: " + player.HP);
                wait(1);
		System.out.println("\n\n1: Go back to the Mezzo");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = scan.nextInt();

		if (choice == 1) {
			Mezzo();
		} else {
			hotSpring();
		}
	}
    public void town() {

		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You walk and observe the town as you go inside.");
                wait(1);
		System.out.println("You see that there is a shop, a grand academy, and a poor man's house");
                wait(1);
		System.out.println("");
                wait(1);
		System.out.println("What do you want to do?");
		System.out.println("");
                wait(1);
		System.out.println("1: Go to Aling Nenang's shop");
		System.out.println("2: Go to the Grand Academy");
		System.out.println("3: Go to the poor man's house");
                System.out.println("4: Leave");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = scan.nextInt();

		if (choice == 1) 
                {	
                        alingNenangShop();
		} 
                else if (choice == 2) 
                {
			grandAcademy();
                }
                else if (choice == 3) 
                {
			poorManHouse();
		}
                else if (choice == 4) 
                {
			Mezzo();
		} 
                else 
                {
			town();
		}
	}
    public void alingNenangShop()
    {
        System.out.println("Aling Nenang welcomes you and greets you.");
        wait(1);
        System.out.println("This is a shop that sells weapons");
        wait(1);
        System.out.println("1: Sword");
        System.out.println("Price: 100");
        System.out.println("2: Infinity edge ");
        System.out.println("Price: 1000");
        System.out.println("3: ChunChunMaru ");
        System.out.println("Price: 10000");
        System.out.println("4: Leave ");
        wait(1);
        System.out.println("Your money: " + player.money);
        System.out.println("What will you do?");
        int choice = scan.nextInt();
        System.out.println("Will you buy?");
        switch(choice)
        {
            case 1:
                weap = new Weapon_Sword();
                System.out.println("1: Buy.");
                System.out.println("2: Back");
                int choice2 = scan.nextInt();
                switch(choice2)
                {   
                    case 1: 
                        if(player.money > weap.price)
                        {
                            player.money = player.money - weap.price;
                            player.currentWeapon = new Weapon_Sword();
                            System.out.println("Sword acquired!");
                        }
                        else{
                            System.out.println("You don't have enough money");
                        }
                    case 2: 
                        alingNenangShop();
                }
                
            case 2: 
                weap = new Weapon_InfinityEdge();
                System.out.println("1: Buy.");
                System.out.println("2: Back");
                choice2 = scan.nextInt();
                switch(choice2)
                {   
                    case 1: 
                        if(player.money > weap.price)
                        {
                            player.money = player.money - weap.price;
                            player.currentWeapon = new Weapon_InfinityEdge();
                            System.out.println( "Infinity edge acquired!");
                        }
                        else if(player.money < weap.price){
                            System.out.println("You don't have enough money");
                        }
                    case 2: 
                        alingNenangShop();
                }
            case 3:
                weap = new Weapon_ChunChunMaru();
                System.out.println("1: Buy.");
                System.out.println("2: Back");
                choice2 = scan.nextInt();
                switch(choice2)
                {   
                    case 1: 
                        if(player.money > weap.price)
                        {
                            player.money = player.money - weap.price;
                            player.currentWeapon = new Weapon_ChunChunMaru();
                            System.out.println("ChunChunMaru the legendary sword acquired!");
                        }
                        else if(player.money < weap.price){
                            System.out.println("You don't have enough money");
                        }
                    case 2: 
                        alingNenangShop();
                }
            case 4:
                town();
        }
            
    }
    public void survivalAlingNenangShop()
    {
        System.out.println("Aling Nenang welcomes you and greets you.");
        wait(1);
        System.out.println("This is a shop that sells weapons");
        wait(1);
        System.out.println("1: Sword");
        System.out.println("Price: 100");
        System.out.println("2: Infinity edge ");
        System.out.println("Price: 1000");
        System.out.println("3: ChunChunMaru ");
        System.out.println("Price: 10000");
        System.out.println("4: Leave ");
        wait(1);
        System.out.println("Your money: " + player.money);
        System.out.println("What will you do?");
        int choice = scan.nextInt();
        System.out.println("Will you buy?");
        switch(choice)
        {
            case 1:
                weap = new Weapon_Sword();
                System.out.println("1: Buy.");
                System.out.println("2: Back");
                int choice2 = scan.nextInt();
                switch(choice2)
                {   
                    case 1: 
                        if(player.money > weap.price)
                        {
                            player.money = player.money - weap.price;
                            player.currentWeapon = new Weapon_Sword();
                            System.out.println("Sword acquired!");
                        }
                        else{
                            System.out.println("You don't have enough money");
                        }
                    case 2: 
                        survivalAlingNenangShop();
                }
                
            case 2: 
                weap = new Weapon_InfinityEdge();
                System.out.println("1: Buy.");
                System.out.println("2: Back");
                choice2 = scan.nextInt();
                switch(choice2)
                {   
                    case 1: 
                        if(player.money > weap.price)
                        {
                            player.money = player.money - weap.price;
                            player.currentWeapon = new Weapon_InfinityEdge();
                            System.out.println( "Infinity edge acquired!");
                        }
                        else if(player.money < weap.price){
                            System.out.println("You don't have enough money");
                        }
                    case 2: 
                        survivalAlingNenangShop();
                }
            case 3:
                weap = new Weapon_ChunChunMaru();
                System.out.println("1: Buy.");
                System.out.println("2: Back");
                choice2 = scan.nextInt();
                switch(choice2)
                {   
                    case 1: 
                        if(player.money > weap.price)
                        {
                            player.money = player.money - weap.price;
                            player.currentWeapon = new Weapon_ChunChunMaru();
                            System.out.println("ChunChunMaru the legendary sword acquired!");
                        }
                        else if(player.money < weap.price){
                            System.out.println("You don't have enough money");
                        }
                    case 2: 
                        survivalAlingNenangShop();
                }
            case 4:
                survivalMenu();
        }
            
    }
    public void grandAcademy()
    {
        if(completion == 1)
        {
            wait(1);
            System.out.println("WHAT?! the puny man/woman has the proof of Gunnhildr Clan?!");
            wait(1);
            System.out.println("The clan that was lost in the void century?!");
            wait(1);
            System.out.println("Very well! you can now attend the grand academy.");
            wait(1);
            System.out.println("We will watch over you!");
            wait(1);
            System.out.println("Show us what you're made of!");
            wait(1);
            System.out.println("Chapter 0 concludes");
            wait(1);
            System.out.println("Chapter 1 starts");
            System.out.println("\n------------------------------------------------------------------\n");
            end.playConclusion();
        }
        System.out.println("You look weak and you don't even have magical power.");
        wait(1);
        System.out.println("You are not welcome here.");
        wait(1);
        System.out.println("Get out trash.");
        wait(1);
        System.out.println("What do you wanna do?");
        System.out.println("1: Town");
        choice = scan.nextInt();
        if(choice == 1)
                town();
        else{
            grandAcademy();
        }
    }
    public void poorManHouse()
    {
        if(rescue == 1){
            completeRescue();
        }
        System.out.println("Poor man: PLEASE HELP US");
        wait(1);
        System.out.println("Poor man: YOUNG'UN PLEASE HELP US");
        wait(1);
        System.out.println("Poor man: MY SISTER WAS KIDNAPPED BY A TROLL");
        wait(1);
        System.out.println("Poor man: PLEASE HELP! THEY TOOK HER TO THE DUNGEON");
        wait(1);
        System.out.println("What do you wanna do?");
        System.out.println("1: Town");
        choice = scan.nextInt();
        if(choice == 1)
                town();
        else{
            poorManHouse();
        }
    }
    public void dungeon() {
                int rand = new java.util.Random().nextInt(100)+1;
                if(rand<90){
                    monster = new Monster_Goblin();
                }
                else{
                    rescue++;
                    System.out.println("You saw the troll and saved the sister.");
                    System.out.println("However, you have to fight it to let the sister run.");
                    monster = new Monster_Troll();
                }
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You encounter a " + monster.name);
		System.out.println("1: Fight");
		System.out.println("2: Run");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = scan.nextInt();

		if (choice == 1) {
                        battle.playBattle();
			fight();
		} else if (choice == 2) {
			Mezzo();
		} else {
			dungeon();
		}
	}
    public void floors()
    {
                int rand = new java.util.Random().nextInt(100)+1;
                if(rand<70){
                    monster = new Monster_Goblin();
                }
                else{
                    monster = new Monster_Troll();
                }
                   
                
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You encounter a " + monster.name);
		System.out.println("1: Fight");
		System.out.println("2: Run");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = scan.nextInt();

		if (choice == 1) {
                        battle.playBattle();
			fightSurvival();
		} else if (choice == 2) {
			survivalMenu();
		} else {
			floors();
		}
    }
    public void fight()
        {
        System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Your HP: " + player.HP);
		System.out.println("Monster HP: " + monster.HP);
		System.out.println("\n1: Attack");
		System.out.println("2: Run");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = scan.nextInt();

		if (choice == 1) {
			playerAttack();
		} else if (choice == 2) {
			Mezzo();
		} else {
			fight();
		}
        }
    public void fightSurvival()
        {
        System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Your HP: " + player.HP);
		System.out.println("Monster HP: " + monster.HP);
		System.out.println("\n1: Attack");
		System.out.println("2: Run");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = scan.nextInt();

		if (choice == 1) {
			playerAttackSurvival();
		} else if (choice == 2) {
			survivalMode();
		} else {
			fightSurvival();
		}
        }
     public void playerAttack()
    {
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);
        System.out.println("You attacked the " + monster.name + " and gave " + playerDamage + " damage!");
        monster.HP = monster.HP - playerDamage;
        if(monster.HP > 0)
        {
            monsterAttack();
        }
        else if(monster.HP < 1)
        {
            win();
        }
    }
       public void playerAttackSurvival()
    {
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);
        System.out.println("You attacked the " + monster.name + " and gave " + playerDamage + " damage!");
        monster.HP = monster.HP - playerDamage;
        if(monster.HP > 0)
        {
            monsterAttackSurvival();
        }
        else if(monster.HP < 1)
        {
            winSurvival();
        }
    }
     public void monsterAttack()
    {
        int monsterDamage = new java.util.Random().nextInt(monster.atk);
        player.HP = player.HP - monsterDamage;
        System.out.println("The " + monster.name +" attacked you and gave " + monsterDamage + " damage!");
        if (player.HP < 1) 
        {
            dead();
	} 
        else if(player.HP > 0) 
        {
            fight();
	}
    }
      public void monsterAttackSurvival()
    {
        int monsterDamage = new java.util.Random().nextInt(monster.atk);
        player.HP = player.HP - monsterDamage;
        System.out.println("The " + monster.name +" attacked you and gave " + monsterDamage + " damage!");
        if (player.HP < 1) 
        {
            deadSurvival();
	} 
        else if(player.HP > 0) 
        {
            fightSurvival();
	}
    }
     public void win()
     {
         int loot = new java.util.Random().nextInt(100)+1;
         System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You killed the " + monster.name + "!");
		System.out.println("You obtaind "+ loot +" money!\n\n");
                player.money = player.money + loot;
		System.out.println("1: Go east");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = scan.nextInt();
		if (choice == 1) {
			Mezzo();
		} else {
			win();
		}
     }
      public void winSurvival()
     {
         int loot = new java.util.Random().nextInt(100)+1;
         System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You killed the " + monster.name + "!");
		System.out.println("You obtaind "+ loot +" money!\n\n");
                player.money = player.money + loot;
                player.score = player.score + 10;
		System.out.println("1: Go to the next Floor");
		System.out.println("\n------------------------------------------------------------------\n");

		choice = scan.nextInt();
		if (choice == 1) {
			floors();
		} else {
			win();
		}
     }
     public void dead() 
        {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You are dead!!!");
		System.out.println("\n\nGAME OVER");
		System.out.println("\n------------------------------------------------------------------\n");

	}
          public void deadSurvival() 
        {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You are dead!!!");
		System.out.println("\n\nGAME OVER");
		System.out.println("\n------------------------------------------------------------------\n");
                score();  
	}
     public void wait(int numSeconds)
    {
    try 
    {
        Thread.sleep(numSeconds * 1000);
    } 
    catch (InterruptedException e) {}
    }
     public void completeRescue()
     {
         {
		System.out.println("\n------------------------------------------------------------------\n");
                wait(1);
		System.out.println("OH GOD! MY SISTER! THANK YOU SO MUCH");
                wait(1);
		System.out.println("Sister: thank you so much!");
                wait(1);
                System.out.println("Poor man: thank you so much!  I would like to give my utmost gratitude.");
                wait(1);
                System.out.println("You can have this, its the proof of our forgotten family that was part of the royalty a long time ago");
                wait(1);
                System.out.println("With this proof, you can go to the grand academy to compete and study there.");
                wait(1);
                System.out.println("You will be able to participate in the grand academy despite lacking magical power");
                wait(1);
		System.out.println("\n------------------------------------------------------------------\n");
                completion++;
                town();
	}
     }
}
