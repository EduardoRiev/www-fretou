package models;

import java.util.HashMap;
import java.util.Map;

public class UsuariosDB {

  private static Map<String, Usuario> userinfos = new HashMap<String, Usuario>();

  /**
  * Adds the specified user to the UserInfoDB.
  * @param name Their name.
  * @param email Their email.
  * @param password Their password.
  */
  public static void addUserInfo(int id, String email, String senha, String tipo) {
    userinfos.put(email, new Usuario(id, email, senha, tipo));
  }

  public static Map<String, Usuario> allUsers(){
    return userinfos;
  }

  /**
  * Returns true if the email represents a known user.
  * @param email The email.
  * @return True if known user.
  */
  public static boolean isUser(String email) {
    return userinfos.containsKey(email);
  }

  /**
  * Returns the UserInfo associated with the email, or null if not found.
  * @param email The email.
  * @return The UserInfo.
  */
  public static Usuario getUser(String email) {
    return userinfos.get((email == null) ? "" : email);
  }

  /**
  * Returns true if email and password are valid credentials.
  * @param email The email.
  * @param password The password.
  * @return True if email is a valid user email and password is valid for that email.
  */
  public static boolean isValid(String email, String senha) {
    return ((email != null)
    &&
    (senha != null)
    &&
    isUser(email)
    &&
    getUser(email).getSenha().equals(senha));
  }

}
