package fponce.resource.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fponce.scoreboard.entity.Score;

@Service
class FileScoreInputReaderService implements ScoreInputReaderService {

    @Override
    public List<Score> readScores() {
        try {
            Path path = Paths.get("src/main/resources/scores.txt");
            List<String> data = Files.readAllLines(path);
            if (!data.isEmpty()) {
                List<Score> orderedScores = data.stream()
                        .map(this::createIndividualScore)
                        .collect(Collectors.toList());
                return orderedScores;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public List<String> readPlayers() {
        List<Score> scores = readScores();
        return scores.stream()
                .map(Score::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    private Score createIndividualScore(String s) {
        String[] a = s.split(" ");
        return new Score(a[0], a[1]);
    }
}
