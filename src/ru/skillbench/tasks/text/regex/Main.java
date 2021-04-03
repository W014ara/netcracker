package ru.skillbench.tasks.text.regex;

public class Main {
    public static void main(String[] args) {
        CurriculumVitaeImpl article = new CurriculumVitaeImpl();
        String text = "John Smith[Date] john@hp.com (123)456 7890 495 926-93-47 ext.1846 800 250 0890";
        article.setText(text);
        System.out.println(article.getFullName());
    }
}
