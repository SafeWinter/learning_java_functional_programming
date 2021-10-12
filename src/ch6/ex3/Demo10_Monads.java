package ch6.ex3;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Demo10_Monads {
    public static void main(String[] args) {
        Map<Integer, Part> parts = getParts();
        
        // Conventional way
        int partId = 123;
        Part part = parts.get(partId);
        part.setOutOfStock(true);
        part.setPartName(part.getPartName() + "-Out-Of-Stock");
        part.replicatePartMonad();
        
        // Monad way
        partId = 456;
        Optional<Part> optPart = Optional.of(parts.get(partId));
        System.out.println(
            optPart
                .flatMap(x -> x.outOfStock(true))
                .flatMap(x -> x.partName(x.getPartName() + "-Out-Of-Stock"))
                .flatMap(Part::replicatePartMonad)
                .orElseThrow(RuntimeException::new)
        );
    }
    
    private static Map<Integer, Part> getParts() {
        Map<Integer, Part> parts = new HashMap<>();
        parts.put(123, new Part(111,"bolt"));
        parts.put(456, new Part(222,"nail"));
        parts.put(789, new Part(333,"wire"));
        return parts;
    }
}
