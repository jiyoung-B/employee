package project.spring4.mvc.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import project.spring4.mvc.employee.model.EmpVO;
import project.spring4.mvc.employee.service.EmpService;
@Controller
public class EmpController {
    private EmpService empsrv;
    @Autowired
    public EmpController(EmpService empsrv) {
        this.empsrv = empsrv;
    }

    @GetMapping("/emplist")
    public ModelAndView emplist(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("emp", empsrv.readEmp());
        mv.setViewName("emplist");
    return mv;

    }

    @GetMapping("/add")
    public String add() {
        return "newemp";
    }

    @PostMapping("/add")
    public ModelAndView newEmp(EmpVO emp){
        ModelAndView mv = new ModelAndView();
        String view = "empfail";
        if(empsrv.newEmp(emp)) {
            //mv.addObject("emp", emp);
            view = "redirect:/emplist";
        }
        mv.setViewName(view);
        return mv;

    }
    @GetMapping("/view")
    public ModelAndView view(@RequestParam int employee_id){
        ModelAndView mv = new ModelAndView();
        String view = "empfail";

        EmpVO emp = empsrv.readOneEmp(employee_id);
        if (emp != null) {
            mv.addObject("emp", emp);
            view = "empview";
        }
        mv.setViewName(view);
        return mv;

    }


    @GetMapping("/modify")
    public ModelAndView modify(@RequestParam int employee_id){
        ModelAndView mv = new ModelAndView();
        mv.addObject("emp", empsrv.readOneEmp(employee_id));
        mv.setViewName("empview");
        return mv;
    }

    @PostMapping("/modify")
    public ModelAndView modify(EmpVO emp){
        String view = "empfail";
        ModelAndView mv = new ModelAndView();
        if(empsrv.modifyEmp(emp)){
            view = "redirect:/view?employee_id=" + emp.getEmployee_id();
        }
        mv.setViewName(view);
        return mv;
    }


}
