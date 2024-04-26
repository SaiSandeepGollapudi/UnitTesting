package com.luv2code.junitdemo;

import javax.swing.*;
import javax.swing.text.html.HTML;
import java.util.List;
import java.util.Set;

public class DemoUtils {

    private String academy = "Luv2Code Academy";
    private String academyDuplicate = academy;
    private String[] firstThreeLettersOfAlphabet = {"A", "B", "C"};
    private List<String> academyInList = List.of("luv", "2", "code");

    public List<String> getAcademyInList() {
        return academyInList;
    }

    public String getAcademy() {
        return academy;
    }

    public String getAcademyDuplicate() {
        return academyDuplicate;
    }

    public String[] getFirstThreeLettersOfAlphabet() {
        return firstThreeLettersOfAlphabet;
    }

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

//    IntelliJ Support for Code Coverage
//    IntelliJ has built-in support for code coverage
//    Can generate coverage reports in the IDE
//    Also can generate HTML output for viewing in web browser
//where your team or managers can access that given server
//
//    So this is useful if you wanted to maybe take this HTML information and publish it to a server, a web server,where your team or managers can access that given server
//    to see the actual coverage results. Or this could be a part of your DevOps build process, where you have a page with the current status  of your given builds.
//    And then, in addition to code coverage reports, IntelliJ can also generate test reports
//    as far as all the test results.So for each one of your test classes,  then all the different test methods,  it'll show which methods passed  and which methods fail.

    public Object checkNull(Object obj) {
        if (obj != null) {
            return obj;
        }
        return null;
    }

    public Boolean isGreater(int n1, int n2) {
        if (n1 > n2) {
            return true;
        }
        return false;
    }

    public String throwException(int a) throws Exception
    {
        if(a<0){
            throw new Exception("Value should be greater or equal to 0");
        }
        return "Value is greater than or equal to 0";
    }
    public void checkTimeout() throws InterruptedException {
        System.out.println("I am going to sleep");
        Thread.sleep(2000);
        System.out.println("Sleeping over");
    }

}
