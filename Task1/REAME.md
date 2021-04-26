# Практическое задание по Java SE 2.1 :coffee:

## Задание 1
```
Создайте класс Vectors, содержащий статические методы работы с
векторами:

* умножения вектора на скаляр,
* сложения двух векторов,
* нахождения скалярного произведения двух векторов.
```
## Задание 2

```
Модифицируйте класс Vectors, добавив в него новые методы:
* записи вектора в байтовый поток void outputVector(Vector v, OutputStream out),
* чтения вектора из байтового потока Vector inputVector(InputStream in),
* записи вектора в символьный поток void writeVector(Vector v, Writer out),
* чтения вектора из символьного потока Vector readVector(Reader in).

В обоих случаях записанный вектор должен представлять собой
последовательность чисел, первым из которых является размерность
вектора, а остальные числа являются значениями координат вектора.
В случае символьного потока рекомендуется считать, что один вектор
записывается в одну строку (числа разделены пробелами). Для чтения
вектора из символьного потока рекомендуется использовать класс
StreamTokenizer.
Проверьте возможности методов (в методе main), в качестве реальных
потоков используя файловые потоки, а также потоки System.in и
System.out.
```
## Задание 3
```
Модифицируйте классы ArrayVector и LinkedListVector
(основанные на массиве и на связном списке) таким образом, чтобы они
были сериализуемыми.
Продемонстрируйте возможности сериализации (в методе main),
записав в файл объект, затем считав и сравнив с исходным (по
сохраненным значениям).
```
## Задание 4
```
Напишите MyClassToBePersisted.java, который содержит
следующие свойства
* Поле профиля
* Поле группы
Напишите SerializeMyClassToBePersisted.java, который создает экземпляр класса MyClassToBePersisted и сериализует его
в файл в своем основном методе.
Напишите DeserializeMyClassToBePersisted.java, который считывает сериализованный файл и десериализует его в экземпляр
класса MyClassToBePersisted в своем основном методе.
```

# Структура проекта

```
│   REAME.md
│   Task1.iml
│   test.bin
│   test.txt
│   test4.bin
│   
├───.idea
│       .gitignore
│       misc.xml
│       modules.xml
│       uiDesigner.xml
│       workspace.xml
│
├───out
│   └───production
│       └───Task1
│           └───netcracker
│               └───Task1
│                   │   Main.class
│                   │
│                   ├───subTask1and2
│                   │       Vectors.class
│                   │
│                   ├───subTask3
│                   │       ArrayVector.class
│                   │       LinkedListVector.class
│                   │
│                   └───subTask4
│                           DeserializeMyClassToBePersisted.class
│                           MyClassToBePersisted.class
│                           SerializeMyClassToBePersisted.class
│
└───src
    └───netcracker
        └───Task1
            │   Main.java
            │
            ├───subTask1and2
            │       Vectors.java
            │
            ├───subTask3
            │       ArrayVector.java
            │       LinkedListVector.java
            │
            └───subTask4
                    DeserializeMyClassToBePersisted.java
                    MyClassToBePersisted.java
                    SerializeMyClassToBePersisted.java
```