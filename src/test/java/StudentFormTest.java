import manager.AppManager;
import manager.HelperBase;
import manager.HelperStudent;
import models.Gender;
import models.Hobby;
import models.StudentDTO;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentFormTest implements HelperStudent, AppManager {




    @BeforeTest
    public void precondition(){


        selectForms();

        selectPractisForms();

    }
@Test
public void studentFormPositive(){
        List<Hobby> hobby=new ArrayList<>();
        hobby.add(Hobby.READING);
        hobby.add(Hobby.MUSIC);
        hobby.add(Hobby.SPORTS);
    StudentDTO studentDTO=StudentDTO.builder()
            .firstName("Sarah")
            .LastName("Conner")
            .email("sara@dasdk.ru")
            .gender(Gender.OTHER)
            .phone("12332112332")
            .birthday("6 29 2000")
            .subjects("Maths,Physics")
            .hobbies(hobby)
            .address("Main Street 2")
            .State("NCR")
            .city("Delhi")
            .build();
    hideFooter();
    hideDiv();
fillForm(studentDTO);

    RemoveAdd();
submit();

}


}
