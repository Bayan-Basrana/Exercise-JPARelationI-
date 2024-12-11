package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.ApiResponse.ApiException;
import com.example.schoolmanagement.Model.Address;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.AddressRepository;
import com.example.schoolmanagement.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final AddressRepository addressRepository;

    public List<Teacher> getTeacher (){
        return teacherRepository.findAll();
    }

    public void addTeacher (Teacher teacher) {
        teacherRepository.save(teacher);
    }


    public void updateTeacher (Integer id , Teacher teacher){
        Teacher old = teacherRepository.findTeacherById(id);
        if (old==null){
            throw new ApiException("Teacher id not found");
        }
        old.setName(teacher.getName());
        old.setAge(teacher.getAge());
        old.setSalary(teacher.getSalary());
        old.setEmail(teacher.getEmail());
        teacherRepository.save(old);
    }

    public void delete (Integer id ){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher==null){
            throw new ApiException("Teacher id not found");
        }
        Address address=addressRepository.findAddressById(id);
        teacher.setAddress(null);
        addressRepository.delete(address);
        teacherRepository.delete(teacher);
    }


    public Teacher getTeacherByTeacherId (Integer id){
        Teacher teacher= teacherRepository.findTeacherById(id);
        if (teacher==null){
            throw new ApiException("Teacher id not found");
        }
        return teacher;
    }
}
