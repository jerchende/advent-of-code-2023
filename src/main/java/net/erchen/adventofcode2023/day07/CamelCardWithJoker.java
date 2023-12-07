package net.erchen.adventofcode2023.day07;

public class CamelCardWithJoker extends CamelCard {

    public CamelCardWithJoker(char value) {
        super(value);
    }

    public static CamelCardWithJoker[] fromInput(String input) {
        return input.chars().mapToObj(c -> new CamelCardWithJoker((char) c)).toArray(CamelCardWithJoker[]::new);
    }


    @Override
    public boolean isJoker() {
        return this.getValue() == 'J';
    }

    @Override
    int orderValue() {
        if (isJoker()) {
            return 1;
        }
        return super.orderValue();
    }
}
