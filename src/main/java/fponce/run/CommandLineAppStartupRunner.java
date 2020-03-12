package fponce.run;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import fponce.resource.reader.ScoreInputReaderService;
import fponce.resource.writer.ScoreOutputWriterService;
import fponce.scoreboard.entity.Score;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private ScoreInputReaderService reader;
    private ScoreOutputWriterService writer;

    public CommandLineAppStartupRunner(ScoreInputReaderService reader, ScoreOutputWriterService writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run(String...args) {
        List<Score> scores = reader.readScores();
        writer.printScores(scores);
        List<String> players = reader.readPlayers();
        writer.printPlayers(players);
    }

}
