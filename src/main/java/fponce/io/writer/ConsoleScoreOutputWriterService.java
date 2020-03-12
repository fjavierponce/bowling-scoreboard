package fponce.io.writer;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import fponce.domain.Shot;

@Service
public class ConsoleScoreOutputWriterService implements ScoreOutputWriterService {

    private Log logger = LogFactory.getLog(ConsoleScoreOutputWriterService.class);

    @Override
    public void printScores(List<Shot> shots) {
        shots.forEach(System.out::println);
    }

    @Override
    public void printPlayers(List<String> players) {
        players.forEach(System.out::println);
    }
}
