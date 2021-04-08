# Короткие, но хитрые задачки

# Задача №1
Имеется простой класс, объявленный в файле HelloWorld.java:
```
public class HelloWorld extends Object{
    public static void main(String... args) {
        System.out.println("Hello, World!");
    }
}
```
Класс компилируется стандартными средствами компиляции Java:
```
javac HelloWorld.java
```
После чего запускется также стандартно:
```
java HelloWorld
```
В результате чего ожидаемо появляется сообщение
```
Hello, World!
```
<u>Задание:</u><br>
Не изменяя текста класса HelloWorld (вообще не редактируя файла HelloWord.java), сделать так,
чтобы запуск программы не приводил к этому «ожидаемому» результату. То есть после запуска
```
java HelloWorld
```
Выводилось, например
```
Good Bye, Universe!
```
При необходимости сам класс HelloWorld.java можно перекомпилировать.
Дополнительные замечания:
Задачу можно решить более чем одним способом.
Как еще можно решить задачу, если предположить, что можно редактировать файл
HelloWorld.java, но нельзя трогать метод main (т. е. не менять его сигнатуры и тела)?
<br><br><br>

# Задача №2 «Сдача»
Имеется текстовая задача:
Вася идет в магазин за батоном, который стоит 1р. 10коп. В кармане у Васи есть лишь горстка
двухрублевых монет. Сколько он должен получить на сдачу с двух рублей за один батон?
Вот код программы, решающей эту задачу.
```
public class Change {
    public static void main(String args[]) {
        System.out.println(2.00 - 1.10);
    }
}
```
Сколько сдачи дадут Васе в результате? Можете ли вы помочь (изменить программу)?
<br><br><br>

# Задача №3 «Смысл жизни»
Как известно, в Java объекты принято сравнивать через object.equals(anotherObject), не полагаясь на
равенство ссылок на эти объекты. Ибо сравнение по ссылкам дает «неверный» результат.
Вашему вниманию предлагается занимательное математическое исследование:
```
    Integer i = 42;
    Integer j = 42;
    java.lang.System.out.println(i + " = " + j + " : " + (i == j));
    i = 142;
    j = 142;
    java.lang.System.out.println(i + " = " + j + " : " + (i == j));
```
Вопрос: чем же так особенно число 42, помимо ответа на главный вопрос жизни, вселенной и всего
такого? Как объясняется результат работы кода, приведенного выше?
<br><br><br>

# Задача №4 «Что в имени тебе моем?»
Помогите голливудской звезде найти себя в списке приглашенных на церемонию вручения «Оскара»
(измените программу так, чтобы выдавала true).
```
    public class Name {
        private String first, last;
        public Name(String first, String last) {
            this.first = first;
            this.last = last;
        }
        public boolean equals(Object o) {
            if (!(o instanceof Name))
                return false;
            Name n = (Name) o;
            return n.first.equals(first) && n.last.equals(last);
        }
        public static void main(String[] args) {
            java.util.Set s = new java.util.HashSet();
            s.add(new Name("Brad", "Pitt"));
            System.out.println(s.contains(new Name("Brad", "Pitt")));
        }
    }
```
