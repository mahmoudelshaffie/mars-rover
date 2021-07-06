# mars-rover

Rover is operate on globe that cooardinates & directions as:
								
								
								 (NORTH)	
									^(+Ve)
									|
									|
		(-Ve)						|(0, 0)					(+Ve)
(WEST)		<-----------------------|------------------------> (East)
									|
									|
									|
									|
									v(-Ve)
								 (SOUTH)
								 
# Rover start requires:
## Start position: position rover start from it 
## Commands: sequence of movements
## Obstacles: cooardinates of obstacles that rover might face (optional)

# Build Instructions
- Goto Repository Directory
- Run command to build docker image: docker build -t mars-rover:latest .
- Run the app: docker run -it -t mars-rover:latest "(0, 0) NORTH" "FFLFFLFFRBBBBBRFFFFFFFFF" "[[1, 0], [-2, 2]]"
- Then the the last position that rover stopped at would be displayed: (0, 2) NORTH

# (*) Last argument 'obstacles' is optional



