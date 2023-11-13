package streams;

import org.junit.Test;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.function.Function;

public class ExceptionOnStreams {

        Function<String, Integer> mapperThrowException = input -> {
            if (input.matches("\\D")) {
                throw new NumberFormatException();
            } else {
                return Integer.parseInt(input);
            }
        };

    Function<String, Publisher<Integer>> mapperBetterSolution = input -> {
        if (input.matches("\\D")) {
            return Mono.error(new NumberFormatException());
        } else {
            return Mono.just(Integer.parseInt(input));
        }
    };

    @Test
    public void testException() {
        Flux<String> inFlux = Flux.just("1", "1.5", "2");
        Flux<Integer> outFlux = inFlux.map(mapperThrowException);

        StepVerifier.create(outFlux)
            .expectNext(1)
            .expectError(NumberFormatException.class)
            .verify();
    }

    @Test
    public void testException2() {
        Flux<String> inFlux = Flux.just("1", "1.5", "2");
        Flux<Integer> outFlux = inFlux.flatMap(mapperBetterSolution);

        StepVerifier.create(outFlux)
                .expectNext(1)
                .expectError(NumberFormatException.class)
                .verify();
    }
}
