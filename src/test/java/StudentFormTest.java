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
            .birthday("05 05 2000")
            .subjects("Maths,Physics")
            .hobbies(hobby)
            .address("Main Street 2")
            .State("NCR")
            .city("Delhi")
            .build();
fillForm(studentDTO);
pause(5000);
submit();

}


}
