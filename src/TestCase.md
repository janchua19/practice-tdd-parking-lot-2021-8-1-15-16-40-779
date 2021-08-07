# story 1
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

# story 2
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