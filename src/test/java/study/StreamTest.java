package study;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import modernjavainaction.Trader;
import modernjavainaction.Transaction;
import org.junit.jupiter.api.Nested;
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

    @Test
    void 무한스트림에_필터를걸면_종료가_될까() {
        IntStream.iterate(0, n -> n + 4)
                .filter(n -> n < 100)
                .forEach(System.out::println);
    }

    @Test
    void groupBy로_collect_해보자() {
        Map<Trader, List<Transaction>> collect = transactions.stream().collect(groupingBy(Transaction::getTrader));
        collect.forEach((trader, transaction) -> {
            System.out.println(trader);
            transaction.forEach(System.out::println);
            System.out.println();
        });
    }

    @Test
    void 리듀스테스트() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
        List<Integer> numbers = stream.reduce(
                new ArrayList<Integer>(),
                (List<Integer> list, Integer e) -> {
                    list.add(e);
                    return list;
                },
                (List<Integer> list1, List<Integer> list2) -> {
                    list1.addAll(list2);
                    return list1;
                }
        );

        numbers.forEach(System.out::println);
    }

    class Dish {
        private String type;
        private String name;

        public Dish(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }
    }

    @Test
    void flatMapping() {
        //given
        List<Dish> menu = List.of(new Dish("beef", "hihi"), new Dish("pork", "byebye"));
        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", List.of("greasy", "salty"));
        dishTags.put("beef", List.of("salty", "roasted"));
        //when
//        menu.stream().map((hi) -> "hi").collect(groupingBy(Dish::getName,
//                Collectors.flatMapping((Dish dish) -> dishTags.get(dish.getName()).stream(), toSet())));

    }

    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(partitioningBy(candidate -> isPrime(candidate)));
    }

    public boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    @Test
    void recursiveTask() {
        class Fibonacci extends RecursiveTask<Integer> {
            final int n;

            Fibonacci(int n) {
                this.n = n;
            }

            protected Integer compute() {
                if (n <= 1) {
                    return n;
                }
                Fibonacci f1 = new Fibonacci(n - 1);
                f1.fork();
                Fibonacci f2 = new Fibonacci(n - 2);
                return f2.compute() + f1.join();
            }
        }

        int result = new ForkJoinPool().invoke(new Fibonacci(12));

        System.out.println(result);
    }

    @Test
    void arrayAsList() {
    }

    interface Task {
        void execute();
    }

    public static void doSomething(Runnable r) {
        r.run();
    }

    public static void doSomething(Task t) {
        t.execute();
    }

    @Nested
    class Intellij {
        @Test
        void lambdaIntellij() {
            doSomething((Task) ()-> System.out.println("hihi"));
        }

    }
}
