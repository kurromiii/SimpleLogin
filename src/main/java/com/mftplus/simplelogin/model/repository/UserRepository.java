package com.mftplus.simplelogin.model.repository;

import com.mftplus.simplelogin.model.entity.User;
import com.mftplus.simplelogin.model.utils.JdbcProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepository implements AutoCloseable{
    private final Connection connection;
    private PreparedStatement preparedStatement;

    public UserRepository() throws Exception {
        connection = JdbcProvider.getJdbcProvider().getConnection();
    }

    //register
    public User save(User user) throws Exception {
        preparedStatement = connection.prepareStatement("select users_seq.nextval as id from dual");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        user.setId(resultSet.getInt("id"));

        preparedStatement = connection.prepareStatement
                ("insert into users (id,name,family,username,password) values (?,?,?,?,?)");
        preparedStatement.setInt(1,user.getId());
        preparedStatement.setString(2,user.getName());
        preparedStatement.setString(3,user.getFamily());
        preparedStatement.setString(4,user.getUserName());
        preparedStatement.setString(5,user.getPassWord());
        preparedStatement.execute();

        return user;
    }

    //unique username
    public User findByUserName(String username) throws Exception {
        preparedStatement = connection.prepareStatement("select * from users where username=? ");
        preparedStatement.setString(1, username);

        ResultSet resultSet = preparedStatement.executeQuery();
        User user = null;
        if (resultSet.next()){
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setFamily(resultSet.getString("family"));
            user.setUserName(resultSet.getString("username"));
            user.setPassWord(resultSet.getString("password"));
        }
        return user;
    }

    //login
    public User findByUserNameAndPassword(User user) throws Exception {
        preparedStatement = connection.prepareStatement
                ("select * from users where username=? and password=?");
        preparedStatement.setString(1,user.getUserName());
        preparedStatement.setString(2,user.getPassWord());

        ResultSet resultSet = preparedStatement.executeQuery();
        User loggedInUser = null;
        if(resultSet.next()){
            loggedInUser = new User();
            loggedInUser.setId(resultSet.getInt("id"));
            loggedInUser.setName(resultSet.getString("name"));
            loggedInUser.setFamily(resultSet.getString("family"));
            loggedInUser.setUserName(resultSet.getString("username"));
            loggedInUser.setPassWord(resultSet.getString("password"));
        }
        return loggedInUser;
    }


    @Override
    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
    }
}
