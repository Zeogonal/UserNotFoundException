import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws UserNotFoundException,AccessDeniedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        User user = getUserByLoginAndPassword(login, password);
        validateUser(user);

    }
    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if(user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        throw new UserNotFoundException("Направильно ввели имя пользователя - пароль");
    }
    public static void validateUser(User user) throws AccessDeniedException{
        if (user.getAge() < 18){
            throw new AccessDeniedException("Доступ запрещем. Вам не иcполнилось 18 лет");
        } else {
            System.out.println("Доступ предоставлен");
        }
    }
    public static User[] getUsers() {
        User user1 = new User("zerojik", "363", "zerojik@mail.no", 9);
        User user2 = new User("omizak", "849", "omizak@mail.no", 47);
        User user3 = new User("pusisa", "356", "pusisa@mail.no", 17);
        User user4 = new User("migmig", "104", "migmig@mail.no", 29);
        return new User[]{user1, user2, user3, user4};
    }
}