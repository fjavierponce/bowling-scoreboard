package fponce.io.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import fponce.domain.Shot;

@Service
class FileScoreInputReaderService implements ScoreInputReaderService {

    @Override
    public List<Shot> readScores() {
        try {
            Path path = Paths.get("src/main/resources/scores.txt");
            List<String> data = Files.readAllLines(path);
            if (!data.isEmpty()) {
                List<Shot> orderedShots = data.stream()
                        .map(this::createIndividualScore)
                        .collect(Collectors.toList());
                return orderedShots;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    @Override
    public List<String> readPlayers() {
        List<Shot> shots = readScores();
        return shots.stream()
                .map(Shot::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    private Shot createIndividualScore(String s) {
        String[] a = s.split(" ");
        return new Shot(a[0], a[1]);
    }
}
