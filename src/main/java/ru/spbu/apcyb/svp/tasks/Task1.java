package ru.spbu.apcyb.svp.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;

@UtilityClass
final class Task1Util {

    /**
     * Перевести строку в сумму.
     */
    public static long strToSum(String str) {
        long result;
        try {
            result = Long.parseLong(str);
        } catch (Exception e) {
            throw new IllegalArgumentException("Ошибка - не целое число!");
        }
        if (result > 0) {
            return result;
        } else {
            throw new ArithmeticException("Ошибка - не натуральное число!");
        }
    }

    /**
     * Преобразование строки в массив.
     */
    public static Long[] strToLongArray(String str) {
        List<Long> notes = new ArrayList<>();
        String[] substrings = str.split(" ");
        for (String tmp : substrings) {
            notes.add(strToSum(tmp));
        }
        Set<Long> uniq = new TreeSet<>(notes);
        notes.clear();
        notes.addAll(uniq);
        notes.sort(Collections.reverseOrder());
        return notes.toArray(new Long[0]);
    }
}

/**
 * Задание 1. Банкомат.
 */
@Log
public class Task1 {

    public static final Scanner IN = new Scanner(System.in);

    /**
     * Поиск всех комбинаций.
     */
    public static int combinations(Long[] banknotes, long sum, long min, String str) {
        int cnt = 0;
        if (sum == 0) {
            log.info(str);
            cnt++;
            return cnt;
        }

        List<Long> newNotes = new ArrayList<>(Arrays.asList(banknotes));
        for (long banknote : banknotes) {
            if (sum - banknote < banknote) {
                newNotes.remove(0);
            }
            if (min >= banknote && sum >= banknote) {
                Long[] tmp = newNotes.toArray(new Long[0]);
                cnt += combinations(tmp, sum - banknote, banknote, str + banknote + " ");
            }
        }
        return cnt;
    }

    /**
     * Разложение строки на массив номиналов.
     */
    public static Long[] readBanknotes() {
        log.info("Введите номиналы через пробел: ");
        String str = IN.nextLine();
        return Task1Util.strToLongArray(str);
    }

    /**
     * Ввод суммы.
     */
    public static long inputSum() {
        log.info("Введите сумму: ");
        String str = IN.nextLine();
        return Task1Util.strToSum(str);
    }

    /**
     * Входная точка в программу.
     */
    public static void main(String[] args) {
        long sum = inputSum();
        Long[] notes = readBanknotes();
        log.info("Комбинации:");
        int cnt = combinations(notes, sum, notes[0], "");
        log.info(() -> "Количество комбинация: " + cnt);
    }
}