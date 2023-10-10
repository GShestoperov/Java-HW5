import java.util.*;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> data = new HashMap<>();

    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void add(String lastname, String phone) {
        if (!data.containsKey(lastname)) {
            data.put(lastname, new ArrayList<>());
        }
        data.get(lastname).add(phone);
    }

    public ArrayList<String> getPhones(String lastname) {
        return data.get(lastname);
    }

    public boolean edit(String lastname, String phone, String newPhone) {
        ArrayList<String> phones = getPhones(lastname);
        if (phones == null) return false;
        for (int i = 0; i < phones.size(); i++) {
            if (phones.get(i).equals(phone)) {
                phones.set(i, newPhone);
                return true;
            }
        }
        return false;
    }

    public void printAllItems() {
        System.out.printf("%-15s %s\n", "Фамилия", "Телефон");
        System.out.println("----------------------------------------------------------------------");
        for (var entry : data.entrySet()) {
            System.out.printf("%-15s", entry.getKey());
            for (var phone : entry.getValue()) {
                System.out.print(phone + " ");
            }
            System.out.println();
        }
        if (data.isEmpty())
            System.out.println("No records");
        System.out.println("----------------------------------------------------------------------");
    }

    public void clear() {
        data.clear();
    }

    public boolean delete(String lastname, String phone) {
        if (data.containsKey(lastname)) {
            ArrayList<String> phones = data.get(lastname);
            if (phones.contains(phone)) {
                phones.remove(phone);
                if (phones.isEmpty()) {
                    data.remove(lastname);
                }
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean delete(String lastname) {
        if (data.containsKey(lastname)) {
            data.remove(lastname);
            return true;
        } else {
            return false;
        }
    }

    public List<String> sort() {
        List<String> dataByKey = new ArrayList<>(data.keySet());
        Collections.sort(dataByKey);
        return dataByKey;
    }

    public void printPhonesByKeys(List<String> keys) {
        System.out.printf("%-15s %s\n", "Фамилия", "Телефон");
        System.out.println("----------------------------------------------------------------------");
        for (var key : keys) {
            System.out.printf("%-15s", key);
            for (var phone : data.get(key)) {
                System.out.print(phone + " ");
            }
            System.out.println();
        }
        if (keys.isEmpty())
            System.out.println("No records");
        System.out.println("----------------------------------------------------------------------");
    }
}
