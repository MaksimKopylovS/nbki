package org.nbki.task.four.task.one;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TaskFour {

    private static final String PATH = "src//main//resources//";
    private static final String fileName = "microsoft.csv";
    private static final String fileNameSort = "csvSort.csv";

    /* Метод сортировки и записи файла в директорию*/
    public void sortFieldFidCsvFile() throws IOException, CsvValidationException {

        /* Получаем список списков строк из CSV файла, по указанному пути */
        List<List<String>> list = readeCSV(PATH+fileName);

        /* Сортируем список моделей CSV и переделываем его в список массива строк*/
        List<String[]> listString = createListCsvModel(list)
                .stream()
                .sorted(Comparator.comparing(CsvModel::getFid))
                .map(CsvModel::getMassField)
                .collect(Collectors.toList());

        /* Создаём новый CSV файл */
        ICSVWriter writer = new CSVWriterBuilder(
                new FileWriter(PATH+fileNameSort))
                .withSeparator(';')
                .build();

        /* Записываем в созданный CSV файл отсортированный список*/
        writer.writeNext(FieldCsv.getMassFieldName());
        writer.writeAll(listString);
        writer.close();
    }

    /* Чтение CSV файла по указанному пути, и вывод в список списков строк */
    private List<List<String>> readeCSV(String path) throws IOException, CsvValidationException {
        CSVReader reader = new CSVReader(new FileReader(path));
        String[] nextLine;
        List<List<String>> list = new LinkedList<>();

        while ((nextLine = reader.readNext()) != null) {
            if (nextLine != null) {
                list.add(Arrays.asList(Arrays.toString(nextLine).split(";")));
            }
        }
        return list;
    }

    /* Редактирование списка списков строк в список моделей CSV*/
    private List<CsvModel> createListCsvModel(List<List<String>> list){
        List<CsvModel> csvModels = new LinkedList<>();

        for (int i = 1; i < list.size(); i++) {

            csvModels.add(new CsvModel(
                            Integer.parseInt(list.get(i).get(0).replaceAll("^\\[|\\]$", "")),
                            list.get(i).get(1),
                            list.get(i).get(2),
                            list.get(i).get(3),
                            list.get(i).get(4),
                            list.get(i).get(5),
                            list.get(i).get(6),
                            list.get(i).get(7).replaceAll("^\\[|\\]$", "")
                    )
            );
        }
        return csvModels;
    }

}
