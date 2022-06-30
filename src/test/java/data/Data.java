package data;

import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
import java.time.Year;
import java.util.Locale;

public class Data {

    private Data() {}

    public static Faker faker = new Faker(new Locale("en"));

    @Value
    @RequiredArgsConstructor
    public static class CardData {
        String number;
        String month;
        String year;
        String owner;
        String cvv;
    }

    public static String getApprovedCardNumber() {
        return "4444 4444 4444 4441";
    }
    public static String getDeclinedCardNumber() {
        return "4444 4444 4444 4442";
    }
    public static String getLongCardNumber() {
        return "4444 4444 4444 4441 4455 666";
    }
    public static String getShortCardNumber() {
        return "4444 4444 4444 444";
    }
    public static String getUnknownCardNumber() {
        return "1234 5678 9090 3222";
    }
    public static String getZerosCardNumber() {
        return "0000 0000 0000 0000";
    }
    public static String getLettersCardNumber() {
        return "qwertyuйцукен";
    }
    public static String getSymbolsCardNumber() {
        return "4@#$ !%^ 4444 =+41";
    }
    public static String getEmptyCardNumber() {
        return "";
    }


    public static String getValidMonth() {
        LocalDate localDate = LocalDate.now();
        return String.format("%02d", localDate.getMonthValue());
    }
    public static String getMonthNotInRange() {return "15";}
    public static String getMonthWitchLetters() {return "Qw";}
    public static String getMonthWitchOneNum() {return "5";}
    public static String getMonthWitchZeros() {return "00";}
    public static String getMonthWitchSymbols() {return "!@";}
    public static String getEmptyMonth() {return "";}


    public static String getValidYear() {return String.format("%ty", Year.now());}

    public static String getPastYear() {
        LocalDate localDate = LocalDate.now();
        return String.format("%ty", localDate.minusYears(1));
    }

    public static String getLettersYear() {return "Qw";}
    public static String getOneNumYear() {return "5";}

    public static String getFutureYear() {
        LocalDate localDate = LocalDate.now();
        return String.format("%ty", localDate.plusYears(7));
    }
    public static String getNextYear() {
        LocalDate localDate = LocalDate.now();
        return String.format("%ty", localDate.plusYears(1));
    }
    public static String get27Year() {
        LocalDate localDate = LocalDate.now();
        return String.format("%ty", localDate.plusYears(5));
    }

    public static String getSymbolsYear() {return "!@";}
    public static String getEmptyYear() {return "";}


    public static String getValidName() {
        return faker.name().fullName();
    }
    public static String getRussianName() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().fullName();
    }

    public static String getNameWitchNums() {return "1234 5678";}
    public static String getNameWitchSymbols() {return "!@#$ %^&*";}
    public static String getOnlyFirstName() {return faker.name().firstName();}
    public static String getOneLetterName() {return "A";}
    public static String getLongName() {return "Valdimir Vladimirovichvladimirvladimir";}
    public static String getDoubleName() {return "Vladimir Vladimirovich-Vladimiroff";}
    public static String getEmptyName() {return "";}


    public static String getCvv() {return "322";}
    public static String getCvvWitchLetters() {return "qwe";}
    public static String getCvvWitchOneNum() {return "3";}
    public static String getCvvWitchTwoNums() {return "32";}
    public static String getCvvWitchFourNums() {return "3221";}
    public static String getCvvWitchSymbols() {return "!@#";}
    public static String getEmptyCvv() {return "";}

}
