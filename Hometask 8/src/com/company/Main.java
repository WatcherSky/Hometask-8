package com.company;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here


        String name = "Mary";
        String password = "123";
        String confirmPassword = "123";
        check(name, password, confirmPassword);
    }



        public static boolean check (String name, String password, String confirmPassword){
            try {
                if (name.toCharArray()[0] != name.toUpperCase(Locale.ROOT).toCharArray()[0]) {
                    throw new WrongNameException("Wrong name!");
                }

                if (name.length() > 20) {
                    throw new WrongNameException("Less than 20!");
                }


                boolean matchesName = name.matches("[a-zA-Z0-9-_]*");
                if (!matchesName) {
                    throw new WrongPasswordException("Forbidden characters!");
                }


                if (!Objects.equals(password, confirmPassword)) {
                    throw new WrongPasswordException("Passwords must be equals!");
                }

                if (password.length() > 20) {
                    throw new WrongPasswordException("Password should be less 20!");
                }
                boolean matchesPassword = password.matches("[a-zA-Z0-9-_]*");
                if (!matchesPassword) {
                    throw new WrongPasswordException("Forbidden characters!");
                }


            } catch(WrongNameException ex){
                    System.out.println(ex.getMessage());
                    return false;
                } catch (WrongPasswordException ex) {
                System.out.println(ex.getMessage());
                return false;
            }
                return true;
            }

        }


