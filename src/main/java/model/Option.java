package model;

import java.util.Scanner;

public interface Option {
    void Operation(Scanner sc, Database database, User user);
    String getName();
}
