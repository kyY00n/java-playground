package networksecurity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SaltFinder {

    // 경로 수정 필요
    public static final String PASSWORD_FILE_PATH = "/Users/oieuoa/dev/playground/java-playground/src/main/java/networksecurity/1MillionPassword_wordlist.txt";
    public static final String HASH_FILE_PATH = "/Users/oieuoa/dev/playground/java-playground/src/main/java/networksecurity/1MillionPassword_hashed.txt";

    // 파일 경로 수정 필요
    public static void main(String[] args) {
        try {
            // 패스워드 해시를 읽어옴
            Set<String> passwordHashes = readPasswordHashes();
            // 샘플 워드를 가져옴
            String sampleWord = getSampleWord();
            // 가능한 솔트를 생성
            List<String> salts = buildSalts();

            // 병렬 스트림을 사용하여 모든 솔트를 확인하고, 해시와 일치하는지 확인
            salts.parallelStream()
                    .forEach(salt -> {
                        try {
                            // 샘플 워드와 솔트를 결합하여 솔트된 워드 생성
                            String saltedWord = sampleWord + salt;
                            // 솔트된 워드를 MD5 해시로 변환
                            String hash = MD5.hash(saltedWord);
                            // 해시된 패스워드와 일치하는지 확인하고, 일치하면 솔트 출력
                            if (passwordHashes.contains(hash)) {
                                System.out.println("salt: " + salt);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 가능한 모든 솔트를 생성하는 메서드
    private static List<String> buildSalts() {
        // 사용할 문자열
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        List<String> salts = new ArrayList<>();
        // 모든 가능한 솔트 생성
        for (int i = 0; i < characters.length(); i++) {
            for (int j = 0; j < characters.length(); j++) {
                for (int k = 0; k < characters.length(); k++) {
                    for (int l = 0; l < characters.length(); l++) {
                        String salt = "" + characters.charAt(i) + characters.charAt(j) + characters.charAt(k)
                                + characters.charAt(l);
                        salts.add(salt);
                    }
                }
            }
        }
        return salts;
    }

    // 샘플 워드를 가져오는 메서드
    private static String getSampleWord() throws IOException {
        // 파일에서 샘플 워드를 읽어옴
        BufferedReader wordlistReader = new BufferedReader(
                new FileReader(PASSWORD_FILE_PATH));
        String sampleWord = wordlistReader.readLine();
        return sampleWord;
    }

    // 패스워드 해시를 읽어오는 메서드
    private static Set<String> readPasswordHashes() throws IOException {
        // 파일에서 패스워드 해시를 읽어옴
        BufferedReader hashedPasswordReader = new BufferedReader(
                new FileReader(HASH_FILE_PATH));
        Set<String> hashedPasswords = new HashSet<>();

        while (hashedPasswordReader.ready()) {
            String hash = hashedPasswordReader.readLine();
            hashedPasswords.add(hash);
        }
        return hashedPasswords;
    }

}
