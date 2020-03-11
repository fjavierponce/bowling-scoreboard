package fponce.resource.loader;

import java.util.List;

import fponce.scoreboard.entity.Score;


public interface ScoreInputReader {

    List<Score> readScores();

    List<String> readPlayers();
}
