package com.example.project1;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Data @AllArgsConstructor
@Service
public class TeasherServise {
    ArrayList<Teacher> techer = new ArrayList<>();
    public ArrayList<Teacher> getStudent(){
        return techer;
    }
    public void AddStudent(Teacher teachers){
        techer.add(teachers);

    }
    public void SetTeacher(Integer id, Teacher teachers){
        techer.set(id, teachers);
    }
    public void RemoveTeacher(int index){
        techer.remove(index);
    }
    public boolean updateTeacher(Integer id, Teacher teachers ){
        for(int i=0; i<techer.size();i++){
            if(techer.get(i).getID()==id){
                techer.set(i,teachers);
                return true;
            }
        }
        return false;
    }
    public boolean deletStudent(Integer id){
        for(int i=0; i<techer.size();i++){
            if(techer.get(id).getID()==id){
                techer.remove(i);
                return true;
            }
        }
        return false;
    }

}
