package com.amu.repositories;

import com.amu.Word;

import java.util.List;

public class FileWordRepository implements WordRepository {
    @Override
    public List<Word> getAll() {
        //@Todo: read from a file
        return null;
    }
}
