import java.util.Scanner;
import java.util.Random;
public class TextBasedGame {
    static boolean dominance = false;
    static boolean insanity = false;
    public static void main(String[] args) {
        System.out.println("Welcome to my game! This is a text based game where you are a character trapped in prison for violating a restraining order");
        System.out.println("The objective of this game is to escape from prison");
        System.out.println("Some advice before we start the game: in every situation, make the worst possible decision");
        System.out.println("Now that that's all clear, let's start! Begin by typing male to play as a male and female to play as a female");
        Scanner scanner = new Scanner(System.in);
        String gender = scanner.nextLine();
        if (gender.equals("male")){
            maleStoryline();
        }
        else {
            femaleStoryline();
        }
    }
    public static void femaleStoryline(){
        System.out.println("The bell rings. It's time for your one hour of unrestricted time in the field.");
        System.out.println("Suddenly a fight starts out between two inmates. Do you choose to join the fight? Type 1 for yes and 2 for no");
        Scanner scanner = new Scanner(System.in);
        int fight = Integer.parseInt(scanner.nextLine());
        if (fight == 1){
            System.out.println("you scream RAWRRRR and charge into the middle of the fight");
            System.out.println("Type in either punch, kick, headbutt for your type of attack and number from 1-30 for the power of attack");
            Scanner anotherFight = new Scanner(System.in);
            String typeOfAttack = anotherFight.nextLine();
            int power = anotherFight.nextInt();
            boolean winOrLose = actualFight(typeOfAttack, power);
            if (winOrLose){
                System.out.println("Yay you've won and now established dominance in the prison!");
                dominance = true;
                wardenComes();
            }
            else {
                System.out.println("You start crying halfway through the fight and all the inmates make fun of you");
                wardenComes();
            }
        }
        else{
            fightScene();
        }
    }
    public static void wardenComes(){
        System.out.println("Warden Malone, a man with an Australian accent and an untucked shirt breaks up the fight");
        System.out.println("He calls you a bunch of clownlings, and demands to know which one of you started the fight");
        if (!dominance){
            System.out.println("Do you choose to take responsibility for your actions or blame others? Type 1 for responsibility, and 2 for blame game");
            Scanner scanner = new Scanner(System.in);
            int response = Integer.parseInt(scanner.nextLine());
            if (response == 1){
                System.out.println("Warden Malone is very pleased at you for being mature, and decides that as a reward you will be able to take a walk tonight");
                escapeAttempt();
            }
            else {
                System.out.println("Because you looked like a crybaby idiot none of the inmates like you and they immediately turn you in");
                System.out.println("The Warden drags you off by the ear into solitary confinement");
                solitaryConfinement();
            }
        }
        else{
            System.out.println("\nBecause you have terrified your inmates into submission, one of them takes the blame instead");
            System.out.println("You proudly announce to the Warden that you were the one who broke up the fight");
            System.out.println("Warden Malone is very pleased at you for being mature, and decides that as a reward you will be able to take a walk tonight");
            escapeAttempt();
        }

    }
    public static void fightScene(){
        System.out.println("BAM! A fist hits you on the face and you start bleeding. Do you get the warden (type w) or defend yourself (type d)?");
        Scanner scanner = new Scanner(System.in);
        String defendOrWarden = scanner.nextLine();
        if (defendOrWarden.equals("d")){
            System.out.println("They've made it personal now. Type in either punch, kick, headbutt for your type of attack and number from 1-30 for the power of attack");
            Scanner fight = new Scanner(System.in);
            String typeOfAttack = fight.nextLine();
            int power = fight.nextInt();
            boolean winOrLose = actualFight(typeOfAttack, power);
            if (winOrLose){
                System.out.println("Yay you've won and now established dominance in the prison!");
                dominance = true;
                wardenComes();
            }
            else{
                System.out.println("You start crying halfway through the fight and all the inmates make fun of you");
                wardenComes();
            }
        }
        else{
            wardenComes();
        }

    }
    public static boolean actualFight(String attack, int power){
        if (attack.equals("headbutt")){
            return true;
        }
        else if (power <= 10){
            return true;
        }
        else if ((attack.equals("punch") && (power >= 20))){
            return true;
        }
        return false;
    }
    public static void maleStoryline(){
        System.out.println("Sorry I only included this option to fulfill lab requirements. You will still play as a female");
        femaleStoryline();
    }
    public static void solitaryConfinement(){
        System.out.println("You're forced into a dingy small cell that smells suspiciously like the CIS swimming pool.");
        System.out.println("The warden gives you a massive grin and tells you to have fun. As he turns to leave, you see his golden key dangling in front of your face");
        System.out.println("Do you decide to risk it and try to grab it? Type 1 for yes, and 2 for no");
        Scanner scanner = new Scanner(System.in);
        int grabKey = scanner.nextInt();
        if (grabKey == 1){
            thief();
        }
        else {
            System.out.println("You decide that it's not worth thr risk. You watch as the warden leaves, and begin the first of your days in confinement");
            System.out.println("By the time the third day comes around, you feel like you're going insane. You have terrible nightmares, and you wake up screaming and shaking");
            System.out.println("Gradually, you become insane. By the time you're released from solitary confinement, you're a shell of a person, with no soul, and no sanity");
            insanity = true;
            System.out.println("Because the warden feels sorry for you (this is out of character, but I just want to finish the story), he allows you take a walk around the prison grounds late at night");
            escapeAttempt();
        }

    }
    public static void thief(){
        System.out.println("Choose the way you're going to go about this heist. Type a random number from between 1 and 5 to indicate the time at which you are making your move?");
        Random rand = new Random();
        int wardenApproach = rand.nextInt(5);
        Scanner scanner = new Scanner(System.in);
        int heist = scanner.nextInt();
        if (heist > wardenApproach){
            System.out.println("Congrats, you've successfully stolen the key");
            System.out.println("Later that night, you use the key to slide througn the prison unnoticed, and successfully escape");
            afterEscape();
        }
        else {
            System.out.println("You're a bit slow, and you fall flat on your face in front of the warden, who immediately realizes what you were gonna do");
            if (!(dominance)){
                System.out.println("Knowing how much everyone in the prison hates you, he throws you to live without the protection of prison guards");
                System.out.println("Within half a minute, you're killed by some random inmate. You are dead. The End");
                return;
            }
            System.out.println("You accidentally smash your head really hard while falling to the floor, and you're losing a lot of blood");
            System.out.println("Without adequate medical assistance, you die. The END ");
            return;
        }

    }
    public static void escapeAttempt(){
        System.out.println("\nThat evening you're taking a walk around when you see a bored looking man with a strange mafia haircut looking at his phone");
        System.out.println("Do you approach him? If you do type 1. Else type 2");
        Scanner scanner = new Scanner(System.in);
        int approachGuard = Integer.parseInt(scanner.nextLine());
        if ((approachGuard == 1) && !(insanity)){
            System.out.println("You approach the guard who introduces himself as CY. He tells you that he's a security guard but he's very bored");
            System.out.println("He gives you a deal: you play him in a game of Japanese mahjong, and if you win, he'll let you escape");
            System.out.println("Please enter in three numbers from 1-10, which will be your three tiles. Press press the enter bar between two numbers");
            Scanner game = new Scanner(System.in);
            int tileOne = game.nextInt();
            int tileTwo = game.nextInt();
            int tileThree = game.nextInt();
            int winOrLose = japaneseMahjong(tileOne, tileTwo, tileThree);
            if (winOrLose == 1){
                System.out.println("He smiles at you, and unlocks the door. You have successfully escaped the prison");
                afterEscape();
            }
            else {
                if (dominance){
                    System.out.println("The security guard unveils his cards with a flourish, and you stare in shock at his perfect deck of tiles");
                    System.out.println("He looks at you disappointed, and says you have failed him. You stare at him confused but he disappears right before your eyes leaving you to question your sanity");
                    System.out.println("Suddenly, the WARDEN comes and he is furious at you and says that you have broken his trust. He sends you off to solitary confinement");
                    solitaryConfinement();
                }
                else{
                    System.out.println("He shakes his head disappointed as he unveils his perfect deck of tiles. You've lost the game");
                    System.out.println("He declares that you are an unworthy opponent and kills you. You are dead. The end");
                }
            }
        }
        else if (insanity){
            System.out.println("Your brain has become so muddled after what happened during confinement that you see the man as a threat and start fighting him");
            System.out.println("Type in either punch, kick, headbutt for your type of attack and number from 1-30 for the power of attack");
            Scanner fight = new Scanner(System.in);
            String typeOfAttack = fight.nextLine();
            int power = fight.nextInt();
            boolean fightResult = actualFight(typeOfAttack, power);
            if (fightResult){
                System.out.println("You have no idea what happened. You stand above the dead body of the man you have just killed and realize that prison has turned you completely insane");
                System.out.println("The warden is bamboozled as to what as just happened.");
                System.out.println("You are dealt a life sentence for manslaughter and moved to a maximum security prison. The chances of escape are 0 now. You die a sad lonely death. The end");
                return;
            }
            else {
                System.out.println("The man scoffs as he holds a knife which he has procured out of nowhere to your neck.");
                System.out.println("Your brains explode. You die. The END");
            }
        }
        else if (dominance){
            System.out.println("The man approaches you. He challenges you to a game of Japanese mahjong, and promises you that you will regret it if you don't accept");
            System.out.println("Do you choose to accept? TYpe 1 for yes, Else, type 2");
            Scanner gameInvitation = new Scanner(System.in);
            int gameAccept = Integer.parseInt(gameInvitation.nextLine());
            if (gameAccept == 1){
                System.out.println("Please enter in three numbers from 1-10, which will be your three tiles in the game. Press press the enter bar between two numbers");
                Scanner game = new Scanner(System.in);
                int tileOne = game.nextInt();
                int tileTwo = game.nextInt();
                int tileThree = game.nextInt();
                int winOrLose = japaneseMahjong(tileOne, tileTwo, tileThree);
                if (winOrLose == 1){
                    System.out.println("He smiles at you, and unlocks the door. You have successfully escaped the prison");
                    afterEscape();
                }
                else {
                    System.out.println("He looks at you disappointed, and says you have failed him. You stare at him confused but he disappears right before your eyes leaving you to question your sanity");
                    System.out.println("Suddenly, the WARDEN comes and he is furious at you and says that you have broken his trust. He sends you off to solitary confinement");
                    solitaryConfinement();
                }
            }
            else{
                wallJump();
            }
        }
        else{
            wallJump();
        }
    }
    public static void wallJump(){
        System.out.println("You walk around and find a tall wall, and decide that your best chance of escape is to try and jump onto the wall");
        System.out.println("You successfully make it to the top of the wall, and realize how high the jump down is. Do you return to the prison (type p) or risk it (type r)?");
        Scanner jump = new Scanner(System.in);
        String jumpDecision = jump.nextLine();
        if (jumpDecision.equals("p")){
            System.out.println("Because you are a coward, you decide to go back to prison. You jump and fall onto the ground with a thud");
            System.out.println("You smash your head on the barbed wire and your brain explodes and you die. The end");
            return;
        }
        else {
            System.out.println("You take a deep breath and compose yourself, aiming for the bushes");
            System.out.println("You stand up and realize you are still alive");
            afterEscape();
        }
    }
    public static int japaneseMahjong(int a, int b, int c){
        if ((a == b) || (b == c) || (a == c)){
            return 1;
        }
        else if ((Math.abs(a - b) == 1) || (Math.abs(b - c) == 1) || (Math.abs(a - c) == 1)){
            return 1;
        }
        return 0;
    }
    public static void afterEscape(){
        System.out.println("Yay you've won the game!!!");
        System.out.println("Please enter your name for a congratulatory message");
        Scanner name = new Scanner(System.in);
        System.out.println(congratulatoryMessage(name.nextLine()));
        return;
    }
    public static String congratulatoryMessage(String name){
        return ("Congrats " + name + " for beating my game!");
    }
}
