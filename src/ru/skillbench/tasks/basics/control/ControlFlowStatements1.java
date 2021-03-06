package ru.skillbench.tasks.basics.control;

public interface ControlFlowStatements1{
    /**
     * Для данного вещественного x найти значение следующей функции f, принимающей вещественные значения:<br/>
     * <pre>
     *        | 2*sin(x), если x>0,
     *  f(x)= |
     *        | 6-x, если x<=0.
     * </pre>
     * @return значение f.
     */
    float getFunctionValue(float x);
    /**
     * Дано целое число в диапазоне 1–7.
     * Вернуть строку — название дня недели, соответствующее этому числу:<br/>
     * 1 — Monday, 2 — Tuesday, 3 - Wednesday, 4 - Thursday, 5 - Friday, 6 - Saturday, 7 - Sunday.
     * @param weekday
     * @return строковое представление weekday
     */
    String decodeWeekday(int weekday);

    /**
     * Создать двумерный массив, содержащий 8x5 целочисленных элементов,
     * и присвоить каждому элементу произведение его индексов: array[i][j] = i*j.
     * @return массив.
     */
    int[][] initArray();
    /**
     * Найти минимальный элемент заданного двумерного массива.
     * @param array массив, содержащий как минимум один элемент
     * @return минимальный элемент массива array.
     */
    int getMinValue(int[][] array);

    /**
     * Начальный размер вклада в банке равен $1000.<br/>
     * По окончанию каждого года размер вклада увеличивается на P процентов (вклад с капитализацией процентов).<br/>
     * По заданному P определить, через сколько лет размер вклада превысит $5000, а также итоговый размер вклада.
     * @param P процент по вкладу
     * @return информация о вкладе (в виде экземпляра класса {@link BankDeposit}) после наступления вышеуказанного условия
     */
    BankDeposit calculateBankDeposit(double P);
    /**
     * Вспомогательный тип для метода {@link ControlFlowStatements1#calculateBankDeposit(double)}.<br/>
     * Примечание: Специальный тип здесь необходим, поскольку метод должен вернуть ДВА значения,
     *  в то время как через аргументы метода значения просто так вернуть нельзя
     *  (передача параметров в методы в Java - только по значению, а не по ссылке).<br/>
     * ВОПРОС: как можно было бы обойтись без специального типа, но вернуть два значения в calculateBankDeposit?
     * (есть несколько способов, возможных с точки зрения синтаксиса, хотя и все они нехороши с точки зрения ООП)
     */
    public static class BankDeposit{
        /**
         * Число полных лет, которые вклад пролежал в банке.
         */
        public int years = 0;
        /**
         * Размер вклада после {@link #years} лет.
         */
        public double amount;

        @Override
        public String toString() {
            return years+" years: $"+amount;
        }
    }
}
