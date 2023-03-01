package study;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import modernjavainaction.Trader;
import modernjavainaction.Transaction;
import org.junit.jupiter.api.Test;

public class StreamTest {

    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");
    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    @Test
    void _2011에_일어난_트랜잭션을_찾아_오름차순으로_정렬() {
        List<Integer> result = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .map(Transaction::getValue).sorted()
                .collect(Collectors.toList());
        result.forEach(System.out::println);
    }

    @Test
    void 거래자가_근무하는_모든_도시를_중복_없이_나열() {
        List<Trader> traders = List.of(raoul, mario, alan, brian);
        Stream<String> distinctCity = traders.stream().map(Trader::getCity).distinct(); // collect 시 toSet()으로 할 수 있겠당.
        distinctCity.forEach(System.out::println);
    }

    @Test
    void 케임브리지에서_근무하는_모든_거래자를_찾아서_이름순으로_정렬() {
        List<Trader> traders = List.of(raoul, mario, alan, brian);
        List<Trader> cambridgeTraders = traders.stream().filter(trader -> trader.getCity().equals("Cambridge")).sorted(
                Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        cambridgeTraders.forEach(System.out::println);
    }

    @Test
    void 모든_거래자의_이름을_알파벳순으로_정렬해서_반환() {
        List<Trader> traders = List.of(raoul, mario, alan, brian);
        List<String> traderNames = traders.stream().map(Trader::getName).sorted().collect(Collectors.toList());
        traderNames.forEach(System.out::println);
    }

    @Test
    void 밀라노에_거래자가_있는지() {
        List<Trader> traders = List.of(raoul, mario, alan, brian);
        boolean milanoTraderExists = traders.stream().anyMatch(trader -> trader.getCity().equals("Milano"));
        System.out.println(milanoTraderExists);
    }

    @Test
    void 케임브리지에_거주하는_거래자의_모든_트랜잭션값을_출력() {
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .forEach(System.out::println);
    }

    @Test
    void 전체_트랜잭션_중_최댓값은_얼마인가() {
        Integer max = transactions.stream().map(Transaction::getValue).reduce(Integer::max).orElseThrow();
        System.out.println(max);
    }


    @Test
    void 전체_트랜잭션_중_최솟값은_얼마인가() {
        Transaction min = transactions.stream().min(Comparator.comparingInt(Transaction::getValue)).orElseThrow();
        System.out.println(min.getValue());
    }

    @Test
    void 무한_스트림은_정렬하거나_리듀스할_수_없다() {
        Optional<Double> max = Stream.generate(Math::random)
                .limit(5)
                .reduce(Double::max);
        // 되는디요

        Stream.iterate(0, n -> n + 2)
                .limit(6)
                .forEach(System.out::println);


    }

    @Test
    void 무한스트림에서_가능한_중간연산() {
        Stream.generate(Math::random)
                .map(i -> 1)
                .forEach(System.out::println); // 안 멈춘다.. 컴퓨터가 게속 1을 토한다..
    }
}
