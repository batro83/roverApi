# roverApi


To change init setup use application.yaml.
You can change mars bounds, drop init rover, obstacle position.
The map is composed of squares. Rover can only go inside the squares, so the 0.1 position would not be correct. It would be correct row 1 column 1


##Stack
Springboot
Mockito

First of all I tried to initialize the project with map size, obstacles and the initial starting point of rover.
Reading the exercise I chose to make rover moves as a service.

##Tests
There is a application.yaml for integration tests. (src/test/resources/config)

##Improvements

- Check init drop of rover
- Check if the obstacles are inside the bounds
- Make Obstacles final
- Maybe try to refactor roverService and split it in one class per move, to be more readable.
- Refine integration test to cover more facing situations
