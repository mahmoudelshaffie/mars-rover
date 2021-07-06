package org.newstore.parsing;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.newstore.parsing.exceptions.InvalidObstacleInputException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObstaclesParser implements InputParser<Map<Integer, Integer>> {
	
	private final int LATITUDE = 0;
	private final int LONGTITUDE = 1;

	private TypeReference<List<Integer[]>> obstaclesTypeRef = new TypeReference<>(){};
	
	@Override
	public Map<Integer, Integer> parse(String input) {
		try {
			List<Integer[]> obstacles = new ObjectMapper().readValue(input, obstaclesTypeRef);
			return obstacles.stream().collect(Collectors.toMap(obs -> obs[LATITUDE], obs -> obs[LONGTITUDE]));
		} catch (Exception cause) {
			throw new InvalidObstacleInputException(input, cause);
		}
	}

}
