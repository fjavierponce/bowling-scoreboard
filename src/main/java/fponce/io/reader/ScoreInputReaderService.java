package fponce.io.reader;

import java.util.List;
import fponce.domain.Score;


public interface ScoreInputReaderService {

    List<Score> readScores();

    List<String> readPlayers();
}
