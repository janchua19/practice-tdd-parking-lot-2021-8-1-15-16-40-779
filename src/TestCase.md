# Story 1
[X] Case1
    Given a parking lot and a car  
    When park the car  
    Then return a parking ticket  

[X] Case2
    Given a parking lot with a parked car and a parking ticket  
    When fetch the car  
    Then return a parked car  

[X] Case3
    Given a parking lot with two ticket and two parking tickets  
    When fetch the car  
    Then return the right car  

[X] Case4
    Given a parking lot and a wrong ticket  
    When customer fetch the car  
    Then return no car

[X] Case5
    Given a parking lot and used ticket  
    When fetch the car  
    Then return no car  

[X] Case6
    Given a parking lot but no space available  
    When park the car  
    Then return no parking ticket 

# Story 2
[X] Case1
    Given a parking lot and unrecognized ticket  
    When fetch the car  
    Then return no car with error unrecognized parking ticket  

[X] Case2
    Given a parking lot and used ticket  
    When fetch the car  
    Then return no car with error unrecognized parking ticket 

[X] Case3
    Given a parking lot and without any position and car  
    When park the car  
    Then return no car with error no available position

# Story 3
[X] Case1
Given a parking lot and a standard parking boy, and a car  
When park the car  
Then return a parking ticket

[X] Case2
Given a parking lot with a parked car, a standard parking boy, and a parking ticket  
When fetch the car  
Then return a parked car

[X] Case3
Given a parking lot with two parked cars, a standard parking boy, and two parking tickets  
When fetch the car  
Then return the right car with each ticket

[X] Case4
Given a parking lot, a standard parking boy, and a wrong parking ticket  
When customer fetch the car  
Then return nothing with error message Unrecognized parking ticket

[X] Case5
Given a parking lot, a standard parking boy, and used parking ticket  
When fetch the car  
Then return nothing with error message Unrecognized parking ticket

[X] Case6
Given a parking lot with no  position, a standard parking boy, and a car  
When park the car  
Then return nothing with error message No available position

# Story 4
[X] Case1
Given a standard parking boy, who manages two parking lots both with available position, and a car  
When park the car  
Then the car will be parked to the first parking lot

[] Case2
Given a standard parking boy, who manage two parking lots, first us full and second with available position and a car  
When park the car  
Then the car will be parked to second parking lot

[] Case3
Given a standard parking boy, who manage two parking lots, both with a parked car and two parking ticket  
When fetch the car twice  
Then return the right car with each ticket

[] Case4
Given a standard parking boy, who manage two parking lots, and an unrecognized ticket  
When customer fetch the car  
Then return nothing with error message Unrecognized parking ticket

[] Case5
Given a standard parking boy, who manage two parking lots, and an used ticket   
When fetch the car  
Then return nothing with error message Unrecognized parking ticket

[] Case6
Given a standard parking boy, who manage two parking lots, both without available position and a car
When park the car  
Then return nothing with error message No available position