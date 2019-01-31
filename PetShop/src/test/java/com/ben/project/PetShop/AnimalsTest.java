package com.ben.project.PetShop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.TestComponent;

@TestComponent
public class AnimalsTest {

    @Test
    public void testEqualMethod() {
        Assertions.assertThat(new Animals(2, "Milou", 60)).isEqualTo(new Animals(2, "Milou", 60));
    }

    @Test
    public void testEqualMethodeFalse() {
        Assertions.assertThat(new Animals(5, "false", 58).equals(new Animals(6, "false", 58))).isEqualTo(false);
    }

    @Test
    public void testEqualMethodeFalseByName() {
        Assertions.assertThat(new Animals(5, "bibiou", 58).equals(new Animals(5, "false", 58))).isEqualTo(false);
    }

    @Test
    public void testEqualMethodeFalseByHeigh() {
        Assertions.assertThat(new Animals(6, "harry", 58).equals(new Animals(6, "harry", 80))).isEqualTo(false);
    }

    @Test
    public void testEqualMethodeFalseByNull() {
        Assertions.assertThat(new Animals(6, "harry", 58).equals(null)).isEqualTo(false);
    }

    @Test
    public void testEqualMethodeFalseByItemNull() {
        Assertions.assertThat(new Animals(6, null, 58).equals(new Animals(6, "harry", 80))).isEqualTo(false);
    }

    @Test
    public void testEqualMethodeFalseByClass() {
        Assertions.assertThat(new Animals(6, "harry", 58).equals(new Object())).isEqualTo(false);
    }
}
