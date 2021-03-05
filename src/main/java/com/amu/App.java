package com.amu;

import com.amu.repositories.InMemoryWordRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RepetitionDictionary dictionary = new RepetitionDictionary(new InMemoryWordRepository());
        dictionary.load();
        TwoSumsResult twoSumsResult = dictionary.findAllTwoSums("deeilnto");
        System.out.println("Two-sum results:");
        System.out.print("Words => ");
        System.out.println(twoSumsResult.getWords());
        System.out.print("Complement words => ");
        System.out.println(twoSumsResult.getComplementWords());
    }
}
