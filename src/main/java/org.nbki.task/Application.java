package org.nbki.task;

import com.opencsv.exceptions.CsvValidationException;
import org.nbki.task.four.task.one.TaskFour;
import org.nbki.task.one.TaskOne;
import org.nbki.task.two.TaskTwo;
import org.nbki.task.three.TaskThree;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/*Доброго дня уважаемые разработчики, подготовил для Вас решение тестового задания,
* огромная просьба указать на допущенные мною ошибки, так как решение тестовых работ
* это тоже опыт =) */

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException {
        /* Задание 1.
        Реализация метода для замены символа в строке
        */
        System.out.println(new TaskOne().replace("HeQQoWorld", 'Q', 'l'));

        /*Задание 2.
        Для перевода String в int используются методы:
        * Integer.parseInt (), Integer.valueOf();
        * для перевода String в double:
        * Double.parseDouble(), Double.valueOf();
        * */
        System.out.println(new TaskTwo().stringToInt("1234"));
        System.out.println(new TaskTwo().stringToDouble("1234.765"));

        /*Задание 3*/
        new TaskThree().fizzBuzz();

        /* Задание 4.
        * Вариант 1, с использованием оперативки
        * Чтение csv файла и сортировка его по первому полю
        *  */
        try {
            new TaskFour().sortFieldFidCsvFile();
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }

        /*Задание 4
        * Вариант 2
        * Для выполнения второго варианта необходимо
        * поочерёдное чтение каждой строки из CSV файла и сохранение её в БД.
        * для этого решил воспользоваться SpringDataJPA, БД выбрал MySQL
        * */
        SpringApplication.run(Application.class, args);
    }
}
