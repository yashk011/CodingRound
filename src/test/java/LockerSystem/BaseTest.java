package LockerSystem;

import org.example.lockermanagementsystem.controller.LockerController;
import org.example.lockermanagementsystem.controller.OrdersController;
import org.example.lockermanagementsystem.respository.LockerRepository;
import org.example.lockermanagementsystem.respository.SlotOtpRepository;
import org.example.lockermanagementsystem.service.DeliveryPersonService;
import org.example.lockermanagementsystem.service.LockerService;
import org.example.lockermanagementsystem.service.NotificationService;
import org.example.lockermanagementsystem.service.OtpService;
import org.example.lockermanagementsystem.strategy.*;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    LockerService lockerService;
    DeliveryPersonService deliveryPersonService;
    OtpService otpService;
    NotificationService notificationService;

    LockerController lockerController;
    OrdersController ordersController;

    @BeforeEach
    public void setUp() {
        SlotSelectionStrategy slotSelectionStrategy = new RandomSlotSelectionStrategy(new RandomNumberGenerator());
        SlotFilteringStrategy slotFilteringStrategy = new DefaultSlotFilteringStrategy();
        LockerRepository lockerRepository = new LockerRepository();
        SlotOtpRepository slotOtpRepository = new SlotOtpRepository();
        IOtpGenerator otpGenerator = new RandomOtpGenerator();


         lockerService = new LockerService(lockerRepository, slotFilteringStrategy, slotSelectionStrategy);
         notificationService = new NotificationService();
         deliveryPersonService = new DeliveryPersonService();
         otpService = new OtpService(slotOtpRepository, otpGenerator);

         lockerController = new LockerController(lockerService, otpService);
         ordersController = new OrdersController(lockerService, otpService, notificationService);

    }
}
