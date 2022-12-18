package com.example.project1;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Data @AllArgsConstructor
@Service

public class StudentServise {
ArrayList<Student> student = new ArrayList<>();
public ArrayList<Student> getStudent(){
    return student;
}
public void AddStudent(Student students){
      student.add(students);

}
public void SetStudent(Integer id, Student students){
      student.set(id, students);
}
public void RemoveStudent(int index){
      student.remove(index);
}
public boolean updateStudent(Integer id, Student students ){
       for(int i=0; i<student.size();i++){
           if(student.get(id).getId()==id){
               student.set(i,students);
                return true;
           }
       }
       return false;
}
    public boolean deletStudent(Integer id){
        for(int i=0; i<student.size();i++){
            if(student.get(id).getId()==id){
                student.remove(i);
                  return true;
            }
        }
        return false;
    }

}
