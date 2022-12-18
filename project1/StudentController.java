package com.example.project1;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
    ArrayList<Student> student = new ArrayList<>();
    private final StudentServise studentServise;


    public StudentController(StudentServise studentServise) {
        this.studentServise = studentServise;
    }

    @GetMapping("/get")
    public ResponseEntity getStudent() {
        ArrayList<Student> student = studentServise.getStudent();
        return ResponseEntity.status(200).body(student);
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody @Valid Student students, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(message));
        }
        return ResponseEntity.status(200).body(student);
    }

    @PutMapping("/update/{index}")
    public ResponseEntity updaStudent(@PathVariable int index, @RequestBody @Valid Student students, Errors errors) {
        if (errors.hasErrors()) {
            String massege = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(new ApiResponse(massege));
        }
        student.set(index, students);
        return ResponseEntity.status(200).body("Student updated");
    }
    @DeleteMapping("/delet/{index}")
    public ResponseEntity deletStudent(@PathVariable Integer id,@Valid int index, Errors errors){

        if (errors.hasErrors()) {
            String massege = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(massege);
        }
        boolean isDeleted=studentServise.deletStudent(id);
        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("Student deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Wrong Id!"));
    }
    @GetMapping("/getid/id")
    public Student StudentId(@RequestBody Student ID){
        for (int i=0;i<student.size();i++){
             if(ID==student.get(i)){
                return  student.get(i);
             }
        }
      return null;
    }
    @GetMapping("/getname/name")
    public Student studentName(@RequestBody Student name){
        for (int i=0;i<student.size();i++){
            if(name==student.get(i)){
                return student.get(i);
            }
        }
        return null;
    }
    @GetMapping("/getmajor/major")
    public Student StudentMajor(@RequestBody Student major){
        for (int i=0;i<student.size();i++){
            if(major==student.get(i)){
                return student.get(i);
            }
        }
        return null;
    }
    @GetMapping("/getage/age")
    public Student StudentAge(@RequestBody Student Age) {
        for (int i = 0; i < student.size(); i++) {
            Student var = student.get(i);
            if (Age == student.get(i)) {
                return student.get(i);

            } //else if (this.Age > student.get(i)) {
                //return student.get(i);

            //}

        }
        return null;
    }
}