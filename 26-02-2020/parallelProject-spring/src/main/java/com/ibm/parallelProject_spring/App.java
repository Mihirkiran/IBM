package com.ibm.parallelProject_spring;

import com.ibm.wallet.ui.UI;

import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{

    public static void main( String[] args ) throws SQLException
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
        UI ui = context.getBean("ui",UI.class);
//        UI ui = new UI();
        ui.main();
    }
}