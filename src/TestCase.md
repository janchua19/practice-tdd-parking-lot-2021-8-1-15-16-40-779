# story 1
[] Case1
    Given a parking lot and a car  
    When park the car  
    Then return a parking ticket  

[] Case2
    Given a parking lot and a ticket  
    When fetch the car  
    Then return a car  

[] Case3
    Given a parking lot and a used ticket  
    When fetch the car  
    Then return a no car  

[] Case4
    Given a parking lot and a wrong ticket  
    When customer fetch the car  
    Then return a no car

[] Case5
    Given a parking lot but no space available  
    When park the car  
    Then return no parking ticket 

[] Case6
    Given a parking lot with two car and two parking ticket 
    When fetch the car  
    Then return correct car