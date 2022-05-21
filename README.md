# job4j_design
Junior level educational projects - job4j, February 2022
The project will encompass a profound study and pet project, demonstrating the key notions in Java, like data structures (Collections, Map) and algorythms, 
logging, sockets, serialization, setting PostGreSQL, JDBC. Additional information on the pet project details is to be added while studying and practicing

[Generics, wild card, bounded and lower bounded wildcard](https://github.com/Frenchfan/job4j_design/commit/70b970f7d318c0db728e59d5f85abff4d9fe7a2d) - extends the strictly predefined use of types by implementing the <?> (wildcard) approach, which helps reating universal methods.

## Collections Pro

#### part 1. [Collections Lite](CollectionsLite.md#collections-lite)

[1. Что такое генерики?](#1-Что-такое-генерики)

[2. Типы генериков?](#2-Типы-генериков)

[3. Где хранится информация про Generics?](#3-Где-хранится-информация-про-Generics)

[4. Как можно получить тип Generics?](#4-Как-можно-получить-тип-Generics)

[5. Что такое итератор?](#5-Что-такое-итератор)

[6. Что такое коллекции?](#6-Что-такое-коллекции)

[7. Назовите базовые интерфейсы коллекций?](#7-Назовите-базовые-интерфейсы-коллекций)

[8. Расскажите реализации интерфейса List?](#8-Расскажите-реализации-интерфейса-List)

[9. Расскажите реализации интерфейса Set?](#9-Расскажите-реализации-интерфейса-Set)

[10. Расскажите реализации интерфейса Map?](#10-Расскажите-реализации-интерфейса-Map)

[11. Отличие ArrayList от LinkedList?](#11-Отличие-ArrayList-от-LinkedList)

[12. Отличие Set от List?](#12-Отличие-Set-от-List)

[13. Расскажите про методы Object hashCode и equals?](#13-Расскажите-про-методы-Object-hashCode-и-equals)

[14. Расскажите про реализации Map?](#14-Расскажите-про-реализации-Map)

[15. Расскажите, что такое коллизии в Map? Как с ними бороться?](#15-Расскажите-что-такое-коллизии-в-Map-Как-с-ними-бороться)

[16. Расскажите, что такое анализ алгоритма?](#16-Расскажите,-что-такое-анализ-алгоритма)

[17. Какая временная сложность алгоритмов(O-нотация) добавления, замены и удаления в каждой из коллекций? С чем связаны отличия?](#17-Какая-временная-сложность-алгоритмов-добавления,-замены-и-удаления-в-каждой-из-коллекций-С-чем-связаны-отличия)

[18. Расскажите реализации данных очередей и стеков?](#18-Расскажите-реализации-данных-очередей-и-стеков)

[19. Расскажите про реализации деревьев?](#19-Расскажите-про-реализации-деревьев)

[20. Что такое loadFactor?](#20-Что-такое-loadFactor)

[21. Пример какова сложность поиска значения по ключу?](#21-Пример-какова-сложность-поиска-значения-по-ключу)

[22. Расскажите правило для переопределения метода hashCode?](#22-Расскажите-правило-для-переопределения-метода-hashCode)

[23. Приведите пример переопределения hashCode?](#23-Приведите-пример-переопределения-hashCode)

[24. Как вычисляется hash функция от объекта в HashMap?](#24-Как-вычисляется-hash-функция-от-объекта-в-HashMap)

[25. Правила проверки при переопределении метода equals?](#25-Правила-проверки-при-переопределении-метода-equals)

[26. Как устроена HashMap?](#26-Как-устроена-HashMap?)

[27. Какое начальное количество корзин в HashMap?](#27-Какое-начальное-количество-корзин-в-HashMap)

[28. Какая оценка временной сложности выборки элемента из HashMap? Гарантирует ли HashMap указанную сложность выборки элемента?](#28-Какая-оценка-временной-сложности-выборки-элемента-из-HashMap-Гарантирует-ли-HashMap-указанную-сложность-выборки-элемента)

[29. Роль equals и hashCode в HashMap?](#29-Роль-equals-и-hashCode-в-HashMap)

[30. Как и когда происходит увеличение количества корзин в HashMap?](#30-Как-и-когда-происходит-увеличение-количества-корзин-в-HashMap)

[31. Как работает HashMap?](#31-Как-работает-HashMap)

[32. Что такое хеш таблицы?](#32-Что-такое-хеш-таблицы)

[33. Что такое красно-черное дерево?](#33-Что-такое-красно-черное-дерево)

[34. Удаление элемента из дерева?](#34-Удаление-элемента-из-дерева)

[35. Какие существуют алгоритмы обхода дерева?](#35-Какие-существуют-алгоритмы-обхода-дерева)

## 1. Что такое генерики?

Обобщенное программирование - это подход к описанию данных и алгоритмов, позволяющий использовать их с разными типами
данных без изменения их описания.

**Обобщения** - это параметризованные типы. С их помощью можно объявлять классы, интерфейсы и методы, где тип данных 
указан в виде параметра. 

Дженерики позволяют типам (классам и интерфейсам) быть параметрами при определении классов, интерфейсов и методов.
Параметры типа предоставляют возможность повторно использовать один и тот же код с разными входами наподобие формальных 
параметров в объявлениях методов. Разница в том, что входные данные для формальных параметров являются значениями, а
для дженериков - типами данных. Переменная типа может быть любым не примитивным типом.

В Java дженерики добавили для реализации обобщенных коллекций, безопасных с точки зрения типов.
Ошибка компиляции - это лучше, чем исключение `ClassCastException` в связи с неправильным приведением типов во время выполнения.
После компиляции какая-либо информация о дженериках стирается. Это называется "Стирание типов".
Также дженерики делают исходный код программы более удобочитаемым.

Свойства дженериков: строгая типизация, единая реализация, отсутствие информации о типе.

В `Java Collections Framework`используются обобщенные типы, например, класс типа `LinkedList<E>` - обобщенный тип. 
Параметр `<E>` предсталяет тип элементов, которые будут храниться в коллекции.

`LinkedList<String>`, `LinkedList<Integer>` - это параметризованные типы, а `String`, `Integer` - реальные типы аргументов.

наглядно из Effective Java:

![img](https://github.com/johnivo/job4j/blob/master/interview_questions/src/main/resources/pro_1.png)

[к оглавлению](#Collections-Pro)

## 2. Типы генериков?

Существует 2 типа дженериков:

+ **<Т> Обычные дженерики (параметризованные типы)** - представляет возможность указать в классе или методе 
неопределенный тип или несколько типов, дать ему имя, котрое в дальнейшем можно использовать в рамках класса или метода, 
как эквивалентное оригинальному типу. 

    Может быть использован с ключевым словом `extends`, ограничен этим классом и его наследниками. 
Так же можно использовать & и/или | указать несколько классов и/или интерфейсов. 
Поддерживает рекурсивное расширение типов.

`public static class NumberContainer<T extends Number & Comparable> {`

+ **<?> Wildcard (подстановочные типы или маски)** - используются в сигнатуре методов, но для параметризации класса - нет! 
Может быть использован в сочитании ключевыми словами `extends` и `super`. Делятся на три типа:
    
    + Upper Bounded Wildcards `<? extends Number>`
    
    + Unbounded Wildcards `<?>`
    
    + Lower Bounded Wildcards `<? super Integer>` 
    
Для выбора типа используют принцип PECS (`Producer Extends` `Consumer Super`)
+ `extends` - когда надо только получать данные из объекта. Метод передает данные в аргумент.
+ `super` - когда надо надо только вставлять данные в объект. Метод читает данные из аргумента.
+ не использовать `wildcard`, когда требуется и получать и вставлять данные в структуру. 

[к оглавлению](#Collections-Pro)

## 3. Где хранится информация про Generics?

Только в исходном коде до момента компиляции.

[к оглавлению](#Collections-Pro)

## 4. Как можно получить тип Generics?

```java
.getGenericSuperclass()
Class<T> t = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
```

[к оглавлению](#Collections-Pro)

## 5. Что такое итератор?

Это шаблон проектирования для прохода по всем элементам множества
Основные методы:
+ `hasNext()` - существует ли следующий элемент.
+ `next()` - возвращает сам элемет.

В стандартной библиотеке java существует 2 интерфейса это `Iterable` и `Iterator`. 
+ `Iterable` - вынуждает релизовать метод возвращающий итератор.
+ `Iterator` - вернуть объект итератора.

[к оглавлению](#Collections-Pro)

## 6. Что такое коллекции?

Это хранилища объектов с динамическим размером, и разным временем на разные операции: поиск, вставка, удаление.

[к оглавлению](#Collections-Pro)

## 7. Назовите базовые интерфейсы коллекций?

+ **`Collection`** - коллекция содержит набор объектов (элементов). 
Здесь определены основные методы для манипуляции с данными, 
такие как вставка (`add`, `addAll`), удаление (`remove`, `removeAll`, `lear`), поиск (`contains`). 

+ **`Map** - описывает коллекцию, состоящую из пар "ключ — значение". У каждого ключа только одно значение.

[к оглавлению](#Collections-Pro)

## 8. Расскажите реализации интерфейса List?

+ **`ArrayList`** - на массиве с несинхронизированными методами.

+ **`Vector`** - на массиве с синхронизированными методами.

+ **`Stack`** - на массиве есть синхронизированные методы но не все.

+ **`LinkedList`** - двусвязный список.

[к оглавлению](#Collections-Pro)

## 9. Расскажите реализации интерфейса Set?

**`Set`** - набор/множество, не может содержать дубликаты.

+ **`HashSet`** - основан на `HashMap`.

+ **`LinkedHashSet`** - расширяет `HashSet`, позволяет получать элементы в порядке их добавления, но требует больше памяти.

+ **`TreeSet`** - основан на сбалансированном двоичном дереве, в результате элементы упорядочены по возрастанию `hashCode()`'ов. 
Можно управлять порядком при помощи компаратора.

[к оглавлению](#Collections-Pro)

## 10. Расскажите реализации интерфейса Map?

+ **`HashMap`** - не синхронизированная хэш-таблица (быстрая).

+ **`LinkedHashMap`** - упорядоченная хэш-таблица с порядком итерирования в порядке добавления.

+ **`TreeMap`** - Упорядоченная по ключам. Основана на красно-черных деревьях. Может использовать компаратов в конструкторе. 

[к оглавлению](#Collections-Pro)

## 11. Отличие ArrayList от LinkedList?

**`ArrayList` - основан на динамическом массиве**, хранит свои элементы в массиве. 
(используют, если элементы чаще читаются, чем добавляются)

**+** Быстрая навигация по коллекции - осуществляется быстрый поиск элементов;

**+** меньше расходует памяти на хранение элементов;

**-** увеличение `ArrayList` происходит медленно;

**-** при вставке или удалении элемента в середину или в начало, приходится переписывать все элементы;

**`LinkedList` - двунаправленный список (цепочка)**, хранит элементы в объектах `Node<E>`, у которых есть ссылки на 
предыдущий и следующий элементы (используют, если элементы чаще добавляются, чем читаются) 

**+** быстрая вставка и удаление в середину списка (переписать `next` и `previous` и всё);

**-** долгий поиск в середине (нужно перебрать все элементы);

Очевидно, что плюсы одного являются минусами второго.
В среднем, сложности одинаковые, но все же ArrayList предпочтительнее использовать. 
`LinkedList` рекомендуется использовать, только когда преобладает удаление или вставка в начало или конец списка.

[к оглавлению](#Collections-Pro)

## 12. Отличие Set от List?

+ **`Set`** - множество, не хранит дубликаты. 

+ **`List`** - список, может содержать дубли.

[к оглавлению](#Collections-Pro)

## 13. Расскажите про методы Object hashCode и equals?

Метод `hashCode()` используется для числового представления объекта, метод `equals()` для сравнения двух объектов.
При переопределении метода `equals()` всегда переопределяют `hashCode()`.
Если метод `equals()` возвращает `true`, то `hashCode()` всегда равны, но не наоборот, потому что 
возможны коллизии, когда для разных объектов будет одинаковый `hashCode()`. *"Множество объектов мощнее множества хеш-кодов."* 
Множество возможных хеш-кодов ограничено диапазоном примитивного типа `int` `2^32`, а множество объектов ничем не ограничено. 
    
**Метод `equals()` переопределяется так:** 
1. Не равны ли ссылки.
2. Не равен `null`.
3. Проверяем что объекты от одного класса.
4. Не равны ли `hashCode`.
5. Не равны состояния полей.
    
**Метод `hashCode()` переопределяется так:**
1. Простое нечетное число (31 популярно).
2. Умножаем результат на другое простое нечетное число (популярно 17).
прибавляем хэш-код поля, которое относится к бизнес логике.
3. Повторяем пункт 2 пока не кончатся поля которые относятся к бизнес-логике.

[к оглавлению](#Collections-Pro)

## 14. Расскажите про реализации Map?

+ **`HashMap`** - основан на хэш-таблицах. Ключи и значения могут быть любых типов, в том числе и `null`. 
Данная реализация не дает гарантий относительно порядка элементов

+ **`LinkedHashMap`** - расширяет класс **`HashMap`**. 
Он создает связный список элементов в карте, расположенных в том порядке, в котором они вставлялись.

+ **`TreeMap`** - Он создает коллекцию, которая для хранения элементов применяет дерево. 
Объекты сохраняются в отсортированном порядке по возрастанию. 
Время доступа и извлечения элементов достаточно мало, что делает класс `TreeMap` отличным выбором для хранения 
больших объемов отсортированной информации

[к оглавлению](#Collections-Pro)

## 15. Расскажите, что такое коллизии в Map Как с ними бороться?

**Хеширование** — преобразование массива входных данных произвольной длины в (выходную) битовую строку установленной длины, 
выполняемое по определенному алгоритму. Функция, воплощающая этот алгоритм и выполняющая преобразование, 
называется хеш-функцией. Хеш-код - это результат вычисления хеш-функции. 

Коллизия - это ситуация, когда не эквивалентные элементы имеют одинаковые хеш-коды. Возникает оттого, что количество 
значений хеш-функций меньше (ограничены диапазоном значений типа `int 2^32`), чем вариантов исходных данных. 
Вероятность возникновения коллизий оценивает качество хеш-функций.

В Java для разрешения коллизий используется модифицированный метод цепочек. Суть: когда количество элементов в корзине 
превышает определенное значение, данная корзина переходит от использования связного списка к использованию 
сбалансированного дерева. Но данный метод имеет смысл лишь тогда, когда на элементах хеш-таблицы задан линейный порядок. 
Т.е. при использовании данных типа `int` или `double` имеет смысл переходить к дереву поиска, а при использовании 
каких-нибудь ссылок на объекты не имеет, т.к. они не реализуют нужный интерфейс. 
Такой подход позволяет улучшить производительность с `O(n)` до `O(log(n))`. 
Данный способ используется в таких коллекциях как `HashMap`, `LinkedHashMap` и `ConcurrentHashMap`.

По простому:

**Коллизия** - это когда для двух объектов вычисляется одинаковый хеш-код.
 
Решение: проверить методом `equals()`, что ссылки на объекты не равны. 
Для хэш-таблицы в ту же ячейку добавляется еще один объект, за счет того что каждая ячейка - это связанный список.

[к оглавлению](#Collections-Pro)

## 16. Расскажите что такое анализ алгоритма?

Анализ алгоритма дает нам понимание того, сколько времени займет решение данной задачи при помощи данного алгоритма. 
Эффективность алгоритма оценивается его временной сложностью.

Временная сложность алгоритма – это функция, позволяющая определить, 
как быстро увеличивается время работы алгоритма с увеличением объёма данных.

Наиболее часто встречающиеся классы сложности:
+ `O(1)` – константная сложность (т.е. константное время);
+ `О(n)` – линейная сложность;
+ `О(nа)` – полиномиальная сложность;
+ `О(log(n))` – логарифмическая сложность;
+ `O(n*log(n))` – квазилинейная сложность;
+ `O(2n)` – экспоненциальная сложность;
+ `O(n!)` – факториальная сложность.

[к оглавлению](#Collections-Pro)

## 17. Какая временная сложность алгоритмов добавления, замены и удаления в каждой из коллекций С чем связаны отличия?

![img](https://github.com/johnivo/job4j/blob/master/interview_questions/src/main/resources/pro_2.png)

+ **`ArrayList`:** индекс - `O(1)`, поиск `O(n)`, вставка `O(n)`, удаление `O(n)`.

+ **`LinkedList`:** индекс - `O(n)`, поиск `O(n)`, вставка `O(1)`, удаление `O(1)`.

+ **Деревья** для всех операций - `O(log(n))`.

+ **Хэш таблицы** для всех операций - `O(1)`, если не считать коллизии.

Справочник по Java Collections Framework https://habr.com/ru/post/237043/

[к оглавлению](#Collections-Pro)

## 18. Расскажите реализации данных очередей и стеков?

+ **`Queue` (FIFO)** - одностороняя очередь, элементы можно получить в том порядке в котором добавляли.

+ **`Dequeue`** - двусторонняя очередь, можно вставлять/получать элементы из начала и конца. 

+ **`Stack` (LIFO)** - стек, можно получить только последний элемент.

```
Queue<Integer> myQ = new LinkedList<Integer>();
```

[к оглавлению](#Collections-Pro)

## 19. Расскажите про реализации деревьев?

+ **`TreeMap`** - упорядоченная по ключам. Основана на красно-черных деревьях. Может использовать компаратор в конструкторе. 
Красно-черные дерево - это самобалансирующееся дерево, которое гарантирует логарифмический рост высоты дерева от числа узлов.

+ **`TreeSet`** - основан на сбалансированном двоичном дереве, в результате элементы упорядочены по возрастанию хеш-кодов. 
Можно управлять порядком при помощи компаратора.

[к оглавлению](#Collections-Pro)

## 20. Что такое loadFactor?

**loadFactor** - это коэффициент загрузки, равен соотношению `(размер коллекции / колличество элементов)`. 
При достижении порогового значения размер коллекции увеличивается.

Например, в хеш-таблице поле, которое показывает на сколько заполнен массив, на котором эта таблица основана. 
Если на 3/4, то создается новый массив с большим размером и данные перераспределяются. 

[к оглавлению](#Collections-Pro)

## 21. Пример какова сложность поиска значения по ключу?

**Пример:** разработчик создал класс
```java
class User {
    private int age;
    private String name;
    private String email;

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return age == user.age &&
    Objects.equals(name, user.name) &&
    Objects.equals(email, user.email);
}

@Override
public int hashCode() {
    return 1;
}
```
и затем создал 60 разных объектов которые использовал в качестве ключа в мапе
какова сложность поиска значения по ключу в таком случае и почему
java >= 1.8

**Ответ:**
Хеш-код у нас константа - худший вариант, т.е. все объекты находятся в одном бакете и хеш-таблица превращается в связный 
список со сложностью поиска `О(n)`. Т.к. версия java >= 1.8 то, когда количество элементов в бакете достигает 
определенной величины (`TREEIFY_THRESHOLD = 8`), вместо связанного списка используется сбалансированное дерево. 
Соответственно у нас `n=60 > 8`.

Поэтому в данном случае временная сложность поиска по ключу составит `О(log(n))`.

[к оглавлению](#Collections-Pro)

## 22. Расскажите правило для переопределения метода hashCode?

Необходимо перекрывать `hashCode` каждый раз, когда выполняется перекрытие `equals`, иначе программа может работать неправильно. 
Метод `hashCode` должен подчиняться общему контракту, определенному в `Object`, и выполнять разумную работу по назначению 
неравным экземплярам разных значений хеш-кодов. 

Главным условием при перекрытии метода `hashCode`: равные объекты должны давать одинаковый хеш-код. 
Два различных экземпляра с точки зрения метода `equals` могут быть логически эквивалентными, 
однако для метода `hashCode` класса `Object` оказаться всего лишь двумя объектами, не имеющими между собой ничего общего.

1. Объявить переменную типа `int` с именем `result` и инициализировать ее хеш-кодом с (identity hash code) 
для первого значащего поля объекта.

2. Для каждого из остальных значащих полей нужно:

    а. Вычислить хеш-код с типа `int` для такого поля.

    б. Объединить хеш-код с, вычисленный в п. 2, а, с `result` следующим образом: `result = 31 * result + с;`

3. Вернуть `result`.

Примечание: Производные поля можно из вычисления хеш-кода исключить, т.е. можно игнорировать любое поле, 
значение которого может быть вычислено из полей, включаемых в вычисления. Необходимо исключить любые поля, 
которые не используются в сравнении методом `equals`, иначе есть риск нарушить второе положение контракта `hashCode`. 
Умножение в п. 2б делает результат зависящим от порядка полей и дает гораздо лучшую хеш-функцию, 
если класс имеет несколько аналогичных полей. 
Значение 31 выбрано потому, что оно является нечетным простым числом, это традиционная практика, 
кроме того повышает производительность (умножение можно заменить сдвигом и вычитанием).

[к оглавлению](#Collections-Pro)

## 23. Приведите пример переопределения hashCode?

Например, переопределим `hashCode` для класса PhoneNumber:
```java
public final class PhoneNumber {
    private final short areaCode, prefix, lineNum;
    public PhoneNumber(int areaCode, int prefix, int lineNum) {
         this . areaCode = rangeCheck (areaCode, 999, ’’area code”);
         this.prefix = rangeCheck (pref ix, 999, ’’prefix’’);
         this.lineNum = rangeCheck(lineNum, 9999, "line num”);}

   // Типичный метод hashCode
   @Override public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31* result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;}

   // Однострочный метод hashCode с посредственной производительностью. Этот стиль хеш-функции рекомендуется использовать только в ситуациях, когда производительность не является критической.
   @Override public int hashCode() {
       return Objects.hash(lineNum, prefix, areaCode);}

   // Метод hashCode с отложенной инициализацией и кешированием хеш-кода. Если класс является неизменяемым, а стоимость вычисления хеш-функции имеет значение, вы можете подумать о хранении хеш-кода в самом объекте вместо того, чтобы вычислять его заново каждый раз, когда в нем появится необходимость.
   private int hashCode; // Автоматически инициализируется значением 0
  @Override public int hashCode() {
      int result = hashCode;
      if (result == 0) {
         result = Short.hashCode(areaCode);
         result =31* result + Short.hashCode(prefix) ;
         result =31* result + Short.hashCode(lineNum);
         hashCode = result;}
      return result;}

}
```

Контракт `hashCode` из спецификации `Object`:

+ Во время выполнения приложения при многократном вызове для одного и того же объекта метод `hashCode` 
должен всегда возвращать одно и то же целое число при условии, что никакая информация, 
используемая при сравнении этого объекта с другими методом equals, не изменилась. 
Однако не требуется, чтобы это же значение оставалось тем же при другом выполнении приложения.

+ Если два объекта равны согласно результату работы `equals(Object)`, то при вызове для каждого из них метода 
`hashCode` должны получиться одинаковые целочисленные значения.

+ Если метод `equals(Object)` утверждает, что два объекта не равны один другому, это не означает, что метод `hashCode` 
возвратит для них разные числа. Однако программист должен понимать, что генерация разных чисел для неравных 
объектов может повысить производительность хеш-таблиц.

[к оглавлению](#Collections-Pro)

## 24. Как вычисляется hash функция от объекта в HashMap?

```java
static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
```
в методе `hash()` cначала вычисляется промежуточное значение `h`, 
оно равно хеш-функции от ключа (для `HashMap` в базовой реализации `Object.hashCode()`), 
затем вычисляется значение, равное нулевому побитовому сдвигу числа `h` вправо на 16 бит с заполнением нулями 
(`>>>` все биты числа сдвигаются вправо на 16 позиций, освободившиеся биты заполняются нулями), 
и для вычисленных выше значений выполняется операция `XOR` (^ побитовое логическое или).

В методе коллекции, при поиске бакета/корзины/индекса хеш-код ключа делится с остатком (`%`) на размер хеш-таблицы 
(по умолчанию `n=16`) и результатом будет число в диапазоне от `0` до `n`, 
т.е. номер ячейки в массиве, куда помещается объект с нашим ключом. 
А т.к. для `HashMap` размер хеш-таблицы равен степени 2, то вместо `%n` (остатка от деления) 
используется более быстрый `&(n-1)` (побитовое И).

Т.е. вместо `index = hash % (n - 1)` используется `index = (n - 1) & hash`

Примечание: побитовый сдвиг `>>>` и операция `XOR` выполняются для того, 
чтобы старшие биты первоначального хеш-кода `h` в дальнейшем участвовали в `(n - 1) & hash` даже при небольшом кол-ве бакетов. 
Этим обеспечивают не само по себе наилучшее распределение в хеш-таблице, а страхуются от неудачной функции `hashcode()`.

**Итого:** Через `%` или `&` вычисляется "внешний" `hash` (находим бакет/корзину/индекс в массиве),
 через `>>>` "внутренний", который отвечает за усложение хеш-кода, подключая к формированию старшие биты.

[к оглавлению](#Collections-Pro)

## 25. Правила проверки при переопределении метода equals?

**1.** Используйте оператор `==` для проверки того, что аргумент является ссылкой на данный объект. 
Если это так, возвращайте `true`. Это просто оптимизация производительности, 
которая может иметь смысл при потенциально дорогостоящем сравнении.

**2.** Используйте оператор `instanceof` для проверки того, что аргумент имеет корректный тип. 
Если это не так, возвращайте `false`. Обычно корректный тип — это тип класса, которому принадлежит данный метод. 
В некоторых случаях это может быть некоторый интерфейс, реализованный этим классом. Если класс реализует интерфейс, 
который уточняет контракт метода `equals`, то в качестве типа указывайте этот интерфейс: 
это позволит выполнять сравнение классов, реализующих этот интерфейс. 
Подобным свойством обладают интерфейсы коллекций, таких как `Set`, `List`, `Мар` и `Map. Entry`.

**3.** Приводите аргумент к корректному типу. Поскольку эта операция следует за проверкой instanceof, она гарантированно успешна.

**4.** Для каждого “важного” поля класса убедитесь, что значение этого поля в аргументе соответствует полю данного объекта. Если все тесты успешны, возвращайте true; в противном случае возвращайте false. Если в п. 2 тип определен как интерфейс, вы должны получить доступ к полям аргумента через методы интерфейса; если тип представляет собой класс, вы можете обращаться к его полям непосредственно, в зависимости от их доступности.

Пример Класс с типичным методом `equals`:
```java
public final class PhoneNumber {
   private final short areaCode, prefix, lineNum;
   public PhoneNumber(int areaCode, int prefix, int lineNum) {
      this . areaCode = rangeCheck (areaCode, 999, ’’area code”);
      this.prefix = rangeCheck (pref ix, 999, ’’prefix’’);
      this.lineNum = rangeCheck(lineNum, 9999, "line num”);}
   private static short rangeCheck(int val, int max, String arg) {
      if (val < 0 || val > max)
         throw new IllegalArgumentException (arg 4- ": "4- val);
         return (short) val;

   @Override public boolean equals(Object о) {
      if (о == this) //1
         return true;
      if (! (o instanceof PhoneNumber)) //2
         return false;

//здесь насколько понял, мы нарушаем принцип подстановки Лисков и используем следующее

      if (о == null || o.getClass() != getClass ())
         return false;


      PhoneNumber pn = (PhoneNumber)o; //3
      return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode; //4
      }
... 
}
```
метод `equals` имеет смысл перекрывать, когда для класса определено понятие логической эквивалентности 
(logical equality), которая не совпадает с тождественностью объектов, а в суперклассе метод equals не перекрыт. 
В общем случае это происходит с классами значений (напр. `Integer` или `String`). 
Перекрывая метод `equals`, нужно соблюдать его общий контракт.

Метод `equals` реализует отношение эквивалентности, которое обладает следующими свойствами:

+ Рефлексивность: для любой ненулевой ссылки на значение `х` выражение `х.equals(х)` должно возвращать `true`.

+ Симметричность: для любых ненулевых ссылок на значения `х` и `у` выражение `х.equals(у)` должно возвращать `true` 
тогда и только тогда, когда `у.equals(х)` возвращает `true`.

+ Транзитивность: для любых ненулевых ссылок на значения `х`, `у` и `z`, если `х.equals(у)` возвращает `true` 
и `у.equals(z)` возвращает `true`, `х.equals(z)` должно возвращать `true`.

+ Непротиворечивость: для любых ненулевых ссылок на значения `х` и `у` многократные вызовы `х.equals(у)` должны либо 
постоянно возвращать `true`, либо постоянно возвращать `false` при условии, что никакая информация, 
используемая в сравнениях `equals`, не изменяется.

+ Для любой ненулевой ссылки на значение `х` выражение `х.equals(null)` должно возвращать `false`.

[к оглавлению](#Collections-Pro)

## 26. Как устроена HashMap?

**`HashMap`** состоит из «корзин» `bucket`. С технической точки зрения бакеты — это элементы массива, которые хранят ссылки 
на списки элементов. При добавлении новой пары ключ-значение, вычисляет хеш-код ключа, на основании которого вычисляется 
номер корзины (номер ячейки массива), в которую попадет новый элемент. 

Если корзина пустая, то в нее сохраняется ссылка на вновь добавляемый элемент, если же там уже есть элемент, 
то происходит последовательный переход по ссылкам между элементами в цепочке, в поисках последнего элемента, 
от которого и ставится ссылка на вновь добавленный элемент. 

Если в списке был найден элемент с таким же ключом, то он заменяется. Добавление, поиск и удаление элементов выполняется 
за константное время. Вроде все здорово, с одной оговоркой, хеш-функция должна равномерно распределять элементы 
по корзинам, в этом случае временная сложность для этих 3 операций будет не ниже `lg т`, 
а в среднем случае как раз константное время.

[к оглавлению](#Collections-Pro)

## 27. Какое начальное количество корзин в HashMap?

По умолчанию в `HashMap` 16 корзин. Отвечая, стоит заметить, что можно используя конструкторы с параметрами: 
через параметр `capacity` задавать свое начальное количество корзин

[к оглавлению](#Collections-Pro)

## 28. Какая оценка временной сложности выборки элемента из HashMap Гарантирует ли HashMap указанную сложность выборки элемента?

Если вы возьмете хеш-функцию, которая постоянно будет возвращать одно и то же значение, то `HashMap` превратится 
в связный список, с низкой производительностью.
 
Если вы будете использовать хеш-функцию с равномерным распределением, в предельном случае гарантироваться будет только 
временная сложность `lg n`. Так что, ответ на вторую часть вопроса — нет, не гарантируется.

[к оглавлению](#Collections-Pro)

## 29. Роль equals и hashCode в HashMap?

`hashCode` позволяет определить корзину для поиска элемента, а `equals` используется для сравнения ключей элементов 
в списке внутри корзины и искомого ключа.

[к оглавлению](#Collections-Pro)

## 30. Как и когда происходит увеличение количества корзин в HashMap?

Помимо `capacity` в `HashMap` есть еще параметр `loadFactor`, на основании которого, вычисляется предельное количество 
занятых корзин (`capacity*loadFactor`). По умолчанию `loadFactor = 0,75`. По достижению предельного значения, 
число корзин увеличивается в 2 раза. Для всех хранимых элементов вычисляется новое «местоположение» с учетом нового 
числа корзин.

[к оглавлению](#Collections-Pro)

## 31. Как работает HashMap?

HashMap has an inner class **Entry**:
```java
static class Entry<K ,V> implements Map.Entry<K, V> {
	final K key;
	V value;
	Entry<K ,V> next;
	final int hash;
}
```
**How HashMap.put() methods works:**

transient Entry[] table;		
1. First of all, the key object is checked for null. If the key is null, the value is stored in table[0] position. 
Because hashcode for null is always 0. 
2. Then on next step, a hash value is calculated using the key’s hash code by calling its hashCode() method. 
This hash value is used to calculate the index in the array for storing Entry object. 
JDK designers well assumed that there might be some poorly written hashCode() functions that can return very high or low hash code value.
To solve this issue, they introduced another hash() function and passed the object’s hash code to this hash() function 
to bring hash value in the range of array index size.
3. Now indexFor(hash, table.length) function is called to calculate exact index position for storing the Entry object.

**How collisions are resolved:**

as we know that two unequal objects can have the same hash code value, 
how two different objects will be stored in same array location called bucket.
The answer is LinkedList. If you remember, Entry class had an attribute "next". 
This attribute always points to the next object in the chain. This is exactly the behavior of LinkedList.

1. So, in case of collision, Entry objects are stored in linked list form. 
When an Entry object needs to be stored in particular index, HashMap checks whether there is already an entry?? 
If there is no entry already present, the entry object is stored in this location. 
If there is already an object sitting on calculated index, its next attribute is checked. 
If it is null, and current entry object becomes next node in linkedlist. 
If next variable is not null, procedure is followed until next is evaluated as null.

2. What if we add the another value object with same key as entered before. 
Logically, it should replace the old value. How it is done? Well, after determining the index position of Entry object, 
while iterating over linkedist on calculated index, HashMap calls equals method on key object for each entry object.

All these entry objects in linkedlist will have similar hashcode but equals() method will test for true equality. 
If key.equals(k) will be true then both keys are treated as same key object. 
This will cause the replacing of value object inside entry object only.

How HashMap.get() methods works:
```java
public V get(Object key) {
    if (key == null)
    return getForNullKey();
    int hash = hash(key.hashCode());
    for (Entry<K , V> e = table[indexFor(hash, table.length)]; e != null; e = e.next) {
		Object k;
		if (e.hash == hash && ((k = e.key) == key || key.equals(k)))
			return e.value;
		}
		return null;
	}
}
```

[к оглавлению](#Collections-Pro)

## 32. Что такое хеш таблицы?

Хеш-таблицей называется структура данных, обеспечивающая очень быструю вставку и поиск. 
У хеш-таблиц также имеются свои недостатки. Они реализуются на базе массивов, а массивы трудно расширить после создания. 
У некоторых разновидностей хеш-таблиц быстродействие катастрофически падает при заполнении таблицы, 
поэтому программист должен довольно точно представлять, сколько элементов данных будет храниться в таблице 
(или приготовиться к периодическому перемещению данных в другую хеш-таблицу большего 
размера — процесс занимает довольно много времени).

Кроме того, при работе с хеш-таблицами не существует удобного способа перебора элементов в определенном 
порядке (скажем, от меньших к большим). Если вам необходима такая возможность, поищите другую структуру данных.

[к оглавлению](#Collections-Pro)

## 33. Что такое красно-черное дерево?

Красно-черные деревья относятся к сбалансированным бинарным деревьям поиска.
Как бинарное дерево, красно-черное обладает свойствами:

1) Оба поддерева являются бинарными деревьями поиска.

2) **Для каждого узла с ключом K выполняется критерий упорядочения:
ключи всех левых потомков <= K < ключи всех правых потомков**
(в других определениях дубликаты должны располагаться с правой стороны либо вообще отсутствовать). 
Это неравенство должно быть истинным для всех потомков узла, а не только его дочерних узлов.

Свойства красно-черных деревьев:
1) Каждый узел окрашен либо в красный, либо в черный цвет (в структуре данных узла появляется дополнительное поле – бит цвета).
2) Корень окрашен в черный цвет.
3) Листья(так называемые null-узлы) окрашены в черный цвет.
4) Каждый красный узел должен иметь два черных дочерних узла. Нужно отметить, что у черного узла могут быть черные 
дочерние узлы. Красные узлы в качестве дочерних могут иметь только черные.
5) Пути от узла к его листьям должны содержать одинаковое количество черных узлов(это черная высота).

Красно-черные деревья: коротко и ясно https://habr.com/ru/post/330644/

[к оглавлению](#Collections-Pro)

## 34. Удаление элемента из дерева?

Если у удаляемого элемента нет потомков или один потомок, то удаленить просто. 
Если у удаляемого элемента есть два потомка, то удаляемый узел надо заменить на приемника. 
Т.к. используется сложный алгоритм для поиска приемника, то часто вместо удаления используют флаг `isDeleted`. 
В остальных методах проверяют значение этого флага.

[к оглавлению](#Collections-Pro)

## 35. Какие существуют алгоритмы обхода дерева?

В зависимости от траекторий выделяют два типа обхода:
+ горизонтальный (в ширину)
+ вертикальный (в глубину).

 **Горизонтальный** обход подразумевает обход дерева по уровням (level-ordered) – вначале обрабатываются все узлы 
текущего уровня, после чего осуществляется переход на нижний уровень.

```java
static void contLevelOrder(Node top) {
    Queue<Node> queue=new LinkedList<> ();
        do {
            top.treatment();
            if (top.left!=null) queue.add(top.left);
            if (top.right!=null) queue.add(top.right);
            if (!queue.isEmpty()) top=queue.poll();
    } while (!queue.isEmpty());
}
```
    
**Вертикальный** бывает 3 видов:
+ прямой (preorder)
    1. Посещение узла.
    2. Вызов самого себя для обхода левого поддерева узла.
    3. Вызов самого себя для обхода правого поддерева узла

+ симметричный (inorder). При симметричном обходе двоичного дерева все узлы перебираются в порядке возрастания ключей.
Простейший способ обхода основан на использовании рекурсии. 
Метод должен выполнить только три операции:
    1. Вызов самого себя для обхода левого поддерева узла.
    2. Посещение узла.
    3. Вызов самого себя для обхода правого поддерева узла. 
```java
private void inOrder(node localRoot) {
     if(localRoot != null) {
          inOrder(localRoot.leftChild);
          console.log(node.value);
          inOrder(localRoot.rightChild);
     }
}        
```

+ обратный (postorder)
    1. Вызов самого себя для обхода левого поддерева узла.
    2. Вызов самого себя для обхода правого поддерева узла.
    3. Посещение узла.

[к оглавлению](#Collections-Pro)

## Источники:

**Generics** 

https://docs.oracle.com/javase/tutorial/java/generics/why.html

Пришел, увидел, обобщил: погружаемся в Java Generics 
https://habr.com/ru/company/sberbank/blog/416413/

Generics в Java 1.5
http://rsdn.org/article/java/genericsinjava.xml#EQNAC

Дженерики (Generics) в java 
https://www.fandroid.info/dzheneriki-generics-v-java/

Использование generic wildcards для повышения удобства Java API 
https://habr.com/ru/post/207360/

Примеры https://o7planning.org/ru/10403/java-generics-tutorial

Александр Маторин — Неочевидные Дженерики https://www.youtube.com/watch?v=_0c9Fd9FacU

Введение в Java. Generics. Wildcards | Технострим https://www.youtube.com/watch?v=FRmgcBxJvb4

Advanced Java - Generics https://www.youtube.com/playlist?list=PL6jg6AGdCNaX1yIJpX4sgALBTmTVc_uOJ
