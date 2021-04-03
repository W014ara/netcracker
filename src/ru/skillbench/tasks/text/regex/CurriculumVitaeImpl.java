package ru.skillbench.tasks.text.regex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CurriculumVitaeImpl implements CurriculumVitae {

    private String articleText;
    private final HashMap<String, String> hidden = new HashMap<>();

    @Override
    public void setText(String text) {
        this.articleText = text;
    }

    @Override
    public String getText() {
        if (this.articleText == null) {
            throw new IllegalStateException();
        }
        return this.articleText;
    }

    @Override
    public List<Phone> getPhones() {
        if (this.articleText == null) {
            throw new IllegalStateException();
        }
        List<Phone> phones = new ArrayList<>();
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(getText());
        while (matcher.find()) {
            int areaCode = -1;
            int extension = -1;
            if (matcher.group(2) != null) {
                areaCode = Integer.parseInt(matcher.group(2));
            }
            if (matcher.group(7) != null) {
                extension = Integer.parseInt(matcher.group(7));
            }
            Phone newPhone = new Phone(matcher.group(), areaCode, extension);
            phones.add(newPhone);
        }
        return phones;
    }

    @Override
    public String getFullName() {
        if (this.articleText == null) {
            throw new IllegalStateException();
        }
        String namePattern = "([A-Z][a-z]*[.]*)\\s([A-Z][a-z]*[.]*)?\\s*([A-Z][a-z]*[.]*)";
        Pattern pattern = Pattern.compile(namePattern);
        Matcher matcher = pattern.matcher(this.articleText);
        if (matcher.find()) {
            return matcher.group().trim();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public String getFirstName() {
        if(this.articleText == null){
            throw new IllegalStateException();
        }
        String fullName = getFullName();
        return fullName.split(" ")[0];
    }

    @Override
    public String getMiddleName() {
        if(this.articleText == null){
            throw new IllegalStateException();
        }
        String fullName = getFullName();
        if (fullName.split(" ").length == 3) {
            return fullName.split(" ")[1];
        } else {
            return null;
        }
    }

    @Override
    public String getLastName() {
        if(this.articleText == null){
            throw new IllegalStateException();
        }
        String fullName = getFullName();
        return fullName.split(" ")[fullName.split(" ").length - 1];
    }

    @Override
    public void updateLastName(String newLastName) {
        if(this.articleText == null){
            throw new IllegalStateException();
        }
        String lastName = getLastName();
        this.articleText = this.articleText.replace(lastName, newLastName);
    }

    @Override
    public void updatePhone(Phone oldPhone, Phone newPhone) {
        if (this.articleText == null) {
            throw new IllegalStateException();
        }
        List<Phone> phones = getPhones();
        if (!this.articleText.contains(oldPhone.getNumber())) {
            throw new IllegalArgumentException();
        }
        this.articleText = this.articleText.replace(oldPhone.getNumber(), newPhone.getNumber());
    }

    @Override
    public void hide(String piece) {
        if (this.articleText == null) {
            throw new IllegalStateException();
        }
        if (!this.articleText.contains(piece)) {
            throw new IllegalArgumentException();
        }
        String sourceString = piece.replaceAll("[^. @]", "X");
        hidden.put(sourceString, piece);
        this.articleText = this.articleText.replace(piece, sourceString);
    }

    @Override
    public void hidePhone(String phone) {
        if (this.articleText == null) {
            throw new IllegalStateException();
        }
        if (!this.articleText.contains(phone)) {
            throw new IllegalArgumentException();
        }

        String sourcePhone = phone.replaceAll("[\\d]", "X");
        hidden.put(sourcePhone, phone);
        this.articleText = this.articleText.replace(phone, sourcePhone);
    }

    @Override
    public int unhideAll() {
        if (this.articleText == null) {
            throw new IllegalStateException();
        }
        int replacedNum = 0;
        for (HashMap.Entry<String, String> entry : hidden.entrySet()) {
            this.articleText = this.articleText.replaceAll(entry.getKey()
                            .replaceAll("\\(", "\\\\\\(").replaceAll("\\)", "\\\\\\)"),
                    entry.getValue());
            replacedNum++;
        }
        return replacedNum;
    }
}
