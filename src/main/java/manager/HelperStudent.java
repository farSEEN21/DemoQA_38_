package manager;

import models.Gender;
import models.Hobby;
import models.StudentDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface HelperStudent extends HelperBase {

    default void selectForms() {
        click(By.xpath("//div[@class='category-cards']/div[2]"));
    }


    default void selectPractisForms() {

        click(By.xpath("//*[.='Practice Form']"));
    }

    default void fillForm(StudentDTO studen) {
        type(By.id("firstName"), studen.getFirstName());
        type(By.id("lastName"), studen.getLastName());
        type(By.id("userEmail"), studen.getEmail());

        type(By.id("userNumber"), studen.getPhone());
        //   typeBDay(studen.getBirthday());
        chooseDate(studen.getBirthday());
//        FromNumToString(studen.getBirthday());
        type(By.id("currentAddress"), studen.getAddress());
        typeState(studen.getState());
        typeCity(studen.getCity());
        addSubject(studen.getSubjects());
        selectGender(studen.getGender());
        selectHobby(studen.getHobbies());
    }

    default void chooseDate(String birthday) {
        click(By.id("dateOfBirthInput"));
        List datesplit = Arrays.asList(birthday.split(" "));
        String year = datesplit.get(2).toString();
        String month = String.valueOf(Integer.parseInt(datesplit.get(0).toString()) - 1);


        String day = datesplit.get(1).toString();
//         month=Integer.parseInt(month)-1+"";
//                System.out.println(month);
//                click(By.cssSelector("react-datepicker__month"));
//        String now=LocalDate. now().toString();
        List<Integer> date = splitbithday(birthday);
//        List<Integer> dateNow =   splitNow(now);
//        System.out.println("Date year Now " +dateNow.get(0)+ " Bith year"+date.get(2));
//        int clicks=dateNow.get(0)-1900;
//        System.out.println(dateNow.get(2));
//        int clickmonth=0;
//       String month=  FromNumToString(birthday);
        System.out.println(month);


        // click(By.id("dateOfBirthInput"));
        chooseyear(By.xpath("//select[@class='react-datepicker__year-select']"), year);

        choosemonth(By.xpath("//select[@class='react-datepicker__month-select']"), month);
        chooseday(By.cssSelector(".react-datepicker__day.react-datepicker__day--0" + day));


//        if(dateNow.get(2)>1){ clickmonth= date.get(1);}
//                //date.get(2);
//        clicks=clicks*12;
//        for (int i=0;i<clicks+dateNow.get(2);i++)
//        {
//            click(By.xpath("//button[normalize-space()='Previous Month']"));
//        }
//        for(int i=0;i<clickmonth;i++)
//        {
//            click(By.xpath("//button[normalize-space()='Next Month']"));
//        }

        //  int year=Integer.parseInt(  data.get(2));
//        int month=Integer.parseInt((String) data.get(0));
////        int dayt=Integer.parseInt((String) data.get(1));
//click(By.id("dateOfBirthInput"));
//pause( 3000);
//
//
//    click(By.xpath("//select[@class='class=react-datepicker__year-dropdown-container react-datepicker__year-dropdown-container--select']"));
//        click(By.xpath("//select[@class='react-datepicker__year-select']"));
//          click(By.xpath("//button[normalize-space()='Next Month']"));


    }

    default List splitbithday(String birthday) {
        List<Integer> birth = new ArrayList<>();
        String[] datesplit = birthday.split(" ");
        for (int i = 0; i < datesplit.length; i++) {
            birth.add(Integer.parseInt(datesplit[i]));
        }
        return birth;
    }

    default String[] splitBithdayIn(String birthday) {

        String[] datesplit = birthday.split(" ");
        return datesplit;
    }

    default List splitNow(String birthday) {
        List<Integer> birth = new ArrayList<>();
        String[] datesplit = birthday.split("-");
        for (int i = 0; i < datesplit.length; i++) {
            birth.add(Integer.parseInt(datesplit[i]));
        }
        return birth;
    }

    default String FromNumToString(String birthday) {
//        click(By.id("dateOfBirthInput"));
//        String now=LocalDate. now().toString();
//        List<Integer> dateNow =   splitNow(now);
//        System.out.println(dateNow.get(1).toString());
        List datesplit = Arrays.asList(birthday.split(" "));
        int month = Integer.parseInt(datesplit.get(1).toString());
        String mounth = "";

        if (month == 1) {
            mounth = "January";
        } else if (month == 2) {
            mounth = "February";
        } else if (month == 3) {
            mounth = "March";
        } else if (month == 4) {
            mounth = "April";
        } else if (month == 5) {
            mounth = "May";
        } else if (month == 6) {
            mounth = "June";
        } else if (month == 7) {
            mounth = "July";
        } else if (month == 8) {
            mounth = "August";
        } else if (month == 9) {
            mounth = "September";
        } else if (month == 10) {
            mounth = "October";
        } else if (month == 11) {
            mounth = "November";
        } else if (month == 12) {
            mounth = "December";
        }
        return mounth;
//              String year=dateNow.get(0).toString();
//        String day=dateNow.get(2).toString();

//        typeBD(By.xpath("//input[@value='"+day+" "+mounth+" "+year+"']"),birthday);
//        typeBD(By.xpath("//*[@id='dateOfBirthInput']"),birthday);

    }


    default void selectGender(Gender gender) {
        if (gender.equals(Gender.MALE)) {

            click(By.cssSelector("label[for='gender-radio-1']"));
        } else if (gender.equals(Gender.FEMALE)) {
            click(By.cssSelector("label[for='gender-radio-2']"));
        } else {
            click(By.cssSelector("label[for='gender-radio-3']"));
        }
    }

    default void addSubject(String subjects) {
        String[] split = subjects.split(",");
        String locator = "subjectsInput"; //Container
        click(By.id(locator));
        for (String subject : split) {
            wd.findElement(By.id(locator)).sendKeys((subject));
            wd.findElement(By.id(locator)).sendKeys((Keys.ENTER));
        }
    }

    default void selectHobby(List<Hobby> hobbies) {
        for (Hobby hobby : hobbies) {
            switch (hobby) {
                case SPORTS:

                    click(By.xpath("//label[normalize-space()='Sports']"));
                    break;

                case READING:

                    click(By.xpath("//label[normalize-space()='Reading']"));
                    break;
                case MUSIC:

                    click(By.xpath("//label[normalize-space()='Music']"));
                    break;


            }
        }


    }

    default void typeState(String state) {
        wd.findElement(By.id("react-select-3-input")).sendKeys(state);
        wd.findElement(By.id("react-select-3-input")).sendKeys((Keys.ENTER));
    }

    default void typeCity(String city) {
        wd.findElement(By.id("react-select-4-input")).sendKeys(city);
        wd.findElement(By.id("react-select-4-input")).sendKeys((Keys.ENTER));
    }

    default void submit() {
        click(By.id("submit"));
    }

}


