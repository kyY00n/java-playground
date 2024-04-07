package networksecurity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordCracker {

    public static void main(String[] args) {
        // 파일 경로 수정 필요

        // 파일에서 읽은 해시값들
        ArrayList<String> passwordHashes = readPasswordHashes(
                "/Users/oieuoa/dev/playground/java-playground/src/main/java/networksecurity/1MillionPassword_hashed.txt");

        // 대상 워드리스트
        ArrayList<String> wordlist = readWordlist(
                "/Users/oieuoa/dev/playground/java-playground/src/main/java/networksecurity/1MillionPassword_wordlist.txt");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the salt: ");
        String salt = scanner.nextLine();
        // 해싱된 패스워드 크랙
        crackPasswords(passwordHashes, wordlist, salt);
    }

    // 파일에서 해싱된 패스워드 읽기
    public static ArrayList<String> readPasswordHashes(String filename) {
        ArrayList<String> hashes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                hashes.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hashes;
    }

    // 워드리스트 읽기
    public static ArrayList<String> readWordlist(String filename) {
        ArrayList<String> wordlist = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordlist.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordlist;
    }

    public static void crackPasswords(ArrayList<String> hashedPasswords, ArrayList<String> wordlist, String salt) {
        int count = 0;
        for (String passwordHash : hashedPasswords) {
            for (String password : wordlist) {
                String saltedPassword = password + salt;
                String hashed = MD5.hash(saltedPassword);
                if (hashed.equals(passwordHash)) {
                    System.out.println(++count + "/1000000 password has been cracked, hashed: " + hashed + ", cracked: "
                            + password);
                    break;
                }
            }
        }
    }

}
