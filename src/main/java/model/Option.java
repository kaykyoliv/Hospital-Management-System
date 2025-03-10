package model;

import java.util.Scanner;

public interface Option {
    void operation(Scanner sc, Database database, User user);

    String getName();
}
