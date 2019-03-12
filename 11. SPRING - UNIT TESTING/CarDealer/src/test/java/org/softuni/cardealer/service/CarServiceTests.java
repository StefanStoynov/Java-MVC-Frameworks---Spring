package org.softuni.cardealer.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.softuni.cardealer.domain.entities.Car;
import org.softuni.cardealer.domain.models.service.CarServiceModel;
import org.softuni.cardealer.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CarServiceTests {

    private static final String ID = "carID";
    @Autowired
    private CarRepository carRepository;
    private CarService carService;
    private ModelMapper modelMapper;
    @Mock
    private CarRepository mockedCarRepository;
    private CarService carServiceWithMockedRepository;

    @Before
    public void init() {
        this.mockedCarRepository = Mockito.mock(CarRepository.class);
        this.modelMapper = new ModelMapper();
        this.carServiceWithMockedRepository = new CarServiceImpl(this.mockedCarRepository, this.modelMapper);
        this.carService = new CarServiceImpl(this.carRepository, this.modelMapper);
    }

    private Car getCar() {
        Car car = new Car();
        car.setMake("Mercedes");
        car.setModel("w208");
        car.setTravelledDistance(11L);

        return car;
    }

    private CarServiceModel getCarWithCorrectData() {
        CarServiceModel model = new CarServiceModel();
        model.setMake("Audi");
        model.setModel("A8");
        model.setTravelledDistance(12L);

        return model;
    }

    private CarServiceModel getCarWithNullMake() {
        CarServiceModel model = new CarServiceModel();
        model.setMake(null);
        model.setModel("z4");
        model.setTravelledDistance(13L);

        return model;
    }

    private CarServiceModel getCarWithNullModel() {
        CarServiceModel model = new CarServiceModel();
        model.setMake("BMW");
        model.setModel(null);
        model.setTravelledDistance(13L);

        return model;
    }

    private CarServiceModel getCarWithNullDistance() {
        CarServiceModel model = new CarServiceModel();
        model.setMake("BMW");
        model.setModel("e90");
        model.setTravelledDistance(null);

        return model;
    }

    @Test
    public void car_findCarById_returnCarById() {
        Mockito.when(mockedCarRepository.findById(ID)).thenReturn(Optional.of(new Car() {
            {
                setId(ID);
            }
        }));

        CarServiceModel carFound = carServiceWithMockedRepository.findCarById(ID);

        assertEquals(ID, carFound.getId());
    }

    @Test
    public void car_findCarByInvalidId_returnNull(){
        Mockito.when(mockedCarRepository.findById(ID)).thenReturn(null);


        CarServiceModel model = carServiceWithMockedRepository.findCarById(ID);

        assertEquals(null, model);

        
    }
    

}
