package uz.pdp.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@ToString
public class Student {
private Integer id;
private String name;
private String email;
private  String course;

private Class student_className;
private String phone;







}
