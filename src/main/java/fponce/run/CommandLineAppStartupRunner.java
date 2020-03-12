package fponce.run;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import fponce.domain.ScoreBoard;
import fponce.io.reader.ScoreInputReaderService;
import fponce.io.writer.ScoreOutputWriterService;
import fponce.domain.Score;
import fponce.scoreboard.ScoreProcessorService;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private ScoreInputReaderService reader;
    private ScoreOutputWriterService writer;
    private ScoreProcessorService scoreProcessorService;

    public CommandLineAppStartupRunner(ScoreInputReaderService reader,
                                       ScoreOutputWriterService writer,
                                       ScoreProcessorService scoreProcessorService) {
        this.reader = reader;
        this.writer = writer;
        this.scoreProcessorService = scoreProcessorService;
    }

    @Override
    public void run(String...args) {
        List<Score> scores = reader.readScores();
        writer.printScores(scores);
        List<String> players = reader.readPlayers();
        writer.printPlayers(players);
        List<ScoreBoard> scoreBoards = scoreProcessorService.calculateScores(players, scores);
    }

}
