package fponce.io.reader;

import java.util.List;
import fponce.domain.Shot;


public interface ScoreInputReaderService {

    List<Shot> readScores();

    List<String> readPlayers();
}
