package fponce.io.writer;

import java.util.List;

import fponce.domain.Shot;

public interface ScoreOutputWriterService {

    void printScores(List<Shot> shots);

    void printPlayers(List<String> players);
}
