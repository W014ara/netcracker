# Примерный аналог формы регистрации с сайта https://passport.yandex.ru/registration

# Реализованные функции

```
1) Подсветка полей ввода;
2) Активация кнопки "Зарегистрироваться" только в том случае, если поставлена галочка на п.1;
3) Кнопка "показать пароль";
4) Переключение между панелями ввода телефона/придумывания контрольного вопроса;
5) Переключение между картинками капчи (голос/картинка);
6) Поля с именем, фамилией, логином, паролем являются обязательными;
7) Номер мобильного телефона вводится исключительно в формате +7 XXXXXXXXXX, предусмотрена подсказка при очистке поля;
8) Реализован кастомный блок select.
```

# Отсутствующие функции

```
1) Визульная составляющая полей ввода не совсем соответствует оригиналу (надпись в заголовках не уменьшается при нажатии на поле ввода);
2) Отсутсвуют всплывающие подказки при вводе некорректных данных;
3) Поля ввода с капчей являются необязательными;
4) Отсутсвует верификация пароля;
5) Отсутсвует реализация смены картинки с капчей.
```

# Структура проекта

```
│   index.html
│   package.json
│   README.md
│
├───scripts
│       index.js
│
├───src
│   ├───font
│   │       YandexSansBold.woff2
│   │       YandexSansMedium.woff2
│   │       YandexSansRegular.woff2
│   │       YandexSansRegularBolder.woff2
│   │
│   └───img
│           captcha-example.PNG
│           captcha-voice.PNG
│           eye-clear.svg
│           eye.svg
│           select-arrow.PNG
│           yandeks-vpervye-obog.ico
│
└───styles
        index.css
        index.css.map
        index.scss
        normalize.css
```