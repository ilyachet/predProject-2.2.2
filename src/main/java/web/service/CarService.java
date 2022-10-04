package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService implements Service{

    private List<Car> carList;

    private CarService() {
        this.carList = new ArrayList<>();

        this.carList.add(new Car("Car1", 1, "Owner1"));
        this.carList.add(new Car("Car2", 2, "Owner2"));
        this.carList.add(new Car("Car3", 3, "Owner3"));
        this.carList.add(new Car("Car4", 4, "Owner4"));
        this.carList.add(new Car("Car5", 5, "Owner5"));
    }

    public List<Car> index() {
        return this.carList;
    }

    public List<Car> showFewCars(int i) {

        if (i >= 1 && i <5) {
            return this.carList.stream().limit(i).collect(Collectors.toList());
        }
        else {
            return this.carList;
        }
    }
}
