package Controller;


import Model.Customer;

public class SessionManager {
    private static SessionManager instance;
    private Customer loggedInUser; // Store logged-in user

    // Private constructor to restrict instantiation
    private SessionManager() {}

    // Singleton instance getter
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    // Set the logged-in user
    public void loginUser(Customer customer) {
        this.loggedInUser = customer;
    }

    // Get the logged-in user
    public Customer getLoggedInUser() {
        return loggedInUser;
    }

    // Clear session (log out)
    public void logout() {
        loggedInUser = null;
    }

    // Check if someone is logged in
    public boolean isLoggedIn() {
        return loggedInUser != null;
    }
}
