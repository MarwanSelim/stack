package eg.edu.alexu.csd.datastructure.stack.cs73;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        stack m = new stack();
               ExpressionEvaluator s =new ExpressionEvaluator();

        Scanner input = new Scanner(System.in);
        double operation;
        double choice;
        double d;
        char c;
        int i;
        String x=" ";
        while (true) {
            // here we choose if we went to use the stack or the expression evaluator
            System.out.printf("1: Stack\n2: Expression Evaluator\n");
            choice=input.nextDouble();
            // the while true is to keep is in the chosen part of the program
            if (choice == 1) {
                while (true) {
                    System.out.printf("1:Push\n2:Pop\n3:Peek\n4:Get size\n5:Check if empty\n");
                    operation = input.nextDouble();
                    if (operation == 1) {
                        System.out.println("enter the object:");
                        x = input.next();
                        // here we see if the object is a number or a string and push it accordingly
                        // we can handel any thing like shown in the junit but this are the two cases that covers every thing
                        try {
                            d = Double.valueOf(x);
                            m.push(d);
                        } catch (NumberFormatException e) {
                            m.push(x);
                        }
                    } else if (operation == 2) {
                        try {
                            System.out.println("the object is :" + m.pop());
                        } catch (RuntimeException e) {
                            System.out.println("the stack is empty");
                        }
                    } else if (operation == 3) {
                        try {
                            System.out.println("the object is :" + m.peek());
                        } catch (RuntimeException e) {
                            System.out.println("the stack is empty");
                        }
                    } else if (operation == 4) {
                        System.out.println("the size of the stack :" + m.size());
                    } else if (operation == 5) {
                        System.out.println(m.isEmpty());
                    } else {
                        System.out.println("invalid number");
                    }
                }
            }else if (choice==2){
                while (true) {
                    System.out.printf("1: expression to turn to a postfix and evaluate\n2: expression to turn to postfix\n");
                    operation = input.nextDouble();
                    // here we put the try catch out in order to do as much of the expression as possable
                    try {

                        if (operation == 1) {
                            System.out.println("enter the expression:");
                            x = input.next();
                            System.out.println(s.infixToPostfix(x));
                            System.out.println(s.evaluate(s.infixToPostfix(x)));
                        } else if (operation == 2) {
                            System.out.println("enter the expression:");
                            x = input.next();
                            System.out.println(s.infixToPostfix(x));
                        } else {
                            System.out.println("enter a valid number");
                        }
                    }catch (RuntimeException e){
                        System.out.println("you entered a wrong expresstion for the operation");
                    }
                }
            }else {
                System.out.println("enter a valid number");
            }

            }
        }

    }

