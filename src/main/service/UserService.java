package main.service;

import main.controller.Request;
import main.dao.UserAssetDAO;
import main.dao.UserDAO;
import main.model.User;

import java.util.List;

public class UserService {

    private UserDAO userDAO;
    private UserAssetDAO userAssetDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public List<User> getAllUsers () {
        return this.userDAO.getAllUsers();
    }
    public List<User> getAllClienti () {
        return this.userDAO.getAllClienti();
    }
    
    public List<User> getAllClientiAss(){
    	return this.userDAO.getAllClientiAss();
    }

    public boolean insertUser (User user) {
        return this.userDAO.insertUser(user);
    }
    
    public boolean deleteUser(int idUser) {
    	return this.userDAO.deleteUser(idUser);
    }
    
    public List<User> getAllUsersN(){
    	return this.userAssetDAO.getAllUsersN();
    }
    
    public boolean updateUser(Request request) {
    	return this.userDAO.udpateUser(request);
    }
}


