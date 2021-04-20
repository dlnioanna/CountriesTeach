package unipi.protal.countriesteach.database;

import android.content.ContentValues;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import unipi.protal.countriesteach.R;
import unipi.protal.countriesteach.entities.Country;
//   https://androtak.wordpress.com/2016/03/01/how-to-convert-any-object-to-contentvalues-in-for-android-sqlite-insertion/

public class CountryContentValues {
    public static final int EUROPE = 1;
    public static final int AMERICA = 2;
    public static final int ASIA = 3;
    public static final int AFRICA = 4;
    public static final int OCEANIA = 5;
    public static final int ANTARCTICA = 6;
    public static final int WORLD = 7;

    //51 countries
    public static List<Country> initializeEuropeanCountries() {
        List<Country> europeanCountries = new ArrayList<>();
        Country c1 = new Country(1, "Αλβανία", EUROPE);
        europeanCountries.add(c1);
        Country c2 = new Country(2, "Ανδόρρα", EUROPE);
        europeanCountries.add(c2);
        Country c3 = new Country(3, "Αρμενία", EUROPE);
        europeanCountries.add(c3);
        Country c4 = new Country(4, "Αυστρία", EUROPE);
        europeanCountries.add(c4);
        Country c5 = new Country(5, "Αζερμπαϊτζάν", EUROPE);
        europeanCountries.add(c5);
        Country c6 = new Country(6, "Λευκορωσία", EUROPE);
        europeanCountries.add(c6);
        Country c7 = new Country(7, "Βέλγιο", EUROPE);
        europeanCountries.add(c7);
        Country c8 = new Country(8, "Βοσνία Ερζεγοβίνη", EUROPE);
        europeanCountries.add(c8);
        Country c9 = new Country(9, "Βουλγαρία", EUROPE);
        europeanCountries.add(c9);
        Country c10 = new Country(10, "Κροατία", EUROPE);
        europeanCountries.add(c10);
        Country c11 = new Country(11, "Κύπρος", EUROPE);
        europeanCountries.add(c11);
        Country c12 = new Country(12, "Τσεχία", EUROPE);
        europeanCountries.add(c12);
        Country c13 = new Country(13, "Δανία", EUROPE);
        europeanCountries.add(c13);
        Country c14 = new Country(14, "Εσθονία", EUROPE);
        europeanCountries.add(c14);
        Country c15 = new Country(15, "Φινλανδία", EUROPE);
        europeanCountries.add(c15);
        Country c16 = new Country(16, "Γαλλία", EUROPE);
        europeanCountries.add(c16);
        Country c17 = new Country(17, "Γεωργία", EUROPE);
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
        Country c37 = new Country(37, "Ρωσία", EUROPE);
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
        Country c45 = new Country(45, "Τουρκία", EUROPE);
        europeanCountries.add(c45);
        Country c46 = new Country(46, "Ηνωμένο Βασίλειο", EUROPE);
        europeanCountries.add(c46);
        Country c47 = new Country(47, "Βατικανό", EUROPE);
        europeanCountries.add(c47);
        Country c48 = new Country(48, "Βόρεια Μακεδονία", EUROPE);
        europeanCountries.add(c48);
        Country c49 = new Country(49, "Καζακστάν", EUROPE);
        europeanCountries.add(c49);
        Country c50 = new Country(50, "Ουκρανία", EUROPE);
        europeanCountries.add(c50);
        Country c51 = new Country(51, "Κόσοβο", EUROPE);
        europeanCountries.add(c51);
        return europeanCountries;
    }

    //25 countries
    public static List<Country> initializeOceanianCountries(){
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
        Country c8 = new Country(59, "Γαλλική Πολυνησία", OCEANIA);
        oceanianCountries.add(c8);
        Country c9 = new Country(60, "Σαμόα", OCEANIA);
        oceanianCountries.add(c9);
        Country c10 = new Country(61, "Γκουάμ", OCEANIA);
        oceanianCountries.add(c10);
        Country c11 = new Country(62, "Κιριμπάτι", OCEANIA);
        oceanianCountries.add(c11);
        Country c12 = new Country(63, "Ομόσπονδες Πολιτείες της Μικρονησίας", OCEANIA);
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
        // todo leipei 66_1
        //   ειναι λαθος 56,63, 69, 76
        // https://www.vectorizer.io/
        Country c18 = new Country(69, "Νήσοι Κουκ", OCEANIA);
        oceanianCountries.add(c18);
        Country c19 = new Country(70, "Ουαλίς και Φουτουνά", OCEANIA);
        oceanianCountries.add(c19);
        Country c20 = new Country(71, "Τουβαλού", OCEANIA);
        oceanianCountries.add(c20);
        Country c21 = new Country(72, "Ναουρού", OCEANIA);
        oceanianCountries.add(c21);
        Country c22 = new Country(73, "Νησί Νόρφολκ", OCEANIA);
        oceanianCountries.add(c22);
        Country c23 = new Country(74, "Νιούε", OCEANIA);
        oceanianCountries.add(c23);
        Country c24 = new Country(75, "Τοκελάου", OCEANIA);
        oceanianCountries.add(c24);
        Country c25 = new Country(76, "Νήσοι Πίτκαιρν", OCEANIA);
        oceanianCountries.add(c25);
        return oceanianCountries;
    }

}
