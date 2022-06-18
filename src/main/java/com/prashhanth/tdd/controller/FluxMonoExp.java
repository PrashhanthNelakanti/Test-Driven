package com.prashhanth.tdd.controller;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.reflect.Array;
import java.util.Arrays;

public class FluxMonoExp {

    public Flux<String> getFruits(){
        return Flux.fromIterable(Arrays.asList("Apple","Mango","Lemon")).log();
    }

    public Flux<String> getFruitsMap(){
        return Flux.fromIterable(Arrays.asList("Apple","Mango","Lemon")).map(String::toUpperCase).log();
    }
    public Flux<String> getFruitsMFlatmap(){
        return Flux.fromIterable(Arrays.asList("Apple","Mango","Lemon")).flatMap(s->Flux.just(s.split(""))).log();
    }

    public Flux<String> getFruitsFilterMap(int size){
        return Flux.fromIterable(Arrays.asList("Jack Fruit","Papaya","Grapes")).filter(f->size<f.length()).
                map(String::toLowerCase).log();
    }

    public Mono<String> getVeggies(){
        return Mono.just("Potato").log();
    }



    public static void main(String[] args) {
        FluxMonoExp fluxMonoExp= new FluxMonoExp();
        fluxMonoExp.getFruits().subscribe(s->{
            System.out.println(s);
        });

        fluxMonoExp.getVeggies().subscribe(v->{
            System.out.println(v);
        });
    }
}
