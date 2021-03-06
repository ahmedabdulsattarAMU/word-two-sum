package com.amu;

import com.amu.repositories.InMemoryWordRepository;

import java.util.Set;

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
        Set<TwoSumsResult> twoSumsResults = dictionary.findAllTwoSums("deeilnto");
        System.out.println("Two-sum results:");
        int idx = 0;
        for (TwoSumsResult result: twoSumsResults) {
            System.out.println("\tResult " + idx + ": ");
            System.out.print("\t\tWords => ");
            System.out.println(result.getWords());
            System.out.print("\t\tComplement words => ");
            System.out.println(result.getComplementWords() + "\n");
        }
    }
}
