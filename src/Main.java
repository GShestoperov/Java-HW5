public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "+7 495 1234567");
        phoneBook.add("Петров", "+7 499 1234567");
        phoneBook.add("Сидоров", "+7 496 1234567");
        phoneBook.add("Иванов", "+7 926 1234567");
        phoneBook.add("Петров", "+7 916 1234567");
        phoneBook.add("Петров", "+7 903 1234567");

        phoneBook.printAllItems();

        if (phoneBook.edit("Иванов", "+7 926 1234567", "+7 926 7654321"))
            System.out.println("Телефон изменен");
        phoneBook.printAllItems();

        if (phoneBook.delete("Петров"))
            System.out.println("Телефоны удалены");
        phoneBook.printAllItems();

        if (phoneBook.delete("Иванов", "+7 495 1234567"))
            System.out.println("Телефон удален");
        phoneBook.printAllItems();

        if (phoneBook.delete("Иванов", "+7 926 7654321"))
            System.out.println("Телефон удален");
        phoneBook.printAllItems();

        phoneBook.clear();
        phoneBook.printAllItems();
    }
}
