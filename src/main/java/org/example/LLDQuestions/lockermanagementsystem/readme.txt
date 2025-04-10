Locker -
    id : String
    slots : List<Slots>

Slot -
    id: String
    isOccupied : boolean
    lockerItem : LockerItem
    allocationDate : Date

LockerItem -
    getSize()

Package -
    String id
    Size size

LockerUser -
    id : String
    contact : Contact

Buyer extends LockerUser -

DeliveryPerson extends LockerUser

Contact -
    name - String
    phone - String

====================

Strategy

IRandomGenerator
    generateRandomNumber(int cap)

DefaultRandomGenerator implements IRandomGenerator
    generateRandomNumber(int cap)

SlotFinderStrategy -
    findSlot(List<Slot>)

DefaultSlotFinderStrategy implements LockerFinderStrategy -
    IRandomGenerator
    findSlot(List<Slot>)

SlotFilterStrategy
    filterSlot(List<Slot> , LockerItem lockerItem)

DefaultSlotFilterStrategy
    filterSlot(List<Slot> , LockerItem lockerItem)
========================
Service

DeliverPersonService
    DeliveryPerson getDeliveryPerson(Slot slot)

LockerService
    - slotAssignmentService : ISlotAssignmentService
    - slotFilteringService : ISlotFilteringService
    - lockerRepository : LockerRepository


    + createLocker()
    + createSlot()
    + allocateSlot()
    + getAllAvailableSlots() : List<Slot>
    + deallocateSLot()


NotificationService -
    sendNotification(LockerUser lockerUser, Slot slot , String otp) : void

OtpService -

    generateOtp(Slot slot) : String
    validateOtp(Slot slot, Otp otp) : boolean

==========================

Repository

  ISlotOtpRepository
      getOtp()
      addOtp()

  ILockerRepository
      createLocker()
      getAllAvailableSlot()

  SlotOtpRepository
      Map<String , String> slotOtpMap

  LockerRepository
       List<Locker> lockers


===========================
Controllers
    - LockerController
        + allocateSlot(Slot slot)
        + createLocker() : Locker
        + createSlot(Locker locker , Size size) : Slot
        + getAvailableSlot() : List<Slot>
        + unlockSlot(Slot slot)

    - OrderController

        + allocateLocker(LockerItem lockerItem, Buyer buyer)


    - ReturnController

        + returnOrder(LockerItem lockerItem)