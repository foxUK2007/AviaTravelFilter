package com.gridnine.testing;

import com.gridnine.testing.type.FilterByType;

public class Main {
    public static void main(String[] args) {
        /**
         * takeBeforePT - Исключает вылеты до текущего момента времени
         * landBeforeTake - Исключает сегменты с датой прилёта раньше даты вылета
         * more2Hours - Исключает перелеты, где общее время, проведённое на земле превышает два часа
         * Допускается комбинация фильтров через аргументы метода flightFilter
         */

        System.out.println("1.Исключены вылеты до текущего момента времени");
        System.out.println(FilterByType.flightFilter("takeBeforePT"));

        System.out.println("2.Исключены сегменты с датой прилёта раньше даты вылета");
        System.out.println(FilterByType.flightFilter("landBeforeTake"));

        System.out.println("3.Исключены перелеты, где общее время, проведённое на земле превышает два часа");
        System.out.println(FilterByType.flightFilter("more2Hours"));
    }
}