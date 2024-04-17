package com.targetindia.utils;

public class BDD {
    public static class Person {
        public String name;
        public Integer age;
        public Person(String name,Integer age) {
            this.name = name;
            this.age = age;
        }
    }

    public sealed static class Result permits Success,Error{}

    public non-sealed static class Success extends Result{
        public static Integer val;
        public Success(Integer val){
            this.val = val;
        }
    }
    public non-sealed static class Error extends Result{
        public static String message;
        public Error(String message){
            this.message  = message;
        }
    }

    public static int getResultValue(Result result){
          if (result.getClass()==Success.class){
              return Success.val;
          }
          else {
              throw new IllegalArgumentException(Error.message);
          }
    }


}
