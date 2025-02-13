package unipi.protal.countriesteach.database;

import android.content.ContentValues;

import androidx.lifecycle.LiveData;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import unipi.protal.countriesteach.R;
import unipi.protal.countriesteach.entities.Country;

//   https://androtak.wordpress.com/2016/03/01/how-to-convert-any-object-to-contentvalues-in-for-android-sqlite-insertion/
// https://www.vectorizer.io/
// https://www.textcompare.org/vectorize/
// https://www.countryflags.com/
public class CountryContentValues {
    public static final int EUROPE = 1;
    public static final int AMERICA = 2;
    public static final int ASIA = 3;
    public static final int AFRICA = 4;
    public static final int OCEANIA = 5;
    public static final int ANTARCTICA = 6;
    public static final int EUROPE_AND_ASIA = 7;
    public static final int WORLD = 8;
    public static final int NUMBER_OF_EUROPEAN_COUNTRIES = 51;
    public static final int NUMBER_OF_AMERICAN_COUNTRIES = 55;
    public static final int NUMBER_OF_ASIAN_COUNTRIES = 45;
    public static final int NUMBER_OF_AFRICAN_COUNTRIES = 54;
    public static final int NUMBER_OF_OCEANIAN_COUNTRIES = 25;
    public static final int NUMBER_OF_ALL_COUNTRIES = 230;
    public static final int EUROPE_START_INDEX = 1;
    public static final int EUROPE_END_INDEX = 51;
    public static final int OCEANIA_START_INDEX = 52;
    public static final int OCEANIA_END_INDEX = 76;
    public static final int ASIA_START_INDEX = 77;
    public static final int ASIA_END_INDEX = 121;
    public static final int AMERICA_START_INDEX = 122;
    public static final int AMERICA_END_INDEX = 176;
    public static final int AFRICA_START_INDEX = 177;
    public static final int AFRICA_END_INDEX = 230;
    public static final int WORLD_START_INDEX = 1;
    public static final int WORLD_END_INDEX = 230;
    public static final List<Long> EUROPEAN_COUNTRY_IDS = new ArrayList<Long>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L,
            11L, 12L, 13L, 14L, 15L, 16L, 17L, 18L, 19L, 20L,
            21L, 22L, 23L, 24L, 25L, 26L, 27L, 28L, 29L, 30L,
            31L, 32L, 33L, 34L, 35L, 36L, 37L, 38L, 39L, 40L,
            41L, 42L, 43L, 44L, 45L, 46L, 47L, 48L, 49L, 50L, 51L));
    public static final List<Long> OCEANIAN_COUNTRY_IDS = new ArrayList<Long>(Arrays.asList(52L, 53L, 54L, 55L, 56L, 57L, 58L, 59L, 60L,
            61L, 62L, 63L, 64L, 65L, 66L, 67L, 68L, 69L, 70L,
            71L, 72L, 73L, 74L, 75L, 76L));
    public static final List<Long> ASIAN_COUNTRY_IDS = new ArrayList<Long>(Arrays.asList(77L, 78L, 79L, 80L,
            81L, 82L, 83L, 84L, 85L, 86L, 87L, 88L, 89L, 90L,
            91L, 92L, 93L, 94L, 95L, 96L, 97L, 98L, 99L, 100L,
            101L, 102L, 103L, 104L, 105L, 106L, 107L, 108L, 109L, 110L,
            111L, 112L, 113L, 114L, 115L, 116L, 117L, 118L, 119L, 120L, 121L, 3L, 5L, 37L, 45L, 49L));
    public static final List<Long> AMERICAN_COUNTRY_IDS = new ArrayList<Long>(Arrays.asList(
            122L, 123L, 124L, 125L, 126L, 127L, 128L, 129L, 130L,
            131L, 132L, 133L, 134L, 135L, 136L, 137L, 138L, 139L, 140L,
            141L, 142L, 143L, 144L, 145L, 146L, 147L, 148L, 149L, 150L,
            151L, 152L, 153L, 154L, 155L, 156L, 157L, 158L, 159L, 160L,
            161L, 162L, 163L, 164L, 165L, 166L, 167L, 168L, 169L, 170L,
            171L, 172L, 173L, 174L, 175L, 176L));
    public static final List<Long> AFRICAN_COUNTRY_IDS = new ArrayList<Long>(Arrays.asList(
            177L, 178L, 179L, 180L, 181L, 182L, 183L, 184L, 185L, 186L, 187L, 188L, 189L, 190L,
            191L, 192L, 193L, 194L, 195L, 196L, 197L, 198L, 199L, 200L,
            201L, 202L, 203L, 204L, 205L, 206L, 207L, 208L, 209L, 210L,
            211L, 212L, 213L, 214L, 215L, 216L, 217L, 218L, 219L, 220L,
            221L, 222L, 223L, 224L, 225L, 226L, 227L, 228L, 229L, 230L));
    public static final List<Long> WORLD_COUNTRY_IDS = new ArrayList<>(Arrays.asList(
            1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L,
            11L, 12L, 13L, 14L, 15L, 16L, 17L, 18L, 19L, 20L, 21L, 22L, 23L, 24L, 25L, 26L, 27L, 28L, 29L, 30L,
            31L, 32L, 33L, 34L, 35L, 36L, 37L, 38L, 39L, 40L, 41L, 42L, 43L, 44L, 45L, 46L, 47L, 48L, 49L, 50L,
            51L, 52L, 53L, 54L, 55L, 56L, 57L, 58L, 59L, 60L, 61L, 62L, 63L, 64L, 65L, 66L, 67L, 68L, 69L, 70L,
            71L, 72L, 73L, 74L, 75L, 76L, 77L, 78L, 79L, 80L, 81L, 82L, 83L, 84L, 85L, 86L, 87L, 88L, 89L, 90L,
            91L, 92L, 93L, 94L, 95L, 96L, 97L, 98L, 99L, 100L, 101L, 102L, 103L, 104L, 105L, 106L, 107L, 108L, 109L, 110L,
            111L, 112L, 113L, 114L, 115L, 116L, 117L, 118L, 119L, 120L, 121L, 122L, 123L, 124L, 125L, 126L, 127L, 128L, 129L, 130L,
            131L, 132L, 133L, 134L, 135L, 136L, 137L, 138L, 139L, 140L, 141L, 142L, 143L, 144L, 145L, 146L, 147L, 148L, 149L, 150L,
            151L, 152L, 153L, 154L, 155L, 156L, 157L, 158L, 159L, 160L, 161L, 162L, 163L, 164L, 165L, 166L, 167L, 168L, 169L, 170L,
            171L, 172L, 173L, 174L, 175L, 176L, 177L, 178L, 179L, 180L, 181L, 182L, 183L, 184L, 185L, 186L, 187L, 188L, 189L, 190L,
            191L, 192L, 193L, 194L, 195L, 196L, 197L, 198L, 199L, 200L, 201L, 202L, 203L, 204L, 205L, 206L, 207L, 208L, 209L, 210L,
            211L, 212L, 213L, 214L, 215L, 216L, 217L, 218L, 219L, 220L, 221L, 222L, 223L, 224L, 225L, 226L, 227L, 228L, 229L, 230L));

    //51 countries
    public static List<Country> initializeEuropeanCountries() {
        List<Country> europeanCountries = new ArrayList<>();
        Country c1 = new Country(1, "Αλβανία",  EUROPE);
        europeanCountries.add(c1);
        Country c2 = new Country(2, "Ανδόρρα", EUROPE);
        europeanCountries.add(c2);
        Country c3 = new Country(3, "Αρμενία",  EUROPE_AND_ASIA);
        europeanCountries.add(c3);
        Country c4 = new Country(4, "Αυστρία",  EUROPE);
        europeanCountries.add(c4);
        Country c5 = new Country(5, "Αζερμπαϊτζάν", EUROPE_AND_ASIA);
        europeanCountries.add(c5);
        Country c6 = new Country(6, "Λευκορωσία", EUROPE);
        europeanCountries.add(c6);
        Country c7 = new Country(7, "Βέλγιο",EUROPE);
        europeanCountries.add(c7);
        Country c8 = new Country(8, "Βοσνία Ερζεγοβίνη",EUROPE);
        europeanCountries.add(c8);
        Country c9 = new Country(9, "Βουλγαρία", EUROPE);
        europeanCountries.add(c9);
        Country c10 = new Country(10, "Κροατία",EUROPE);
        europeanCountries.add(c10);
        Country c11 = new Country(11, "Κύπρος", EUROPE);
        europeanCountries.add(c11);
        Country c12 = new Country(12, "Τσεχία", EUROPE);
        europeanCountries.add(c12);
        Country c13 = new Country(13, "Δανία",EUROPE);
        europeanCountries.add(c13);
        Country c14 = new Country(14, "Εσθονία", EUROPE);
        europeanCountries.add(c14);
        Country c15 = new Country(15, "Φινλανδία", EUROPE);
        europeanCountries.add(c15);
        Country c16 = new Country(16, "Γαλλία", EUROPE);
        europeanCountries.add(c16);
        Country c17 = new Country(17, "Γεωργία", EUROPE_AND_ASIA);
        europeanCountries.add(c17);
        Country c18 = new Country(18, "Γερμανία", EUROPE);
        europeanCountries.add(c18);
        Country c19 = new Country(19, "Ελλάδα", EUROPE);
        europeanCountries.add(c19);
        Country c20 = new Country(20, "Ουγγαρία", EUROPE);
        europeanCountries.add(c20);
        Country c21 = new Country(21, "Ισλανδία", EUROPE);
        europeanCountries.add(c21);
        Country c22 = new Country(22, "Ιρλανδία", EUROPE);
        europeanCountries.add(c22);
        Country c23 = new Country(23, "Ιταλία", EUROPE);
        europeanCountries.add(c23);
        Country c24 = new Country(24, "Λετονία", EUROPE);
        europeanCountries.add(c24);
        Country c25 = new Country(25, "Λίχτενσταϊν", EUROPE);
        europeanCountries.add(c25);
        Country c26 = new Country(26, "Λιθουανία", EUROPE);
        europeanCountries.add(c26);
        Country c27 = new Country(27, "Λουξεμβούργο", EUROPE);
        europeanCountries.add(c27);
        Country c28 = new Country(28, "Μάλτα", EUROPE);
        europeanCountries.add(c28);
        Country c29 = new Country(29, "Μολδαβία", EUROPE);
        europeanCountries.add(c29);
        Country c30 = new Country(30, "Μονακό", EUROPE);
        europeanCountries.add(c30);
        Country c31 = new Country(31, "Μαυροβούνιο", EUROPE);
        europeanCountries.add(c31);
        Country c32 = new Country(32, "Ολλανδία", EUROPE);
        europeanCountries.add(c32);
        Country c33 = new Country(33, "Νορβηγία", EUROPE);
        europeanCountries.add(c33);
        Country c34 = new Country(34, "Πολωνία", EUROPE);
        europeanCountries.add(c34);
        Country c35 = new Country(35, "Πορτογαλία", EUROPE);
        europeanCountries.add(c35);
        Country c36 = new Country(36, "Ρουμανία", EUROPE);
        europeanCountries.add(c36);
        Country c37 = new Country(37, "Ρωσία", EUROPE_AND_ASIA);
        europeanCountries.add(c37);
        Country c38 = new Country(38, "Άγιος Μαρίνος", EUROPE);
        europeanCountries.add(c38);
        Country c39 = new Country(39, "Σερβία", EUROPE);
        europeanCountries.add(c39);
        Country c40 = new Country(40, "Σλοβακία", EUROPE);
        europeanCountries.add(c40);
        Country c41 = new Country(41, "Σλοβενία", EUROPE);
        europeanCountries.add(c41);
        Country c42 = new Country(42, "Σουηδία", EUROPE);
        europeanCountries.add(c42);
        Country c43 = new Country(43, "Ισπανία", EUROPE);
        europeanCountries.add(c43);
        Country c44 = new Country(44, "Ελβετία", EUROPE);
        europeanCountries.add(c44);
        Country c45 = new Country(45, "Τουρκία", EUROPE_AND_ASIA);
        europeanCountries.add(c45);
        Country c46 = new Country(46, "Ηνωμένο Βασίλειο", EUROPE);
        europeanCountries.add(c46);
        Country c47 = new Country(47, "Βατικανό", EUROPE);
        europeanCountries.add(c47);
        Country c48 = new Country(48, "Βόρεια Μακεδονία", EUROPE);
        europeanCountries.add(c48);
        Country c49 = new Country(49, "Καζακστάν", EUROPE_AND_ASIA);
        europeanCountries.add(c49);
        Country c50 = new Country(50, "Ουκρανία", EUROPE);
        europeanCountries.add(c50);
        Country c51 = new Country(51, "Κόσοβο", EUROPE);
        europeanCountries.add(c51);
        return europeanCountries;
    }

    //25 countries
    public static List<Country> initializeOceanianCountries() {
        List<Country> oceanianCountries = new ArrayList<>();
        Country c1 = new Country(52, "Αυστραλία", OCEANIA);
        oceanianCountries.add(c1);
        Country c2 = new Country(53, "Παπούα Νέα Γουινέα", OCEANIA);
        oceanianCountries.add(c2);
        Country c3 = new Country(54, "Νέα Ζηλανδία", OCEANIA);
        oceanianCountries.add(c3);
        Country c4 = new Country(55, "Φίτζι", OCEANIA);
        oceanianCountries.add(c4);
        Country c5 = new Country(56, "Νήσοι Σολομώντα", OCEANIA);
        oceanianCountries.add(c5);
        Country c6 = new Country(57, "Βανουάτου", OCEANIA);
        oceanianCountries.add(c6);
        Country c7 = new Country(58, "Νέα Καληδονία", OCEANIA);
        oceanianCountries.add(c7);
        Country c8 = new Country(59, "Γαλλική Πολυνησία", OCEANIA);//anthem of france
        oceanianCountries.add(c8);
        Country c9 = new Country(60, "Σαμόα", OCEANIA);
        oceanianCountries.add(c9);
        Country c10 = new Country(61, "Γκουάμ", OCEANIA);
        oceanianCountries.add(c10);
        Country c11 = new Country(62, "Κιριμπάτι", OCEANIA);
        oceanianCountries.add(c11);
        Country c12 = new Country(63, "Μικρονησία", OCEANIA);
        oceanianCountries.add(c12);
        Country c13 = new Country(64, "Τόνγκα", OCEANIA);
        oceanianCountries.add(c13);
        Country c14 = new Country(65, "Αμερικανική Σαμόα", OCEANIA);
        oceanianCountries.add(c14);
        Country c15 = new Country(66, "Βόρειες Μαριάνες Νήσοι", OCEANIA);
        oceanianCountries.add(c15);
        Country c16 = new Country(67, "Νήσοι Μάρσαλ", OCEANIA);
        oceanianCountries.add(c16);
        Country c17 = new Country(68, "Παλάου", OCEANIA);
        oceanianCountries.add(c17);
        Country c18 = new Country(69, "Νήσοι Κουκ", OCEANIA);
        oceanianCountries.add(c18);
        Country c19 = new Country(70, "Ουαλίς και Φουτουνά", OCEANIA);//anthem of france
        oceanianCountries.add(c19);
        Country c20 = new Country(71, "Τουβαλού", OCEANIA);
        oceanianCountries.add(c20);
        Country c21 = new Country(72, "Ναουρού", OCEANIA);
        oceanianCountries.add(c21);
        Country c22 = new Country(73, "Νησί Νόρφολκ", OCEANIA); //uk anthem
        oceanianCountries.add(c22);
        Country c23 = new Country(74, "Νιούε", OCEANIA);
        oceanianCountries.add(c23);
        Country c24 = new Country(75, "Τοκελάου", OCEANIA);
        oceanianCountries.add(c24);
        Country c25 = new Country(76, "Νήσοι Πίτκαιρν", OCEANIA); //uk anthem
        oceanianCountries.add(c25);
        return oceanianCountries;
    }

    //  Γεωργία, Αρμενία, Αζερμπαϊτζάν, Ρωσία, Τουρκία, Καζακστάν έχουν περαστεί στην Ευρώπη με attr continentId EUROPE_AND_ASIA
    // Hong Kong kai Macau den einai anagnorismena
    public static List<Country> initializeAsianCountries() {
        List<Country> asianCountries = new ArrayList<>();
        Country c1 = new Country(77, "Μακάου", ASIA); //
        asianCountries.add(c1);
        Country c2 = new Country(78, "Χονγκ Κονγκ", ASIA);//uk anthem
        asianCountries.add(c2);
        Country c3 = new Country(79, "Αφγανιστάν", ASIA);
        asianCountries.add(c3);
        Country c4 = new Country(80, "Μπαχρέιν", ASIA);
        asianCountries.add(c4);
        Country c5 = new Country(81, "Μπανγκλαντές", ASIA);
        asianCountries.add(c5);
        Country c6 = new Country(82, "Μπουτάν", ASIA);
        asianCountries.add(c6);
        Country c7 = new Country(83, "Μπρουνέι", ASIA);
        asianCountries.add(c7);
        Country c8 = new Country(84, "Καμπότζη", ASIA);
        asianCountries.add(c8);
        Country c9 = new Country(85, "Κίνα", ASIA);
        asianCountries.add(c9);
        Country c10 = new Country(86, "Ινδία", ASIA);
        asianCountries.add(c10);
        Country c11 = new Country(87, "Ινδονησία", ASIA);
        asianCountries.add(c11);
        Country c12 = new Country(88, "Ιράν", ASIA);
        asianCountries.add(c12);
        Country c13 = new Country(89, "Ιράκ", ASIA);
        asianCountries.add(c13);
        Country c14 = new Country(90, "Ισραήλ", ASIA);
        asianCountries.add(c14);
        Country c15 = new Country(91, "Ιαπωνία", ASIA);
        asianCountries.add(c15);
        Country c16 = new Country(92, "Ιορδανία", ASIA);
        asianCountries.add(c16);
        Country c17 = new Country(93, "Κουβέιτ", ASIA);
        asianCountries.add(c17);
        Country c18 = new Country(94, "Κιργιζία", ASIA);
        asianCountries.add(c18);
        Country c19 = new Country(95, "Λάος", ASIA);
        asianCountries.add(c19);
        Country c20 = new Country(96, "Λίβανος", ASIA);
        asianCountries.add(c20);
        Country c21 = new Country(97, "Μαλαισία", ASIA);
        asianCountries.add(c21);
        Country c22 = new Country(98, "Μαλδίβες", ASIA);
        asianCountries.add(c22);
        Country c23 = new Country(99, "Μογγολία", ASIA);
        asianCountries.add(c23);
        Country c24 = new Country(100, "Μιανμάρ", ASIA);
        asianCountries.add(c24);
        Country c25 = new Country(101, "Νεπάλ", ASIA);
        asianCountries.add(c25);
        Country c26 = new Country(102, "Βόρεια Κορέα", ASIA);
        asianCountries.add(c26);
        Country c27 = new Country(103, "Ομάν", ASIA);
        asianCountries.add(c27);
        Country c28 = new Country(104, "Πακιστάν", ASIA);
        asianCountries.add(c28);
        Country c29 = new Country(105, "Παλαιστίνη", ASIA);
        asianCountries.add(c29);
        Country c30 = new Country(106, "Φιλιππίνες", ASIA);
        asianCountries.add(c30);
        Country c31 = new Country(107, "Κατάρ", ASIA);
        asianCountries.add(c31);
        Country c32 = new Country(108, "Σαουδική Αραβία", ASIA);
        asianCountries.add(c32);
        Country c33 = new Country(109, "Σιγκαπούρη", ASIA);
        asianCountries.add(c33);
        Country c34 = new Country(110, "Νότια Κορέα", ASIA);
        asianCountries.add(c34);
        Country c35 = new Country(111, "Σρι Λάνκα", ASIA);
        asianCountries.add(c35);
        Country c36 = new Country(112, "Συρία", ASIA);
        asianCountries.add(c36);
        Country c37 = new Country(113, "Ταϊβάν", ASIA);
        asianCountries.add(c37);
        Country c38 = new Country(114, "Τατζικιστάν", ASIA);
        asianCountries.add(c38);
        Country c39 = new Country(115, "Ταϊλάνδη", ASIA);
        asianCountries.add(c39);
        Country c40 = new Country(116, "Ανατολικό Τιμόρ", ASIA);//
        asianCountries.add(c40);
        Country c41 = new Country(117, "Τουρκμενιστάν", ASIA);
        asianCountries.add(c41);
        Country c42 = new Country(118, "Ηνωμένα Αραβικά Εμιράτα", ASIA);
        asianCountries.add(c42);
        Country c43 = new Country(119, "Ουζμπεκιστάν", ASIA);
        asianCountries.add(c43);
        Country c44 = new Country(120, "Βιετνάμ", ASIA);
        asianCountries.add(c44);
        Country c45 = new Country(121, "Υεμένη", ASIA);
        asianCountries.add(c45);
        return asianCountries;
    }

    public static List<Country> initializeAmericanCountries() {
        List<Country> americanCountries = new ArrayList<>();
        Country c1 = new Country(122, "Ανγκουίλα", AMERICA);
        Country c2 = new Country(123, "Αντίγκουα και Μπαρμπούντα", AMERICA);
        Country c3 = new Country(124, "Αργεντινή", AMERICA);
        Country c4 = new Country(125, "Αρούμπα", AMERICA);
        Country c5 = new Country(126, "Μπαχάμες", AMERICA);
        Country c6 = new Country(127, "Μπαρμπάντος", AMERICA);
        Country c7 = new Country(128, "Μπελίζ", AMERICA);
        Country c8 = new Country(129, "Βερμούδες", AMERICA);// uk anthem
        Country c9 = new Country(130, "Βολιβία", AMERICA);
        Country c10 = new Country(131, "Βραζιλία", AMERICA);
        Country c11 = new Country(132, "Βρετανικές Παρθένοι Νήσοι", AMERICA);// uk anthem
        Country c12 = new Country(133, "Καναδάς", AMERICA);
        Country c13 = new Country(134, "Καραϊβική Ολλανδία", AMERICA);//netherlands anthem
        Country c14 = new Country(135, "Νήσοι Κέιμαν", AMERICA);// uk anthem
        Country c15 = new Country(136, "Χιλή", AMERICA);
        Country c16 = new Country(137, "Κολομβία", AMERICA);
        Country c17 = new Country(138, "Κόστα Ρίκα", AMERICA);
        Country c18 = new Country(139, "Κούβα", AMERICA);
        Country c19 = new Country(140, "Κουρασάο", AMERICA); //
        Country c20 = new Country(141, "Δομινίκα", AMERICA);
        Country c21 = new Country(142, "Δομινικανή Δημοκρατία", AMERICA);
        Country c22 = new Country(143, "Ισημερινός ", AMERICA);
        Country c23 = new Country(144, "Ελ Σαλβαδόρ", AMERICA);
        Country c24 = new Country(145, "Νήσοι Φώκλαντ", AMERICA); // uk anthem
        Country c25 = new Country(146, "Γαλλική Γουιάνα", AMERICA);// france anthem
        Country c26 = new Country(147, "Γροιλανδία", AMERICA);
        Country c27 = new Country(148, "Γρενάδα", AMERICA);
        Country c28 = new Country(149, "Γουαδελούπη", AMERICA); //france anthem
        Country c29 = new Country(150, "Γουατεμάλα", AMERICA);
        Country c30 = new Country(151, "Γουιάνα", AMERICA);
        Country c31 = new Country(152, "Αϊτή", AMERICA);
        Country c32 = new Country(153, "Ονδούρα", AMERICA);
        Country c33 = new Country(154, "Τζαμάικα", AMERICA);
        Country c34 = new Country(155, "Μαρτινίκα", AMERICA);//france anthem
        Country c35 = new Country(156, "Μεξικό", AMERICA);
        Country c36 = new Country(157, "Μοντσερράτ", AMERICA); //uk anthem
        Country c37 = new Country(158, "Νικαράγουα", AMERICA);
        Country c38 = new Country(159, "Παναμάς", AMERICA);
        Country c39 = new Country(160, "Παραγουάη", AMERICA);
        Country c40 = new Country(161, "Περού", AMERICA);
        Country c41 = new Country(162, "Πουέρτο Ρίκο", AMERICA);
        Country c42 = new Country(163, "Άγιος Βαρθολομαίος", AMERICA);
        Country c43 = new Country(164, "Άγιος Χριστόφορος και Νέβις", AMERICA);
        Country c44 = new Country(165, "Αγία Λουκία", AMERICA);
        Country c45 = new Country(166, "Άγιος Μαρτίνος", AMERICA);
        Country c46 = new Country(167, "Σαιν-Πιερ και Μικελόν", AMERICA);
        Country c47 = new Country(168, "Άγιος Βικέντιος και Γρεναδίνες", AMERICA);
        Country c48 = new Country(169, "Άγιος Μαρτίνος", AMERICA);
        Country c49 = new Country(170, "Σουρινάμ", AMERICA);
        Country c50 = new Country(171, "Τρινιντάντ και Τομπάγκο", AMERICA);
        Country c51 = new Country(172, "Τερκς και Κέικος", AMERICA);
        Country c52 = new Country(173, "Ηνωμένες Πολιτείες Αμερικής", AMERICA);
        Country c53 = new Country(174, "Αμερικανικές Παρθένοι Νήσοι", AMERICA); //us anthem
        Country c54 = new Country(175, "Ουρουγουάη", AMERICA);
        Country c55 = new Country(176, "Βενεζουέλα", AMERICA);
        americanCountries.add(c1);
        americanCountries.add(c2);
        americanCountries.add(c3);
        americanCountries.add(c4);
        americanCountries.add(c5);
        americanCountries.add(c6);
        americanCountries.add(c7);
        americanCountries.add(c8);
        americanCountries.add(c9);
        americanCountries.add(c10);
        americanCountries.add(c11);
        americanCountries.add(c12);
        americanCountries.add(c13);
        americanCountries.add(c14);
        americanCountries.add(c15);
        americanCountries.add(c16);
        americanCountries.add(c17);
        americanCountries.add(c18);
        americanCountries.add(c19);
        americanCountries.add(c20);
        americanCountries.add(c21);
        americanCountries.add(c22);
        americanCountries.add(c23);
        americanCountries.add(c24);
        americanCountries.add(c25);
        americanCountries.add(c26);
        americanCountries.add(c27);
        americanCountries.add(c28);
        americanCountries.add(c29);
        americanCountries.add(c30);
        americanCountries.add(c31);
        americanCountries.add(c32);
        americanCountries.add(c33);
        americanCountries.add(c34);
        americanCountries.add(c35);
        americanCountries.add(c36);
        americanCountries.add(c37);
        americanCountries.add(c38);
        americanCountries.add(c39);
        americanCountries.add(c40);
        americanCountries.add(c41);
        americanCountries.add(c42);
        americanCountries.add(c43);
        americanCountries.add(c44);
        americanCountries.add(c45);
        americanCountries.add(c46);
        americanCountries.add(c47);
        americanCountries.add(c48);
        americanCountries.add(c49);
        americanCountries.add(c50);
        americanCountries.add(c51);
        americanCountries.add(c52);
        americanCountries.add(c53);
        americanCountries.add(c54);
        americanCountries.add(c55);
        return americanCountries;
    }

    public static List<Country> initializeAfricanCountries() {
        List<Country> africanCountries = new ArrayList<>();
        Country c1 = new Country(177, "Νιγηρία", AFRICA);
        Country c2 = new Country(178, "Αιθιοπία", AFRICA);
        Country c3 = new Country(179, "Κονγκό", AFRICA);
        Country c4 = new Country(180, "Αίγυπτος", AFRICA);
        Country c5 = new Country(181, "Νότια Αφρική", AFRICA);
        Country c6 = new Country(182, "Τανζανία", AFRICA);
        Country c7 = new Country(183, "Κένυα", AFRICA);
        Country c8 = new Country(184, "Ουγκάντα", AFRICA);
        Country c9 = new Country(185, "Αλγερία", AFRICA);
        Country c10 = new Country(186, "Σουδάν", AFRICA);
        Country c11 = new Country(187, "Μαρόκο", AFRICA);
        Country c12 = new Country(188, "Μοζαμβίκη", AFRICA);
        Country c13 = new Country(189, "Γκάνα", AFRICA);
        Country c14 = new Country(190, "Ανγκόλα", AFRICA);
        Country c15 = new Country(191, "Σομαλία", AFRICA);
        Country c16 = new Country(192, "Ακτή Ελεφαντοστού", AFRICA);
        Country c17 = new Country(193, "Μαδαγασκάρη", AFRICA);
        Country c18 = new Country(194, "Καμερούν", AFRICA);
        Country c19 = new Country(195, "Μπουρκίνα Φάσο", AFRICA);
        Country c20 = new Country(196, "Νίγηρας", AFRICA);
        Country c21 = new Country(197, "Μαλάουι", AFRICA);
        Country c22 = new Country(198, "Ζάμπια", AFRICA);
        Country c23 = new Country(199, "Σενεγάλη", AFRICA);
        Country c24 = new Country(200, "Μάλι ", AFRICA);
        Country c25 = new Country(201, "Ζιμπάμπουε", AFRICA);
        Country c26 = new Country(202, "Τσαντ", AFRICA);
        Country c27 = new Country(203, "Τυνησία", AFRICA);
        Country c28 = new Country(204, "Γουινέα", AFRICA);
        Country c29 = new Country(205, "Ρουάντα", AFRICA);
        Country c30 = new Country(206, "Μπενίν", AFRICA);
        Country c31 = new Country(207, "Μπουρούντι", AFRICA);
        Country c32 = new Country(208, "Νότιο Σουδάν", AFRICA);
        Country c33 = new Country(209, "Ερυθραία", AFRICA);
        Country c34 = new Country(210, "Σιέρα Λεόνε", AFRICA);
        Country c35 = new Country(211, "Τόγκο", AFRICA);
        Country c36 = new Country(212, "Λιβύη", AFRICA);
        Country c37 = new Country(213, "Μαυριτανία", AFRICA);
        Country c38 = new Country(214, "Δημοκρατία του Κονγκό", AFRICA);
        Country c39 = new Country(215, "Λιβερία", AFRICA);
        Country c40 = new Country(216, "Κεντροαφρικανική Δημοκρατία", AFRICA);
        Country c41 = new Country(217, "Ναμίμπια", AFRICA);
        Country c42 = new Country(218, "Λεσότο", AFRICA);
        Country c43 = new Country(219, "Μποτσουάνα", AFRICA);
        Country c44 = new Country(220, "Γκάμπια", AFRICA);
        Country c45 = new Country(221, "Γκαμπόν", AFRICA);
        Country c46 = new Country(222, "Γουινέα Μπισσάου", AFRICA);
        Country c47 = new Country(223, "Μαυρίκιος", AFRICA);
        Country c48 = new Country(224, "Ισημερινή Γουινέα", AFRICA);
        Country c49 = new Country(225, "Εσουατίνι", AFRICA);
        Country c50 = new Country(226, "Τζιμπουτί", AFRICA);
        Country c51 = new Country(227, "Κομόρες", AFRICA);
        Country c52 = new Country(228, "Πράσινο Ακρωτήριο", AFRICA);
        Country c53 = new Country(229, "Σάο Τομέ και Πρίνσιπε", AFRICA);
        Country c54 = new Country(230, "Σεϋχέλλες", AFRICA);
        africanCountries.add(c1);
        africanCountries.add(c2);
        africanCountries.add(c3);
        africanCountries.add(c4);
        africanCountries.add(c5);
        africanCountries.add(c6);
        africanCountries.add(c7);
        africanCountries.add(c8);
        africanCountries.add(c9);
        africanCountries.add(c10);
        africanCountries.add(c11);
        africanCountries.add(c12);
        africanCountries.add(c13);
        africanCountries.add(c14);
        africanCountries.add(c15);
        africanCountries.add(c16);
        africanCountries.add(c17);
        africanCountries.add(c18);
        africanCountries.add(c19);
        africanCountries.add(c20);
        africanCountries.add(c21);
        africanCountries.add(c22);
        africanCountries.add(c23);
        africanCountries.add(c24);
        africanCountries.add(c25);
        africanCountries.add(c26);
        africanCountries.add(c27);
        africanCountries.add(c28);
        africanCountries.add(c29);
        africanCountries.add(c30);
        africanCountries.add(c31);
        africanCountries.add(c32);
        africanCountries.add(c33);
        africanCountries.add(c34);
        africanCountries.add(c35);
        africanCountries.add(c36);
        africanCountries.add(c37);
        africanCountries.add(c38);
        africanCountries.add(c39);
        africanCountries.add(c40);
        africanCountries.add(c41);
        africanCountries.add(c42);
        africanCountries.add(c43);
        africanCountries.add(c44);
        africanCountries.add(c45);
        africanCountries.add(c46);
        africanCountries.add(c47);
        africanCountries.add(c48);
        africanCountries.add(c49);
        africanCountries.add(c50);
        africanCountries.add(c51);
        africanCountries.add(c52);
        africanCountries.add(c53);
        africanCountries.add(c54);
        return africanCountries;
    }

}
