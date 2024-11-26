package helper;

public class Endpoint {
    public static final String host_gorest = "https://gorest.co.in/public/v2/";
    public static final String get_list_users = host_gorest + "users";
    public static final String create_new_user = get_list_users;
    public static final String delete_user = get_list_users + "/";
    public static final String update_user = get_list_users + "/";
    public static final String invalid_create_new_user = host_gorest;
}
