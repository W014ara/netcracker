package ru.skillbench.tasks.text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;

public class ContactCardImpl implements ContactCard {

    private String fullName;
    private String organization;
    private String gender;
    private Calendar birthDate;
    private final HashMap<String, String> phoneNumber = new HashMap<>();

    public ContactCard getInstance(Scanner scanner) {
        String s = scanner.nextLine();
        if (!s.equals("BEGIN:VCARD"))
            throw new NoSuchElementException();
        while (scanner.hasNextLine()) {
            s = scanner.nextLine();
            if (!s.contains(":")) {
                throw new InputMismatchException();
            }
            if (s.contains("FN")) {
                fullName = s.substring(3);
            } else if (s.contains("ORG")) {
                organization = s.substring(4);
            } else if (s.contains("GENDER")) {
                gender = s.substring(7);
            } else if (s.contains("BDAY")) {
                try {
                    birthDate = Calendar.getInstance();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    simpleDateFormat.setLenient(false);
                    birthDate.setTime(simpleDateFormat.parse(s.substring(5)));
                } catch (ParseException e) {
                    InputMismatchException mismatchException = new InputMismatchException();
                    mismatchException.initCause(e);
                    throw mismatchException;
                }
            } else if (s.contains("TEL")) {
                String number = s.substring(s.indexOf(":") + 1);
                if (!number.matches("\\d{10}")) {
                    throw new InputMismatchException();
                }
                phoneNumber.put(s.substring(s.indexOf("=") + 1, s.indexOf(":")), number);
            } else if (s.equals("END:VCARD")) {
                break;
            } else {
                throw new InputMismatchException();
            }
        }
        if (fullName == null || organization == null) {
            throw new NoSuchElementException();
        }
        return this;

    }

    public ContactCard getInstance(String data) {
        return getInstance(new Scanner(data));
    }

    public String getFullName() {
        return fullName;
    }

    public String getOrganization() {
        return organization;
    }

    public boolean isWoman() {
        if (gender == null || gender.equals("M")) {
            return false;
        }
        return this.gender.equals("F");
    }

    public Calendar getBirthday() {
        if (birthDate == null) {
            throw new NoSuchElementException();
        }
        return birthDate;
    }

    public Period getAge() {
        if (birthDate == null) {
            throw new NoSuchElementException();
        }

        Calendar now = Calendar.getInstance();

        LocalDate birth = LocalDateTime.ofInstant(birthDate.toInstant(), birthDate.getTimeZone().toZoneId()).toLocalDate();
        LocalDate current = LocalDateTime.ofInstant(now.toInstant(), now.getTimeZone().toZoneId()).toLocalDate();

        return Period.between(birth, current);
    }

    public int getAgeYears() {
        if (birthDate == null) {
            throw new NoSuchElementException();
        }
        return this.getAge().getYears();
    }

    public String getPhone(String type) {
        if (!phoneNumber.containsKey(type)) {
            throw new NoSuchElementException();
        }
        StringBuilder stringBuilder = new StringBuilder(phoneNumber.get(type));
        stringBuilder.insert(0, "(");
        stringBuilder.insert(4, ")");
        stringBuilder.insert(5, " ");
        stringBuilder.insert(9, "-");
        return stringBuilder.toString();
    }
}