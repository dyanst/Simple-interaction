package com.wang.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;
    private String Name;
    private int Age;
    private String Residence;
    private String Address;
    private String Email;
    private int Phone;
    private String Freelance;

}
