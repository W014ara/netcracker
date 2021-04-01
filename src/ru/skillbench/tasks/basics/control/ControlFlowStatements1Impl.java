package ru.skillbench.tasks.basics.control;

import java.util.HashMap;

import static java.lang.Math.sin;

public class ControlFlowStatements1Impl implements ControlFlowStatements1{

    @Override
    public float getFunctionValue(float x) {
        return (x > 0) ? (float)(2 * sin(x)) : (6 - x);
    }

    @Override
    public String decodeWeekday(int weekday) {
        HashMap<Integer, String> dataselect = new HashMap<>();
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for(int index = 0; index < 7; ++index){
            dataselect.put(index + 1, days[index]);
        }
        return (dataselect.get(weekday));
    }

    @Override
    public int[][] initArray() {
        int[][] array = new int[8][5];
        for (int i = 0; i < array.length; ++i) {
            for(int j = 0; j < array[i].length; ++j) {
                array[i][j] = i * j;
            }
        }
        return array;
    }

    @Override
    public int getMinValue(int[][] array) {
        int min = array[0][0];
        for (int[] ints : array) {
            for (int j = 0; j < array[0].length; ++j) {
                if (min > ints[j]) {
                    min = ints[j];
                }
            }
        }
        return min;
    }

    @Override
    public BankDeposit calculateBankDeposit(double P) {
        BankDeposit target_obj = new BankDeposit();
        target_obj.amount = 1000;
        while (target_obj.amount <= 5000){
            target_obj.amount = target_obj.amount + (target_obj.amount * P / 100);
            target_obj.years++;
        }
        return target_obj;
    }
}
