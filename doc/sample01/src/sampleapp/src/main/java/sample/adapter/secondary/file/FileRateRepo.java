package sample.adapter.file;

import sample.application.domain.*;

import org.apache.commons.csv.*;
import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;

public class FileRateRepo implements IRateRepository {

    private RateEntity[] rateEntityArray;

    public FileRateRepo(String filename) {
        this.rateEntityArray = new RateEntity[2];

        // https://commons.apache.org/proper/commons-csv/
        try (Reader in = new FileReader(filename)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
            int idx = 0;
            for (CSVRecord record : records) {
                int id = Integer.parseInt(record.get(0));
                double rate = Double.parseDouble(record.get(1));
                this.rateEntityArray[idx] = new RateEntity(id, rate);
                if (idx == 1) {
                    break;
                }
                idx++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public RateEntity read(int id) {
        if (id >= rateEntityArray[0].getId() && id < rateEntityArray[1].getId()) {
            return rateEntityArray[0];
        } else {
            return rateEntityArray[1];
        }

    }
}
