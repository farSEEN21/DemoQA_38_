package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@Builder
@ToString
public class StudentDTO {


    String firstName;
    String LastName;
    String email;
    Gender gender;
    String phone;
    String birthday;
    String subjects;
    List<Hobby> hobbies;
    String address;
    String State;
    String city;




}
