package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IStudentService;

@Controller
@RequestMapping("/acc")
public class StudentController {
    @Autowired
    IStudentService iStudentService;

    @GetMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list", iStudentService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView;
    }
    @GetMapping("/edit{id}")
    public ModelAndView showEdit(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("student",iStudentService.findById(id));
        return modelAndView;
    }
    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam String name){
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("list",iStudentService.findAllByName(name));
        return modelAndView;
    }
    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam long id) {
        iStudentService.Delete(iStudentService.findById(id));
        ModelAndView modelAndView = new ModelAndView("redirect:/acc/show");
        return modelAndView;
    }
    @PostMapping("/edit/{id}")
    public ModelAndView edit(@ModelAttribute Student student){
        iStudentService.edit(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/acc/show");
       return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute Student student){
       iStudentService.save(student);
       ModelAndView modelAttribute = new ModelAndView("redirect:/acc/show");
       return modelAttribute;
    }
}
