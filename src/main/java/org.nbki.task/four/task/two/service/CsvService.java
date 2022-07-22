package org.nbki.task.four.task.two.service;

import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import lombok.RequiredArgsConstructor;
import org.nbki.task.four.task.one.FieldCsv;
import org.nbki.task.four.task.two.model.CsvModel;
import org.nbki.task.four.task.two.repository.CsvRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CsvService {

    private static final String PATH = "src//main//resources//";
    private static final String FILE_NAME = "microsoft.csv";
    private static final String FILENAME_SORT = "csvSort.csv";

    private final CsvRepository csvRepository;

    @PostConstruct
    public void sortFieldFidCsvFile() {
        String line;
        String[] cashMass;
/*         Данный метод вытаскивает по одной записи из СSV файла и записывает их в БД
        * это позволяет не перегружать оперативную память.
        * */
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH + FILE_NAME))) {

            while ((line = reader.readLine()) != null) {
                if (line != null && line.charAt(0) != 'F') {
                    cashMass = line.split(";");
                    csvRepository.save(new CsvModel(
                                    Integer.valueOf(cashMass[0]),
                                    cashMass[1],
                                    cashMass[2],
                                    cashMass[3],
                                    cashMass[4],
                                    cashMass[5],
                                    cashMass[6],
                                    cashMass[7]
                            )
                    );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    private void sortSaveScvFile(){

        /*Вытаскиваем из БД необходимые данные и переделываем их в масив строк для сохранения*/
        List<String[]> listString = csvRepository.findAllByOrderFid()
                .stream()
                .map(CsvModel::getMassField)
                .collect(Collectors.toList());

        /* Создаём новый CSV файл */
        try (ICSVWriter writer = new CSVWriterBuilder(
                new FileWriter(PATH+FILENAME_SORT))
                .withSeparator(';')
                .build()){

            /* Записываем в созданный CSV файл отсортированный список*/
            writer.writeNext(FieldCsv.getMassFieldName());
            writer.writeAll(listString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
