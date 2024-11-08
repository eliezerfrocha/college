import java.util.Scanner;

/**
 * 1049 - Animal
 * In this problem, your job is to read three Portuguese words. These words
 * define an animal according to the table below,
 * from left to right. After, print the chosen animal defined by these three
 * words.
 * 
 * Input:
 * The input contains 3 words, one by line, that will be used to identify the
 * animal, according to the above table,
 * with all letters in lowercase.
 * -
 * Output:
 * Print the animal name according to the given input.
 */
public class Animal {
    public static void main(String[] args) {
        System.out.println();
        Scanner s = new Scanner(System.in);

        String word1 = s.next();
        String word2 = s.next();
        String word3 = s.next();
        String response = "";

        s.close();

        switch (word1) {
            case "vertebrado":
                switch (word2) {
                    case "ave":
                        response = word3.equals("carnivoro") ? "aguia" : "pomba";
                        break;
                    case "mamifero":
                        response = word3.equals("onivoro") ? "homem" : "vaca";
                        break;
                }
                break;
            case "invertebrado":
                switch (word2) {
                    case "inseto":
                        response = word3.equals("hematofago") ? "pulga" : "lagarta";
                        break;
                    case "anelideo":
                        response = word3.equals("hematofago") ? "sanguessuga" : "minhoca";
                        break;
                }
                break;
        }

        System.out.println(response);
        System.out.println();
    }
}