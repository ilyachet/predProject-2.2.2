package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;
import web.service.CarServiceImpl;

@Controller
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarServiceImpl carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String printAllCars(@RequestParam(name = "count", required = false) String count, Model model) {
        if (count != null) {
            model.addAttribute("count", count);
            model.addAttribute("carList", carService.showFewCars(Integer.parseInt(count)));
        } else {
            model.addAttribute("carList", carService.index());
        }
        return "cars";

    }
}
