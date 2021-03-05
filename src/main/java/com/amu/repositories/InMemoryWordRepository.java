package com.amu.repositories;

import com.amu.Word;

import java.util.Arrays;
import java.util.List;

public class InMemoryWordRepository implements WordRepository {

    @Override
    public List<Word> getAll() {
        return Arrays.asList(
                new Word("ahmed"),
                new Word("adrien"),
                new Word("julien"),
                new Word("elon"),
                new Word("leon"),
                new Word("melon"),
                new Word("juice"),
                new Word("lemon"),
                new Word("tied"),
                new Word("car"),
                new Word("diet"),
                new Word("aim"),
                new Word("mia")
        );
    }
}
