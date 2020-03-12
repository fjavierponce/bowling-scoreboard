package fponce.resource.reader;

import java.util.List;
import fponce.scoreboard.entity.Score;


public interface ScoreInputReaderService {

    List<Score> readScores();

    List<String> readPlayers();
}
