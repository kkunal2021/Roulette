package com.kunal.rest.csv;

import java.io.File;

/**
 * @author kunal
 */

public class CsvRepository {

    private final File inputFile;

    public CsvRepository(final File inputFile) {
        this.inputFile = inputFile;
    }
}
