package com.example.project1;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v2")
public class TeacherController {
    ArrayList<Teacher> teacher = new ArrayList<>();
    private final TeasherServise teachertServise;

    public TeacherController(TeasherServise teachertServise) {
        this.teachertServise = teachertServise;
    }


    @GetMapping("/get")
    public ResponseEntity getTeacher() {
        ArrayList<Teacher> teacher = teachertServise.getStudent();
        return ResponseEntity.status(200).body(teacher);
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        return ResponseEntity.status(200).body(teacher);
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updateTeacher(@PathVariable int index, @RequestBody @Valid Teacher teachers, Errors errors) {
        if (errors.hasErrors()) {
            String massege = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massege));
        }
        teacher.set(index, teachers);
        return ResponseEntity.status(200).body("Teacher updated");
    }
    @DeleteMapping("/delet/{index}")
    public ResponseEntity deletStudent(@PathVariable Integer id,@Valid int index, Errors errors){

        if (errors.hasErrors()) {
            String massege = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        boolean isDeleted=teachertServise.deletStudent(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Teacher deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong Id!"));
    }
    @GetMapping("/getid")
    public Teacher techerID(Teacher ID){
        for (int i=0;i<teacher.size();i++){
            if (ID==teacher.get(i)){
                return teacher.get(i);
            }
        }
        return null;
    }
    @GetMapping("/getsalery")
    public Teacher teacherSalary(Teacher salary){
        for (int i=0;i<teacher.size();i++){
            if (salary==teacher.get(i)){
                return teacher.get(i);
            }
        }
        return null;
    }

}
