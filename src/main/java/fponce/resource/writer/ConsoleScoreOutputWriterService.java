package fponce.resource.writer;

import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import fponce.scoreboard.entity.Score;

@Service
public class ConsoleScoreOutputWriterService implements ScoreOutputWriterService {

    private Log logger = LogFactory.getLog(ConsoleScoreOutputWriterService.class);

    @Override
    public void printScores(List<Score> scores) {
        scores.forEach(System.out::println);
    }

    @Override
    public void printPlayers(List<String> players) {
        players.forEach(System.out::println);
    }
}
