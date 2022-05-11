package ru.gb.java2.task2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 29.04.2022 23:37
 *
 * @author PetSoft
 */
public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String[][] array1 = {
                {"1", "2", "3", "4"},
                {"-1", "-2", "-3", "-4"},
                {"901", "-56", "37", "304"},
                {"2341", "9002", "03", "40089"}};

        String[][] array2 = {
                {"1", "2", "3", "4"},
                {"-1", "10", "-3", "-4"},
                {"901", "-56", "37", "304"},
                {"2341", "9002", "03", "40089"}};

        String[][] array3 = {
                {"1", "2", "3", "4"},
                {"-1", "-2", "-3", "-4"},
                {"901", "-56", "37",},
                {"2341", "9002", "03", "40089"}};

        String[][] array4 = {
                {"1", "2", "3", "4"},
                {"-1", "-2", "-3", "-4"},
                {"901", "String", "37", "45"},
                {"2341", "9002", "03", "40089"}};

        String[][] array5 = {
                {"1", "2", "3", "4"},
                {"-1", "-2", "-3", "-4"},
                {"2341", "9002", "03", "40089"}};

        String[][] array6 = null;

        try {
            Utils.sum(array1, 4);
        } catch (MyArrayDataException | MyArraySizeException e) {
            LOG.error(e.getMessage(), e);
        }

        try {
            Utils.sum(array2, 4);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        }

        try {
            Utils.sum(array3, 4);
        } catch (MyArraySizeException e) {
            LOG.error(e.getMessage(), e);
        }

        try {
            Utils.sum(array4, 4);
        } catch (MyArrayDataException e) {
            LOG.error(e.getMessage(), e);
        }

        try {
            Utils.sum(array5, 4);
        } catch (MyArraySizeException e) {
            LOG.error(e.getMessage(), e);
        }

        try {
            Utils.sum(array6, 4);
        } catch (RuntimeException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
